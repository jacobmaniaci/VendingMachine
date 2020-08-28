package com.techelevator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	public static void WriteLog(String log) throws IOException {
//	File logFile = new File("log.txt");
//	logFile.createNewFile();

		try (FileWriter write = new FileWriter("Log.txt", true)) {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();
			write.append(formatter.format(date) + "\t");
			write.append(log + "\n");

		}
	}
}
