/*클래스가 잘 생각나지 않을 경우
1.class를 만든다.
2.데이터 멤버(인스턴스 변수)를 반드시 만든다.
3.생성자(클래스 이름과 동일하게)를 만든다.
4.데이터 멤버(인스턴스 변수)를 컨트롤하는 함수를 만든다.
5.생각이 나지 않을 경우, 다른 class 있는 내용을 복사, 붙여넣기 한다.

주의해야할 사항(실수 하지 말것)
1. 클래스 안에 클래스가 들어 가지 않도록 한다.
ex) class A{
	class B{
    }
}
2. 되도록 이면 메인을 가진 class는 따로 파일을 만들고 시작.
ex) 이런식으로
public class InterfaceTest {
	public static void main(String[] args) {
                // 구현 내용
	}
}
*/

1. Object 클래스란?
모든 자바 클래스의 최고 조상 클래스이다.
자바의 모든 클래스는 Object 클래스의 모든 메소드를 바로 사용할 수 있습니다.

2. 아래의 소스코드에 대하여 아래와 같이 출력되는 이유는?
출력 A@28a418fc
==============
class A{
}

public class Test {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a); 
		// String s = String.valueOf(x); -> s가 주소 뿌림
	}
}


3. class이름 및 함수에서 final의 의미는?
class final이 오면 상속이 안 된다는 의미
함수 앞에 final은 오버라이딩 할 수 없다는 의미

4. 아래의 Main이 돌아가도록 프로그래밍 하시오.
interface Printable { // MS가 정의하고 제공한 인터페이스
	public void print(String doc);
}
class SPrinterDriver implements Printable {
	@Override
	public void print(String doc) {
		System.out.println("From Samsung printer");
		System.out.println(doc);
	}
}
class LPrinterDriver implements Printable {
	@Override
	public void print(String doc){
	System.out.println("From LG printer");
	System.out.println(doc);
	}
}

	//SPrinterDriver 와 LPrinterDriver를 만드시오
	public static void main(String[] args) {
		String myDoc = "This is a report about...";

		// 삼성 프린터로 출력
		Printable prn = new SPrinterDriver();
		prn.print(myDoc);
		System.out.println();

		// LG 프린터로 출력
		prn = new LPrinterDriver();
		prn.print(myDoc);
	}

/*
출력: 
From Samsung printer
This is a report about ...
From LG printer
This is a report about ...
*/

5. @Override 에 대하여 설명하시오.
하위 클래스가 상위 클래스의 상속을 그대로 사용하지 않고 변경할 때 사용하는 메소드 오버라이딩(Overriding) 

6. interface 에 대하여 설명해 보시오.
자식 클래스는 부모클래스의 상속을 받지만 다중 상속은 지원하지 않는다. 하지만 다중 상속을 위해 자바에서는 인터페이스를 사용한다. 다른 클래스를 작성할 때 기본 틀을 제공하고 클래스 사이의 중간 역할을 담당하는 추상 클래스를 의미한다.
상속클래스를 할 때 extends를 사용 인터페이스는 implements를 사용한다.

7. interface 안에 올 수 있는 것은 두가지를 말해 보시오?
class와 달리 interface는 모든 필드는 public static final, 모든 메소드는 public abstract이 온다.

8. abstract 키워드란?
자식 클래스에서 반드시 오버라이딩해야만 사용할 수 있는 메소드

9. 아래의 결과가 나오도록 프로그래밍 하시오.
class Circle{
	private int r;
	
	public Circle(int r) {
		this.r = r;
	}
	public String toString() {
		return "출력: 넓이는 " + (r*r*3.141592) + " 입니다.";
	}
}

Object obj = new Circle(10);
System.out.println(obj);

//출력: 넓이는 314.134 입니다. (예시)

10. 아래의 프로그래밍을 하시오.
아래의 인터페이스에 맞추어(상속하여) 아래를 프로그래밍 하시오.
Circle, Rectangle , Triangle

interface AreaGetable{
double getArea();
}
class Circle implements AreaGetable{
	private int r;
	
	public Circle(int r) {
		this.r = r;
	}

	public double getArea() {
		return r * r * Math.PI;
	}
}
class Rectangle implements AreaGetable{
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public double getArea() {
		return width * height;
	}
}
class Triangle implements AreaGetable{
	private int width;
	private int height;
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public double getArea() {
		return (width * height)/2;
	}
}

main(){

AreaGetable area = new Circle(4);
sysout(area.getArea())

area = new Rectangle(4,5);
sysout(area.getArea())

area = new Triangle(4,5);
sysout(area.getArea())
}

//interface가 나오게 된 배경
//자바는 단일상속 → 다중상속을 지원
interface Printable{
	//interface특징:
	//추상 함수, abstract붙으면 뒤에 body가 오지 못한다.(함수 선언만 가능)그 문장이 끝;
	//바디 실제 구현부분이 없음
	//public abstract는 생략이 가능
	//없으면 컴파일러가 붙여줌
	//abstract = 자손이 구현하라(실제 구현하지 말라는 뜻)
	//	interface {
	//	void print(String doc);
	//	} 일 경우 자손을 구현하면 된다.
	public abstract void print(String doc); //→함수 선언
	
}
interface Printable2{
	void print(String doc);
}
class A{
	
}
//extends자리에 implements implements구현해라 

class Printer extends A implements Printable, Printable2{

	@Override
	public void print(String doc) {
		System.out.println(doc);
	}
	
}

public class Interface {

	public static void main(String[] args) {
		Printable printable = new Printer();
		printable.print("Hello World");

	}

}