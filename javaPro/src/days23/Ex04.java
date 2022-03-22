package days23;

import java.text.ChoiceFormat;

/**
 * @author 이채영
 * @date 2022. 3. 22. - 오전 11:23:09
 * @subject p548 ChoiceFormat클래스
 * @content     특정범위에 속하는 값을 문자열로 변환해주는 형식화클래스
 */
public class Ex04 {

	public static void main(String[] args) {
		int [] scores = {100, 95,88,73,52,60,70,0};
		/*
		String [] grades = {"가","양", "미", "우","수"};
		double [] limits = {0,60,70,80,90};
		ChoiceFormat cf = new ChoiceFormat(limits, grades);
		*/
		//p.548 예제 10-17
		String newPattern="0#가|60#양|70#미|80#우|90#수";
		ChoiceFormat cf = new ChoiceFormat(newPattern);
		
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d 점-%s\n",scores[i],cf.format(scores[i]));
		}
		

	}

}
