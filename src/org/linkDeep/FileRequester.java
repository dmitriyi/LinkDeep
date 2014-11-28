package org.linkDeep;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileRequester extends JFrame {
	
	JPanel panle1 = new JPanel();
	
	public FileRequester(){
		super(Main.APP_NAME);
		
		setSize(700, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		choserFrame();
		add(panle1);
		setVisible(false);
	}

	public void choserFrame(){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Excel 98 - 2003 Workbook", "xls");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(panle1);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filePath = chooser.getSelectedFile().getPath();
//			GUIMain newGUI = new GUIMain(filePath);
		}
	}

}
