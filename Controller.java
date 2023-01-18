package Homework3;

import Homework3.Exceptions.OverSizeMessageException;
import Homework3.Exceptions.UnderSizeMessageException;
import Homework3.Services.Parser;
import Homework3.Users.User;
import Homework3.Utils.WriteToTxt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {

	public void startProgram() {
		Scanner scanner = new Scanner(System.in);
		Parser parser = new Parser();
		WriteToTxt writer = new WriteToTxt();
		while (true) {
			System.out.println("Enter user or \"q\" to stop program:");
			String currentMessage = scanner.nextLine();
			if (currentMessage.equals("q")) {
				scanner.close();
				break;
			} else {
				try {
					User currentUser = parser.parseToUser(currentMessage);
					System.out.println("Correct Input");
					System.out.println(currentUser);
					try {
						writer.write(currentUser);
					} catch (IOException e){
						e.printStackTrace();
					}
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
