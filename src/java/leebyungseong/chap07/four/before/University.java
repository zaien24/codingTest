package java.leebyungseong.chap07.four.before;

public class University extends Student {
	private int courses;
	
	public University(String name, int grade, int courses){
		super();
		System.out.println("University 생성자 호출");
		super.name=name;
		super.grade=grade;
		this.courses= courses;
				
	}
	
	public University(){
		this("이순신",2,20);
	}
	
	
	public int getCourses(){
		return courses;
	}
	
	//overriding 메소드
	public String getStudInfo(){
		System.out.println("University 클래스의 getStudInfo 메소드 호출");
		return "이름은>> "+ name + ", 학년은>> " +grade + ", 신청 학점은>> "+courses;
	}
	
	//학교명
	public String getProfessor(){
		return "이순신 교수님";
	}	
}