package days03;


//LOMBOK 자동으로 이런것들 만들어주는 라이브러리
public class DepartmentsDTO {
	
	private int DEPARTMENT_ID;
	private String DEPARTMENT_NAME;
	private int MANAGER_ID;
	private int LOCATION_ID;
	
	public DepartmentsDTO() {
		super();
	}
	


	public DepartmentsDTO(int dEPARTMENT_ID, String dEPARTMENT_NAME, int mANAGER_ID, int lOCATION_ID) {
		super();
		DEPARTMENT_ID = dEPARTMENT_ID;
		DEPARTMENT_NAME = dEPARTMENT_NAME;
		MANAGER_ID = mANAGER_ID;
		LOCATION_ID = lOCATION_ID;
	}
	
	
	
//get,set	
	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}
	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}
	public int getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	public int getLOCATION_ID() {
		return LOCATION_ID;
	}
	public void setLOCATION_ID(int lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}



	@Override
	public String toString() {
		return "DepartmentsDTO [DEPARTMENT_ID=" + DEPARTMENT_ID + ", DEPARTMENT_NAME=" + DEPARTMENT_NAME
				+ ", MANAGER_ID=" + MANAGER_ID + ", LOCATION_ID=" + LOCATION_ID + "]";
	}

}
