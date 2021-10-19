1. 반복문 무한루프 만드는 세가지 방법은?
for / while / do~while

2. 아래와 같이 출력 되도록 프로그래밍 하시오.(//반복문 사용 할 필요 없음)
126500 의 금액을 한국 화폐로 바꾸었을 때 각각 몇 개의 화폐가 필요한지 계산해서 출력하기
예) int 126500;
오만원 : 2장	
만원 : 2장
오천원 : 1장
천원 : 1장
오백원 : 1개
백원 : 0개
곱하고 나누기 연산으로 계산 가능. 일단 생각하는 그대로 표현. 
65000 / 5000 몫1 나머지 15000 / 1000

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
		tmp = tmp - m_1 * 100;

		System.out.println("오만원 : " + m_500 + "장");
		System.out.println("만원 : " + m_100 + "장");
		System.out.println("오천원 : " + m_50 + "장");
		System.out.println("천원 : " + m_10 + "장");
		System.out.println("오백원 : " + m_5 + "개");
		System.out.println("백원 : " + m_1 + "개");
	}
}
	//두번째 방법은 좀 간단하게
		money = 126_000;
		
		System.out.println("오만원 " + money/50000 + "장");
		money = money % 50000;
		System.out.println("만원 " + money/10000 + "장");
		money = money % 10000;
		System.out.println("오천원 " + money/5000 + "장");
		money = money % 5000;
		System.out.println("천원 " + money/1000 + "장");
		money = money % 1000;
		System.out.println("오백원 " + money/500 + "장");
		money = money % 500;
		System.out.println("백원 " + money/100 + "장");
		money = money % 100;


3. 구구단 출력 하시오.
for (int i = 1; i < 10; i++) {
	for (int k = 1; k < 10; k++) {
		System.out.println(i + " * " + k + " = " + i * k);
		}
	}

4. 구구단 짝수단 출력 하시오.
for (int i = 1; i < 10; i++) {
	for (int k = 1; k < 10; k++) {
		if((i % 2) == 0)
			System.out.println(i + " * " + k + " = " + i * k);
		}
	}

5. 3의 배수인 단(3,6,9)만 출력 하시오.
for (int i = 1; i < 10; i++) {
	for (int k = 1; k < 10; k++) {
		if((i % 3) == 0)
			System.out.println(i + " * " + k + " = " + i * k);
		}
	}

6.아래의 별을 찍으시오.
*****
*****
*****
*****
for (int i = 1; i <= 5; i++) {
	for (int j = 1; j <= 5; j++) {
		System.out.print("*");
	}
	System.out.println();
}

*바깥쪽 for문은 단순 행을 위해 찍는거다, 안쪽 for문은 열을 찍음
스페이스는 생각 하지 않고, 먼저 별 갯수만큼 찍는다.

7. 아래의 별을 찍으시오.
*
**
***
****
*****

for (int i = 1; i <= 5; i++) {
	for (int j = 1; j <= i; j++) {
		System.out.print("*");
	}
	System.out.println();
}

8. 아래의 별을 찍으시오.
*****
****
***
**
*

for (int i = 1; i <= 5; i++) {
	for (int j = i; j <= 5; j++) {
		System.out.print("*");
	}
	System.out.println();
}

9. 아래의 별을 찍으시오.
    *
   **
  ***
 ****
*****

for (int i = 1; i <= 5; i++) {
	for (int j = i; j <= 5; j++) {
		System.out.print(" ");
	}
	for (int j = 1; j <= i; j++) {
		System.out.print("*");
	}
	System.out.println();
}

10. 아래의 별을 찍으시오.
*****
 ****
  ***
   **
    *

for (int i = 1; i <= 5; i++) {
	for (int j = 1; j <= i; j++) {
		System.out.print(" ");
	}
	for (int j = i; j <= 5; j++) {
		System.out.print("*");
	}
	System.out.println();
}

11. 아래의 별을 찍으시오.
    *
   ***
  *****
 *******
*********

for (int i = 1; i <= 10; i++) {
	if ((i % 2) == 1) {
		for (int j = i / 2; j <= 5; j++) {
			System.out.print(" ");
		}
		for (int j = 1; j <= i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
}

12. 구구단 에서 2의 배수 이자 3의 배수인 수의 갯수는?
int sum = 0;
	for (int i = 2; i < 10; i++) {
		for (int k = 1; k < 10; k++) {
			if ((((i * k) % 3) == 0) && (((i * k) % 2) == 0))
				sum = sum + 1;
		}
	}
	System.out.println(sum);

13. 다음과 같이 출력하시오.
1. Hi
2. Hi
3. Hi
4. Hi
5. Hi

for (int i = 1; i <= 5; i++) {
	System.out.println(i + "." + "Hi");
}

14. 아래와 같이 출력 하시오.
1 1 1 1 1
2 2 2 2 2
3 3 3 3 3
4 4 4 4 4
5 5 5 5 5 

for (int i = 1; i <= 5; i++) {
	for (int j = 1; j <= 5; j++) {
		System.out.print(i);
	}
	System.out.println();
}

15. 아래와 같이 출력 하시오.
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
6 7 8 9 10

for (int i = 1; i <= 5; i++) {
	for (int j = 1; j <= 5; j++) {
		System.out.print(j + i);
	}
	System.out.println();
}
