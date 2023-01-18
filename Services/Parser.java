package Homework3.Services;

import Homework3.Exceptions.IncorrectDateFormatException;
import Homework3.Exceptions.IncorrectMaleException;
import Homework3.Exceptions.IncorrectNameException;
import Homework3.Exceptions.IncorrectPhoneException;
import Homework3.Exceptions.OverSizeMessageException;
import Homework3.Exceptions.UnderSizeMessageException;
import Homework3.Users.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	public User parseToUser(String line) throws RuntimeException {
		User user = new User();
		if (checkCountElements(line) < 0) {
			throw new OverSizeMessageException("Your message too large");
		} else if (checkCountElements(line) > 0) {
			throw new UnderSizeMessageException("Your message too short");
		} else {
			ArrayList<String> userList = new ArrayList<>(Arrays.asList(line.split(" ")));
			Pattern patternDateFormat = Pattern.compile(
				 "^\\d{2}" + "\\." + "\\d{2}" + "\\." + "\\d{4}$");
			Pattern patternMaleFormat = Pattern.compile("[mf]");
			Pattern patternNameFormat = Pattern.compile("^\\D{2,}$");
			Pattern patternPhoneFormat = Pattern.compile("^\\d{3,12}$");
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).contains(".")) {
					Matcher matcherDate = patternDateFormat.matcher(userList.get(i));
					if (matcherDate.find()) {
						user.setBirthDate(userList.get(i));
					} else {
						throw new IncorrectDateFormatException("Date Format Incorrect! (dd.mm.yyyy)");
					}
				} else if (userList.get(i).length() == 1) {
					Matcher matcherMale = patternMaleFormat.matcher(userList.get(i));
					if (matcherMale.find()) {
						user.setMale(userList.get(i).charAt(0));
					} else {
						throw new IncorrectMaleException("Male Format Incorrect! (m or f)");
					}
				} else if (Character.isDigit(userList.get(i).charAt(0))) {
					Matcher matcherPhone = patternPhoneFormat.matcher(userList.get(i));
					if (matcherPhone.find()) {
						user.setPhone(Long.valueOf(userList.get(i)));
					} else {
						throw new IncorrectPhoneException("Phone Format Incorrect! (3-12 digits)");
					}
				} else {
					String[] fullName = new String[3];
					for (int j = 0; j < 3; j++) {
						Matcher matcherName = patternNameFormat.matcher(userList.get(i));
						if (matcherName.find()){
							fullName[j] = userList.get(i);
						} else {
							throw new IncorrectNameException("Name Format Incorrect! (2+ letters)");
						}
						i++;
					}
					user.setLastName(fullName[0]);
					user.setFirstName(fullName[1]);
					user.setSecondName(fullName[2]);
					i--;
				}
			}
		}
		return user;
	}

	public Integer checkCountElements(String line) {
		String[] inputList = line.split(" ");
		return (User.countUserCharacters - inputList.length);
	}

	public boolean isOnlyDigit(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isDigit(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
