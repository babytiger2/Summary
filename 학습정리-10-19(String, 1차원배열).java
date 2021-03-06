함수오버로딩 - 같은 이름, 타입, 갯수

this용도 = this 함수, this로 변수 접근

String = ==(주소비교)
equals,
concat
subString
compare 등등...

index는 0부터 시작

1. Stirng 에서 concat 메서드에 대해서 설명하시오.
String의 인스턴스를 연결한다. 

2. Stirng 에서 substring 메서드 사용법은?
부분 문자열을 검색합니다. 부분 문자열은 지정된 문자 위치에서 시작하고 문자열 끝까지 계속됩니다.

3. Stirng  compareTo 사용법은?
문자열의 비교 또는 숫자의 비교에 쓰인다.

4. String.valueOf 에 대하여 설명하시오.
메서드는 String 객체의 원시 값을 문자열 데이터 타입으로 반환 합니다.

5. 아래가 실행되는 원리(함수)를 표현해 보세요.
String str = "age" + 17;

String str = "age" concat String.valueof(17);
age17

6. StringBuilder 와 String 의 차이는?
String은 불변의 속성을 갖는다. 그래서 메모리 소모가 엄청나기 때문에 문자열 결합의 최적화를 위해서
StringBuilder가 개발되었다.

7. 아래의 메모리 그림을 그리시오. (1차원 배열)
int[] ar1 = new int[5];

8. 아래의 메모리 그림을 그리시오. (1차원 배열)
Box[] ar = new Box[5];

9. 아래를 프로그래밍 하시오. Scanner

"Hello.java" 문자열에서 파일명과 확장자인 java를 분리시키는 프로그램을 짜시오.

입력: Hello.java
출력: 파일이름은: Hello 이며 확장자는 java 입니다.

입력: Java.avi
출력: 파일 이름은: Java 이며 확장자는 avi 입니다.
package edu.ex.honey;

import java.util.Scanner;

import edu.ex.money.MoneyArr;

public class MoneyTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		int dot=0;
		
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)=='.') {		//chaeAt은 문자 리턴
				dot = i;
			}
		}
		int index = word.indexOf('.');
		
		System.out.println(index);			//.의 위치를 알려준다
		//System.out.println(dot);
		
		String fileName = word.substring(0,index);
		String extention = word.substring(index+1,word.length());
		
		System.out.println(fileName);
		System.out.println(extention);
	}

}

10. 아래를 배열을 활용하여 프로그램을 짜시오.
화폐매수 구하기
- 1원 부터 5000 원 까지 랜덤으로 생성.
- 500원 100 원 50 원 10원은 배열로 선언 하여 저장 

해당 랜덤생성된 화폐 매수를 아래와 같이 출력

2860원 

출력
500원 : 5개 
100원 : 3개 
50원 : 1개 
10원 : 1개

import java.util.Scanner;

class Money {
	private int m_500, m_100, m_50, m_10, m_5, m_1, money, tmp;

	Money(int money) {

		setMoney(money);
	}

	public void setMoney(int money) {

		if (money < 0) {
			this.money = 0;
			System.out.println("잘못된 입력입니다.");
			return;
		}

		this.money = money;

	}

	public void show() {

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


public class Next {

	public static void main(String[] args) {

		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("얼마입니까?");
			
			int money = sc.nextInt();
			
			Money m = new Money(money);
			m.show();
		
			char ch = sc.next().charAt(0);
			 
	        if(ch == 'N' || ch == 'n' )
	         break;
		}
		
		System.out.println("끝내겠습니다.");
		
	}

}