1. 변수의 스코프에 대하여 설명하시오.
{}안에서 변수 선언을 했을 때 괄호가 끝나기 전까지는 유효하다.

2. 지역변수란?
함수 안에서 선언된 변수

3. 인스턴스 변수란?
class안에 있는 변수, 함수 밖에 있는 변수

4. 아래의 함수를 펙토리얼로 표현하시오.
System.out.println("3 factorial: " + factorial(3));
3 factorial: 3!
System.out.println("12 factorial: " + factorial(12));
12 factorial: 12!

5. 클래스의 구성요소는?
변수와 함수로 구성되어 있다.

6. 원의 넓이는 구하는 프로그램을 아래와 같이 작성하시오.
- 원클래스를 만들것
- 변수 radius
- 변수 radius에 대한 setter getter 함수 만들것
- getArea 함수
- 메인 메소드를 가진 다른 클래스(AreaTest)에서 원 객체를 생성할것.

class Circle{
	int radius;		//인스턴스 변수 선언
	public void setRadius(int r) {
		radius = r;
	}
	public int getRadius() {
		return radius;	//반지름 값을 가져와 보겠다
	}
	public double getArea() {
		return radius * radius * Math.PI;	//Math.PI는 고슬링 아저씨가 만들어 놓은 PI
	}	
}

public class CircleTest {
	public static void main(String[] args) {
		Circle2 c2 = new Circle2();	//Circle은 class명
		c2.setRadius(10);
	 
		System.out.println(c2.getArea());
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력 하시오 ");
		int r = sc.nextInt();
		Circle c = new Circle(r);
		c.getArea();
		*/
	}
}

7. 객체에 대하여 설명하시오.
.class를 메모리에 올린것

8. 아래의 클래스에 대하여, 메모리 그림을 그리시오.
class Rectangle{
	int width;
	int height;
	
	public int getArea() {
		return width * height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

public class Rectangle {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
	}
}
     Rectangle              int
     _______        2000 _________
1000| 2000  |-----> 2004|width    |
1004|_______|       2008|height   |
     rectangle      2012|getArea  |
	            2016|getWidth |
		    2020|setWidth |
		    2024|getHeight|
		    2028|setHeight|
						

9. 클래스와 객체의 차이는?
- 클래스 : .class
- 객체 : .class를 메모리에 올린것
///class를 생성. class를 하나 만들고 함수 호출( = 객체생성 )
class A{
	int num = 50;
	public void printNum() {
		System.out.println(num);
	}
}

public class InstanceTest {
	public static void main(String[] args) {
		A a;	//(int a;)A a; == A a = new A();
		a = new A();
		a.printNum();
	}
}

10. 아래의 프로그램을 작성하시오.
-1 부터 num 까지 합을 구하는 class 를 작성하도록 하시오.
 class GetSum {
	int num;
	void setNum(int n) {
		num = n;
	}
	void sum() {
		int sum = 0;
		for (int i = -1; i <= num; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
	}
}

public class SumMain {
	public static void main(String[] args) {
		GetSum getsum = new GetSum(); //1)객체 생성
		int num; //2)num 변수 선언
		num = 50;

		getsum.setNum(num); //3)getsum 객체의 setNum함수 호출, num값 50 저장
		getsum.sum(); //4)getsum객체의 sum함수 호출, 1-50까지 합 구함

	}
}

11. 아래의 프로그래밍을 작성하시오.
Gugudan gugudan = new Gugudan();
gugudan.printGugu(10); //1단부터 10단까지 출력
gugudan.printGugu(20); //1단부터 20단까지 출력

class Gugudan{
	public void printGugu(int dan) {
		for (int i = 1; i <= dan; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + (i * j));
			}
		}	
	}
}

public class count {
	public static void main(String args[]) {
		Gugudan gugudan = new Gugudan();
		gugudan.printGugu(10); //1단부터 10단까지 출력
		gugudan.printGugu(20); //1단부터 20단까지 출력
	}
}
