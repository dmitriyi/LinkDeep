package org.linkDeep;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

public class RunFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Tests myTests = new Tests();

	boolean kill;
	String ip = "192.168.1.62";

	JTextArea textArea = new JTextArea("Starting");
	JButton btnStop = new JButton("Stop");
	GridBagLayout gridBagLayout = new GridBagLayout();

	public RunFrame(boolean kill) throws Exception {
		super(Main.APP_NAME);

		this.kill = kill;

		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		frame();

		setVisible(true);

		try {
			process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void frame() {

		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.anchor = GridBagConstraints.NORTH;
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 4;
		gbc_btnStop.gridy = 0;
		getContentPane().add(btnStop, gbc_btnStop);
		btnStop.addActionListener(this);

		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 11;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		getContentPane().add(textArea, gbc_textArea);

	}

	// public void setText (String toSet){
	// textArea.setText(toSet);
	// }

	private void process() throws Exception {
		executeCmd(myTests.connect(ip));
		if (kill == true) {
			executeCmd(myTests.killSwitch(ip));
		}
		/*
		 * while (Array newArray : totalArray){
		 * 
		 * }
		 */
	}

	private synchronized void executeCmd(final String command) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",
						command);
				builder.redirectErrorStream(true);
				Process p = null;
				try {
					p = builder.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader r = new BufferedReader(new InputStreamReader(p
						.getInputStream()));
				String line = "";

				while (true) {
					try {
						line = r.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (line == null) {
						break;
					}
					if (line.contains("Unreachable")) {
						textArea.append(line + "\n");
						System.out.println("Host Cannot be connected to");
						break;
					}
					textArea.append(line + "\n");
					System.out.println(line);
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Stop".equalsIgnoreCase(e.getActionCommand())) {
			System.exit(0);
		}

	}

}
