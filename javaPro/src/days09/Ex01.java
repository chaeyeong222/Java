package days09;
/**
 * @author 이채영
 * @date 2022. 2. 25. - 오전 9:28:51
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		//팩토리얼 (factorial) ==계승
		//n!= n*(n-1) *..*1 
	    // 0! ==1
		
		
		
		//5팩토리얼 값을 구해서 출력하는 코딩을 하세요
		int n=5;
		
		int result = factorial(n);
		System.out.println(result);
		
		result = recursiveFactorial(n);
		if(result == -1) {
			System.out.println("입력이 잘못되었습니다");
		}else		System.out.println(result);
		
		/*
		int result = 1;
		for(int i = n; i>=1; i--) {
			result *=i;
		}System.out.println(result);
		*/
		}//main

	//음수가 입력되면 => 입력이 잘못되었습니다, 0입력->1
	
	private static int recursiveFactorial(int n) {
	if(n>1) return n* recursiveFactorial(n-1);
	else if(n==1) return n;
	else if(n==0) return 1;
	else { //if(n<0)
		
		return -1;
	}
	}
	
	
	
	private static int factorial(int n) {
		int result = 1;
		for(int i = 1; i<=n; i++) {
			result *=i;
		}return result;
		
	}

}//class
