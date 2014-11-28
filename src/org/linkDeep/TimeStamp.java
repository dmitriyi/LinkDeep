package org.linkDeep;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

	public String getTimeStamp () throws ParseException {
			  Date date = new Date();
			  Timestamp timestamp = new Timestamp(date.getTime());
			  String tempStamp = "" + timestamp;
			  date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tempStamp);
			  
			  String newString = new SimpleDateFormat("yyyy-MM-dd_H-mm-ss").format(date); // 9:00

			  return newString;	 
			}
}

