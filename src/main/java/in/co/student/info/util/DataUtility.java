package in.co.student.info.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DataUtility {
	
	/**
     * Application Date Format
     */ 	
public static final String APP_DATE_FORMATE = "MM/dd/yyyy";

public static  SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMATE);


public static Date getDate(String val ){	
	try{
		return formatter.parse(val);
	}catch(Exception e){
		return null;
	}
}

public static Timestamp getCurrentTimestamp() {
	Timestamp timeStamp = null;
	try {
		timeStamp = new Timestamp(new Date().getTime());
	} catch (Exception e) {
	}
	return timeStamp;

}

public static String getStringDate(Date val ){	
	
		return formatter.format(val);
	
}

}
