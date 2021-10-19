*반복문에는 3가지 종류가 있어요.
while 실행 안 할 수도 있음
do~ while 한번은 반드시 실행
for은 설정한 조건식까지 반복

1. switch 문에서 아래의 프로그래밍을 짜시오.
3 4 5월 봄 입니다. 출력
6 7 8월 여름 입니다. 출력
9 10 11월 가을 입니다. 출력
12 1 2월 겨울 입니다. 출력

int month =11;

	switch (month) {
		case 3,4,5:
			System.out.println("봄입니다.");
			break;
		case 6,7,8:
			System.out.println("여름입니다.");
			break;
		case 9,10,11:
			System.out.println("가을입니다.");
			break;
		case 12,1,2:
			System.out.println("겨울입니다.");
			break;
	}


2. int num = -10 을 할당 후 해당 정수에 대한 절댓값을 출력하는 프로그램을 작성하시오.
절대값은 양수 입니다.

	int num = -10;
		
		if(num < 0) {
			System.out.println(num*(-1));
		}
		else
			System.out.println(num);


3. while 문과 do while 문의 차이는 무엇인가요?
while 문은 조건이 안 맞으면 바로 끝.
do while은 조건이 끝에 있어서 {}을 무조건 실행 후 조건과 맞춘다.

4. 아래에서 for 문이 실행 되는 순서를 정리하시오.
for (i = 1; i <= 1000; i++){
	sum = sum +i
}

i=1 --> i <= 1000 --> sum = sum +i --> i++ --> i <= 1000 --> sum = sum +i --> i++

5. 구구단 6단을 출력 하는 프로그램을 짜시오.
1)	int dan = 6;
		
		for(int i = 1;i < 10; i++) {
			System.out.println(i + " * " + dan + " = " + dan*i);
		}

2)	int dan = 6;
		int num = 0;
		
		while((num++)<10) {
			System.out.println(num + " * " + dan + " = " + num*dan);
		}

6. 1부터 10000 까지의 합을 구하는 프로그램을 짜시오.(***********마지막만 나오게)
	int sum = 0;
		for(int i = 1;i <= 10000; i++) {
			
			sum = sum + i;
			
		}
		System.out.println(sum);

7. 1부터 10000 까지의 숫자중 홀수 의 합을 구하는 프로그램을 짜시오.
	int sum = 0;
		for (int i = 1; i <= 10000; i++) {
			if ((i % 2) == 1) {
				sum = sum + i;
				System.out.println(sum);
			}
		}

8. break 와 continue에 대하여 설명하시오.
break는 특정 조건에서 빠져나오고 싶을 때. 조건의 전제가 있기 때문에 if와 같이 쓰인다.
continue는 처음의 조건으로 가고 싶을 때.

9. 1과 100 사이의 숫자중 5의 배수이자 7의 배수의 첫번재 수는(프로그램밍 하시오)
1)	int num = 0;
		while ((num++) < 1000) {
			if (((num % 2) == 0) && ((num % 3) == 0))
				break;
		}
		System.out.println(num);

2)	for (int i = 1; i <= 100; i++) {
		if (((i % 5) != 0) || ((i % 7) != 0)) {
			continue;
		}			
			System.out.println(i);
			break;
	}

3)	for (int i = 1; i <= 100; i++) {
		if (((i % 5) == 0) && ((i % 7) == 0)) {
			System.out.println(i);
			break;
		}
	}
4)	int num = 1;
		boolean search = false;
		
		//처음 만나는 5의 배수이자 7의 배수인 수를 찾는 반복문
		while(num < 100) {
			if(((num % 5) == 0) & ((num % 7) == 0)) {
				search = true;
				break;
			}
			num++;
		}
		if(search)
			System.out.println("찾는 정수 : " + num);
		else
			System.out.println("5의 배수이자 7의 배수인 수를 찾지 못했습니다.");

10. 1과 10000 사이의 숫자중 5의 배수이자 7의 배수인 수의 갯수는(프로그램밍 하시오)
1)	int num = 0;
	int count = 0;
		while ((num++) < 10000) {
			if (((num % 5) != 0) || ((num % 7) != 0))	
				continue;
				count++;
			}
		System.out.println("count: " + count);

2)	int count = 0;
		for (int i = 1; i < 10000; i++) {
			if (((i % 5) != 0) || ((i % 7) != 0))
				continue;
				count++;
			}
		System.out.println("count: " + count);

3)	int count = 0;
		for (int i = 1; i < 10000; i++) {
			if (((i % 5) == 0) && ((i % 7) == 0))
				count++;
			}
		System.out.println("count: " + count);
