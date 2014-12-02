package org.linkDeep;

import java.util.ArrayList;

public class FormLinks {
	ArrayList<String> aryLinks = new ArrayList<String>();

	// Constants
	private final String BEGIN = "xbapp launch ms-xbl-";
	private final String SLASH = "://";
	private final String Q = "?";
	private final String CON_ID = "&contentid=";
	private final String CON_TYPE = "&contenttype=";
	private final String TIME = "&time=";

	// Content Type Variables:
	private final String TV_SERIES = "tvSeries";
	private final String MOVIE = "movie";
	private final String TV_EPISODE = "tvEpisode";

	// Authority Variables:
	private final String aDefault = "default";
	private final String aDetails = "media-details";
	private final String aPlayback = "media-playback";
	private final String aHelp = "media-help";
	private final String aSettings = "media-settings";
	private final String aSearch = "media-search";

	private String titleID;
	private String tvSeriesID;
	private String tvEpisodeID;
	private String movieID;
	private String scenario;
	private boolean authDefault;
	private boolean authDetails;
	private boolean authSettings;
	private boolean authHelp;
	private boolean authPlayback;
	private boolean authSearch;

	/*
	 * xbapp launch
	 * "ms-xbl-%appid%://media-playback?contenttype=Movie&contentid=%Moviecontentid%&time=00:15:00"
	 */

	// public FormLinks() {

	// titleID,
	// tvSeriesID,
	// tvEpisodeID,
	// movieID,
	// pacadgeID,
	// screenShotPath,
	// scenario,
	// authDefault,
	// authDetails,
	// authSettings,
	// authHelp,
	// authPlayback,
	// authSearch

	// }

	public FormLinks(String titleID, String tvSeriesID, String tvEpisodeID,
			String movieID, String scenario, boolean authDefault,
			boolean authDetails, boolean authSettings, boolean authHelp,
			boolean authPlayback, boolean authSearch) {
		this.titleID = titleID;
		this.tvSeriesID = tvSeriesID;
		this.tvEpisodeID = tvEpisodeID;
		this.movieID = movieID;
		this.scenario = scenario;
		this.authDefault = authDefault;
		this.authDetails = authDetails;
		this.authSettings = authSettings;
		this.authHelp = authHelp;
		this.authPlayback = authPlayback;
		this.authSearch = authSearch;
		if (scenario == "all") {
			valid();
			invalid();
		} else if (scenario == "valid") {
			valid();
		} else {
			invalid();
		}
	}

	private String start() {
		String start = BEGIN + titleID + SLASH;
		return start;
	}

	private void invalid() {
		// TODO Complete Invalid
	}

	private void valid() {
		if (authDefault == true) {
			defaultValidLinks();
		}
		if (authDetails == true){
			detailsValidLinks();
		}
		if (authSettings == true){
			settingsValidLinks();
		}
		if (authHelp == true){
			helpValidLinks();
		}
		if (authPlayback = true){
			playbackValidLinks();
		}
		if (authSearch = true){
			searchValidLinks();
		}
	}

	private void defaultValidLinks() {
		aryLinks.add(start() + aDefault);
		System.out.println(aryLinks.toString());
	}

	private void detailsValidLinks() {
		if (tvEpisodeID.equalsIgnoreCase("") == false){
			aryLinks.add(start() + aDetails + Q + CON_ID + tvEpisodeID + CON_TYPE + TV_EPISODE);
			System.out.println(aryLinks.toString());
		}
		
		if (tvSeriesID.equalsIgnoreCase("") == false){
			aryLinks.add(start() + aDetails + Q + CON_ID + tvSeriesID + CON_TYPE + TV_SERIES);
			System.out.println(aryLinks.toString());
		}
		
		if (movieID.equalsIgnoreCase("")== false){
			
		}
	}	

	private void settingsValidLinks() {
		// TODO Auto-generated method stub
		
	}
	
	private void helpValidLinks() {
		// TODO Auto-generated method stub
		
	}

	private void playbackValidLinks() {
		// TODO Auto-generated method stub
		
	}

	private void searchValidLinks() {
		// TODO Auto-generated method stub
		
	}
}
