import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class CalendarMain {
	public CalendarMain(){
		Date date = new Date(); // �ý��� ���� �ð��� �����´�. 
		System.out.println("���� ��¥: " + date);
		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� E���� H:m:s");
		System.out.println("���� ��¥: " + sdf.format(date));
//		Calendar cal = new GregorianCalendar();

		//�ý��� ���� �ð��� �����´�. 
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(cal.MONTH)+1; //Month �� 0���� ����. // cal ��ü�� ��ȿ�ϴ� cal.���� �θ��� �͵� ���� 
		int day = cal.get(Calendar.DAY_OF_MONTH); 
		int week = cal.get(Calendar.DAY_OF_WEEK); // day_of_week: ��~��. day�� 1���� ����
		String weekDay = null; 
		switch(week){
			case 1:	weekDay = "��"; break;
			case 2:	weekDay = "��"; break;
			case 3:	weekDay = "ȭ"; break;
			case 4:	weekDay = "��"; break;
			case 5:	weekDay = "��"; break;
			case 6:	weekDay = "��"; break;
			case 7:	weekDay = "��";
		}
		System.out.println("������: " + year +"��	"+ month +"�� "+ day +"�� " + weekDay + "����");

		//���� �ð��� �����Ϸ���, set()


	}

	public static void main(String[] args) 	{
		new CalendarMain();
	}
}
