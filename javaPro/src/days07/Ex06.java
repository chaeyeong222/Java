package days07;

public class Ex06 {

	public static void main(String[] args) {
		// 1-2+3-4+5-6+7-8+9-10=-5
		
		/*
		int sum=0;
		for(int i=1; i<=10; i++) {
			if(i%2==0) {
				sum-=i;
				System.out.printf("%d+", i);
			} else{
				sum+=i;
				System.out.printf("%d-", i);
			}
         }System.out.println("\b=" +sum);

		System.out.println("----------------");
		
		int sum = 0;
		for(int i=1; i<=10; i++) {
			
			sum += (i%2 ==0? -i:i);
			System.out.printf(i%2==0?"%d+":"%d-",i);
		}System.out.println("\b="+sum);
		
		System.out.println("----------------");
		//스위치 변수 선언해서 코딩
		
		int sum=0;
		boolean sw = false;
		
		for(int i=1; i<=10; i++) {
			if(sw ==true) {
				sum-=i;
				System.out.printf("%d+", i);
			} else{
				sum+=i;
				System.out.printf("%d-", i);
			}
			sw = !sw;
         }System.out.println("\b=" +sum);
		*/
		int sum=0;
		boolean sw = false;
		
		for(int i=1; i<=10; i++) {
			sum += (i%2 ==0? -i:i);
			System.out.printf(i%2==0?"%d+":"%d-",i);
			sw = !sw;
         }System.out.println("\b=" +sum);
		
		
		
	}//main

}//class
