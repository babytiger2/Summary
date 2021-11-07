1. Generic 메소드에 대하여 설명하시오.
제네릭이란 데이터의 타입을 일반화하는 것을 의미한다.
제네릭은 클래스나 메소드에서 사용할 데이터 타입을 컴파일 시에 미리 지정하는 방법입니다.
제네릭 사용에 대한 장점은 클래스나 메소드 내부에서 사용되는 객체의 타입 안정성을 높일 수 있습니다.
반환값에 대한 타입 변환 및 타입 검사에 들어가는 노력을 줄일 수 있습니다.

2. Generic(제네릭) 클래스의 타입 인자 제한하는 방법과 효과는?
인스턴스 생성 시 타입인자로 Number 또는 이를 상속하는 클래스만 올 수 있음. T로 전달이 되는 인자는 
Number Class를 상속 또는 Number Class의 Instance만 가능.

3. 와일드 카드란?
제네릭 코드에서 물음표로 표기되어 있는 것을 말하며, 아직 알려지지 않은 타입을 나타냅니다.
타입 파라미터를 제대로 사용하고 있다면 제네릭, 제대로 사용하려면 와일드 카드

4. 아래가 에러나는 이유를 설명하시오.
class Box<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public get() { return ob; }
}

...

public static void inBox(Box<? super Toy> box, Toy n) {
   box.set(n);   // 넣는 것! OK!
   Toy myToy = box.get();   // 꺼내는 것! Error!
}

: 자식을 부모로 받아내서

5. 아래의 소스코드 중에 System.out.println(zBox.get().get().get()); 부분을 설명하시오.

class Box<T> {
	private T ob;
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

public class BoxInBox {
	public static void main(String[] args) {
		Box<String> sBox = new Box<>();
		sBox.set("I am so happy.");
		Box<Box<String>> wBox = new Box<>();
		wBox.set(sBox);
		Box<Box<Box<String>>> zBox = new Box<>();
		zBox.set(wBox);
		System.out.println(zBox.get().get().get());
	}
}
: 제네릭 3개의 집합 안에 들어가 있기 때문에 꺼내려고 get()을 3번 준다.

6. 아래를 컴파일 에러가 나지 않게끔 프로그래밍 하시오.
    public static void main(String[] args) {
        Box7<Integer> box1 = new Box7<>();
        box1.set(99);

        Box7<Integer> box2 = new Box7<>();
        box2.set(55);

        System.out.println(box1.get() + " & " + box2.get());
        swapBox(box1, box2); 
        System.out.println(box1.get() + " & " + box2.get());
    }
/*
출력 =========================================

99 & 55
55 & 99
*/
class Box7<L>{
	private L num;
	
	public void set(L la) {	//set으로 결과값을 출력한다.
		num = la;
	}
	public L get() {		//get으로 결과값을 부른다.
		return num;
	}
}

private static <L> void swapBox(Box7<L> box1,Box7<L> box2) {
		L i = box1.get();
		box1.set(box2.get());
       box2.set(i);
	}

7. Scanner를 이용하여 한 라인을 읽고, 공백으로 분리된 어절이 몇 개 들어 있는지 "그만"을 입력할 때까지 반복하는 프로그램을 작성하라.

>>I love Java.
어절 개수는 3
>>자바는 객체 지향 언어로서 매우 좋은 언어이다.
어절 개수는 7
>>그만
종료합니다...
[Hint] Scanner.nextLine()을 이용하면 빈칸을 포함하여 한 번에 한 줄을 읽을 수 있다.

(1) StringTokenizer 클래스를 이용하여 작성하라.

while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("문장을 입력하세요.");
			String num = sc.nextLine();
			if (num.equals("그만")) {
				System.out.println("종료합니다.");
				break;
			} else {
				StringTokenizer st1 = new StringTokenizer(num, " ");
				System.out.println("어절 개수는 " + st1.countTokens());

			}
		}

*********HTML
form 폼 태그
: 집어넣을 수 있는 부분 action이 서버주소, method는 get하고 post가 있다.(액션 프라푸티, 메소드 프라푸티)
→form안에 있는 값들을 action에 있는 주소로 보내겠다.

input의 type은 뭘 넣을지 name이 키 value형태로 key : value형태로 

name태그는 value를 식별하는 변수명
String name = "Tom"
받을 때는 name이란 이름으로 

아이디로 변수명이 uid란 이름으로 있음

type에 각각의 타입을 지정해주면 알맞게 쓸 수 있음.
input박스에 type 값은 정해져있다.
name은 개발자가 지정하는 것

타입을 지정만 해줘도 된다.(어디까지가 웹 브라우저가 자동적으로 일 하는지 모른다.)
html만든 사람은 이렇게 하면 구글 웨 브라우저에서 이렇게 한다 라고 개발되어 있다.
그래서 개발자는 어디까지 몫인지 감을 잡으면 된다.

radio는 선택의 동그라미가 뜬다, gender는 남녀가 선택할 있게 해준다. 둘 중에 하나만 선택가능하게 되어짐
선택지는 원하는 만큼 늘릴 수 있다. 

name은 같은 것끼리 묶는 것 그래서 name이 같아져야 함.

마지막submit에서 넘어가는 것은 남녀값이 아니라 valur값이 넘어간다.
checkbox로 주게 되면 체크가 되는 형태로 선택가능.
똑같은 name으로 묶으면 

div태그를 가장 많이 사용함. 블록태그 
span은 inline태그라고 표현한다.

1. 블록태그 div
2. 인라인태그 span

div는 단락마다 줄이 바뀐다.
span은 한 줄로 이어져서 나온다.

div - block이라는 건 한 블록 한 블록 내용으로 처음부터 끝(한 줄)채운다.
span - inline은 내 안에 있는 내용물까지만 자리를 차지하겠다.

inline태그의 종류도 있다(다른 용어들도 존재 정확히 말하면 아예 같은 일을 한다기 보다는 
inline의 속성을 갖고 있음.)

<b> = bold의 의미

대표적인 inline, block태그를 기억하고 찾아볼 것

div에 의미를 부여한 것이 시멘틱 태그이다.
semantic에는 header,nav,section,footer가 있다. 문단을 나눌 때 div대신 사용

6장 - html5(4까지 div) + CSS + Javascript

CSS 글자 색깔 입히고 cascating system style?
<style>
 
selector는 선택자