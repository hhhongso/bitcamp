package bitProject.cafe.dto;

import java.io.Serializable;

public class RoomDTO implements Serializable {
	private int roomNum;
	private String id;
	private int year;
	private int month;
	private int date;
	private int inHour;
	private int outHour;

	public RoomDTO(int roomNum, String id, int year, int month, int date, int inHour, int outHour) {
		super();
		this.roomNum = roomNum;
		this.id = id;
		this.year = year;
		this.month = month;
		this.date = date;
		this.inHour = inHour;
		this.outHour = outHour;
	}

	public String getId() {
		return id;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public int getInHour() {
		return inHour;
	}

	public int getOutHour() {
		return outHour;
	}

}


