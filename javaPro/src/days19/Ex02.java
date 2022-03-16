package days19;

import java.io.Serializable;

/**
 * @author 이채영
 * @date 2022. 3. 16. - 오전 10:11:02
 * @subject p.392 스타크래프트 게임
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		//SCV- 자원, 수리
		
		
	}//main

}//class

//public interface Serializable
//[직렬화가 가능한 클래스]implements Serializable 붙이면 직렬화가 가능한 클래스
class Unit implements Serializable{
}

class GroundUnit extends Unit{ //지상유닛
}

class AirUnit extends Unit{ //공중유닛
}
//자기자신을 통한 수리ok 
class SCV extends GroundUnit implements Repairable{//자원캐는애들
	void 자원캐는메서드(){
		
	}
	void unitRepair(Repairable Unit) {
		//수리작업
	}
}
//implements Repairable 를 통해 SCV 통한 수리가 가능한 유닛인지 알 수 있음
class Tank extends GroundUnit implements Repairable{//탱크  -> SCV통한 수리o
	
}
class DropShip extends AirUnit implements Repairable{//수송선  -> SCV통한 수리o
	
}
class Marine extends GroundUnit{//보병  -> SCV통한 수리x
	
}

interface Repairable{
	//아무멤버도x
}