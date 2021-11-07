1. Generic 이전의 코드의 문제 상황들을 예시로 설명하시오.

2. 아래의 결과가 나오도록 프로그래밍 하시오.
class DDBoxDemo {
    public static void main(String[] args) {
        DBox<String, Integer> box1 = new DBox<>();
        box1.set("Apple", 25);

        DBox<String, Integer> box2 = new DBox<>();
        box2.set("Orange", 33);
        
        DDBox<DBox<String, Integer>, DBox<String, Integer>> ddbox = new DDBox<>();
        ddbox.set(box1, box2);

        System.out.println(ddbox);
    }
}

/*
==================
Apple & 25
Orange & 33
*/

class DBox<l, r>{
	private l fru;
	private r age;
	
	public void set(l it,r tu) {
		fru = it;
		age = tu;
	}
	public String toString() {
		return fru + " & " + age;
	}
}

class DDBox<l, r>{
	private l fru2;
	private r age2;
	
	public void set(l it,r tu) {
		fru2 = it;
		age2 = tu;
	}
	@Override
	public String toString() {
		return fru2 + "\n" + age2;
	}
}

//제네릭 문법이 생기면서 자바 1.5부터는 예전에 다형성 적용(Object)함
//형변환 및 실시간 에러 등을 컴파일 에러로 잡아 낼 수 있게 됨 → 굉장히 필요한
//과거 실시간 에러가 컴파일 에러로 잡아 낼 수 있는 이유는?
//<>안에 있는 데이터 타입을 미리 정하고 들어감으로써 에러를 바로 잡는다. 이게 핵심이고 제네릭을 쓰는 이유
 

3. 아래와 같이 결과 값이 나오도록 만드시오.
   public static void main(String[] args) {
        DBox<String, Integer> box = new DBox<String, Integer>();
        box.set("Apple", 25);
        System.out.println(box);
        
        DBox<String, String> box2 = new DBox<String,String>();
        box2.set("Apple", "Orange");
        System.out.println(box2);

/*
==================
Apple & 25
Apple & Orange
*/

class DaBox<L, R>{
	private L fru;
	private R age;
	
	public void set(L it,R tu) {
		fru = it;
		age = tu;
	}
	public String toString() {
		return fru + " & " + age;
	}
}

4. 업다운 게임을 짜시오.
1. 랜덤으로 숫자를 생성 - 컴퓨터가 가짐
2. 게임을 시작 유저가 숫자를 입력
3. 10번의 기회를 주어 맞으면 맞았다고 출력 10번의 기회가 지나면 게임 종료.

출력의 예
========================================
**************
1. 게임 시작
2. 게임 종료
**************
1
게임시작
>>>
50
down
>>>
45
down
>>>
30
down
>>>
20
down
>>>
10
up
>>>
15
up
>>>
17
맞았다
**************
1. 게임 시작
2. 게임 종료
**************
========================================
//객체선언 각각 해줘야 되고, 
import java.util.Random;
import java.util.Scanner;

public class Homework {
	public static void main(String[] args) {
		int dom, num, ram;
		
		while(true) {
			dom = (int) (Math.random()*30 +1);
			Scanner sc = new Scanner(System.in);
			System.out.println("************");
			System.out.println("1. 게임 시작:");
			System.out.println("2. 게임 종료:");
			System.out.println("************");
			num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("게임 시작");

				for(int i = 0; ; i++) {
					if(i >= 10) {
						System.out.println("기회를 다 사용");
						break;
					}
					System.out.println(">>>");
					ram = sc.nextInt();
					if(dom == ram) {
						System.out.println("same");
						System.out.println("게임 종료");
						break;
					}
					else if(dom < ram) {
						System.out.println("down");
						continue;
					}
					else if(dom > ram) {
						System.out.println("up");
						continue;
					}
				}
				break;
			case 2:
				System.out.println("게임 종료");
				return;			//break는 while처음으로

			default:
				System.out.println("잘못된 입력");
			}
		}
	}
}

//두번째 방법
class UpDownGame {
	private static int COUNT = 10;
	private int[] arrInput; // 배열로 하게끔
	private int answer;

	public UpDownGame() {
		arrInput = new int[COUNT];
		answer = (int) (Math.random() * 100 + 1);

	}

	public void run() {
		try {
			Scanner sc = new Scanner(System.in);

			for (int i = 0; i < arrInput.length; i++) {
				System.out.println("숫자를 입력해 주세요.");
				int num = sc.nextInt();

				if (num > answer) {
					System.out.println("down====>" + (COUNT - i - 1) + "번 남았습니다.");
				} else if (num < answer) {
					System.out.println("up====>" + (COUNT - i - 1) + "번 남았습니다.");
				} else {
					System.out.println("일치");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
			run(); // 재귀호출로 처음부터 다시 하게끔
		}
	}
}

public class RandomGame {
	public static void main(String[] args) {
		Scanner sc;
		UpDownGame game;

		while (true) {
			try {
				sc = new Scanner(System.in);
				System.out.println("게임시작 1");
				System.out.println("게임종료 2");
				System.out.println(">>>>>>>>>");
				int num = sc.nextInt();

				if (num == 1) {
					game = new UpDownGame();
					game.run();
				} else {
					System.out.println("게임종료");
					break;

				}
			}catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("게임을 다시 시작 합니다.");
			}

		}

	}
}

*********html 음악재생 만들기
<body>
    <table border="1">
        <tr>
            <td>
                <h1>주간 히트 노래</h1>
                <hr/>
                <ol>
                    <li><img src="img01.png" alt=""><a href="#">어머니 누구니</a></li>
                    <li><img src="img02.png" alt=""><a href="#">한번 더 말해줘</a></li>
                    <li><img src="img03.png" alt=""><a href="#">다른 남자 말고 너</a></li>
                    <li><img src="img04.png" alt=""><a href="#">모두가 내 발 아래</a></li>
                    <li><img src="img05.png" alt=""><a href="#">조만간 봐요</a></li>

                </ol>
                <p>
                <audio src="34ex1.mp3" controls="controls" autoplay="autoplay" loop="loop"></audio>
                </p>
            </td>
        </tr>
    </table>
</body>