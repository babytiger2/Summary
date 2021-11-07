1. Wrapper class란?
8개의 기본타입 데이터를 객체로 만들어 주는 클래스
각각의 타입에 해당하는 데이터를 받아 값을 가지는 객체로 만듬

2. auto unboxing이란?
auto boxing은 new를 사용하지 않고 자동으로 인스턴스 생성 가능
반대로 Value() 메소드를 사용하지 않고, auto unboxing을 이용하여 인스턴스 저장된 값을 바로 참조 가능

3. BigInteger 클래스에 대하여 설명하시오.
- 클래스 Person은 이름을 저장하는 필드 구성
- 클래스 Person은 상위 클래스 Object의 메소드 equals()를 오버라이딩하여 이름이 같으면 true를 반환하는 메소드 구현
- 다음과 같은 소스로 클래스 Person을 점검

Person p1 = new Person("홍길동");
System.out.println(p1.equals(new Person("홍길동")));
System.out.println(p1.equals(new Person("최명태")));

결과 
true
flase

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		if (this.name.equals(person.name)) {
			return true;
		}
		return false;
	}
}

4. 다음 조건을 만족하는 클래스 String의 객체 이용 프로그램을 작성하여 메소드 equals()와 연산자 == 의 차이를 비교 설명하시오.
String s1 = new String("java");
String s2 = new String("java");
String s3 = s2;

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
System.out.println(s2 == s3);
System.out.println(s2.equals(s3));

==은 주소지가 같은지에 대해서 연산하고 equals()는 문자열이 같은지 연산함

5. 아래를 정리하시오.
- 프로토콜 
컴퓨터 사용 시 기기 간 또는 내부에서 통신되는 데이터 형식에 대한 합의를 요구하는데 그것을 정의하는 규칙을 보고 프로토콜이라고 한다.

- DNS(도메인 네임 시스템)
인터넷과 연결된 모든 것에는 주소가 존재 그것이 IP주소인데 숫자로 되어 이어서 일일히 구분하고 기억하기 어렵다 그래서 문자로 만들어진
도메인 네임이라는 것을 이용

- 포트 번호(프로그램 번호)
컴퓨터에서 작동중인 여러프로그램들중(멀티스레드중) 하나를 식별하기위해 사용
