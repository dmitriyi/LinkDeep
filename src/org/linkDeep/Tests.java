package org.linkDeep;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tests {
	
	private String adkAddress = "cd \"C:\\Program Files (x86)\\Microsoft Durango XDK\\bin\"";
	
	public String connect (String ip) throws Exception{
		String command = adkAddress + " && xbconnect " + ip;
//		executeCmd(command);
		return command;
	}
	
	public void sendDeepLink (String deepLink) throws Exception{
		String command = adkAddress + " && " + deepLink;
		executeCmd(command);
	}
	
	public void screenShot (String screenShotDir, String testItem)  throws Exception{
		TimeStamp timeStamp = new TimeStamp();
		String command = adkAddress + " && xbcapture /O " + screenShotDir + timeStamp.getTimeStamp() + testItem + ".png";
//		xbcapture /O "%screenShotPath%\%date%Default.png"
		executeCmd(command);
	}
	
	public String killSwitch (String packegenumber){
		String command = adkAddress + " && xbapp terminate " + packegenumber;
		return command;
//		xbapp terminate %packege%
	}
	
	/*
	 * Process the string of commands to CMD
	 */
//	private static void executeCmd (String command) throws Exception{
//		ProcessBuilder builder = new ProcessBuilder(
//	            "cmd.exe", "/c", command);
//	        builder.redirectErrorStream(true);
//	        Process p = builder.start();
//	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//	        String line;
//	        while (true) {
//	            line = r.readLine();
//	            if (line == null) { break; }
//	            System.out.println(line);
//	        }
//	}
	
	private static void executeCmd (String command) throws Exception{
		ProcessBuilder builder = new ProcessBuilder(
	            "cmd.exe", "/c", command);
	        builder.redirectErrorStream(true);
	        Process p = builder.start();
	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }
	}

	
}
