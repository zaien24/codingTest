package java.leebyungseong.chap07.four.before;

public class Elementary extends Student {
	
	public Elementary(String name, int grade,int point){
		System.out.println("Elementary 생성자 호출");
		super.name=name;
		super.grade=grade;
		
	}
	
	public Elementary(String name, int grade){
		System.out.println("Elementary 생성자 호출");
		super.name=name;
		super.grade=grade;
	}
	
	public Elementary(){
		this("이순신",3);
		System.out.println("Elementary 생성자 호출");
	}
	
	public String getClassTeacher(){
		return "박길순 선생님";
	}	

}
