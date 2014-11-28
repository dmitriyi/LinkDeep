package org.linkDeep;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcellParser {
	
	private String inputFile;

	  public void setInputFile(String inputFile) {
	    this.inputFile = inputFile;
	  }

	  public void read() throws IOException  {
		  // Create new input file:
	    File inputWorkbook = new File(inputFile);
	    Workbook w;
	    // Try block
	    try {
	    	// Use imported work book class to get workbook
	      w = Workbook.getWorkbook(inputWorkbook);
	      // Get the first Sheet
	      Sheet sheet = w.getSheet(0);
	      // Loop over ALL! columns and lines in the sheet

	      for (int j = 0; j < sheet.getColumns(); j++) {
	        for (int i = 0; i < sheet.getRows(); i++) {
	          Cell cell = sheet.getCell(j, i);
	          CellType type = cell.getType();
	          if (type == CellType.LABEL) {
	            System.out.println("I got a label "
	                + cell.getContents());
	          }

	          if (type == CellType.NUMBER) {
	            System.out.println("I got a number "
	                + cell.getContents());
	          }

	        }
	      }
	    } catch (BiffException e) {
	      e.printStackTrace();
	    }
	  }

	  public void sheets() throws IOException {
		  File inputWorkbook = new File(inputFile);
		   Workbook w;
		   int counter = 0;
		    try {
		    	w = Workbook.getWorkbook(inputWorkbook);
		    	for (String newSheet: w.getSheetNames()){
		    		System.out.println(newSheet);
		    		counter++;
		    	}
		    } catch (BiffException e) {
			      e.printStackTrace();
		    }
		    
	  }
	  
	  public void cells(int sheetNum) throws IOException {
		  File inputWorkbook = new File(inputFile);
		   Workbook w;
		    try {
		    	w = Workbook.getWorkbook(inputWorkbook);
		    	Sheet sheet = w.getSheet(sheetNum);
		    	
		    } catch (BiffException e){
		    	e.printStackTrace();
		    }
	  }
	  
	  
	  public static void main(String[] args) throws IOException {
		ExcellParser test = new ExcellParser();
	    test.setInputFile("C:\\Users\\Dmitriy Ignatov\\Desktop\\Java\\JLinkDeep\\Copy of PBS_Deeplinks.xls");
//	    test.read();
	    test.sheets();
	    
	  }
}
