package days25;

import java.util.Stack;

public class Ex03_02 {

	public static void main(String[] args) {
		//605p
		
		Stack s = new Stack();
		
		s.push("김기태");
		s.push("박재영");
		s.push("정도연");
		s.push("이다원");
		
		String name = (String)s.peek();
		System.out.println(name); //이다원
		name = (String)s.peek();
		System.out.println(name); //이다원 -> 제거안하기 때문에 또 나옴
		
		System.out.println(s.empty());  //false   Stack에서 새로 만든 것
		//System.out.println(s.isEmpty()); //false  Vector에서 물려받은 것
		/*
		String name =(String)s.pop();
		System.out.println(name); //이다원
		name =(String)s.pop();
		System.out.println(name); //정도연
		*/
		/*
		String name;
		while(!s.empty()) { //비어있지 않다면 계속
			name =(String)s.pop();
			System.out.println(name);
		}
		*/
		//s.iterator() -> stack에서는 사용하면 안된다. 왜? 순차적으로 가져오니까 스택구조 사용x
		
		int findIndex = s.search("홍길동");
		//수정,삭제...
		

	}//main

}//class
