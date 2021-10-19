1. 아래의 BankAccount(소스 PPT 참고) 에 대하여 메모리 그림을 그리시오.
BankAccount ref1 = new BankAccount();
BankAccount ref2 = ref1;

	 스텍				 	   힙
    메모리                   메모리
주소 _______            2000 ______________
1000| 2000  |ref1  ----->   |0             |balance
1004|_______|           2004|______________|
                            |deposit       |
     _______            2008|______________|
3000| 2000  |ref2	    |withdraW      |
3004|_______|	    	2012|______________|
			    |checkMyBalance|
                            |______________|

					
2. 생성자란 무엇인가요?
new 연산자와 같이 사용되어 클래스로부터 객체를 생성할 때 호출되어 객체의 초기화를 담당한다.
ClassName c = new ClassName();

3. 디폴트 생성자에 대하여 설명하시오.(Default Constructor)
생성자를 정의 해주지 않아도 기본으로 정의 되어 있는 생성자입니다.

4. 생성자의 용도는?
인스턴스 생성시 필드에 초기값으로 부여하기 위해
인스턴스 생성에 필요한 초기화 명령을 실행하기 위해

5. null 에 대하여 설명하시오.
변수에 아무것도 할당되지 않았을 때 그 변수는 null이라고 한다. null은 아무거도 없음을 의미

6. 아래의 TV 클래스를 만드시오.
public static void main(String[] args) {
	TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
	myTV.show();
}
//출력
LG에서 만든 2017년형 32인치 TV

class TV{
	String brand;	//값 3개를 이렇게 준다.
	int year;
	int inch;

	TV(String brand,int year,int inch){	//하지만 this에 있는 건 변수명
		this.brand = brand;
		this.year = year;
		this.inch = inch;
	}	
	public void show() {
		System.out.println(brand + "에서 만든" + year + "년" + inch + "인치");
	}
}

7. 아래의 Grade 를 만드시오.
public static void main(String[] args) {
		
		int math, science, english;
		math = 90;
		science = 80; 
		english = 80;

		Grade me = new Grade(math, science, english);
		System.out.println("평균은 " + me.average());
		System.out.println(me.getGrade()); //우 입니다.

class Grade{
	int math;
	int science;
	int english;
	int avg;

	Grade(int math, int science, int english){
		this.math = math;
		this.science = science;
		this.english = english;
	}
	public double average(){
		double avg = (math + science + english)/3.0;
		return avg;
		
	}
	public String getGrade() {		
		double avg = average();
		String str;
		
		if(avg >= 90) {
			str = "수";
		}
		else if(avg >= 80) {
			str = "우";
		}
		else if(avg >= 70) {
			str = "미";
		}
		else if(avg >= 60) {
			str = "양";
		}
		else {
			str = "가";
		}
	return str;		//void는 return값 필요없음. 그래서 string 써야 함.
	}
}

8. 노래 한 곡을 나타내는 Song 클래스를 작성하라. Song은 다음 필드로 구성된다.
- 노래의 제목을 나타내는 title
- 가수를 나타내는 artist
- 노래가 발표된 연도를 나타내는 year
- 국적을 나타내는 country

또한 Song 클래스에 다음 생성자와 메소드를 작성하라.

- 생성자 2개: 기본 생성자와 매개변수로 모든 필드를 초기화하는 생성자
- 노래 정보를 출력하는 show() 메소드
- main() 메소드에서는 
 
Song 객체로 생성하고 
show()를 이용하여 노래의 정보를 다음과 같이 출력하라.

출력:
1978년, 스웨덴 국적의 ABBA가 부른 "Dancing Queen"

class Song1{
	String title, artist, country;
	int year;
	
	Song1(String title, String artist, int year, String country){	//디폴트 생성자(매개변수로 필트 초기화해라)
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	public void show() {
		System.out.println(year + "년, " + country + " 국적의 " + artist + "가 부른 " + title);
	}
}
public class Song {
	public static void main(String[] args) {
		Song1 Song = new Song1("Dancing Queen", "ABBA", 1978, "스웨덴");
		Song.show();
	} 
}
