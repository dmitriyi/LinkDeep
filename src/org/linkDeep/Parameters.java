package org.linkDeep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;


public class Parameters {

	private boolean kill;
	private String ip;
	private String titleID;
	private String tvSeriesID;
	private String tvEpisodeID;
	private String movieID;
	private String pacadgeID;
	private String screenShotPath;
	private boolean autoDismiss;
	private String scenario;
	private boolean authDefault;
	private boolean authDetails;
	private boolean authSettings;
	private boolean authHelp;
	private boolean authPlayback;
	private boolean authSearch;
	
	
	public boolean isKill() {
		return kill;
	}

	public void setKill(boolean kill) {
		this.kill = kill;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTitleID() {
		return titleID;
	}

	public void setTitleID(String titleID) {
		this.titleID = titleID;
	}

	public String getTvSeriesID() {
		return tvSeriesID;
	}

	public void setTvSeriesID(String tvSeriesID) {
		this.tvSeriesID = tvSeriesID;
	}

	public String getTvEpisodeID() {
		return tvEpisodeID;
	}

	public void setTvEpisodeID(String tvEpisodeID) {
		this.tvEpisodeID = tvEpisodeID;
	}

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public String getPacadgeID() {
		return pacadgeID;
	}

	public void setPacadgeID(String pacadgeID) {
		this.pacadgeID = pacadgeID;
	}

	public String getScreenShotPath() {
		return screenShotPath;
	}

	public void setScreenShotPath(String screenShotPath) {
		this.screenShotPath = screenShotPath;
	}

	public boolean isAutoDismiss() {
		return autoDismiss;
	}

	public void setAutoDismiss(boolean autoDismiss) {
		this.autoDismiss = autoDismiss;
	}

	public String getScenario() {
		if (scenario == "" || scenario == null)
			scenario = "all";
		return scenario;
	}


	public void setScenario(String scenario) {
		this.scenario = scenario;
	}


	public boolean isAuthDefault() {
		return authDefault;
	}


	public void setAuthDefault(boolean authDefault) {
		this.authDefault = authDefault;
	}


	public boolean isAuthDetails() {
		return authDetails;
	}


	public void setAuthDetails(boolean authDetails) {
		this.authDetails = authDetails;
	}


	public boolean isAuthSettings() {
		return authSettings;
	}


	public void setAuthSettings(boolean authSettings) {
		this.authSettings = authSettings;
	}


	public boolean isAuthHelp() {
		return authHelp;
	}


	public void setAuthHelp(boolean authHelp) {
		this.authHelp = authHelp;
	}


	public boolean isAuthPlayback() {
		return authPlayback;
	}


	public void setAuthPlayback(boolean authPlayback) {
		this.authPlayback = authPlayback;
	}


	public boolean isAuthSearch() {
		return authSearch;
	}


	public void setAuthSearch(boolean authSearch) {
		this.authSearch = authSearch;
	}


	public void loadParam() throws InvalidPropertiesFormatException, IOException{
		Properties props = new Properties();
		System.out.println("Loading");
		try { // Read File
		FileInputStream fIs = new FileInputStream("linkDeep.xml");
		props.loadFromXML(fIs);
		} catch (FileNotFoundException e){
			System.out.println("File Not Found");
		}
		
		//Assign Values
		boolean killYes = Boolean.parseBoolean(props.getProperty("kill"));
		kill = killYes;
		
		String ipAdr = props.getProperty("ip");
		ip = ipAdr;
		
		String title = props.getProperty("titleID");
		titleID = title;
		
		String tvSeries = props.getProperty("tvSeriesID");
		tvSeriesID = tvSeries;
		
		String tvEpisode = props.getProperty("tvEpisodeID");
		tvEpisodeID = tvEpisode;
		
		String movie = props.getProperty("movieID");
		movieID = movie;
		
		String pacadge = props.getProperty("pacadgeID");
		pacadgeID = pacadge;
		
		String screenCap = props.getProperty("screenShotPath"); 
		screenShotPath = screenCap;
		
		boolean dismiss = Boolean.parseBoolean(props.getProperty("autoDismiss"));
		autoDismiss = dismiss;
		
		String tscenario = props.getProperty("scenario");
		scenario = tscenario;
		
		// Authority Values
		boolean def = Boolean.parseBoolean(props.getProperty("authDefault"));
		authDefault = def;
		
		boolean details = Boolean.parseBoolean(props.getProperty("authDetails"));
		authDetails = details;
		
		boolean settings = Boolean.parseBoolean(props.getProperty("authSettings"));
		authSettings = settings;
		
		boolean help = Boolean.parseBoolean(props.getProperty("authHelp"));
		authHelp = help;
		
		boolean playback = Boolean.parseBoolean(props.getProperty("authPlayback"));
		authPlayback = playback;
		
		boolean search = Boolean.parseBoolean(props.getProperty("authSearch"));
		authSearch = search;
	}

	
	public void saveParamChangesAsXML() throws FileNotFoundException {
		try {
			Properties props = new Properties();
			
			//Save properties
			props.setProperty("kill", Boolean.toString(kill));
			props.setProperty("ip", ip);
			props.setProperty("titleID", titleID);
			props.setProperty("tvSeriesID", tvSeriesID);
			props.setProperty("tvEpisodeID", tvEpisodeID);
			props.setProperty("movieID", movieID);
			props.setProperty("pacadgeID", pacadgeID);
			props.setProperty("screenShotPath", screenShotPath);
			props.setProperty("autoDismiss", Boolean.toString(autoDismiss));
			props.setProperty("scenario", scenario);
			props.setProperty("authDefault", Boolean.toString(authDefault));
			props.setProperty("authSettings", Boolean.toString(authSettings));
			props.setProperty("authHelp", Boolean.toString(authHelp));
			props.setProperty("authPlayback", Boolean.toString(authPlayback));
			props.setProperty("authSearch", Boolean.toString(authSearch));
			props.setProperty("authDetails", Boolean.toString(authDetails));
			
			File f = new File("linkDeep.xml");
			OutputStream out = new FileOutputStream(f);
			props.storeToXML(out, "LinkDeep Config File");
			System.out.println("Saved");
		} catch (Exception e) {
			File f = new File("linkDeep.xml");
			OutputStream out = new FileOutputStream(f);
			e.printStackTrace();
		}
	}
}
