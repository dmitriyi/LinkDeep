package org.linkDeep;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JCheckBox;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.awt.Color;

public class GUIMain extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6052531125585852071L;

	Parameters param = new Parameters();

	JPanel panelSettings = new JPanel();

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
	@SuppressWarnings("unused")
	private String errors = "";
	
	private final String ERR_IP = "Title ID is not entered!";
	private final String ERR_TITLE = "Title ID is not entered!";
	private final String ERR_MEDIA_ID = "One or more Media IDs are required!";
	private final String ERR_AUTH = "Select Authorities to Test!";
	private final String ERR_PACK = "Cannot Terminate if no Package ID ";
	

	JLabel lblSettings = new JLabel("Settings");
	JLabel lblError = new JLabel(" ");
	JCheckBox chckbxKillswitch;
	JLabel lblIp = new JLabel("Console IP Address:");
	JTextField txtFldip;
	JLabel lblAppid = new JLabel("Title ID:");
	JTextField txtTitleId;
	JLabel lblTvseriescontentid = new JLabel("TV Series Content ID:");
	JTextField txtFldTvSeriesContentId;
	JLabel lblTvepisodecontentid = new JLabel("TV Episode Content ID:");
	JTextField txtTvepisodecontentid;
	JLabel lblMoviecontentid = new JLabel("Movie Content ID:");
	JTextField txtMoviecontentid;
	JLabel lblPackage = new JLabel("Package ID:");
	JTextField txtPackegenumber;
	JLabel lblScreenshotpath = new JLabel("Screenshot Path:");
	JTextField txtScreenshotpath;
	JCheckBox chckbxDismissErrorsAutomatically;
	JLabel lblAuthoritiesToTest = new JLabel("Authorities to test:");
	JLabel lblScenarios = new JLabel("Scenarios:");
	JCheckBox chckbxDefault;
	JCheckBox chckbxMediahelp;
	JCheckBox chckbxMediaDetails;
	JCheckBox chckbxMediaPlayback;
	JCheckBox chckbxSettings;
	JCheckBox chckbxSearch;
	ButtonGroup testGroup = new ButtonGroup(); // Scenarios Button Group
	JRadioButton rdbtnAll = new JRadioButton("All");
	JRadioButton rdbtnValidOnly = new JRadioButton("Valid Only");
	JRadioButton rdbtnInvalidOnly = new JRadioButton("Invalid Only");
	JButton btnSave = new JButton("Save");
	JButton btnRun = new JButton("RUN!");

	public GUIMain() throws InvalidPropertiesFormatException, IOException {
		super(Main.APP_NAME);
		retriveParam();

		setSize(700, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		settingsFrame();
		setVisible(true);
	}

	private void retriveParam() throws InvalidPropertiesFormatException,
			IOException {

		param.loadParam();
		kill = param.isKill();
		ip = param.getIp();
		titleID = param.getTitleID();
		tvSeriesID = param.getTvSeriesID();
		tvEpisodeID = param.getTvEpisodeID();
		movieID = param.getMovieID();
		pacadgeID = param.getPacadgeID();
		screenShotPath = param.getScreenShotPath();
		autoDismiss = param.isAutoDismiss();
		scenario = param.getScenario();
		authDefault = param.isAuthDefault();
		authDetails = param.isAuthDetails();
		authSettings = param.isAuthSettings();
		authHelp = param.isAuthHelp();
		authPlayback = param.isAuthPlayback();
		authSearch = param.isAuthSearch();

	}

	private void settingsFrame() {
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gbl_panel1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelSettings.setLayout(gbl_panel1);

		// Title MSG
		lblSettings.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblSettings = new GridBagConstraints();
		gbc_lblSettings.gridwidth = 2;
		gbc_lblSettings.anchor = GridBagConstraints.NORTH;
		gbc_lblSettings.insets = new Insets(0, 0, 5, 5);
		gbc_lblSettings.gridx = 4;
		gbc_lblSettings.gridy = 1;
		panelSettings.add(lblSettings, gbc_lblSettings);

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 2;
		lblError.setForeground(Color.RED);
		panelSettings.add(lblError, gbc_lblNewLabel);

		// Strut
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 3;
		panelSettings.add(horizontalStrut, gbc_horizontalStrut);

		// Kill The App After test Checkbox
		chckbxKillswitch = new JCheckBox("Terminate App After Test?", kill);
		GridBagConstraints gbc_chckbxKillswitch = new GridBagConstraints();
		gbc_chckbxKillswitch.gridwidth = 11;
		gbc_chckbxKillswitch.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxKillswitch.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxKillswitch.gridx = 1;
		gbc_chckbxKillswitch.gridy = 3;
		panelSettings.add(chckbxKillswitch, gbc_chckbxKillswitch);

		// IP Address Label
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.anchor = GridBagConstraints.WEST;
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 1;
		gbc_lblIp.gridy = 4;
		panelSettings.add(lblIp, gbc_lblIp);

		// IP Address Field
		txtFldip = new JTextField(ip);
		GridBagConstraints gbc_txtFldip = new GridBagConstraints();
		gbc_txtFldip.gridwidth = 9;
		gbc_txtFldip.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFldip.anchor = GridBagConstraints.NORTH;
		gbc_txtFldip.insets = new Insets(0, 0, 5, 5);
		gbc_txtFldip.gridx = 3;
		gbc_txtFldip.gridy = 4;
		panelSettings.add(txtFldip, gbc_txtFldip);

		// Strut
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 12;
		gbc_horizontalStrut_1.gridy = 4;
		panelSettings.add(horizontalStrut_1, gbc_horizontalStrut_1);

		// Title ID Label
		GridBagConstraints gbc_lblAppid = new GridBagConstraints();
		gbc_lblAppid.anchor = GridBagConstraints.WEST;
		gbc_lblAppid.insets = new Insets(0, 0, 5, 5);
		gbc_lblAppid.gridx = 1;
		gbc_lblAppid.gridy = 5;
		panelSettings.add(lblAppid, gbc_lblAppid);

		// Title ID Field
		txtTitleId = new JTextField(titleID);
		GridBagConstraints gbc_fldAppId = new GridBagConstraints();
		gbc_fldAppId.gridwidth = 9;
		gbc_fldAppId.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldAppId.insets = new Insets(0, 0, 5, 5);
		gbc_fldAppId.gridx = 3;
		gbc_fldAppId.gridy = 5;
		panelSettings.add(txtTitleId, gbc_fldAppId);
		txtTitleId.setColumns(10);

		// TV Series Content ID Label
		GridBagConstraints gbc_lblTvseriescontentid = new GridBagConstraints();
		gbc_lblTvseriescontentid.anchor = GridBagConstraints.WEST;
		gbc_lblTvseriescontentid.insets = new Insets(0, 0, 5, 5);
		gbc_lblTvseriescontentid.gridx = 1;
		gbc_lblTvseriescontentid.gridy = 6;
		panelSettings.add(lblTvseriescontentid, gbc_lblTvseriescontentid);

		// TV Series Content ID Field
		txtFldTvSeriesContentId = new JTextField(tvSeriesID);
		GridBagConstraints gbc_txtFldtvseriescontentid = new GridBagConstraints();
		gbc_txtFldtvseriescontentid.gridwidth = 9;
		txtFldTvSeriesContentId.setColumns(10);
		gbc_txtFldtvseriescontentid.insets = new Insets(0, 0, 5, 5);
		gbc_txtFldtvseriescontentid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFldtvseriescontentid.gridx = 3;
		gbc_txtFldtvseriescontentid.gridy = 6;
		panelSettings.add(txtFldTvSeriesContentId, gbc_txtFldtvseriescontentid);

		// TV Episode Content ID Label
		GridBagConstraints gbc_lblTvepisodecontentid = new GridBagConstraints();
		gbc_lblTvepisodecontentid.anchor = GridBagConstraints.WEST;
		gbc_lblTvepisodecontentid.insets = new Insets(0, 0, 5, 5);
		gbc_lblTvepisodecontentid.gridx = 1;
		gbc_lblTvepisodecontentid.gridy = 7;
		panelSettings.add(lblTvepisodecontentid, gbc_lblTvepisodecontentid);

		// TV Episode Content ID Field
		txtTvepisodecontentid = new JTextField(tvEpisodeID);
		GridBagConstraints gbc_txtTvepisodecontentid = new GridBagConstraints();
		gbc_txtTvepisodecontentid.gridwidth = 9;
		txtTvepisodecontentid.setColumns(10);
		gbc_txtTvepisodecontentid.insets = new Insets(0, 0, 5, 5);
		gbc_txtTvepisodecontentid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTvepisodecontentid.gridx = 3;
		gbc_txtTvepisodecontentid.gridy = 7;
		panelSettings.add(txtTvepisodecontentid, gbc_txtTvepisodecontentid);

		// Movie Content ID Label
		GridBagConstraints gbc_lblMoviecontentid = new GridBagConstraints();
		gbc_lblMoviecontentid.anchor = GridBagConstraints.WEST;
		gbc_lblMoviecontentid.insets = new Insets(0, 0, 5, 5);
		gbc_lblMoviecontentid.gridx = 1;
		gbc_lblMoviecontentid.gridy = 8;
		panelSettings.add(lblMoviecontentid, gbc_lblMoviecontentid);

		// Movie Content ID Field
		txtMoviecontentid = new JTextField(movieID);
		GridBagConstraints gbc_txtMoviecontentid = new GridBagConstraints();
		gbc_txtMoviecontentid.gridwidth = 9;
		gbc_txtMoviecontentid.insets = new Insets(0, 0, 5, 5);
		gbc_txtMoviecontentid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMoviecontentid.gridx = 3;
		gbc_txtMoviecontentid.gridy = 8;
		panelSettings.add(txtMoviecontentid, gbc_txtMoviecontentid);

		// Package ID Label
		GridBagConstraints gbc_lblPackege = new GridBagConstraints();
		gbc_lblPackege.anchor = GridBagConstraints.WEST;
		gbc_lblPackege.insets = new Insets(0, 0, 5, 5);
		gbc_lblPackege.gridx = 1;
		gbc_lblPackege.gridy = 9;
		panelSettings.add(lblPackage, gbc_lblPackege);

		// Package ID Field
		txtPackegenumber = new JTextField(pacadgeID);
		GridBagConstraints gbc_txtPackegenumber = new GridBagConstraints();
		gbc_txtPackegenumber.gridwidth = 9;
		gbc_txtPackegenumber.insets = new Insets(0, 0, 5, 5);
		gbc_txtPackegenumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPackegenumber.gridx = 3;
		gbc_txtPackegenumber.gridy = 9;
		panelSettings.add(txtPackegenumber, gbc_txtPackegenumber);

		// Screen Shot Path Label
		GridBagConstraints gbc_lblScreenshotpath = new GridBagConstraints();
		gbc_lblScreenshotpath.anchor = GridBagConstraints.WEST;
		gbc_lblScreenshotpath.insets = new Insets(0, 0, 5, 5);
		gbc_lblScreenshotpath.gridx = 1;
		gbc_lblScreenshotpath.gridy = 10;
		panelSettings.add(lblScreenshotpath, gbc_lblScreenshotpath);

		// Screen Shot Path Field
		txtScreenshotpath = new JTextField(screenShotPath);
		GridBagConstraints gbc_txtScreenshotpath = new GridBagConstraints();
		gbc_txtScreenshotpath.gridwidth = 9;
		gbc_txtScreenshotpath.insets = new Insets(0, 0, 5, 5);
		gbc_txtScreenshotpath.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtScreenshotpath.gridx = 3;
		gbc_txtScreenshotpath.gridy = 10;
		panelSettings.add(txtScreenshotpath, gbc_txtScreenshotpath);

		// Dismiss Errors Automatically checkbox
		chckbxDismissErrorsAutomatically = new JCheckBox(
				"Dismiss Errors automatically", autoDismiss);
		GridBagConstraints gbc_chckbxDissmissErrorsAutomatically = new GridBagConstraints();
		gbc_chckbxDissmissErrorsAutomatically.gridwidth = 11;
		gbc_chckbxDissmissErrorsAutomatically.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxDissmissErrorsAutomatically.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDissmissErrorsAutomatically.gridx = 1;
		gbc_chckbxDissmissErrorsAutomatically.gridy = 11;
		panelSettings.add(chckbxDismissErrorsAutomatically,
				gbc_chckbxDissmissErrorsAutomatically);

		// Strut
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 3;
		gbc_verticalStrut.gridy = 12;
		panelSettings.add(verticalStrut, gbc_verticalStrut);

		// Authorities Label
		GridBagConstraints gbc_lblAuthoritiesToTest = new GridBagConstraints();
		gbc_lblAuthoritiesToTest.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAuthoritiesToTest.gridwidth = 2;
		gbc_lblAuthoritiesToTest.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthoritiesToTest.gridx = 3;
		gbc_lblAuthoritiesToTest.gridy = 13;
		panelSettings.add(lblAuthoritiesToTest, gbc_lblAuthoritiesToTest);

		// Scenarios Label
		GridBagConstraints gbc_lblScenarios = new GridBagConstraints();
		gbc_lblScenarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblScenarios.gridx = 6;
		gbc_lblScenarios.gridy = 13;
		panelSettings.add(lblScenarios, gbc_lblScenarios);

		// Default Authority Checkbox
		chckbxDefault = new JCheckBox("Default", authDefault);
		GridBagConstraints gbc_chckbxDefault = new GridBagConstraints();
		gbc_chckbxDefault.anchor = GridBagConstraints.WEST;
		gbc_chckbxDefault.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDefault.gridx = 3;
		gbc_chckbxDefault.gridy = 14;
		panelSettings.add(chckbxDefault, gbc_chckbxDefault);

		// Help Authority Checkbox
		chckbxMediahelp = new JCheckBox("Help", authHelp);
		GridBagConstraints gbc_chckbxMediahelp = new GridBagConstraints();
		gbc_chckbxMediahelp.anchor = GridBagConstraints.WEST;
		gbc_chckbxMediahelp.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMediahelp.gridx = 4;
		gbc_chckbxMediahelp.gridy = 14;
		panelSettings.add(chckbxMediahelp, gbc_chckbxMediahelp);

		// Details Authority Checkbox
		chckbxMediaDetails = new JCheckBox("Details", authDetails);
		GridBagConstraints gbc_chkbxMediaDetails = new GridBagConstraints();
		gbc_chkbxMediaDetails.anchor = GridBagConstraints.WEST;
		gbc_chkbxMediaDetails.insets = new Insets(0, 0, 5, 5);
		gbc_chkbxMediaDetails.gridx = 3;
		gbc_chkbxMediaDetails.gridy = 15;
		panelSettings.add(chckbxMediaDetails, gbc_chkbxMediaDetails);

		// Playback Authority Checkbox
		chckbxMediaPlayback = new JCheckBox("Playback", authPlayback);
		GridBagConstraints gbc_chkbxMediaPlayback = new GridBagConstraints();
		gbc_chkbxMediaPlayback.anchor = GridBagConstraints.WEST;
		gbc_chkbxMediaPlayback.insets = new Insets(0, 0, 5, 5);
		gbc_chkbxMediaPlayback.gridx = 4;
		gbc_chkbxMediaPlayback.gridy = 15;
		panelSettings.add(chckbxMediaPlayback, gbc_chkbxMediaPlayback);

		// Settings Authority Checkbox
		chckbxSettings = new JCheckBox("Settings", authSettings);
		GridBagConstraints gbc_chckbxSettings = new GridBagConstraints();
		gbc_chckbxSettings.anchor = GridBagConstraints.WEST;
		gbc_chckbxSettings.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSettings.gridx = 3;
		gbc_chckbxSettings.gridy = 16;
		panelSettings.add(chckbxSettings, gbc_chckbxSettings);

		// Search Authority Checkbox
		chckbxSearch = new JCheckBox("Search", authSearch);
		GridBagConstraints gbc_chckbxSearch = new GridBagConstraints();
		gbc_chckbxSearch.anchor = GridBagConstraints.WEST;
		gbc_chckbxSearch.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSearch.gridx = 4;
		gbc_chckbxSearch.gridy = 16;
		panelSettings.add(chckbxSearch, gbc_chckbxSearch);

		// Run All Tests
		testGroup.add(rdbtnAll);
		rdbtnAll.setSelected(scenario.equals("all"));
		GridBagConstraints gbc_rdbtnAll = new GridBagConstraints();
		gbc_rdbtnAll.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAll.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAll.gridx = 6;
		gbc_rdbtnAll.gridy = 14;
		panelSettings.add(rdbtnAll, gbc_rdbtnAll);

		// Run Only Valid Tests
		testGroup.add(rdbtnValidOnly);
		rdbtnValidOnly.setSelected(scenario.equals("valid"));
		GridBagConstraints gbc_rdbtnValidOnly = new GridBagConstraints();
		gbc_rdbtnValidOnly.anchor = GridBagConstraints.WEST;
		gbc_rdbtnValidOnly.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnValidOnly.gridx = 6;
		gbc_rdbtnValidOnly.gridy = 15;
		panelSettings.add(rdbtnValidOnly, gbc_rdbtnValidOnly);

		// Run Invalid only Tests
		testGroup.add(rdbtnInvalidOnly);
		rdbtnInvalidOnly.setSelected(scenario.equals("inval"));
		GridBagConstraints gbc_rdbtnInvalidOnly = new GridBagConstraints();
		gbc_rdbtnInvalidOnly.anchor = GridBagConstraints.WEST;
		gbc_rdbtnInvalidOnly.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnInvalidOnly.gridx = 6;
		gbc_rdbtnInvalidOnly.gridy = 16;
		panelSettings.add(rdbtnInvalidOnly, gbc_rdbtnInvalidOnly);

		// Strut
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.gridwidth = 3;
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 7;
		gbc_horizontalStrut_2.gridy = 15;
		panelSettings.add(horizontalStrut_2, gbc_horizontalStrut_2);
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.anchor = GridBagConstraints.SOUTHEAST;

		// Save Config
		gbc_btnSave.gridx = 10;
		gbc_btnSave.gridy = 15;
		panelSettings.add(btnSave, gbc_btnSave);
		btnSave.addActionListener(this);

		// Strut
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 5;
		gbc_horizontalStrut_4.gridy = 16;
		panelSettings.add(horizontalStrut_4, gbc_horizontalStrut_4);

		// Strut
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 7;
		gbc_horizontalStrut_3.gridy = 16;
		panelSettings.add(horizontalStrut_3, gbc_horizontalStrut_3);

		// Run the Test
		GridBagConstraints gbc_btnRun = new GridBagConstraints();
		gbc_btnRun.insets = new Insets(0, 0, 5, 5);
		gbc_btnRun.gridx = 10;
		gbc_btnRun.gridy = 16;
		panelSettings.add(btnRun, gbc_btnRun);
		btnRun.addActionListener(this);

		getContentPane().add(panelSettings);

		// Strut
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.gridwidth = 2;
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 4;
		gbc_verticalStrut_2.gridy = 17;
		panelSettings.add(verticalStrut_2, gbc_verticalStrut_2);
	}

	private void runFrame() throws Exception {
		// FormLinks newLinks = new FormLinks();
		@SuppressWarnings("unused")
		RunFrame frame = new RunFrame(kill);
		setVisible(false);
	}

	private void saveData() throws FileNotFoundException {
		retriveData();
		param.setKill(kill);
		param.setIp(ip);
		param.setTitleID(titleID);
		param.setTvSeriesID(tvSeriesID);
		param.setTvEpisodeID(tvEpisodeID);
		param.setMovieID(movieID);
		param.setPacadgeID(pacadgeID);
		param.setScreenShotPath(screenShotPath);
		param.setAutoDismiss(autoDismiss);
		param.setScenario(scenario);
		param.setAuthDefault(authDefault);
		param.setAuthHelp(authHelp);
		param.setAuthDetails(authDetails);
		param.setAuthSettings(authSettings);
		param.setAuthDetails(authDetails);
		param.setAuthPlayback(authPlayback);
		param.setAuthSearch(authSearch);
		param.saveParamChangesAsXML();
	}

	private void retriveData() {
		kill = chckbxKillswitch.isSelected();
		ip = txtFldip.getText();
		titleID = txtTitleId.getText();
		tvSeriesID = txtFldTvSeriesContentId.getText();
		tvEpisodeID = txtTvepisodecontentid.getText();
		movieID = txtMoviecontentid.getText();
		pacadgeID = txtPackegenumber.getText();
		screenShotPath = txtScreenshotpath.getText();
		autoDismiss = chckbxDismissErrorsAutomatically.isSelected();
		authDefault = chckbxDefault.isSelected();
		authDetails = chckbxMediaDetails.isSelected();
		authSettings = chckbxSettings.isSelected();
		authHelp = chckbxMediahelp.isSelected();
		authPlayback = chckbxMediaPlayback.isSelected();
		authSearch = chckbxSearch.isSelected();

		if (rdbtnAll.isSelected()) {
			scenario = "all";
		} else if (rdbtnValidOnly.isSelected()) {
			scenario = "valid";
		} else
			scenario = "inval";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			saveData();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		if ("RUN!".equalsIgnoreCase(e.getActionCommand())) {
			if (ip.equalsIgnoreCase(null) || ip.equalsIgnoreCase("")) {
				lblError.setText(ERR_IP);
			} else if (titleID.equalsIgnoreCase(null) || titleID.equals("")) {
				lblError.setText(ERR_TITLE);
			} else if (tvSeriesID.equalsIgnoreCase("")
					&& tvEpisodeID.equalsIgnoreCase("")
					&& movieID.equalsIgnoreCase("")) {
				lblError.setText(ERR_MEDIA_ID);
			} else if (tvSeriesID.equalsIgnoreCase(null)
					&& tvEpisodeID.equalsIgnoreCase(null)
					&& movieID.equalsIgnoreCase(null)) {
				lblError.setText(ERR_MEDIA_ID);
			} else if (authDefault == false && authDetails == false
					&& authSettings == false && authHelp == false
					&& authPlayback == false && authSearch == false) {
				lblError.setText(ERR_AUTH);
			} else if (kill == true && pacadgeID.equalsIgnoreCase("")) {
				lblError.setText(ERR_PACK);
			} else if (kill == true && pacadgeID.equalsIgnoreCase(null)) {
				lblError.setText(ERR_PACK);
			} else {
				try {
					FormLinks newLinks = new FormLinks(titleID, tvSeriesID, tvEpisodeID, movieID, scenario, authDefault, authDetails, authSettings, authHelp, authPlayback, authSearch);
//					runFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
