package days10;

public class Ex01_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first=1;
	      int second=1;
	      int sum = 0;
	      int next =0;
	      

	      //233까지 출력되는 이유?
	      while (next<150) {
	         next=first+second;//순서 잘못됨. 먼저 처리해야함.
	         first=second;
	         second=next;
	         sum+=next;
	         System.out.println(next); 
	      }

	}

}
