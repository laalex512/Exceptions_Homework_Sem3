package Homework3.Utils;

import Homework3.Users.User;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt {
	public void write(User user) throws IOException{
		String pathFile = "Homework3/Data/" + user.getLastName() + ".txt";
		FileWriter fw = new FileWriter(pathFile, true);
		fw.write(user + "\n");
		fw.close();
	}
}
