1. 메소드 오버로딩에 대하여 설명하시오.
같은 이름으로 함수를 만들어 낼 수 있는 것

2. 메소드 오버로딩을 적용한 대표적인 함수는?
println();

3. this 함수에 대하여 설명하시오.
this는 인스턴스의 자기 자신을 의미한다. 

4. this 의 용도는?
역할로는 생성자 호출을 위한 this함수와 자기 자신의 메모리를 가르키는 this.(this포인터)로 나뉜다. 

5. 스트링 객체를 생성하는 2가지 방법은 무엇인가?
new를 이용하는 방법과 "" 사용하는 방법이 있다.

6. 아래의 결과를 예측하고,이유를 설명하시오.
String str1 = "Simple String"; 
String str2 = "Simple String";

String str3 = new String("Simple String");
String str4 = new String("Simple String");

//참조변수의 참조 값 비교
if(str1 == str2)
   System.out.println("str1과 str2는 동일 인스턴스 참조");
else
   System.out.println("str1과 str2는 다른 인스턴스 참조");

//참조변수의 참조 값 비교
if(str3 == str4)
   System.out.println("str3과 str4는 동일 인스턴스 참조");
else
   System.out.println("str3과 str4는 다른 인스턴스 참조");

1,2번은 같은 객체로 인식했고 하나의 객체로 인식되기 때문에 같다고 표현된다. 하지만 3,4번은 new로 인해서 같은 문자열이지만 객체가 계속 생성되기 때문에 3,4는 같은 객체로 인식되지 않는다.
또 다른 말로는 1,2는 안에 있는 주소값으로 비교되었고 3,4는 메모리에 올라갔기 때문에 메모리의 위치가 다름으로 인식되었다.

7. Immutable 에 대하여 설명하시오.
원본 불변 객체로 생성 후 그 상태를 바꿀 수 없는 객체를 말한다. 불변 객체는 재할당은 가능하지만, 한번 할당하면 내부 데이터를 변경할 수 없는 객체이다.

8. 사용자로부터 받은 문자열(영문으로)에서 자음과 모음 개수를 계산하는 프로그램을 작성
입력:abcd 
출력:

총글자수는 4개
자음:3 개
모음:1 개

import java.util.Scanner;

import edu.ex.vow.ConsVowCount;

public class ConsVowTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		ConsVowCount cons = new ConsVowCount(word);
		
		cons.countResult();
		
		System.out.println("계속 yes 중단 no");
		String yesOrNo = sc.next();
		
		if(yesOrNo.equals('yes') || yesOrNo.equals('YES'))
			continue;
		else
			break;
		
	}
}
import java.util.Scanner;

public class Order {

	void order() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요.");
		String word = sc.nextLine();
		
		for(int i = word.length() -1; i>= 0; i--) {
			System.out.print(word.charAt(i));
		}

}

public static void main(String[] args) {
	Order abcd = new Order();
	abcd.order();
	}

}

9. 사용자에게 받은 문자열을 역순으로 화면에 출력하는 프로그램을 작성하시오.
입력:abcde
출력:edcba

import java.util.Scanner;

public class Order {

	void order() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요.");
		String word = sc.nextLine();
		
		for(int i = word.length() -1; i>= 0; i--) {
			System.out.print(word.charAt(i));
		}

}

public static void main(String[] args) {
	Order abcd = new Order();
	abcd.order();
	}

}

10. 사용자로부터 키를 입력 받아서 표준 체중을 계산한 후에 사용자의 체중과 비교하여 
저체중인지, 표준 인지, 과체중인지를 판단하는 프로그램을 작성하라. 
표준 체중 계산식은 다음을 사용하라.
표준체중(kg) = ( 키(cm) - 100 ) * 0.9

입력:
키(cm)를 입력하세요. : 193
체중(kg)을 입력하세요. : 25
출력:
표준 체중은 83.7입니다.
당신은 저체중 입니다. 

public class BMI {
	
	private double cm;
	private double kg;
	
	public BMI(double cm, double kg) {
		this.cm = cm;
		this.kg = kg;
	}

	
	public void printResult() {
		double mKg = (cm - 100)*0.9;
		
		System.out.println("표준 체중은 " + mKg + "입니다");
		
		if(kg > mKg) {
			System.out.println("과체중입니다");
		}
		else if(kg < mKg) {
			System.out.println("저체중입니다");
		}
		else {
			System.out.println("표준입니다");
		}
		
		
		System.out.println("이름 : " );
	}

}
package edu.ex.vow;
package defalut;

import java.util.Scanner;

public class BMITest {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키(cm) 입력하세요");
		int cm = sc.nextInt();
		
		System.out.println("체중(kg) 입력하세요");
		int kg = sc.nextInt();
		
		BMI bmi = new BMI(cm,kg);
		bmi.printResult();
	}
}
