1. is a 관계와 has a 관계란?
is a 는 상속관계가 가능한지 따져보아야 한다.
has a 는 상속관계가 불가능하다.

2.다형성(polymorphism)이란 무엇인가?
하나의 메소드나 클래스를 여러 방법으로 실행시키는 것

3. 아래가 되지 않는 이유에 대하여 메모리 그림으로 설명하시오.
//MobilePhone(부모) SmartPhone(자식)
SmartPhone ph2 = new MobilePhone();

같은 함수일 때 부모가 올라가고 자식이 올라가는데 대체된 부분이 출력되면서 부모의 출력을 입력했지만 자식의 출력을 확인할 수 있다.

4. 메소드 오버라이딩(Overriding) 이란?
상속받은 부모 클래스의 메소드를 재정의하여 사용하는 것을 의미한다.

5. 자바의 정석: 연습 문제 56page - 3개의 함수를 완성 하시오.
//polymorphism

class Product {
	int price; // 제품의 가격

	Product(int price) {
		this.price = price;
	}
	
}

class Tv extends Product {
	Tv() {
		super(100);
	}

	//println 객체 넣으면 toString 이 실행 되더라.
	@Override
	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}

/*
실행결과
잔액이 부족하여 을 를 살수 없습니다 Computer / .
구입한 물건:Tv,Computer,Tv,Audio,Computer,Computer,
사용한 금액:850
남은 금액:150
*/

class Buyer {
	int money = 1000;
	
	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product cart index 배열 에 사용될

	void buy(Product p) {
		/*
		 * (1) . 아래의 로직에 맞게 코드를 작성하시오 
		 * 1.1 . 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다
		  
		 * 1.2 ,
		 * 가진 돈이 충분하면 제품의 가격을 가진 돈에서 빼고 1.3 .(add ) 장바구니에 구입한 물건을 담는다 메서드 호출 Java 3 - 의
		 * 정석 판 연습문제 풀이 定石 57
		 */
		if(money < p.price)	{
			System.out.println("잔액이 부족하여" + p + "을를 살수 없습니다"); 
			return;
		}
		
		money = money - p.price;
		add(p);
		
	}

	void add(Product p ) {
		/*
		 * (2) . 아래의 로직에 맞게 코드를 작성하시오
		 *  1.1  i의 값이 장바구니의 크기보다 같거나 크면 
		 *  1.1.1 2 . 기존의 장바구니보다 2배로 큰 새로운 배열을 생성한다 
		 *  1.1.2 . 기존의 장바구니의 내용을 새로운 배열에 복사한다 
		 *  1.1.3 . 새로운 장바구니와 기존의 장바구니를 바꾼다 
		 *  1.2 (cart) . i 1 . 물건을 장바구니 에 저장한다 그리고 의 값을 증가시킨다
		 */
		if( i >= cart.length) {			
			Product[] temp = new Product[cart.length * 2]; 
			//               
			System.arraycopy(cart, 0, temp, 0, cart.length);
			cart = temp;		
		}
		
		cart[i] =p;
		i++;
		
	}

	void summary() {
		/*
		 * (3) . 아래의 로직에 맞게 코드를 작성하시오 1.1 . 장바구니에 담긴 물건들의 목록을 만들어 출력한다 1.2 . 장바구니에 담긴
		 * 물건들의 가격을 모두 더해서 출력한다 1.3 (money) . 물건을 사고 남은 금액 를 출력한다
		 */
		String itemList="";		
		int sum=0;
		
		for (Product product : cart) {
			itemList = itemList + product.toString();
			sum = sum + product.price;
		}
		
		//
		System.out.println("구입한 물건" + itemList);
		System.out.println("사용한 금액" + sum);
		System.out.println("남은금액" + money);	
		
	} 
}

public class BuyerTest {
	
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();

	}

}

6. 갬블링 게임을 만들어 보자. (문제 5번 과 6번은 상속은 안써도됨)
두 사람이 게임을 진행한다. 
이들의 이름을 키보드로 입력 받으며 
각 사람은 Person 클래스로 작성하라. 
그러므로 프로그램에는 2개의 Person 객체가 생성되어야 한다.

 두 사람은 번갈아 가면서 게임을 진행하는데 
각 사람이 자기 차례에서 <Enter> 키를 입력하면, 
3개의 난수가 발생되고 이 숫자가 모두 같으면 승자가 되고 
게임이 끝난다.
 난수의 범위를 너무 크게 잡으면 3개의 숫자가 
일치하게 나올 가능성이 적기 때문에 숫자의 범위는 
1~3까지로 한다.
=========================
1번째 선수 이름>>수희
2번째 선수 이름>>연수
[수희]:
3  1  1  아쉽군요!
[연수]:
3  1  3  아쉽군요!
[수희]:
2  2  1  아쉽군요!
[연수]:
1  1  2  아쉽군요!
[수희]:
3  3  3  수희님이 이겼습니다!
import java.util.Scanner;

import java.util.Scanner;

class Person{					//데이터멤버가 뭔지 정하고 필요한 함수 사용
	private String name;
	
	public String getName() {	
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int num1, num2, num3;
	
	public Person (String name) {
		this.name = name;
	}
	
	public boolean game () {
		
		num1 = (int)(Math.random()*3 +1);
		num2 = (int)(Math.random()*3 +1);
		num3 = (int)(Math.random()*3 +1);
		
		System.out.println(num1 +" "+ num2 +" "+ num3);
		
		if(num1==num2 && num2==num3) {		//세 개 다 같을 때
			return true;
		}
		return false;
	}
	
}

public class GabelTest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1번째 선수 이름>>>");
		String name = sc.next();
		Person p1 = new Person(name);
		
		System.out.println("2번째 선수 이름>>>");
		name = sc.next();
		Person p2 = new Person(name);
		
		String buffer = sc.nextLine();	//깔끔히 지워주는 역할
		
		while(true) {
			System.out.println("[" + p1.getName() + "]");
			//엔터를 받아내기 위한 입력
			buffer = sc.nextLine();
			
			if(p1.game()) {
				System.out.println(p1.getName() + "이겼습니다.");
				break;
			}
			System.out.println("아쉽군요.");
			
			System.out.println("[" + p2.getName() + "]");
			buffer = sc.nextLine();
			
			if(p2.game()) {
				System.out.println(p2.getName() + "이겼습니다.");
				break;
			}
			System.out.println("아쉽군요.");
			
		}
	}
}


7. 프로그래밍
문제 5의 갬블링 게임을 n명이 하도록 수정하라.(배열)
실행 예시와 같이 게임에 참여하는 선수의 수를 입력 받고 각 선수의 이름을 
입력 받도록 수정하라.

겜블링 게임에 참여할 선수 숫자>>3
1번째 선수 이름>>황
2번째 선수 이름>>이
3번째 선수 이름>>김
[황]:
2  3  3  아쉽군요!
[이]:
1  2  2  아쉽군요!
[김]:
2  2  3  아쉽군요!
[황]:
3  2  2  아쉽군요!
[이]:
1  1  3  아쉽군요!
[김]:
2  2  1  아쉽군요!
[황]:
2  2  2  황님이 이겼습니다!
import java.util.Scanner;

class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int num1, num2, num3;

	public Person(String name) {
		this.name = name;
	}


	public boolean game() {

		num1 = (int) (Math.random() * 3 + 1);
		num2 = (int) (Math.random() * 3 + 1);
		num3 = (int) (Math.random() * 3 + 1);

		System.out.println(num1 + " " + num2 + " " + num3);

		if (num1 == num2 && num2 == num3) {
			return true;
		}
		return false;
	}
}

//n명이 하도록
public class GambelTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("참여할 선수는>>>>");
		int num = sc.nextInt();

		Person[] arrPer = new Person[num];
		// 몇명 참여할지에 대해서

		for (int i = 0; i < arrPer.length; i++) {
			System.out.println((i + 1) + "번째 선수 이름>>>");
			String name = sc.next();
			arrPer[i] = new Person(name);
		}
		String buffer = sc.nextLine();

		while (true) {

			for (int i = 0; i < arrPer.length; i++) {
				System.out.println("[" + arrPer[i].getName() + "]");

				buffer = sc.nextLine();

				if (arrPer[i].game()) {
					System.out.println("[" + arrPer[i].getName() + "]" + "이겼습니다.");
					return;
				}
				System.out.println("아쉽군요.");
			}
		}
	}

}
