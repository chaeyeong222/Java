package days26;

import java.util.ArrayList;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오후 4:22:52
 * @subject 
 * @content 
 */
public class Ex12 {

	public static void main(String[] args) {
		// p676 제한된 제네릭 클래스  : class Box<T extends B>
		
		/*
		Box2<Toy> box = new Box2<Toy>();
		box.list.add(new Toy());
		box.list.add(new Toy());
		box.list.add(new Toy());
		*/

		//                 T 반드시  Fruit 과일 의 자식들만 제한하는 제네릭 클래스 선언
	/*
		FruitBox<Fruit> box = new FruitBox<>();
		box.list.add(new Apple());
		box.list.add(new Apple());
		// The method add(Apple) in the type ArrayList<Apple>
		//  is not applicable for the arguments (Grape)
		//box.list.add(new Grape());
	*/
		
	//	FruitBox<Apple> box4 = new FruitBox<>();
		// FruitBox<Grape> box5 = new FruitBox<>();
		
		//FruitBox<Toy> box2 = new FruitBox<>();
		//FruitBox<Member> box3 = new FruitBox<>();
		
	}  // main

}   // class

//                         제한된 제네릭 클래스 
interface Eatable{}
//                                          과일 클래스를 물려받은 자식이면서 Eatable 인터페이스를 구현한 클래스 타입..
class FruitBox<T extends Fruit & Eatable>{
	ArrayList<T> list = new ArrayList<T>();
}


//  class Box<T extends B>
