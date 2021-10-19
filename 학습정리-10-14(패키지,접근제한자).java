1. set classpath 에 대하여 설명하시오.
.class 가 있는 위치 알려줌.

2.절대 경로와, 상대경로란?
절대 경로는 파일이 위치한 고유한 경로
상대 경로는 부르는 대상에 따라 부르는 경로가 바뀐다.

3.  cd.  와  cd..  의 차이는?
cd.는 자기자신
cd..는 c드라이브

4. package 에 대하여 설명해 보시오.
서로 관련있는 클래스를 모아 하나의 그룹으로 구성한 것

5. 정보은닉에 대하여 설명하여 보시오.
클래스 내부에서 사용할 변수나 메서드를 private로 선언해서 외부에서 접근하지 못하도록 
하는 것을 객체지향에서 '정보은닉(information hiding)'

6. 접근제한자에 대하여 설명하시오.
객체들의 속성이자 특징을 대외적으로 공개하지 않기 위해 사용함.
제한자 종류에는 public, protected, default, private가 있음.

7. 지역변수에 접근 제한자가 필요없는 이유는?
지역 변수의 경우 해당 영역(메소드 안)에서 실행이 끝나면 메모리 남아있지 않고 없어지는 변수라서
지역변수는 바로 실행하고 변수는 메모리에서 사라지기 때문에 지역내에서만 실행 되기 때문에 
붙일 이유가 없다.

8. 아래의 클래스를 구현하시오. 
1)
class cash {
	public static void main(String[] args) {
		Money money = new Money(-126000);
		money.show();
	}
}
class Money{
	int money;

	public Money(int money) {
		if (money < 0) {
			System.out.println("잘못된 입력입니다.");
			
			return ;
		} 
		else {
			this.money = money;
		}
	}

	void show() {
		int rem = money;
		
		System.out.println("오만원"+ rem/50_000 +"장");
		rem = rem % 50_000;
		
		System.out.println("만원"+ rem/10_000 +"장");
		rem = rem % 10_000;
		
		System.out.println("천원"+ rem/1_000 +"장");
		rem = rem % 1_000;
		
		System.out.println("오백원"+ rem/500 +"개");
		rem = rem % 500;
		
		System.out.println("백원"+ rem/100 +"개");
		rem = rem % 100;
	}

}

2)
class Money {
	private  int m_500, m_100, m_50, m_10, m_5, m_1, money, tmp;

	Money(int money) {	
		setMoney(money);
	}
	
	public void setMoney(int money) {
		if(money < 0) {
			this.money = 0;
			System.out.println("잘못된 입력입니다.");
			return;
		}
		this.money = money;
	}
	
	public void show() {
		m_500 = money / 50000;
		tmp = money - m_500 * 50000;

		m_100 = tmp / 10000;
		tmp = tmp - m_100 * 10000;

		m_50 = tmp / 5000;
		tmp = tmp - m_50 * 5000;

		m_10 = tmp / 1000;
		tmp = tmp - m_10 * 1000;

		m_5 = tmp / 500;
		tmp = tmp - m_5 * 500;

		m_1 = tmp / 100;
		System.out.println("오만원 : " + m_500 + "장");
		System.out.println("만원 : " + m_100 + "장");
		System.out.println("오천원 : " + m_50 + "장");
		System.out.println("천원 : " + m_10 + "장");
		System.out.println("오백원 : " + m_5 + "개");
		System.out.println("백원 : " + m_1 + "개");
	}
}

출력 
잘못된 입력입니다.
오만원 0장....
오만원 0장....
등등등....

9. 아래의 클래스를 구현하시오.
package edu.kosmo.ex.main;

import edu.kosmo.ex.dept.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee employee = new Employee(
			"홍길동", 19, "서울 뉴욕시", "개발 1팀");
			
			employee.printInfo();
	}
}

package edu.kosmo.ex.dept;

public class Employee {
	private String name;
	private int age;
	private String address;
	private String dept;		//private 붙이는 습관 들이기
	
	public Employee(String name, int age, String address, String dept) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.dept = dept;
	}
	
	public void printInfo() {			//함수 시작에는 public
		System.out.println("이름 : " + name);
		System.out.println("나이 : " +  age);
		System.out.println("주소 : " + address);
		System.out.println("부서 : " + dept);
	}
	
}
출력:
이름 : 홍길동
나이 : 19
주소 : 서울 뉴욕시
부서 : 개발 1팀


10.다음 멤버를 가지고 직사각형을 표현하는 Rectangle 클래스를 작성하라.
- int 타입의 x, y, width, height 필드 : 사각형을 구성하는 점과 크기 정보
- x, y, width, height 값을 매개변수로 받아 필드를 초기화하는 생성자
- int square() : 사각형 넓이 리턴
- void show() : 사각형의 좌표와 넓이를 화면에 출력
- boolean contains(Rectangle r) : 매개변수로 받은 r이 현 사각형 안에 있으면 true 리턴 (겹치면 안됨. 완전히 안에 있어야 true)
- main() 메소드의 코드와 실행 결과는 다음과 같다.

public static void main(String args[]) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
		
		r.show();
		System.out.println("S의 면적은 "+s.square());
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contains(s)) System.out.println("t는 s를 포함합니다.");
	}

출력:
(2,2)에서 크기가 8x7인 사각형
s의 면적은 36
t는 r을 포함합니다.


public class Rectangle {
	private int x, y, width, height;
		
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void show() {
		System.out.println("(" + x + "," + y + ")에서 " + "크기가 " + width + "x" + height + "인 사각형" );
	}
	
	public int square() {
		return width * height;
	}

	public boolean contains (Rectangle r) {
		boolean bool = false;		//if에 부합하면 true 아니면 false
		
		if( (this.x < r.x) && ((this.x + this.width) > (r.x + r.width))&&(this.y < r.y) && ((this.y + this.height) > (r.y + r.height))){
		bool = true;
		}
	return bool;	
	}
}

package edu.kosmo.ex.main;

import edu.kosmo.ex.shape.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
		
		r.show();
		System.out.println("S의 면적은 "+s.square());
		
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contains(s)) System.out.println("t는 s를 포함합니다.");	
	}
}
