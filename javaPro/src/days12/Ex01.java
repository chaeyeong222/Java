package days12;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 이채영
 * @date 2022. 3. 4. - 오전 9:09:17
 * @subject 
 * @content 등수처리
 */
public class Ex01 {

	public static void main(String[] args) {
		// 10명의 학생 0~300 임의의 정수 배열 초기화
		int [] tots = new int [10];
		/*
		 for(int i=0;i<30;i++) {
			tots[i] = (int)(Math.random()*100+1);
			System.out.println(tots[i]);
		} */

		Random rnd = new Random();
		for(int i=0;i<tots.length;i++) {
			tots[i] = rnd.nextInt(301);

		}System.out.println(Arrays.toString(tots));


		int [] ranks = new int [10];
		/*	for(int i=0;i<ranks.length;i++) {
			ranks[i]=1;
		}*/
		// 위아래 같은 코딩임.
		//Arrays 클래스 : 배열을 사용하기 쉽도록 기능을 구현해 놓은 클래스
		Arrays.fill(ranks, 1);

		//[등수처리] days7.Ex01_02.java 구구단과 같음.

		for(int j=0;j<ranks.length; j++) {
			for(int i=0; i<tots.length; i++) {
				/*if(j!=i ) {
					if(tots[j]<tots[i]) {
						ranks[j]++;
					}
				}
				if(j!=i && tots[j] <tots[i]) {
					ranks[j]++;
				}//비교하는게 정확하지만 자기자신보다 큰 경우는 당연히 없기때문에 성능이 좋도록 제외함*/
				
				if(tots[j] <tots[i]) {
					ranks[j]++;
				}//if
			}//for i
		}//for j

		System.out.println(Arrays.toString(ranks));

	}//main

}//class
