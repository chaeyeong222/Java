package days25;

public class Ex02 {

	public static void main(String[] args) {
		// [LinkedList 컬렉션 클래스]
		//불연속적 구조
		//비순차적으로 삭제/추가(성능 좋다)
		//[요소(Element)]---[]---[]---[]---[] 단방향 링크드리스트
		//[노드(node)]==[]==[]==[]==[] 더블형(양방향)링크드리스트
		//==[]==[]==[]==[]==[]== 더블형 써클(양방향 환형)링크드리스트

		Node node1 = new Node();
		node1.value = 10;


		Node node2 = new Node();
		node2.value = 20;

		Node node3 = new Node();
		node3.value = 30;

		Node node4 = new Node();
		node4.value = 40;

		node1.next= node2; 
		node2.next= node3; 
		node3.next= node4; 
		node4.next=null; //다음node 없음
		
		Node node = node1;
		while(node !=null) {
				System.out.println(node.value);
		        node = node.next;
	}
	}
}
class Node{
	int value;

	Node next = null;
	//Node prev=null;
}