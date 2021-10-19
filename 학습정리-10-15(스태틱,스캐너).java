1. 스태틱 변수의 다른 용어 3가지는?
공유변수, 클래스 변수, 정적 변수

2. 스태틱 변수의 접근 방법은?
1)인스턴트 생성 후 접근
2)클래스의 이름으로 접근

3. 스태틱 변수의 활용의 예를 드시오.
메모리 절약, 공유가 가능하고 정해져 있는 것은 스태틱 변수 가능

4. 스태틱 함수에 인스턴스 라면이 올수 없는 이유는?
스태틱함수는 메모리 생성이 먼저 되기 때문에 메모리의 생성 시기가 달라 오류가 발생한다.

5. 아래의 프로그램에서 기존에 값을 다이렉트로 넣었던 부분을 Scanner 로 입력 받아 처리 하시오.
int math, science, english;
	math = 90;
	science = 80; 
	english = 80;

	Grade me = new Grade(math, science, english);
	System.out.println("평균은 " + me.average());
	System.out.println(me.getGrade()); //우 입니다.

import java.util.Scanner;
class Grade {

	private int math;
	private int science;
	private int english;

	Grade(int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}

	public double average() {		//average() 함수 선언
		return (math + science + english) / 3.0;	//정해진 수가 아니기 때문에 return
	}

	public String getGrade() {		//getGrade() 함수 선언
		String str;			//String으로 문자열 사용

		double avg = average();

		if (avg >= 90) {
			str = "수 입니다.";
		} 
		else if (avg >= 80) {
			str = "우 입니다.";
		} 
		else {
			str = "가 입니다.";
		}
	return str;
	}
}

public class Score {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		
		int math = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();

		Grade me = new Grade(math, science, english);
		System.out.println("평균은 " + me.average());
		System.out.println(me.getGrade());
	}
}

6. 아래의 가위바위보 게임을 짜시오.
- 난수 발생 함수가 필요 할것입니다. 아래의 메소드를 참고 해 주세요.
- (Math.random() * 3 + 1);
1) 한 번만 실행 하는 걸 먼저 짜본다.(계속 실행이 아니라 한 번만 실행 되도록)
while(true){}로 돌린다.
2) sysout("계속하시겠습니까?(Y/N)");
char yesOrNo = scanner.next().charAt(0);

출력=======================
가위, 바위, 보 중 하나를 입력하세요.
가위
바위
졌습니다.
계속하시겠습니까?(Y/N)
y
가위, 바위, 보 중 하나를 입력하세요.
보
보
비겼습니다.
계속하시겠습니까?(Y/N)

*추가* 원형 스캐너
import java.util.Scanner;

class circle{
	private int r;
	
	public circle(int r){
		this.r = r;
	}
	public void circleArea(){
		System.out.println(r*r*Math.PI);
	}
}
public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반지름을 입력하세요.");
		
		int r = sc.nextInt();
		
		circle circle = new circle(r);
		circle.circleArea();

	}

}

*추가* 사각형 스캐너
import java.util.Scanner;

class Rectangle{
	private int a;
	private int b;
	
	Rectangle(int a, int b){
		this.a = a;
		this.b = b;
	}
	public void getArea() {
		System.out.println(a*b);	
	}
}

public class RectangleTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가로 세로 입력 하세요. ");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		Rectangle r = new Rectangle(a,b);
		r.getArea();
	}
}
