package kr.co.bit;
/* Calendar 클래스는 
 * new연산자 없이, getinstance를 통해 객체 생성: 클래스 타입에서 직접 값을 가져옴. 
 *
 * static int YEAR			Calendar.YEAR 			 현재 년도를 가져온다.
static int MONTH 			Calendar.MONTH	 		 현재 월을 가져온다. (1월은 0) 
static int DATE 			Calendar.DATE			 현재 월의 날짜를 가져온다. 
static int WEEK_OF_YEAR 	Calendar.WEEK_OF_YEAR	 현재 년도의 몇째 주
static int WEEK_OF_MONTH 	Calendar.WEEK_OF_MONTH	 현재 월의 몇째 주 
static int DAY_OF_YEAR 		Calendar.DAY_OF_YEAR	현재 년도의 날짜 
static int DAY_OF_MONTH		Calendar.DAY_OF_MONTH	 현재 월의 날짜 (DATE와 동일) 
static int DAY_OF_WEEK 		Calendar.DAY_OF_WEEK	현재 요일 (일요일은 1, 토요일은 7)
static int HOUR 			Calendar.HOUR 			현재 시간 (12시간제)
static int HOUR_OF_DAY		Calendar.HOUR_OF_DAY	현재 시간 (24시간제) 
static int MINUTE 			Calendar.MINUTE			현재 분
static int SECOND 			Calendar.SECOND 		현재 초 
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
 *add(): 일정 시간만큼 더하거나 뺀다. 즉, 특정 시간을 기준으로 일정 시간 전후의 날짜/시간을 알 수 있음. 
 *before(), after(): 캘린더 인스턴스가 전달된 객체가 나타내는 시간 이전/이후 를 확인. 
 *roll(): 일정 시간만큼 더하거나 뺀다. 단, Calendar 필드에는 영향을 주지 않는다.
 */
public class CalendarTest {

	public static void main(String[] args) {
		Calendar myCal = Calendar.getInstance(); //객체생성
				
		myCal.set(Calendar.YEAR, 2019);
		myCal.set(Calendar.MONTH, 8); //Calendar 클래스에서 month, 요일은 0부터 시작
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		//myCal.set(Calendar.DATE, 2); dayofmonth랑 date
		//myCal.set(Calendar.HOUR, 15);
		myCal.set(Calendar.HOUR_OF_DAY, 19);
		myCal.set(Calendar.MINUTE, 17);
		myCal.set(Calendar.SECOND, 1);
		
		//출력형식 생성: 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df = DateFormat.getDateTimeInstance(); //객체생성
		
		Date date = myCal.getTime();
		
		System.out.println(sdf.format(date));
		System.out.println(df.format(date));
	}

}
