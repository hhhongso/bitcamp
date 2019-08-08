package bitProject.cafe.dto;

// 게시판 Panel - Data Transfer Object
// 게시글 번호 : seq
// 게시글 제목 : text
// 작성자 : author
// 날짜 : date
public class BoardDTO {
	private String seq; // DB Primary Number
	private String text; // 제목
	private String dateWrite; // 작성일
	private String id;

	public BoardDTO() {
		
	} // constructor
	

	public BoardDTO(String seq, String text, String id, String dateWrite) {
		this.seq = seq;
		this.text = text;
		this.id = id;
		this.dateWrite = dateWrite;
	}

	// setter
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public void setDateWrite(String dateWrite) {
		this.dateWrite = dateWrite;
	}

	
	// getter
	public String getSeq() {
		return seq;
	}

	public String getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}

	
	public String getDateWrite() {
		return dateWrite;
	}

}



