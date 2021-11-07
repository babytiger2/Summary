1. 배열에서의 초기화 방법은?
배열은 메모리 상에 연속적으로 나열한다. 변수는 한개의 데이터만 저장할 수 있습니다. 따라서 저장해야 할 데이터의 수가
많아지만 그만큼 많은 양의 변수를 선언되면서 비효율성이 발생한다. 그래서 효율적인 방법으로 인해 배열을 사용합니다. 배열은
같은 타입의 데이터를 연속된 공간에 나열시키고 각 데이터에 인덱스(index)를 부여해 놓은 자료구조입니다.
Arrays.fill을 사용하여 배열을 한 번에 초기화시키거나 for문을 통해 초기화시킵니다.

2. arraycopy 함수의 사용 방법은?
System.arraycopy( 배열1, 배열1의 복사시작번호, 배열2, 배열2의 복사시작번호, 복사길이)
System.arraycopy( 배열1[배열1의 복사시작번호], 배열2[배열2의 복사시작번호], 복사길이)


3.main 함수에서 String[] args 사용 방법은?
args를 문자열로 배열로 사용하겠다는 의미입니다.
args는 변수명이기 때문에 꼭 args가 아니어도 상관은 없으나 String[] args 구문 자체를 뺄 수는 없다.
main은 프로그램 실행 시 처음으로 수행되는 함수이기 때문에 외부로부터 값을 입력 받아야 하는데 프로그램 내부에서 값을
호출할 수 없으면 안되기 때문에 항상 문자열로 받게 됩니다.



4.enhenced for 문이란?
강화된 for문으로 값을 변경하려고 하면 사용이 부적절하다.
enhenced for문은 출력용.
for(int i =0; i<ar.length;i++)
sysout(ar[i]);
for(int i : ar)	//ar는 반복의 대상
sysout(i);


5. Box 클래스를 짜시오.
class Box {
	private int num;
	private String word;
	
	public Box(int num,String word) {
		this.num = num;
		this.word = word;
	}
	public int getBoxNum() {
		return num;
	}
	public String toString() {
		return word;
	}
}
public static void main(String[] args) {
	Box[] ar = new Box[5];
	ar[0] = new Box(101, "Coffee");
	ar[1] = new Box(202, "Computer");
	ar[2] = new Box(303, "Apple");
	ar[3] = new Box(404, "Dress");
	ar[4] = new Box(505, "Fairy-tale book");

	for (Box e : ar) {
		if (e.getBoxNum() == 505)
			System.out.println(e);
	}
}

6. 프로그램을 완성 하시오.

양의 정수 100개를 랜덤 생성하여, 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력해 보자.
public class Box{	
	public static void main(String[] args) {
		int [] num = new int[100];
		
		for(int i=0; i<num.length;i++) {
			num[i] = (int)(Math.random()*10000+1);
			
			if((num[i]%3)==0) {
				System.out.println(num[i]);
			}
		}
			
	}
}

7. 프로그램을 완성 하시오.(for문을 도는데 첫번째 거를 맥스를 잡고 두번째 값하고 비교)

- 5개의 숫자를 랜덤 으로 받아 배열로 저장
- 5개의 숫자 중 가장 큰 값을 출력

class ArrMax{
	private int[] arr;
	
	public ArrMax() {
		arr = new int[5];
		
		for(int i=0; i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100)+1;	//뒤에 1부터 100까지
			
		}
	}
	
	public void printMax() {	//printMax는 주로 show 쓰던 자리
		int max = arr[0];
		
		for(int i=0; i<arr.length;i++) {
			
			System.out.println(arr[i]);
			
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println("최대값은 "+max);
	}
}
public class MaxTest{	
	public static void main(String[] args) {
		ArrMax arrMax = new ArrMax();
		arrMax.printMax();
	}
}

8. char 배열을 생성하여, 알파벳 A~Z까지 대입 후, 출력 해보자. 
알파벳은 26개.
public class MaxTest{	
	public static void main(String[] args) {
		
		char[] alpabet = new char[26];
		
		for(int i=0;i<alpabet.length;i++) {
			alpabet[i] = (char)('A' + i);
			System.out.println(alpabet[i]);
		}
		for (char ch : alpabet) {
			System.out.println(ch);
		}
	}
}

9. 정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 
배열에 저장하라. 
그리고 배열에 든 숫자들과 평균을 출력하라.

랜덤한 정수들 : 3 6 3 6 1 3 8 9 6 9
평균은 5.4
class ArrAvg{
	private int[] arr = new int[10];
	private int num;

	public int[] getArr() {
		return arr;
	}
	
	public int getNum() {
		return num;
	}
	
	public ArrAvg() {
		for(int i=0; i<arr.length;i++) {
			arr[i] = (int)(Math.random()*10+1);
		}
	}
	public void resultAvg() {
		double avg = 0;
		double sum = 0;
		
		for(int i:arr) {
			sum += i;
			System.out.println(i);
		}
		avg = sum /arr.length;
				System.out.println(avg);
	}
	
}
public class Random{
	public static void main(String[] args) {
		ArrAvg arrAvg = new ArrAvg();
		arrAvg.resultAvg();
	}
}

10. Rectangle 을 배열로 3개 선언

해당 객체에 인덱스 순서대로 가로 세로 설정 - 
이번에는 반드시 scanner 로 입력 받을것

해당 배열에 있는 Rectangle 의 총넓이의 합을 구하시오.

또한 아래의 함수도 만들것(static 으로 만들것)
- 파라미터를 Rectangle 배열로 받아서 해당 배열에 들어 잇는 
Rectangle 들에 총 넓이를 리턴 하는 함수를 만드시오.
import java.util.Scanner;

class Rectangle{
	private int width;
	private int height;
	
	public Rectangle(int a, int b) {
		this.width = a;
		this.height = b;
	}
	public int getRecArea() {
		return width*height;
	}
	
	public static int getArea(Rectangle[] rec ) {
		int sum = 0;
		for(int i = 0; i< rec.length; i++) {
			sum = sum +rec[i].getRecArea();
			
		}
		return sum;
	}
}
public class RectangleArr {

	public static void main(String[] args) {
		
		Rectangle[] rec = new Rectangle[3];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i <rec.length;i++) {
			System.out.println("가로 세로 넣으세요");
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			rec[i] = new Rectangle(width,height);
		}

11. Circle을 배열로 5개 선언
해당 객체에 인덱스 순서대로 반지름 설정
해당 배열에 있는 Circle의 총넓이의 합을 구하시오.
금방 만든 Circle 클래스에 아래의 함수를 만드시오.
-파라미터를 Circle 배열로 받아서 해당 배열에 들어있는 Circle들에 
총 넓이를 리턴하는 함수를 만드시오.
package edu.ex.money.main; 

import edu.ex.money.Circle;

public class CircleArray{

	private double r;

	public CircleArray(double r) { 
		this.r = r; 
		}

	public double getArea() {
		return r*r*Math.PI;
	}
}
package edu.ex.money;

import edu.ex.money.main.CircleArray;

public class Circle{
	public static void main(String[] args) {
		CircleArray c = new CircleArray(3);		//CircleArray
		System.out.println(c.getArea());
		
		CircleArray[] cirArr = new CircleArray[5];//CircleArray
		
		
		cirArr[0] = new CircleArray(1);
		cirArr[1] = new CircleArray(2);		//CircleArray
		cirArr[2] = new CircleArray(3);
		cirArr[3] = new CircleArray(4);
		cirArr[4] = new CircleArray(5);
		
		for(int i=0; i<cirArr.length;i++) {
			int r = (int)(Math.random()*100)+1;
			cirArr[i] = new CircleArray(r);
		}
		
		double sum = 0;
		for(int i=0;i<cirArr.length;i++) {
			sum = sum + cirArr[i].getArea();
			
			
		}
		System.out.println("총넓이" + sum);
		
	}
}

public class CircleArray {

	public static void main(String[] args) {
		int[] Circle = new int[5];
		//Circle[0] = new int(3);
		//circle[1] = new int(3);
		//circle[2] = new int(3);
		//circle[3] = new int(3);
		//circle[4] = new int(3);
		
		for(int i=0; i<Circle.length;i++) {
			int r = (int)(Math.random()*100)+1;
			
		}
		
		for(int i=0;i<Circle.length;i++) {
			Circle[i] = i;
			
			double circleArea;
			circleArea = (double)(i*i*Math.PI);
			System.out.println(circleArea);
		}
		
	}
}

