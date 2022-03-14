package days07;

public class Ex03_02 {

	public static void main(String[] args) {
		//10개의 정수를 저장할 변수를 선언하고, 그 기억공간에 각각 다른 값을 넣어 Math.random(),
		// 5~25까지의 수, 10개의 정수중 최대, 최소값 출력
		
	/*	
		int [] array = new int [10];
		int max, min;
		
		for(int i=0; i<10; i++) {
			
			array[i] = (int)(Math.random() *21+5);
			System.out.println(array[i]);
			}
		System.out.println("dd");
		for(int j=0;j<10;j++) {
			max = array[j]>array[j+1]? array[j] :array[j+1];
			 
			} System.out.println(max);
		*/
		
		//
		int [] m = new int [20];
		for(int i=0; i<m.length; i++) {
			m[i] = (int)(Math.random() *21) +5;
			System.out.print(m[i]+"/");
			
			}
			System.out.println();
			
			int max = m[0], min = m[0];
			for(int i=1; i<m.length; i++) {
				if(max<m[i])  max=m[i];
				if(min>m[i])  min=m[i];
		}
			System.out.println("최대값:" +max);
			System.out.println("최소값:" +min);
		

	}

}
