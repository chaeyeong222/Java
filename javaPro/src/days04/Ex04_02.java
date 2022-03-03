package days04;

/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 12:29:47
 * @subject  전위형, 후위형 연산자
 * @content   
 * + 두가지 완전히 다름
 *   while (x++ <10){
 *   while (++x <10){
 */
public class Ex04_02 {
	public static void main(String[] args) {
		
		int x = 10;
		//int y = ++x;   //x=11, y=11
		int y = ++x;     //x=11, y=10
		
		System.out.printf("x=%d, y=%d\n",x,y);
		
	}

}
