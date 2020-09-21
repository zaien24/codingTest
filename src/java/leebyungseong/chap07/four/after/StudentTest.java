package java.leebyungseong.chap07.four.after;

public class StudentTest {
	public static void main(String[] args){
		
		//Student s= new Student();  //추상 클래스는 객체 생성이 불가능하다.
		Student st= new University ("홍길동",3,22,"차범근");  //upcasting
		Elementary m  = new Elementary("이순신",2,"홍명보");
			
		System.out.println("학생 이름:"+st.getName());
		System.out.println(st.getTeacher());
		System.out.println(m.getTeacher());

	
	}
}
