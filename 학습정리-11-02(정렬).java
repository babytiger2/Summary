1. 아래의 결과 값은 false 출력이 된다. true 가 되도록 INum을짜시오.
class INum {
	private int num;

	public INum(int num) {
		this.num = num;
	}
	@Override
	public boolean equals(Object obj) {
		INum ar = (INum) obj;
		if (this.num == ar.num) {
			return true;
		}
		return false;
	}
}

INum[] ar1 = new INum[3];
INum[] ar2 = new INum[3];

ar1[0] = new INum(1); ar2[0] = new INum(1);
ar1[1] = new INum(2); ar2[1] = new INum(2);
ar1[2] = new INum(3); ar2[2] = new INum(3);

System.out.println(Arrays.equals(ar1, ar2));

2. 아래에서 정렬이 이름 순으로 되게끔 하시오. Person 객체를 만드시오.
class ArrayObjSearch {
	public static void main(String[] args) {
		Person[] ar = new Person[3];    
		ar[0] = new Person("Lee", 29);
		ar[1] = new Person("Goo", 15);
		ar[2] = new Person("Soo", 37);
		Arrays.sort(ar);
	}
}

import java.util.Arrays;

class Person implements Comparable {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object o) {
		Person p = (Person) o;
		return p.name.compareTo(this.name);
	}

	@Override
	public String toString() {
		return name + " " + age;
	}
}

public class Arraysort4 {

	public static void main(String[] args) {
		Person[] ar = new Person[3];

		ar[0] = new Person("Lee1234", 29);
		ar[1] = new Person("Goo12", 15);
		ar[2] = new Person("Soo3", 37);

		Arrays.sort(ar);

		System.out.println(Arrays.toString(ar));
	}
}

3.위의 문제에서 사람의 이름 글자 수가 많은 순으로 정렬을 되게끔 person 객체를 만드시오.
class Person implements Comparable {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compareTo(Object o) {
		Person p = (Person) o;
		return  p.name.length() - this.name.length();
	}

	public String toString() {
		return name + ": " + age;
	}
}

4. 아래의 문자열을 ":" 구분자로 하여, PM 08 45 를 차례로 출력하는 프로그램을 작성 하시오.
"PM:08:45"

StringTokenizer str = new StringTokenizer("PM:08:45", ":");
	while(str.hasMoreTokens())
		System.out.print(str.nextToken() + ' ');

5. 아래를 넓이 순서대로 출력하게끔 하시오.
Rectangle[] recArr = {new Rectangle(6, 6),new Rectangle(5, 5),new Rectangle(10, 10),new Rectangle(12, 12),new Rectangle(11, 11)};
	Arrays.sort(recArr);      
	for ( Rectangle rec: recArr) {
		System.out.println(rec.getArea());
	}

class Rectangle implements Comparable {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getArea() {
		return width * height;
	}

	@Override
	public int compareTo(Object obj) {
		Rectangle rec = (Rectangle) obj;
		return this.getArea() - rec.getArea();
	}
}

6. html 에서 아래의 태그를 설명하시오.
-<br> break(Line break) 줄을 바꾼다
-<li> List Item 본문 안에 줄을 바꿔서 출력하는 부분
ul태그와 ol태그의 내부에서 사용된다.
내부의 사용하면서 목록의 내용이 되는 실질적인 태그
-<ol> ordered list 숫자나 로마체 등 순서가 있는 목록을 만드는 데 사용
-<ul> unordered list 순서가 필요없는 본문 앞에 점을 찍음

*********나이순으로 찍으시오.
class Person implements Comparable {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object obj) {
		Person p = (Person) obj;
		return this.age - p.age;
	}

	public String toString() {
		return name + " " + age;
	}
}

Person[] ar = new Person[3];

	ar[0] = new Person("Lee1234", 29);
	ar[1] = new Person("Goo12", 15);
	ar[2] = new Person("Soo3", 37);

	Arrays.sort(ar);
		for(Person p : ar)
		System.out.println(p);
