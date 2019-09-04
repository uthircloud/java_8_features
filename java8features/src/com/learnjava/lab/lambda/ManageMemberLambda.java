/**
 * 
 */
package com.learnjava.lab.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.learnjava.lab.lambda.intf.CheckMember;
import com.learnjava.lab.lambda.model.Member;

/**
 * @author UthirNew
 *
 */
public class ManageMemberLambda {
	
	public static void main(String [] args){
		
		ManageMemberLambda manageMbr = new ManageMemberLambda();
		
		
		
		manageMbr.printMembers(manageMbr.getMembers(), (Member m) -> m.getAge() >= 30 
				                                                     && m.getAge() <= 45 
				                                                     && m.getGender().equals("M"));
		
		System.out.println("--------------------------------------------------------------------");
		
		manageMbr.printMembersWithPredciate(manageMbr.getMembers(), (m) -> m.getAge() >= 30 
				                                                     && m.getAge() <= 45 
				                                                     && m.getGender().equals("M"));
		
		System.out.println("--------------------------------------------------------------------");
		
		manageMbr.printMemberWithConsumer(manageMbr.getMembers(), (m) -> m.getAge() >= 30 
				                                                     && m.getAge() <= 45 
				                                                     && m.getGender().equals("M"),m -> m.printPerson());
		
		System.out.println("--------------------------------------------------------------------");
		
		
		manageMbr.printMemberWithFunction(manageMbr.getMembers(), (m) -> m.getAge() >= 30 
				                                                     && m.getAge() <= 45 
				                                                     && m.getGender().equals("M"),
				                                                     m -> m.getFirstNm() + " " + m.getLastNm(),
				                                                     mbrName -> System.out.println(mbrName));
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Lambda with Streams");
		
		List<Member> mbrs = manageMbr.getMembers();
		
		mbrs.stream()                                // Stream gives Iterable Source from mbrs collection
		    .filter(m -> m.getAge() >= 30)          // Filter will apply predicate condition
		    .map(m -> m.getFirstNm() + " " + m.getLastNm()) //Map will collect or Consume predicate based output for given condition
			.forEach(name -> System.out.println(name));     // ForEach will perform given action in consumed objects
	}
	
	
	public void printMembers(List<Member> mbrs,CheckMember checkMbr){
		
		System.out.println("Printing Member based on Lambda Impl");
		for(Member mbr:mbrs){
			if(checkMbr.test(mbr)){
				mbr.printPerson();
			}
		}
	}
	
	public void printMembersWithPredciate(List<Member> mbrs,Predicate<Member> checkMbr){
		
		System.out.println("Printing Member based on Lambda Predicate Impl");
		for(Member mbr:mbrs){
			if(checkMbr.test(mbr)){
				mbr.printPerson();
			}
		}
	}
	
	public void printMemberWithConsumer(List<Member> mbrs,Predicate<Member> checkMbr,
			                            Consumer<Member> holder){
		System.out.println("Printing Member based on Lambda Consumer Impl");
		for(Member mbr:mbrs){
			if(checkMbr.test(mbr)){
				holder.accept(mbr);
			}
		}
	}
	
	
	public void printMemberWithFunction(List<Member> mbrs,
			                            Predicate<Member> checkMbr,
			                            Function<Member,String> mapper,
			                            Consumer<String> holder){
	
		System.out.println("Printing Member based on Lambda using Function and Consumer impl");
		
		for(Member mbr:mbrs){
			if(checkMbr.test(mbr)){
			 String data = mapper.apply(mbr);
			 holder.accept(data);
			}
		}
	}
	
	public <X,Y> void printMembersGenericLambda(Iterable<X> source,
			                                    Predicate<X> tester,
			                                    Function<X, Y> mapper,
			                                    Consumer<Y> holder){
		
		System.out.println("Printing Member based on Lambda using Generic Impl");
		for(X m: source){
			if(tester.test(m)){
				Y data = mapper.apply(m);
				holder.accept(data);
			}
		}
	}
	
	public List<Member> getMembers() {

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
