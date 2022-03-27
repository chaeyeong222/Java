package days26;

import java.util.ArrayList;

public class Ex11 {

	public static void main(String[] args) {
		/*
		 * [제네릭의 용어]
		 * class Box<T> {
		 *   //
		 *   }
		 *   
		 *   1.Box <t> 제네릭클랫, T의 Box 또는 TBox
		 *     "T의 Box 제네릭 클래스"
		 *   2. T 타입변수 또는 타입 매개변수 (T타입문자)
		 *   3. Box 원시타입 raw type
		 *   
		 */
		/*
		 * [제네릭의 제한]
		 * 제네릭? 컴파일 시 타입 결정
		 * class Box<T> {
		 *   static 필드;   //에러남
		 *   static 메서드 () {}  //에러남
		 *     (제네릭 클래스 안에서는 스테틱 필드, 메서드 선언 불가)
		 *     T[] 배열은 선언 사용 가능함.
		 *      = new T[3]; 배열 생성은 불가 
		 *   }
		 *   
		 */

		Box2<Fruit> fruitBox = new Box2<>();
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		//타입불일치  당연히 에러
		//Box2<Grape> grapeBox = new Box2<Apple>();
		
	}//main

}//class

class Fruit{public String toString() {return "과일";}}
class Apple extends Fruit implements Eatable {public String toString() {return "과일";}}
class Grape extends Fruit{public String toString() {return "과일";}}
class Toy {public String toString() {return "과일";}}

class Box2<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	int size() {return list.size();}
	public String toString() {return list.toString();}
}

