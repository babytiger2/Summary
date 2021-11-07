1. 상속을 UML로 표시하면?
class TV {                                 * UML 표시
  ...                                              TV  
}                                                  ↑
                                               ColorTV
class ColorTV extends TV {
  ...
}

2. 부모 클래스와 자식 클래스의 다른 용어들은?
부모 클래스의 다른 용어는 상위클래스,기초클래스가 있고
자식 클래스의 다른 용어는 하위클래스 라고도 부른다.

3. this 키워드와 super 키워드의 차이는 무엇인가요?
this는 생성자 호출을 의미 
super는 부모 생성자 호출의 의미

4. 단일 상속과 다중 상속 이란 무엇인가요? UML 로의 표기는?
class TV {                                 * UML 표시
  ...                                              TV  
}                                                  ↑
                                               ColorTV
class ColorTV extends TV {
  ...
}

//////////////////////////////////////////////////////////////////

class TV {                                 * UML 표시
  ...                                              TV  
}                                                  ↑
                                               ColorTV
class ColorTV extends TV {                  ↑
  ...				  IPTV
}

class IPTV extends ColorTV {
  ...
}

5.
다음은 2차원 상의 한 점을 표현하는 Point 클래스이다. 
Point를 상속받아 색을 가진 점을 나타내는 ColorPoint 클래스를 작성하라. 
다음 main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.

class Point {
	private int x, y;
	public Point(int x, int y) { this.x = x; this.y = y; }
	public int getX() { return x; }
	public int getY() { return y; }
	protected void move(int x, int y) { this.x =x; this.y = y; }
class ColorPoint extends Point{
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		super(x,y);
		this.color = color;
	}
	public void setXY(int x,int y) {
		super.move(x, y);	//private 으로 xy소환 불가능 move로 대체
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString() {
		String str = null;
		str = color + "색의(" + super.getX() + "," + super.getY() +")의 점";
		return str;
	}
}
public static void main(String[] args) {
	ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
	cp.setXY(10, 20);
	cp.setColor("RED");
	String str = cp.toString();
	System.out.println(str+"입니다. ");
}

/*
=======================
RED색의 (10,20)의 점입니다.
*/

6. 다음 main() 메소드와 실행 결과를 참고하여 TV를 상속받은 ColorTV 클래스를 작성하라.
다음 TV 클래스가 있다.

class TV{
   private int size;
   public TV(int size) { this.size = size; }
   protected int getSize() { return size; }
}

class ColorTV extends TV {
	private int color;
	
	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}
	public void printProperty() {
		System.out.print(super.getSize()+"인치");
		System.out.print(color+"컬러");
	}
}

public static void main(String[] args) {
   ColorTV myTV = new ColorTV(32, 1024);
   myTV.printProperty();
}

/*
======================
32인치 1024컬러
*/

7. 다음 main() 메소드와 실행 결과를 참고하여 ColorTV를 상속받는 IPTV 클래스를 작성하라.
class TV {
	private int size;

	public TV(int size) {
		this.size = size;
	}
	
	protected int getSize() {
		return size;
	}
}

class ColorTV extends TV {
	private int color;

	public ColorTV (int size,int color) {
		super(size);
		this.color = color;
	}

	public void printProperty() {
		System.out.println(super.getSize() + "인치" + this.color + "컬러");
	}
}


class IPTV extends ColorTV {
	private String ip;
	
	public IPTV(String ip, int size, int color) {
		super(size,color);
		//super(color);
		this.ip = ip;
	}
	public void printProperty() {
		System.out.print(ip +"주소에");
		super.printProperty();
	}
}


public static void main(String[] args) {
   IPTV iptv = new IPTV("192.1.1.2", 32, 2048); //"192.1.1.2" 주소에 32인치, 2048컬러
   iptv.printProperty();
}

/*
=============================================
나의 IPTV는 192.1.1.2 주소의 32인치 2048컬러
*/

++++++++++개별진척도
1.
public class Random{
	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		int num =1;
		
		for(int i=0; i<arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				arr[i][j] = (int)(Math.random()*100+1);
				
			}
		}
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}

**********
class SuperCLS {
    protected static int count = 0;

    public SuperCLS() {
        count++;
        System.out.println("호출됨");
    }
}

//SubCLS obj3 = new SubCLS();
//obj3.showCount();
class SubCLS extends SuperCLS {	
	
	public SubCLS() {
		super();		
	} //컴파일러가 넣어준다.
	
	public void showCount() {
        System.out.println(count);
    }
}


public class BreakPoint {
    public static void main(String[] args) {
    	   SuperCLS obj1 = new SuperCLS();
           SuperCLS obj2 = new SuperCLS();
           
           SubCLS obj3 = new SubCLS();
           obj3.showCount();
    	
    }
}

************상속에 대해서  class를 만들 때 체크해야 될 부분
/*  
1. class명을 만든다. 
2. 데이터 멤버(인스턴스 변수)를 만든다.(private)
3. 생성자를 만든다.(public Friend)
4. 데이터 멤버를 컨트롤 하는 함수를 만든다.  
*/
class Friend{
	private String name;
	private String num;
	
	public Friend(String name, String num) {
		this.name = name;
		this.num = num;
	}
	public void showInfo() {
		System.out.println(name);
		System.out.println(num);
		
	}
}

class UnivFriend extends Friend{
	
	private String major;
	
	public UnivFriend(String name, String major, String num) {
		super(name,num);
		this.major = major;
	}
	public void showInfo() {
		super.showInfo();
		System.out.println(major);
		
	}
}

class CompFriend extends Friend{
	
	private String dept;
	
	public CompFriend(String name, String dept, String num) {
		super(name,num);
		this.dept = dept;
	}
	public void showInfo() {
		super.showInfo();
		System.out.println(dept);
	}
}

public class UnivComp {

	public static void main(String[] args) {
		Friend[] frns = new Friend[10];
        int cnt = 0;
        
        frns[cnt++] = new UnivFriend("LEE", "Computer", "010-333-555");
        frns[cnt++] = new UnivFriend("SEO", "Electronics", "010-222-444");
        frns[cnt++] = new CompFriend("YOON", "R&D 1", "02-123-999");
        frns[cnt++] = new CompFriend("PARK", "R&D 2", "02-321-777");


        // 모든 동창 및 동료의 정보 전체 출력
        for(int i = 0; i < cnt; i++) {
            frns[i].showInfo();
            System.out.println();
        }
	}
}
