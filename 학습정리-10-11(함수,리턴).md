1. 함수는 어떻게 알아 볼수있는가? 
함수 뒤에는 괄호가 붙는다.

2. 함수 호출 하는 법은?
함수를 만든 후 함수();로 호출한다.

3. 함수 만드는 법은?
public static int 함수명(파라메터){
}
리턴타입 함수명(파라미터){
return 값;
}

int add(int num1, int num2){
return num1 + num2;
}

4. 리턴 타입 void 는 어떠한 경우에 쓰는가? 
함수의 반환 값이 없을 때

5. 아래를 함수로 만드시오. 
starPrint2(5)

출력
*****
 ****
  ***
   **
    *

public static void main(String[] args) {
	starPrint(5);
}
	public static void starPrint(int num) {
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= num; j++) {
				System.out.print("*");
			}
		System.out.println();
		}
	}

6. 아래를 함수로 만드시오.
starPrint3(5) 

출력
    *   
   ***
  *****
 *******
*********

public static void main(String[] args) {
	starPrint(7);
}
	public static void starPrint2(int num) {
		for (int i = 1; i <= num; i++) {
			for (int j = i; j < num; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i - 1); j++) {
				System.out.print("*");
			}
		System.out.println();
		}
	}
	
6. 아래의 함수를 만드시오. 		
char grade;
double avg = 80;

grade = getGrade(avg);
// 우 입니다.
System.out.println(grade + " 입니다.");

public static void main(String[] args) {
	char grade;
	double avg = 80;
		
	grade = getGrade(75);
	//우 입니다.
	System.out.println(grade + " 입니다.");
}
	public static char getGrade(double avg) {
		char grade = '가';
		
		if(avg >= 90) {
			grade = '수';
		}
		else if(avg >= 80) {
			grade = '우';
		}
		else if(avg >= 70) {
			grade = '미';
		}
		else if(avg >= 60) {
			grade = '양';
		}
		else {
			grade = '가';
		}
	return grade;
	}

7. 아래의 함수를 만드시오. 
int sum = getHap(1,100);
//5050
System.out.println(sum);

public static void main(String[] args) {
	int sum = getHap(1, 100);
	// 5050
	System.out.println(sum);
}

	// 1+2+3+4+5
	public static int getHap(int start, int end) {
		int sum = 0;
		for (int i = 1; i <= end; i++) {
			sum = sum + i;

		}
	return sum;
	}

8. 아래의 함수를 만드시오. 
int count = get57(1,100);
//count 는 1부터 100 까지의 숫자중 5의 배수 이자 7의 배수인 수의 갯수
System.out.println(count );

public static void main(String[] args) {
	int count = get57(1, 100);
	System.out.println(count);
}

	public static int get57(int a, int b) {
		int count = 0;
		for (int i = 1; i <= b; i++) {
			if (((i % 5) == 0) && ((i % 7) == 0))
				count = count + i;
		}
		return count;
	}

9. 아래의 함수를 만드시오. 
printGuGudan(3)// 3단 출력
printGuGudan(4)// 4단 출력

public static void main(String[] args) {
	//int dan;
	printGuGudan(3);	// 3단 출력
	printGuGudan(4);	// 4단 출력
}
	public static void printGuGudan(int dan) {
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + "*" + i + "=" + i * dan);
		}
	}

10.아래의 함수를 만드시오. 
getRecArea(3,5) //사각형 넓이

public static void main(String[] args) {
	double area = getRectArea(3, 5);
	System.out.println(area);
}
	public static double getRectArea(double a, double b) {
		return (a * b);
	}


getRecCirlce(5) //원넓이

public static void main(String[] args) {
	double area = getCircleArea(5);
	System.out.println(area);
}
	public static double getCircleArea(double r) {
		double result = (r*r*3.14);
		return result;
		/* 
		final double PI = 3,14;
		return r * r * PI;
		*/
	}

getTriangleArea(4 , 5) //삼각형 넓이

public static void main(String[] args) {
	double area = getTriangleArea(4 , 5);
	System.out.println(area);
}
	public static double getTriangleArea(double a, double b) {
		return ((a * b)/2);
	}

11. 함수로 만들면 좋은점은?
-같은 작업을(중복) 하지 않기 위해
-기능이 2번 이상 중복되면 반드시 함수로 만들것.

12. 아래의 함수를 만드시오. 
int month = 4;
getSeason(3)// 봄입니다. 출력
getSeason(12)// 겨울 입니다. 출력
(switch처럼 1,2,3,4은 봄입니다. 처럼 void 만들기.

public static void main(String[] args) {
	//int month = 4;
	getSeason(3);	// 봄입니다. 출력
	getSeason(12);	// 겨울 입니다. 출력
}
	public static void getSeason(int month) {
		switch(month) {
		case 3,4,5:
			System.out.println("봄");
		break;
		case 6,7,8:
			System.out.println("여름");
		break;
		case 9,10,11:
			System.out.println("가을");
		break;
		case 12,1,2:
			System.out.println("겨울");
		break;
		}
	}
