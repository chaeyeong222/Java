package days04;

import java.sql.Date;

public class empRankDTO {

	
	private int empno;
	private String ename;
	private double sal;
	private int deptno;
	private int rank;
	
	@Override
	public String toString() {
		return "empRankDTO [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", deptno=" + deptno + ", rank="
				+ rank + "]";
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public empRankDTO() {
		super();
	}
	
	public empRankDTO(int empno, String ename, double sal, int deptno, int rank) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;
		this.rank = rank;
	}
}
