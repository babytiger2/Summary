1. 리터럴이란?
상수는 변하지 않는 변수를 의미하며(메모리 위치) 메모리 값을 변경할 수 없다.
리터럴은 변수의 값이 변하지 않는 데이터(메모리 위치안의 값)를 의미한다

2. 아래의 내용이 에러가 나는 이유와 수정 방법은?
System.out.println(3147483647 + 3147483648); //에러남
int 사용시 21억이 넘어가기 때문에 long을 사용한다.

3. 자동 형변환과 명시적 형변환에 대하여 설명하시오.
연산 시 두개의 형을 일치 시키려고 자동으로 형 변환한다.
원하는 형에 맞게 맞춰주는 것을 명시적 형 변환이라고 한다.

4. 아래의 에러가 나는 이유를 설명하고 수정 하시오.
int a = 3;
int b = 4;	
double result = a / b;
System.out.println(result);

a, b는 정수인데 result값은 실수라서 에러가 나고
수정하려면 a, b둘 중 하나를 실수 double로 선언한다.

5. 이스케이프 시퀀스의 종류를 나열하고 기능을 설명하시오.
큰 따옴표는 문자열을 출력하는데 사용하지만 큰 따옴표를 하나만 사용할 시 오류가 난다.
큰 따옴표를 그대로 출력하고 싶을 때 "\"원하는 것 입력\""를 사용한다.

6. 아래의 출력 결과를 확인하고, 130이 나오는 이유를 설명
System.out.println('A'); 
System.out.println('A' + 'A');

첫번째는 ''만 존재했기에 문자로 인식한다. 두번째는 +로 인해 연산으로 인식했고 
A를 출력하는 수가 65라서 130이 나온다.

7. 결합 방향과 우선순위에 대하여 설명하시오.
결합 방향은 연산 기호에 따라서 ->, <-가 존재한다.
가장 우선순위는 괄호 먼저이다.

8. "1초과 100미만인가?"를 코딩으로 표현하면?
((1 < num)  && (num <100))

9. "2의 배수 또는 3의 배수?" 를 코딩으로 표현하면?
((num % 2) == 0) || ((num % 3) == 0))

10. 아래의 프린트 결과를 예측해 보고, 코딩 후 결과를 확인 하시오.
class SCE {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		boolean result;    

    result = ((num1 += 10) < 0) && ((num2 += 10) > 0);
	System.out.println("result = " + result);
	System.out.println("num1 = " + num1);
	System.out.println("num2 = " + num2);
	
    result = ((num1 += 10) > 0) || ((num2 += 10) > 0);
	System.out.println("result = " + result);
	System.out.println("num1 = " + num1);
	System.out.println("num2 = " + num2);
	}
}

result = false
num1 = 10
num2 = 0
result = true
num1 = 20
num2 = 0

11. 아래를 프로그래밍 하시오.
국어 : 50
영어 : 70
수학 : 95
총점과 평균을 구하시오.
-단 평균은 소숫점 까지 나오도록 하시오.

class count {
	public static void main(String[] args) {
		int lag = 50;
		int eng = 70;
		int math = 95;
		
		int sum = lag + eng + math;
		System.out.println(sum);
		
		double avg = (lag + eng + math)/3.0;
		System.out.println(avg);
	}
}