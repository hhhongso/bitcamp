import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class CalendarMain {
	public CalendarMain(){
		Date date = new Date(); // 시스템 상의 시간을 가져온다. 
		System.out.println("오늘 날짜: " + date);
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 H:m:s");
		System.out.println("오늘 날짜: " + sdf.format(date));
//		Calendar cal = new GregorianCalendar();

		//시스템 상의 시간을 가져온다. 
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(cal.MONTH)+1; //Month 는 0부터 시작. // cal 객체가 유효하니 cal.으로 부르는 것도 가능 
		int day = cal.get(Calendar.DAY_OF_MONTH); 
		int week = cal.get(Calendar.DAY_OF_WEEK); // day_of_week: 일~토. day는 1부터 시작
		String weekDay = null; 
		switch(week){
			case 1:	weekDay = "일"; break;
			case 2:	weekDay = "월"; break;
			case 3:	weekDay = "화"; break;
			case 4:	weekDay = "수"; break;
			case 5:	weekDay = "목"; break;
			case 6:	weekDay = "금"; break;
			case 7:	weekDay = "토";
		}
		System.out.println("오늘은: " + year +"년	"+ month +"월 "+ day +"일 " + weekDay + "요일");

		//사용사 시간을 설정하려면, set()


	}

	public static void main(String[] args) 	{
		new CalendarMain();
	}
}
