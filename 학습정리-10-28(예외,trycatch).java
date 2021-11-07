1. 오류(Error)와 예외(Exception)의 차이는?
에러는 시스템에 비정상적인 상황이 생겼을 때 발생한다.
예외는 개발자가 구현한 로직에서 발생한다. 예외는 발생할 상황을 미리 예측하여 처리한다.

2. unchecked 와 checked 예외의 차이는?
unchecked는 RuntimeException으로 보통의  error이고 명시적인 처리를 강제로 하지 않는다. 
checked는 반드시 예외 처리를 해야하고 try/catch나 throws IOException으로 처리한다.

3. 예외처리(Exception Handling) UML(상속도)참고하여  그리시오.

4. throws 에 대하여 설명하시오.
받은 함수한테 해당 예외를 나를 호출한 함수한테 다시 주는 것(예외 처리)
스스로 처리하지 않는다.
ex)throws IOException

5. 아래가 컴파일 에러가 나는 이유에 대하여 설명하시오.
try {
		int num = 6 / 0;
} catch (Exception e) {
		e.printStackTrace();
} catch (InputMismatchException e) {
		e.printStackTrace();
}


6. 사칙연산 계산기를 아래의 조건으로 짜시오.
interface ICalculator {
	int add(int x, int y);
	int sub(int x, int y);
	int mul(int x, int y);
	int div(int x, int y);
}

public class CalculatorMain {

	public static void main(String[] args) {
		ICalculator cal = new Calculator();

		//출력결과 참고 하여 try catch 를 적절히 넣을것  
			System.out.println(cal.add(6, 5));
			System.out.println(cal.sub(6, 5));	
			System.out.println(cal.mul(6, 5));	
			System.out.println(cal.div(6, 0));

	}
}

interface ICalculator {
	int add(int x, int y);
	int sub(int x, int y);
	int mul(int x, int y);
	int div(int x, int y);
}

class Calculator implements ICalculator{
	public int add(int x, int y) {
		return x+y;
	}

	@Override
	public int sub(int x, int y) {
		return x-y;
	}

	@Override
	public int mul(int x, int y) {
		return x*y;
	}

	@Override
	public int div(int x, int y) {
		return x/y;
	}
}

public class CalculatorMain {
	public static void main(String[] args) {
		ICalculator cal = new Calculator();
		try {
		//출력결과 참고 하여 try catch 를 적절히 넣을것  
			System.out.println(cal.add(6, 5));
			System.out.println(cal.sub(6, 5));	
			System.out.println(cal.mul(6, 5));	
			System.out.println(cal.div(6, 0));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("계산기 종료");
		}
	}
}
================================================

/*
11
1
30
java.lang.ArithmeticException: / by zero
	at Calculator.div(CalculatorMain.java:32)
	at CalculatorMain.main(CalculatorMain.java:45)
계산기 종료
*/

7. 과일, 사과, 배, 포도를 표현한 클래스를 만들고 이들 간의 관계를 고려하여 하나의 클래스를 추상 클래스로 만들어 메소드 print()를 구현하고 
다음과 같은 소스와 결과가 나오도록 클래스를 작성하시오.
- 소스
Fruit fAry[] = {new Grape(), new Apple(), new Pear()};
for(Fruit f : fAry)
f.print();

- 결과
나는 포도이다.
나는 사과이다.
나는 배이다.


abstract class Fruit{
	abstract void print();
}

class Grape extends Fruit{
	public void print() {
		System.out.println("나는 포도이다.");
	}
}
class Apple extends Fruit{
	public void print() {
		System.out.println("나는 사과이다.");
	}
}
class Pear extends Fruit{
	public void print() {
		System.out.println("나는 배이다.");
	}
}

public class ConfileTest {

	public static void main(String[] args) {
		Fruit fAry[] = {new Grape(), new Apple(), new Pear()};
		for(Fruit f : fAry)
		f.print();
	}

}

8. AreaTest
interface Shape {
	   final double PI = 3.14; // 상수
	   void draw(); // 도형을 그리는 추상 메소드
	   double getArea(); // 도형의 면적을 리턴하는 추상 메소드
	   default public void redraw() { // 디폴트 메소드
	      System.out.print("--- 다시 그립니다.");
	      draw();
	   }
	}

class Circle implements Shape{
	private double r;
	public Circle(double r){
		this.r = r;
	}
	public void draw() {
		System.out.println("반지름이 " + r + "인 원입니다.");
	}
	public double getArea(){
		return r*r*Math.PI;
	}
}

class Oval implements Shape{
	private int width;
	private int height;
	
	public Oval(int width,int height){
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		System.out.println(width + "X" + height + "에 내접하는 타원입니다.");
	}
	public double getArea(){
		return width*height*Math.PI;
	}
}
class Rect implements Shape{
	private int width;
	private int height;
	
	public Rect(int width,int height){
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		System.out.println(width + "X" + height + "크기의 사각형");
	}
	public double getArea(){
		return width*height;
	}
}

class AreaTest{
	public static void main(String[] args) {
	   Shape[] list = new Shape[3]; // Shape을 상속받은 클래스 객체의 레퍼런스 배열
	   list[0] = new Circle(10); // 반지름이 10인 원 객체
	   list[1] = new Oval(20, 30); // 20x30 사각형에 내접하는 타원
	   list[2] = new Rect(10, 40); // 10x40 크기의 사각형
	   for(int i=0; i<list.length; i++) list[i].redraw();
	   for(int i=0; i<list.length; i++) System.out.println("면적은 "+ list[i].getArea());
	}
}

*********좌표 출력할 때
Rectangle copy = (Rectangle)super.clone();

        // 깊은 복사의 형태로 복사본을 수정
        copy.upperLeft = (Point)upperLeft.clone();
        copy.lowerRight = (Point)lowerRight.clone();
        
        // 완성된 복사본의 참조를 반환
        return copy;
=======================================
(1,1,9,9)뽑아내고 싶을 때

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
        //return super.clone();
        
        Rectangle1 copy = (Rectangle1)super.clone();

        // 깊은 복사의 형태로 복사본을 수정
        copy.upperLeft = (Point2)upperLeft.clone();
        copy.lowerRight = (Point2)lowerRight.clone();
        
        // 완성된 복사본의 참조를 반환
        return copy;
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

public class ShallowCopy {
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
