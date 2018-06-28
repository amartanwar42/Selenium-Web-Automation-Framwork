package generic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemDate {


	public static String currentDate()
	{
		SimpleDateFormat simpledateformat= new SimpleDateFormat("M-dd-yyyy:hh:mm:ss");
		String d=simpledateformat.format(new Date());
		String date=d.toString().replace(":", "-");
		return date;
	
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

}
