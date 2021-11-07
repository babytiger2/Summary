1. instanceof 연산자에 대하여 설명하시오.
형 변환 가능한지 묻는 것

2. 아래를 프로그래밍 하시오.
 다음을 만족하는 클래스 Employee를 작성하시오. 
- 클래스 Employee(직원)은 
 //클래스 Regular(정규직)와 Temporary(비정규직)의 상위 클래스
- 필드: 이름, 나이, 주소, 부서, 월급 정보를 필드로 선언
- 생성자 : 이름, 나이, 주소, 부서를 지정하는 생성자 정의
- 메소드 printInfo() : 인자는 없고 자신의 필드 이름, 나이, 주소, 부서를 출력

class Employee{
	private String name, address, team;
	protected int age, salary;
	
	public Employee(String name, int age, String address, String team) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.team = team;
	}
	
	public void printInfo() {
		System.out.println("이름 :"+ name);
		System.out.println("나이 :" + age);
		System.out.println("주소 :" + address);
		System.out.println("소속 :" + team);
	}
}

public class NewTest {

	public static void main(String[] args) {
		
		Employee employee = 
				new Employee("홍길동", 27, "Los Angles", "개발");
		employee.printInfo();
	
	}
}

=======================================

다음을 만족하는 클래스 Regular를 작성하시오. 
- 클래스 Regular는 위에서 구현된 클래스 Employee의 하위 클래스
- 생성자 : 이름, 나이, 주소, 부서를 지정하는 상위 생성자 호출
- Setter : 월급 정보 필드를 지정
- 메소드 printInfo() : 인자는 없고 기본적인 이름, 나이, 주소, 부서 를 출력후
 "정규직  월급" 이라는 이름으로 월급출력
-상위 클래스에서 접근제한자 수정이 필요 하면 수정 할것.

class Employee{
	private String name, address, team;
	protected int age, salary;
	
	public Employee(String name, int age, String address, String team) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.team = team;
	}
	
	public void printInfo() {
		System.out.println("이름 :"+ name);
		System.out.println("나이 :" + age);
		System.out.println("주소 :" + address);
		System.out.println("소속 :" + team);
	}
}

class Regular extends Employee{
	
	public Regular(String name, int age, String address, String team) {
		super(name, age, address, team);
		
	}

	public void setSalary(int salary) {
		super.salary = salary;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println("정규직 월급" + super.salary);
	}
}

public class NewTest {

	public static void main(String[] args) {
		
		Employee employee = 
				new Employee("홍길동", 27, "Los Angles", "개발");
		employee.printInfo();
		
		Regular regular = 
				new Regular("김삿갓", 35, "New York", "개발");
		
		regular.setSalary(1000);
		regular.printInfo();
	}
}

3. Point 를 상속받아
3차원의 점을 나타내는 Point3D 클래스를 작성하라. 
다음 main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.
==================================================
public static void main(String[] args) {
	Point3D p = new Point3D(1,2,3); // 1,2,3은 각각 x, y, z축의 값.
	System.out.println(p.toString()+"입니다.");
	p.moveUp(); // z 축으로 위쪽 이동
	System.out.println(p.toString()+"입니다.");
	p.moveDown(); // z 축으로 아래쪽 이동
	p.move(10, 10); // x, y 축으로 이동
	System.out.println(p.toString()+"입니다.");
	p.move(100,  200, 300); // x, y, z축으로 이동
	System.out.println(p.toString()+"입니다.");
}
==================================================

class Point {
	private int x, y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) { 
		this.move(x, y);  
	}

	public int getX() { 
		return x; 
	}
	
	public int getY() { 
		return y; 
	}
	
	protected void move(int x, int y) {
		this.x = x; 						
		this.y = y;    					
	}
}
/*
class ColorPoint extends Point{
	private String color = "BLACK";   
	
	public ColorPoint() {
		
	}
	
	public ColorPoint(int x, int y, String color) { 
		super(x, y);
		this.color = color;
	}
	
	public ColorPoint(int x, int y) {
		super(x, y);
	}
	
	public void setXY(int x, int y) {
		super.move(x, y);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return color + "색의 ("+ super.getX()+", "+ super.getY()+")의 점";
	}
}
*/

class Point3D extends Point{
	private int z;
	
	public Point3D(int x,int y,int z) {
		super(x,y);
		this.z = z;
	}

	public void moveUp() {
		this.z++;
		//this.z = this.z + 1;
	}
	public void moveDown() {
		z--;
		//this.z = this.z - 1;
	}
	//public void move(int x, int y) {
		// super.move(x, y);
	//}
	public void move(int x, int y, int z) {
		super.move(x,y);
		this.z = z;
	}
	public String toString() {
		return "(" + super.getX() + "," + getY() + "," + z + ")의 점";
	}
}

/*
================================================
(1,2,3) 의 점입니다.
(1,2,4) 의 점입니다.
(10,10,3) 의 점입니다.
(100,200,300) 의 점입니다.
*/
================================================
/*
겜블링 게임을 n명이 하도록 수정하라.
실행 예시와 같이 게임에 참여하는 선수의 수를 입력 받고 각 선수의 이름을 
입력 받도록 수정하라.

겜블링 게임에 참여할 선수 숫자>>3
1번째 선수 이름>>황
2번째 선수 이름>>이
3번째 선수 이름>>김
[황]:
*/
import java.util.Scanner;

class Person {
	private String name;
	private int num1, num2, num3;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Person(String name) {
		this.name = name;
	}

	public boolean game() {

		num1 = (int) (Math.random() * 3 + 1);
		num2 = (int) (Math.random() * 3 + 1);
		num3 = (int) (Math.random() * 3 + 1);
		System.out.print("\t"+num1+" "+num2+" "+num3+" ");
		
		if (num1 == num2 && num2 == num3) {
			return true;
		}
		return false;
	}
}

public class GablingTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("겜블링 게임에 참여할 선수 숫자>>");
		int num = sc.nextInt();
		Person[] arrPerson = new Person[num]; 

		for(int i=0; i < arrPerson.length; i++) {
			System.out.println( ( i+1 ) + "번째 선수 이름>>");
			String name = sc.next();
			arrPerson[i] = new Person(name);
		}
		
		String buffer = sc.nextLine();
		while(true) {
			
			for(int i=0; i < arrPerson.length; i++) {
				System.out.print("["+arrPerson[i].getName()+"]:");
				//엔터를 받아 내기 위한 입력
				buffer = sc.nextLine();
				
				if(arrPerson[i].game()) {
					System.out.println("["+arrPerson[i].getName()+"]:" + "님이 이겼습니다.");
					return;
				}
				System.out.println("아쉽군요");
			}
		}
	}
}
