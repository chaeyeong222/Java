package days10;

import java.util.Random;

public class Ex02 {

	public static void main(String[] args) {
		//결제할 때 랜덤하게 특정 위치 4자리 숫자가 ****로 출력
		//System.out.println("7655-****-9234-5677");
		//System.out.println("7655-8988-9234-****");
		//System.out.println("****-8988-9234-5677");
		//System.out.println("7655-8988-****-5677");
		
		String card = "7655-8988-9234-5677";
		
		String regex = "-";
		String [] cardNumbers = card.split(regex);
		
		Random rnd = new Random();
		//rnd.nextInt(4);   // 0<= 정수    <4(bound) ->Math.random 사용 안해도 돼
		int starIndex=rnd.nextInt(4);
		cardNumbers[starIndex] = "****";
		/*
		for (String cn : cardNumbers) {
			System.out.println(cn);
		}
		*/
		//각 배열의 요소값을 '-'로 연결해서 출력
		//System.out.printf("%s-%s-%s-%s\n",cardNumbers[0],cardNumbers[1],cardNumbers[2],cardNumbers[3]);
		
		String data =  String.format("%s-%s-%s-%s\n", 
				cardNumbers[0], cardNumbers[1], cardNumbers[2], cardNumbers[3]);
		
		//6. String.join()
				card = String.join("-", cardNumbers);
				System.out.println(card);
		

	}

}
