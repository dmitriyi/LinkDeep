package org.linkDeep;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class RunFrame extends JPanel implements ActionListener{
	
	JTextArea textArea = new JTextArea();
	JButton btnStop = new JButton("Stop");
	GridBagLayout gridBagLayout = new GridBagLayout();
	
	public RunFrame () throws Exception{
		
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.anchor = GridBagConstraints.NORTH;
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 4;
		gbc_btnStop.gridy = 0;
		add(btnStop, gbc_btnStop);
		btnStop.addActionListener(this);
		
		
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 12;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		add(textArea, gbc_textArea);
		setVisible(true);
		
		Tests newTest = new Tests();
		setText(newTest.connect("192.168.1.5"));
		
	}
	
	public void setText (String toSet){
		textArea.setText(toSet);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Stop".equalsIgnoreCase(e.getActionCommand())){
			System.exit(0);
		}
		
	}
	

}
