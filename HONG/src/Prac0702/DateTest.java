package Prac0702;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {
public static void main(String[] args) {
	Calendar date1 = Calendar.getInstance();
	date1.add(Calendar.YEAR, 1);
	date1.set(Calendar.MONTH, 11);
	date1.set(Calendar.DAY_OF_MONTH, 27);
	date1.set(Calendar.HOUR_OF_DAY, 19);
	date1.set(Calendar.MINUTE, 17);
	date1.set(Calendar.SECOND, 1);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
	System.out.println(sdf.format(date1));
	
	
}
}
