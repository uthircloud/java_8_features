/**
 * 
 */
package com.learnjava.lab.lambda.model;

/**
 * @author UthirNew
 *
 */
public class Member {

	private String firstNm;
	private String lastNm;
	private String gender;
	private int age;
	/**
	 * @return the firstNm
	 */
	public String getFirstNm() {
		return firstNm;
	}
	/**
	 * @param firstNm the firstNm to set
	 */
	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}
	/**
	 * @return the lastNm
	 */
	public String getLastNm() {
		return lastNm;
	}
	/**
	 * @param lastNm the lastNm to set
	 */
	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printPerson(){
		System.out.println(this.firstNm + " " + this.lastNm);
	}
}
