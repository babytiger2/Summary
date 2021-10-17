1. 아래가 에러가 나는 이유를 설명하고, 수정 하시오.
short num = 1;
short num = -num;
num 앞에 -가 있기 때문에 연산으로 출력되려고 하는데 연산은 int로 계산되기 
때문에 오류가 나서 원하는 결과값과 = 사이에 (short)를 붙여줘야 한다

2. 전위 증가 연산자와 후위 증가 연산자의 차이는?
전위 증가 연산자는 먼저 +1을 연산 한 후 출력한다.
후위 증가 연산자는 반대로 출력 후 +1을 연산한다.

3. 아래의 비트 연산자 4가지를 설명하시오.
& | ^ ~

& and
 |  or
^ XOR
~ not

4. 아래의 쉬프트 연산자에 대하여 설명하시오.
<< : 화살표의 방향인 왼쪽으로 비트를 밀어낸다.
>> : 화살표의 방향인 오른쪽으로 비트를 밀어낸다.

5. 아래의 출력값을 예측하시오.
class AssignSteResult {
	public static void main(String[] args) {
		int num1 = 10, num2 = 20, num3 = 30;
		num1 = num2 = num3;    

    /* 
    = 연산자는 결합 방향이 오른쪽에서 왼쪽으로 진행된다.  
    ->따라서 위의 문장은 다음과 같다. 
    num1 = (num2 = num3);        
    */
    
    System.out.println(num1);	
    System.out.println(num2);
    System.out.println(num3);
	}
}

30
30
30

6. 아래의 출력값을 예측하시오.
class AddNum {
	public static void main(String[] args) {
		int result = 3 + 6;
		System.out.println("3 + 6 = " + result);  
  
		result += 9;
		System.out.println("3 + 6 + 9 = " + result);
    
		result += 12;
   		System.out.println("3 + 6 + 9 + 12 = " + result);
	}
}

3 + 6 = 9
3 + 6 + 9 = 18
3 + 6 + 9 + 18 = 36


7. 조건문의 3가지 종류를 나열하고 설명하시오.
if문 : if문이 true일 경우 실행, false일 경우 미실행
if-else문 : if문이 true면 실행, false면 else를 실행
else if문 : 두 개 이상의 조건식이 있을 때 사용한다. else if절은 여러 번 정의할 수 있고, else절은 생략이 가능하다. 
단, if문이 처음에 나오고 그다음에 else if문이 제일 마지막에는 else문이 나와야 한다.

8. 아래의 프로그램을 짜시오.
 국어:80 수학:80 영어:60 총점과 평균을 출력하고, 
 평균에 따른 수우미양가를 출력 하시오.
class count {
	public static void main(String[] args) {
		int lag = 50;
		int eng = 70;
		int math = 95;

		int sum = lag + eng + math;
		System.out.println(sum);

		double avg = (lag + eng + math) / 3.0;
		System.out.println(avg);

		if (avg >= 90) {
			System.out.println("수 입니다.");
		} else if (avg >= 80) {
			System.out.println("우 입니다.");
		} else if (avg >= 70) {
			System.out.println("미 입니다.");
		} else if (avg >= 60) {
			System.out.println("양 입니다.");
		} else {
			System.out.println("가 입니다.");
		}
	}
}

9. int 변수 3개 선언 
임의 값 집어 넣음

그중 3개의 값중 최대값을 출력 
90 100 60

출력:
최대값은 100 입니다.

//첫번째 방법
		if(a > b) {
			if(a > c) {
				max = a;
			}
			else {
				max = c;
			}
		}
		else {
			if(b > c) {
				max = b;
			}
			else {
				max = c;
			}
		}
		
		System.out.println(max);

//두번째 방법
		if((a > b) && (a > c)) {
			max = a;
			
		}
		else if((b > a) && (b > c)) {
			max = b;
		}
		else {
			max = c;
		}
		
		System.out.println(max);
		
//세번째 방법 좀 더 코딩을 줄이기
		max = a;
		if(b > max) {
			max = b;
		}
		if(c > max) {
			max = c;
		}
		
		System.out.println(max);
//네 번째 방법
		max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
		System.out.println(max);

10. int 변수 선언 후 임의로 값을 넣음.
해당 값이 짝수 이면 "짝수 입니다" 출력
해당 값이 홀수 이면 "홀수 입니다" 출력

int a = 8;
	if((a % 2)==0) {
		System.out.println("짝수입니다.");
	}
	else if((a % 2)==1) {
		System.out.println("홀수입니다.");
	}
