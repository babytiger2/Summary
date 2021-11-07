1. Maker 인터페이스에 대하여 설명하시오.
일반적인 인터페이스와 동일하지만, 아무 메서드도 선언하지 않은 인터페이스이다. 대표적인 마커 인터페이스는 Serializable, Cloneable, EventListener가 있다.

2. 추상 클래스(abstract class)에 대하여 설명하시오.
자식 클래스에서 반드시 오버라이딩해야만 사용할 수 있는 메소드를 의미한다. 자바에서 추상 메소드의 사용 목적은 추상 메소드가 포함된 클래스를 상속받는 자식 클래스가 반드시
추상 메소드를 구현하도록 하기 위함입니다.

3. Exception 에 대하여 설명하시오.
프로그램 구성시 많은 에러가 발생한다. 프로그램이 오작동하지 않기 위한 자바의 배려이다. 하지만 에러를 무시하고 싶을 때나 에러에 맞는 적절한 처리를 하고 싶을 때 자바는 
try ... catch, throw을 이용하여 도와준다.

4. 에러를 내는 주체는?

5. 아래의 소스코드를 참고 하여 중에 Main안에 있는 두개의
getAllArea 과 getArea 함수를 완성하시오.
================================
interface AreaGetable {
	double getArea();

}

class Circle implements AreaGetable {
	private double r;

	public Circle(double r) {
		this.r = r;
	}

	@Override
	public double getArea() {

		return r * r * Math.PI;
	}
}

class Rectangle implements AreaGetable {

	private double width, height;

	public Rectangle(double width, double height) {
		this.height = height;
		this.width = width;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}
}


class CondOp {
public static double getAllArea(AreaGetable[] area) {
		double sum = 0;
		
		for(AreaGetable areaGetable : area) {
			sum = sum + areaGetable.getArea();
		}
		for(int i=0; i<area.length;i++) {
			sum = sum + area[i].getArea();
		}
			return sum;
	}
	public static void main(String[] args) {

		AreaGetable[] area = { new Rectangle(4, 5), new Circle(4), new Circle(4), new Circle(5), new Circle(5),
				new Circle(6) ,new Rectangle(4, 5),new Rectangle(4, 5),new Rectangle(4, 5),};

		// AreaGetable oneArea = new Circle(4);
		System.out.println(getAllArea(area));
		System.out.println(getArea(new Circle(10))); //314
		System.out.println(getArea(new Rectangle(4, 5))); //20

		// oneArea = new Rectangle(4,5);
		// System.out.println(area.getArea());

	}
private static double getArea(AreaGetable area) {
		
		return area.getArea();
	}
}

6. 아래의 결과를 나타내는 사칙연산 계산기를 완성하시오.
주의 잘못된 입력이 있으면 처음부터 다시 입력을 받도록 예외처리 구문(try catch)을 넣을것
=====================
*** 계산기 ***
수1 : 10
수2 : 20
연산 : +
계산 결과 : 30
계속 하시겠습니까? 계속 : Y , 종료 : N
y
*** 계산기 ***
수1 : R
잘못된 입력입니다. 다시입력해 주세요
*** 계산기 ***
수1 : 10
수2 : 20
연산 : *
계산 결과 : 200
계속 하시겠습니까? 계속 : Y , 종료 : N
y
*** 계산기 ***
수1 : 90
수2 : 80
연산 : /
계산 결과 : 1
계속 하시겠습니까? 계속 : Y , 종료 : N
n
종료입니다.

while{
try
입력 int
입력 int
입력 string

+-/*

연산결과 뿌려주고 
string y n
=====================
import java.util.Scanner;

class ByTimes {
	public static void main(String[] args) {

		while (true) {
			// 변수 선언
			int num1 = 0, num2 = 0, result = 0;
			String op = "";
			Scanner scan;

			try {
				scan = new Scanner(System.in);

				System.out.println("*** 계산기 ***"); // 타이틀 출력
				System.out.print("수1 : ");
				num1 = scan.nextInt();
				System.out.print("수2 : ");
				num2 = scan.nextInt();

				System.out.print("연산 : ");
				// 문자열 입력 처리
				op = scan.next();

				// 입력한 연산 문자로 분기.
				switch (op) {
				case "+":
					result = num1 + num2;
					break; // 각 case별로 분리
				case "-":
					result = num1 - num2;
					break;
				case "*":
					result = num1 * num2;
					break;
				case "/":
					result = num1 / num2;
					break;
				case "%":
					result = num1 % num2;
					break;
				default:
					System.out.println("잘못된 연산자 입력!");
					result = 0; // 생략해도 됨
					break;
				}

				System.out.println("계산 결과 : " + result);

				System.out.println("계속 하시겠습니까? 계속 : Y , 종료 : N");
				String finish = scan.next();

				if (finish.equals("N") || finish.equals("n"))
					break;

			} catch (Exception e) {
				System.out.println("잘못된 입력입니다. 다시입력해 주세요");
				continue;
			}

		}

		System.out.println("종료입니다.");
	}
}

***********바다,육지,하늘에 삽니다.
interface Printable {
	void printLine(String str);
}

class SimplePrinter implements Printable {
	public void printLine(String str) {
		System.out.println(str);
	}
}

class MultiPrinter extends SimplePrinter {
	public void printLine(String str) {
		super.printLine("start of multi...");
		super.printLine(str);
		super.printLine("end of multi");
	}
}

interface Sea {
}

interface Ground {
}

interface Locable {
	void printLive();
}

class Fish implements Locable, Sea {

	@Override
	public void printLive() {
		System.out.println("바다에 삽니다.");
	}
}

class Tiger implements Locable, Ground {

	@Override
	public void printLive() {
		System.out.println("육지에 삽니다.");
	}
}

class InstanceofInterface {


	public static void checkLocation(Locable loc) {
		
		if (loc instanceof Sea) {
			System.out.println("바다에 삽니다.");
		} else if (loc instanceof Ground) {
			System.out.println("육지에 삽니다.");
		} else {
			System.out.println("하늘에 살겠지");
		}
	
	}
	
	public static void main(String[] args) {
		Fish fish = new Fish();
		Tiger tiger = new Tiger();

		checkLocation(fish);
		checkLocation(tiger);

	}
}