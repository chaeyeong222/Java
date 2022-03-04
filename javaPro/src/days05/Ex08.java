package days05;

/**
 * @author 이채영
 * @date 2022. 2. 21. - 오후 3:08:24
 * @subject 
 * @content ++i 전위형/        i++후위형
 */
public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum=0, i=1;;
	//	while( ++i <=10) {    // 1<=10 무한루프
		
		// System.out.print(++i + "+");    전위형
		// System.out.print(i++ + "+");    후위형
		
			sum +=i;
		
			System.out.print(i + "+");
			i++;
		System.out.println("=" + sum);

	}

}
