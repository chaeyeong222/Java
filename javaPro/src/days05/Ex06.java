package days05;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		for(int i = 1; i<=10; i++) {
			System.out.printf("%d -%s\n", i,"헬로우월드");
		}
		
		
		int sum=0;
		for(int i = 1,j=100,k=3;       i<=10 &&  j>98;   i++, j--, k++) {
			System.out.print(i + "+");
			sum +=i;
		}
		System.out.println("=" + sum);

	}

}
