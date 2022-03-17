package days09;

public class Ex03_02 {

	public static void main(String[] args) {
		
		//System.out.println((double) Math.pow(2.0, 3.0));//2의 3승
		//	i = Math.abs(i);//절대치 구해주는 함수
		
		int i = -3;
        i = change(i);
		
		System.out.println(i);
		
	}//main

	private static int change(int i) {
		i = i*-1;
		return i;
	}

}//class
