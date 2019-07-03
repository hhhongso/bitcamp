package kr.co.bit;
/* Calendar Ŭ������ 
 * new������ ����, getinstance�� ���� ��ü ����: Ŭ���� Ÿ�Կ��� ���� ���� ������. 
 *
 * static int YEAR			Calendar.YEAR 			 ���� �⵵�� �����´�.
static int MONTH 			Calendar.MONTH	 		 ���� ���� �����´�. (1���� 0) 
static int DATE 			Calendar.DATE			 ���� ���� ��¥�� �����´�. 
static int WEEK_OF_YEAR 	Calendar.WEEK_OF_YEAR	 ���� �⵵�� ��° ��
static int WEEK_OF_MONTH 	Calendar.WEEK_OF_MONTH	 ���� ���� ��° �� 
static int DAY_OF_YEAR 		Calendar.DAY_OF_YEAR	���� �⵵�� ��¥ 
static int DAY_OF_MONTH		Calendar.DAY_OF_MONTH	 ���� ���� ��¥ (DATE�� ����) 
static int DAY_OF_WEEK 		Calendar.DAY_OF_WEEK	���� ���� (�Ͽ����� 1, ������� 7)
static int HOUR 			Calendar.HOUR 			���� �ð� (12�ð���)
static int HOUR_OF_DAY		Calendar.HOUR_OF_DAY	���� �ð� (24�ð���) 
static int MINUTE 			Calendar.MINUTE			���� ��
static int SECOND 			Calendar.SECOND 		���� �� 
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
 *add(): ���� �ð���ŭ ���ϰų� ����. ��, Ư�� �ð��� �������� ���� �ð� ������ ��¥/�ð��� �� �� ����. 
 *before(), after(): Ķ���� �ν��Ͻ��� ���޵� ��ü�� ��Ÿ���� �ð� ����/���� �� Ȯ��. 
 *roll(): ���� �ð���ŭ ���ϰų� ����. ��, Calendar �ʵ忡�� ������ ���� �ʴ´�.
 */
public class CalendarTest {

	public static void main(String[] args) {
		Calendar myCal = Calendar.getInstance(); //��ü����
				
		myCal.set(Calendar.YEAR, 2019);
		myCal.set(Calendar.MONTH, 8); //Calendar Ŭ�������� month, ������ 0���� ����
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		//myCal.set(Calendar.DATE, 2); dayofmonth�� date
		//myCal.set(Calendar.HOUR, 15);
		myCal.set(Calendar.HOUR_OF_DAY, 19);
		myCal.set(Calendar.MINUTE, 17);
		myCal.set(Calendar.SECOND, 1);
		
		//������� ����: 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df = DateFormat.getDateTimeInstance(); //��ü����
		
		Date date = myCal.getTime();
		
		System.out.println(sdf.format(date));
		System.out.println(df.format(date));
	}

}
