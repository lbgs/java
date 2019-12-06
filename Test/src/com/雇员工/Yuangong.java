package com.雇员工;
/**
 * 
 * @author 王荣华
 *功能：创建一个员工类
 */
public class Yuangong {
	private String empNO;
	private String name;
	private float sal;
	public Yuangong(String empNo,String name,float sal){
		this.empNO=empNo;
		this.name=name;
		this.sal=sal;
	}
	public String getEmpNO() {
		return empNO;
	}
	public void setEmpNO(String empNO) {
		this.empNO = empNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
}
