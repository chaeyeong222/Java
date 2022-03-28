package days27;

import java.util.ArrayList;


/**
 * @author 이채영
 * @date 2022. 3. 28. - 오전 9:21:29
 * @subject p.684 제네릭메서드
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		//1. 제네릭 메서드? 메서드 선언부에 제네릭 타입에 선언된 메서드
		//2. 제네릭 타입의 선언 위치 : 리턴 자료형 앞
		//예) [접근지정자] [기타제어자] <T> 리턴자료형 메서드명 ([매개변수...]){ 
		//       return 리턴값   }
		// 3. 왜 선언 및 사용?
		
		FruitBox<Apple> appleBox= new FruitBox();
		Juicer.makeJuice(appleBox);
		
		//		FruitBox<Apple> appleBox= new FruitBox();
		//Juicer.makeJuice(appleBox);
		FruitBox<Grape> grapeBox= new FruitBox();
		Juicer.makeJuice(grapeBox);
		
		Juice a = Juicer.<Grape>makeJuice(grapeBox);
		
		
		System.out.println("end");
	}

}
class Fruit{public String toString() {return "과일";}}
class Apple extends Fruit{public String toString() {return "과일";}}
class Grape extends Fruit{public String toString() {return "과일";}}

class FruitBox<T extends Fruit >{
	ArrayList<T> list = new ArrayList<T>();
}

class Juice {}
//주스기계(사람)
class Juicer{
	//에러: Erasure of method makeJuice(FruitBox<Apple>) 
	// is the same as another method in type Juicer
/*	static Juice makeJuice (FruitBox<Apple> box) {
		return new Juice();
	}
	static Juice makeJuice (FruitBox<Grape> box) {
		return new Juice();
	}*/
	
	//제네릭 타입이 다른것 만으로는 오버로딩 성립 안됨.
	//와일드 카드 사용
	/*
	static Juice makeJuice (FruitBox<? extends Fruit> box) {
		return new Juice();
	}
*/
	
	//와일드카드 사용한 메서드를 제네릭 메서드로 선언할 수 있다. 
	static <T extends Fruit> Juice makeJuice (FruitBox<T> box) {
		return new Juice();
	}
}