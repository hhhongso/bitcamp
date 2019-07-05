package kr.co.bit.obj2;

public interface Interface1 {

interface constructorMethod {
	abstract void constructorexecute();
}
	
interface processMethod {
	abstract void setBoard(); // ~할 게시글 제목 입력:
	abstract void setTitle(); // 번호, 제목, 내용, 작성자,...
	abstract void setSql(); //
	abstract void setQuery();
	abstract void executeProcess();
	abstract void setClose();
}
}
