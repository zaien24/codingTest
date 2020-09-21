package java.leebyungseong.chap07.four.before;

public class Student {

	public String name;
	public int grade;
	
	public Student(){
		System.out.println("Student 생성자 호출");
	}
	
	public String getName(){
		return name;
	}
	
	public int getGrade(){
		return grade;
	}
	
	public String getStudInfo(){
		System.out.println("Student 클래스의 getStudInfo()메소드 호출");
		
		return "이름은 : " + name + " ,학년은 " +grade;
	}
	
	//학생의 담임선생님의 이름을 구하는 메소드
	public String getTeacher(){
		return "김길동 선생님";
	}
}
