package days09;

public class Ex03 {

	public static void main(String[] args) {
		// [재귀호출함수]
		//2^3=2*2*2
		
		//System.out.println((double) Math.pow(2.0, 3.0));//2의 3승
		
		//int result = power (2,3);
		//double result =power(2, -3);  //0.125
		double result =recursivepower(2, -3);  //0.125
		System.out.println(result);
	}
	//[과제] 누승을 재귀함수로.
	private static double recursivepower(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
	private static double power(int i, int j) {
	    double result=1;
	    int n = Math.abs(j);
	    for(int k=1; k<=n; k++) {
	    	result *= i;
		 }return j<0? 1/result:result;
	
	
	
	/*
	    private static double power(int i, int j) {
	    double result=1;
	    
	    if(j>0) {
	    for(int k=1; k<=j; k++) {
	    	result *=i;
	    }	return result;
	    
	    }else {
	    	 j = j*-1;
	    	 for(int k=1; k<=j; k++) {
	 	    	result *=i;
	 	    }return 1/result;
 }
	*/
	
	}//main

}//class
