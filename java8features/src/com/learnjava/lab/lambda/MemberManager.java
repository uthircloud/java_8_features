/**
 * 
 */
package com.learnjava.lab.lambda;

import java.util.ArrayList;
import java.util.List;

import com.learnjava.lab.lambda.model.Member;

/**
 * @author UthirNew
 *
 */
public class MemberManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MemberManager mbrManger = new MemberManager();
		
		System.out.println("Members age greater than 30");
		mbrManger.printMemberOlderThanByAge(mbrManger.getMembers(), 30);
		
		System.out.println("-----------------------------------------------------------");
		
		mbrManger.printMembersByAgeRange(mbrManger.getMembers(), 30, 50);
		

	}

	 /**With this approach we need to implement different methods or change this
	 method when search criteria changes
	  **/
	public void printMemberOlderThanByAge(List<Member> mbrs,int age){
		for(Member mbr:mbrs){
			if(mbr.getAge()>=25){
				mbr.printPerson();
			}
		}
	}
	
	public void printMembersByAgeRange(List<Member> mbrs,int min,int max){
		System.out.println("Display Members based on Age Range between "+min+"and"+max);
		for(Member mbr:mbrs){
			if(mbr.getAge() >= min && mbr.getAge() <=max){
				mbr.printPerson();
			}
		}
    }
	
	
	public List<Member> getMembers(){
		
		List<Member> members = new ArrayList<>();
		
		Member mbr1 = new Member();
		
		mbr1.setFirstNm("Rohit");
		mbr1.setLastNm("Sharma");
		mbr1.setAge(30);
		mbr1.setGender("M");
		members.add(mbr1);
		
		Member mbr2 = new Member();
		
		mbr2.setFirstNm("Kapil");
		mbr2.setLastNm("Dev");
		mbr2.setAge(50);
		mbr2.setGender("M");
		members.add(mbr2);
		
		Member mbr3 = new Member();
		
		mbr3.setFirstNm("Virat");
		mbr3.setLastNm("Kohli");
		mbr3.setAge(28);
		mbr3.setGender("M");
		members.add(mbr3);
		
		
		Member mbr4 = new Member();
		
		mbr4.setFirstNm("Sachin");
		mbr4.setLastNm("Tendulkar");
		mbr4.setAge(42);
		mbr4.setGender("M");
		members.add(mbr4);
		
		Member mbr5 = new Member();
		
		mbr5.setFirstNm("Rishab");
		mbr5.setLastNm("Pant");
		mbr5.setAge(22);
		mbr5.setGender("M");
		members.add(mbr5);
		
		return members;
		
		
	}
}
