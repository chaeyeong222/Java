package days04;

public class deptRankDTO {
	
	
	private int deptno;
	private String dname;
	private int cnt;
	
	@Override
	public String toString() {
		return "deptRankDTO [deptno=" + deptno + ", dname=" + dname + ", cnt=" + cnt + "]";
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public deptRankDTO() {
		super();
	}
	
	public deptRankDTO(int deptno, String dname, int cnt) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.cnt = cnt;
	}

}
