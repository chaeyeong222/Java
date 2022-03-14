package days07;

public class Ex03 {

	public static void main(String[] args) {
		//세 정수를 임의의 값으로 입력받아서  math.random() 10~50 정수
		// 그 세 정수 중 가장 큰 값을 출력
		/*
		
		int [] array = new int [3];
		
		for(int i=0; i<3; i++) {
	
		array[i] = (int)(Math.random() * 50);
		if(array[i] <10 ) continue;
		
		}
		int n = array[0];
		int m = array[1];
		int k = array[2];

				
		if( n >=m && m>=k) {
			System.out.println(n);
		}
		
*/
		int x,y,z;
		//초기화                     0.0<= double Math.random()<1.0
		//                 0.0*41+10<=(int) Math.random()<1.0*41 +10
		//                             10<=(int) Math.random()<51
		x= (int) (Math.random() *41 +10) ;
		y= (int) (Math.random() *41 +10) ;
		z= (int) (Math.random() *41 +10) ;
		System.out.printf("x=%d, y=%d, z=%d",x,y,z);
		
		//두 정수 먼저 비교, 남은 값과 비교
		/*
		int max, min;
		
		if(x>y) max=x;
		else     max=y;
		if(max<z) max=z;
		
		System.out.println("최대값="+ max);
		*/
		
		//삼항연산자 안에 삼항연산자
		
		int max = x>y?  (x>z? x:z) : (y>z? y:z);
		int min =  x<y? (x<z? x:z) : (y<z? y:z);
		System.out.printf("\n최대값=%d,최소값=%d", max, min);
		
		
		
		
		
		
		
	}

}
