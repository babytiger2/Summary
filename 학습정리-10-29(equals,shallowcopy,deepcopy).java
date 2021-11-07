1. Object클래스의 11개 함수를 나열해 보시오.
그중 우리가 외워야 할 함수들은 찍어 보세요 ㅎㅎ
equals(Object arg0)
getClass()
hashCode()
notify()
notifyAll()
toString()
wait()
wait(long arg0)
wait(long arg0, int arg1)

2. equals 함수에 대하여 설명하시오.
boolean equals(Object obj)로 정의된 equals 메소드는 2개의 객체가 동일한지 검사하기 위해 사용된다. equals가 구현되는 방법은 2개의 객체가 참조하는 것이 동일한지 확인해야 한다.
결론은 2개의 객체가 가르키는 곳이 동일한 메모리 주소일 경우에만 동일한 객체가 된다.

3. String 클래스 에서 문자열 비교시 equals를 쓰는 이유는?
2개의 객체가 동일한지 검사하기 위해서 equals가 없다면 메모리 주소로 인해 같다고 판단 될 수 있기 때문에 문자열이 같은지 비교하려고 사용한다.

4. shallow copy, deep copy 의 차이는?
얕은 복사는 객체를 복사할 때, 해당 객체만 복사하여 새 객체를 생성한다. 복사된 객체의 인스턴스 변수는 원본 객체의 인스턴스 변수와 같은 메모리 주소를 참조한다. 따라서, 해당 메모리 주소의 값이 변경되면 원본 객체 및 복사 객체의 인스턴스 변수 값은 같이 변경된다.
깊은 복사는 객체를 복사 할 때, 해당 객체와 인스턴스 변수까지 복사하는 방식이다. 전부를 복사하여 새 주소에 담기 때문에 참조를 공유하지 않는다.

5. 금일 배운 Rectangle의 shallow copy 와 deep copy 일 때의 메모리 그림을 그려보시오.

6. 아래를 프로그래밍 하시오.
- 클래스 Person
* 필드 : 이름, 나이, 주소 선언
- 클래스 Student
* 필드 : 학교명, 학과, 학번, 8개 평균평점을 저장할 배열로 선언
* 생성자 : 학교명, 학과, 학번 지정
* 메소드 average() : 8개 학기 평균평점의 평균을 반환
- 클래스 Person과 Student 
- 프로그램 테스트 프로그램의 결과 : 8개 학기의 평균평점은 표준입력으로 받도록한다.

이름 : 김다정
나이 : 20

주소 : 서울시 관악구
학교 : 동양서울대학교
학과 : 전산정보학과
학번 : 20132222
----------------------------------------

8학기 학점을 순서대로 입력하세요

1학기 학점  → 3.37
2학기 학점  → 3.89
3학기 학점  → 4.35
4학기 학점  → 3.76
5학기 학점  → 3.89
6학기 학점  → 4.26
7학기 학점  → 4.89
8학기 학점  → 3.89

----------------------------------------

8학기 총 평균 평점은 4.0375점입니다.

class Person{
	private String name, age, addr;
	
	public Person(String name, String age, String addr){
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public void showInfo() {
		System.out.println("이름: " + name);
		System.out.println("전화: " + age);
		System.out.println();
		System.out.println("주소: " + addr);
	}
}
class Student extends Person{
	private String univ,major,num;
	
	public Student(String name, String age, String addr,String univ, String major, String num) {
		super(name,age,addr);
		this.univ = univ;
		this.major = major;
		this.num = num;
	}
	public void showInfo() {
		super.showInfo();
		System.out.println("대학: " + univ);
		System.out.println("전공: " + major);
		System.out.println("학번: " + num);
	}
}

public class StudentTest {
	public static void main(String[] args) {
		Student[] s = new Student[1];
		int stu = 0;
        s[stu++] = new Student("김다정", "20", "서울시 관악구","동양서울대학교", "전산정보학과", "20132222");
	       
        for(int i = 0; i < stu; i++) {
            s[i].showInfo();
            System.out.println();	
        }
}
	
	class Score{
		
		public Score(String score1, String score2, String score3, String score4, String score5, String score6,
				String score7, String score8) {
			Score sc = new Score("3.37", "3.89", "4.35","3.76", "3.89", "4.26", "4.89","3.89");
			
			for(int i=0;i<=9;i++) {
			System.out.println(i+"학기 점수 : "+sc);
			}
		}
	}
}

*********추상 클래스************
7. 철수 학생은 다음 3개의 필드와 메소드를 가진 4개의 클래스 Add, Sub, Mul, Div를 작성하려고 한다.
- int 타입의 a, b 필드: 2개의 피연산자
- void setValue(int a, int b): 피연산자 값을 객체 내에 저장한다.
- int calculate(): 클래스의 목적에 맞는 연산을 실행하고 결과를 리턴한다.

곰곰 생각해보니, Add, Sub, Mul, Div 클래스에 공통된 필드와 메소드가 존재하므로 새로운 추상 클래스 Calc를 작성하고,
 Calc를 상속받아 만들면 되겠다고 생각했다. 
그리고 main() 메소드에서 다음 실행 사례와 같이 2개의 정수와 연산자를 입력받은 후, 
Add, Sub, Mul, Div 중에서 이 연산을 처리할 수 있는 객체를 생성하고 setValue() 와 calculate()를 호출하여 
그 결과 값을 화면에 출력하면 된다고 생각하였다. 

철수처럼 프로그램을 작성하라.(예외처리 구문도 넣어 주세요^^)

두 정수와 연산자를 입력하시오 >> 5 7 +

import java.util.Scanner;

abstract class Calc{
	protected int a, b;

	void setValue(int a, int b) {
	this.a = a;
	this.b = b;
	}
	abstract int calculate();
}
class Add extends Calc{
	@Override
	int calculate() {
		return a + b;
	}
}
class Sub extends Calc{
	@Override
	int calculate() {
		return super.a - super.b;
	}
}
class Mul extends Calc{
	@Override
	int calculate() {
		return a * b;
	}
}
class Div extends Calc{
	@Override
	int calculate() {
		return super.a / super.b;
	}
}
public class ClaculaterTest{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 연산자를 입력하시오.");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		String op = sc.next();
		Calc cal = null;
		
		switch (op) {
		case "+":
			cal = new Add();
			break;
		case "-":
			cal = new Sub();
			break;
		case "*":
			cal = new Mul();
			break;
		case "/":
			cal = new Div();
			break;

		default:
			System.out.println("잘못된 연산입니다.");
			break;
		}
		cal.setValue(a,b);
		System.out.println(cal.calculate());
	}
}

8. 문자열을 입력 받아 한 글자씩 회전시켜 모두 출력하는 프로그램을 작성하라.
(클래스로 작성할 필요없이 메인에서 직접 할것)
[Hint] Scanner.nextLine()을 이용하면 빈칸을 포함하여 한 번에 한 줄을 읽을 수 있다.
문자열을 입력하세요. 빈칸이나 있어도 되고 영어 한글 모두 됩니다.

I Love you
Love youI
Love youI
ove youI L
ve youI Lo
e youI Lov
youI Love
youI Love
ouI Love y
uI Love yo
I Love you

import java.util.Scanner;

public class ILoveYou {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열입력");
		String input = sc.next();
		for (int i = 0; i <= input.length(); i++) {
			System.out.print(input.substring(i));
			System.out.println(input.substring(0, i));
		}
	}
}

*********************Override boolean**************************
class MyPoint{
	int a;
	int b;
	
	public MyPoint(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "Point(" + a + "," + b + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		MyPoint point = (MyPoint)obj;
		
		if((this.a == point.a) && (this.b == point.b)) {
			return true;
		}
		return false;
	}
}

public class MyPointarea {

	public static void main(String[] args) {

		MyPoint p = new MyPoint(3, 50);
		MyPoint q = new MyPoint(4, 50);

		System.out.println(p);
		//equals없어도 이미 부모에 있음
		if (p.equals(q))
			System.out.println("같은 점");
		else
			System.out.println("다른 점");

	}
}

package Other;

class Circle {
	private int x,y,r;
    
	public Circle(int x, int y , int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
    
	public String toString() {
		return ("Circle(" + x + "," + y + ")반지름" + r);
	}
    
    @Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {

			Circle circle = (Circle) obj;
			if ((this.x == circle.x) && (this.y == circle.y)) {
				return true;
			}
		}
		return false;
	}
}

public class MyPointarea {

	public static void main(String[] args) {
		Circle a = new Circle(2,3,5);
		Circle b = new Circle(2,3,30);
		
		System.out.println("원 a : " + a);
		System.out.println("원 b : " + b);
		
		if(a.equals(b))
			System.out.println("같은 원");
		else
			System.out.println("서로 다른 원");
	}
}

/*	
결과값
원 a : Circle(2,3)반지름5
원 b : Circle(2,3)반지름30
같은 원
*/

*********ShallowCopy
package edu.komo.ex.main;

class Point2 implements Cloneable {
    private int xPos;
    private int yPos;
    
    public Point2(int x, int y) {
        xPos = x;
        yPos = y;
    }
    
    public void showPosition() {
        System.out.printf("[%d, %d]", xPos, yPos);
        System.out.println();
    }

    public void changePos(int x, int y) {
        xPos = x;
        yPos = y;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Rectangle1 implements Cloneable {
    private Point2 upperLeft;     // 좌측 상단 좌표
    private Point2 lowerRight;     // 우측 하단 좌표
    
    public Rectangle1(int x1, int y1, int x2, int y2) {
        upperLeft = new Point2(x1, y1);
        lowerRight = new Point2(x2, y2);
    }

    // 좌표 정보를 수정함
    public void changePos(int x1, int y1, int x2, int y2) {
        upperLeft.changePos(x1, y1);
        lowerRight.changePos(x2, y2);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 직사각형 좌표 정보 출력    
    public void showPosition() {
        System.out.print("좌측 상단: ");
        upperLeft.showPosition();
        
        System.out.print("우측 하단: ");
        lowerRight.showPosition();
        System.out.println(); 
    }
}

class ShallowCopy {
    public static void main(String[] args) {
        Rectangle1 org = new Rectangle1(1, 1, 9, 9);
        Rectangle1 cpy;
        
        try {
            // 인스턴스 복사
            cpy = (Rectangle1)org.clone();

            // 한 인스턴스의 좌표 정보를 수정
            org.changePos(2, 2, 7, 7);

            org.showPosition();
            
            cpy.showPosition();
            
            
            org.changePos(3, 3, 3, 3);
            
            org.showPosition();
            
            cpy.showPosition();
            
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

*********도형 면적 구하기
package edu.kosmo.ex.main;

interface Shape {
	final double PI = 3.14; // 상수
	abstract void draw(); // 도형을 그리는 추상 메소드
	abstract double getArea(); // 도형의 면적을 리턴하는 추상 메소드

	default public void redraw() { // 디폴트 메소드
		System.out.print("--- 다시 그립니다.");
		draw();
	}
}

class Circle implements Shape {
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}
	@Override
	public void draw() {
		System.out.println("반지름이 " + radius + "인 원입니다.");
	}
	@Override
	public double getArea() {
		return PI * radius * radius;
	}
}

class Oval implements Shape {
	private int a, b;

	public Oval(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void draw() {
		System.out.println(a + "x" + b + "에 내접하는 타원입니다.");
	}

	public double getArea() {
		return PI * a * b;
	}
}

class Rect implements Shape {
	private int a, b;

	public Rect(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void draw() {
		System.out.println(a + "x" + b + "크기의 사각형 입니다.");
	}

	public double getArea() {
		return a * b;
	}
}

public class ShapeImplTest {

	public static void main(String[] args) {
		Shape[] list = new Shape[3]; // Shape을 상속받은 클래스 객체의 레퍼런스 배열
		
		list[0] = new Circle(10); // 반지름이 10인 원 객체
		list[1] = new Oval(20, 30); // 20x30 사각형에 내접하는 타원
		list[2] = new Rect(10, 40); // 10x40 크기의 사각형
		
		for (int i = 0; i < list.length; i++)
			list[i].redraw();
		
		for (int i = 0; i < list.length; i++)
			System.out.println("면적은 " + list[i].getArea());
	}

}
