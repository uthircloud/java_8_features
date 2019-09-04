# Lambda Expressions

Lambda expressions is implementation of a functional interface. A functional interface is an interface with only one abstract method (but it can have more than one default methods) which is introduced in Java 8.

* It will enable to pass a functionality as a method argument (we can call this as code as data).  
  
* Enable to create a function without belonging to any class.  
    
* Lambda expression can be passed around as if it was an object and executed on demand.  
    

## Syntax

Lambda expression consist of three parts.

 * A parentheses part () which holds a comma separated parameters or it can be empty.
  
    If a lambda expression has more than one parameter it will be represented with comma separated.
    
    If only one parameter parentheses is optional.
    
    Also it can be empty parentheses when no argument method expression.
    
    (a,b) -> a + b  
    a -> System.out.println(a)  
    ()-> "Return this string"   
     
 * An arrow token <b> -> </b>  
 
 
 * A body which is single expression or statement block  
    
    If you specify single expression Java runtime evaluates the expression and return its value.
    
     (a,b) -> a+b
     
     Alternately you can use return statement as well.
     
      a -> { a.equals("Test") 
             && a.length == 4
           }
     
     When specifying statement in lambda body it should be enclosed by  parentheses. But expressions need not be in 
     parentheses.
     
     a -> a.equals("Test") && a.length == 4  // This is expression   
     a -> { return a.equals("Test") && a.length == 4} // As return is statement it should be specified in parentheses.
     
     In Lambda expression void method invocations do not need to be enclosed in parentheses.
     
     a -> System.out.println(a); 
     
## Power of Lambda

  Consider a Member Search use case where you have to search or filter members based on different criteria.
  
    public class Member {
		private String firstNm;
		private String lastNm;
		private String gender; 
	    private int age;
    
    //Respective getters and Setters
    }
 
  * Find members who's age is greater than 25.
  
  **Approach-1: We can implement this in a conventional way like below.**  
  
  **Ref:** **MemberManager.java**
     
    public void printMemberOlderThanByAge(List<Member> mbrs,int age) {
		 for(Member mbr:mbrs) {
			 if(mbr.getAge() >= 25) {
				 mbr.printPerson();
			 }
		 }
	}  

  In this approach main draw back is when search criteria changes we need to make code change.
  
 **Approach-2: Create new generalized search method to handle age range search.**  
 
 **Ref:** **MemberManager.java**  

  Let's consider if want to fetch members based on certain age range like members age of greater than 25 and age less than 40.So to achieve this
  we need to create another method or change existing logic.  
  
    public void printMembersByAgeRange(List<Member> mbrs,int min,int max) {
         System.out.println("Display Members based on Age Range ie Ages between"+min+"and"+max);		 
		 for(Member mbr:mbrs) {
			 if(mbr.getAge()>= min && mbr.getAge()<=max) {
				 mbr.printPerson();
			 }
		 }
	 }  
	 
  In this approach also we have some draw back when there is a change in search criteria other than age also
  if there is a change in Member object when few more attribute is added like location.
  
 **Approach-3: Implement Search criteria in separate Local Class and invoke it by interface.**  
   
   **Ref:** **ManageMemberLocalClass.java**
  
  Let's say if we want to filter member based on age and gender. This will lead to introduction of new method.
  To avoid this we can separate search criteria to a separate class.
  
  This method will filter member based on criteria which is defined in separate class.
  
    public void printMembers(List<Member> mbrs,CheckMember checkMbr) {
		
		for(Member mbr:mbrs) {
			if(checkMbr.test(mbr)) {
				mbr.printPerson();
			}
		}
     } 
     
   Here **CheckMember** interface provide test method which return a boolen value.   
   
    public interface CheckMember {
	   boolean test(Member mbr);
    }
    
   **CheckMemberEligibleForPrint** class implement this interface and actual search criteria logic.
   
    public class CheckMemberEligibleForPrint implements CheckMember{
	@Override
	public boolean test(Member mbr) {
		
		if(mbr.getAge()>=30 && mbr.getAge() <=45
				&& mbr.getGender().equals("M")) {
			return true;
		}
		return false;
	 }
    }
   
   This approach is more cleaner compared to previous two approaches. But we may need to create more class and interfaces
   when new search criteria is needed.
   
   We can avoid creation of new class for different search criteria by implementing this using Anonymous class. 
   
   **Anonymous class is a inner class with no name. It can implement an interface or extend a class.**
   
  **Approach-4: Implement Search criteria in Anonymous class and invoke it by interface.**
   
   **Ref:** **ManageMbrAnonymousClass.java**  
   
   We can implement above search logic using Anonymous class by which we can eliminate need of interface.
    
    pirntMembers(mangerMember.getMembers(), new CheckMember() {
			
			@Override
			public boolean test(Member mbr) {
				
				if(mbr.getAge()>=30 && mbr.getAge() <=45
						&& mbr.getGender().equals("M")) {
					return true;
				}
				return false;
			}
		});
	} 
   
   Here mangerMember.getMembers() will give list of members.This approach will reduce amount of code required as we are not using interface. But anonymous class code syntax is bulky.
   
   As Lambda expression is implementation of functional interface in our case **CheckMember** interface is having only one abstract method (its a functional interface) we can implement this logic using Lambda expression.
   
  **Approach-5: Implement Search criteria as Lambda expression.**  
   
   **Ref:** **ManageMemberLambda.java**  
   
   We can implement lambda expression for the search criteria as below.Here we are using lambda expression to pass a parameter. This parameter is nothing but a function(Code as Data) which provide filter/search criteria. 
   
    printMembers(manageMbr.getMembers(), (Member m) -> m.getAge() >= 30 && m.getAge() <=45 
				                                                       && m.getGender().equals("M"));
				                                                       
    
    public void printMembers(List<Member> mbrs,CheckMember checkMbr) {
		System.out.println("Printing Member based on Lambda Impl");
		for(Member mbr:mbrs) {
			  if(checkMbr.test(mbr)) {
				  mbr.printPerson();
			  }
		  }
	}  
	
  **Approach-6: Use of JDK standard interface with Lambda expression.**  
   
   JDK has several standard functional interfaces already defined which can be used for our program anywhere.
   which you can find in the package **java.util.function**. 
   
   We can also change our **CheckMember** interface with JDK's one. JDK has an interface called Predicate<T> which define a boolen test method.
   
      interface Predicate<T> {
       boolean test(T t);
      }  
      
   If we use **Predicate** interface we don't need to define it JDK will automatically interpret this definition and execute lamda.So we can define our **printMembers** method like below.
   
    printMembrsWithPrdicate(manageMbr.getMembers(), (Member m) -> m.getAge() >= 30 && m.getAge() <=45 
				                                                       && m.getGender().equals("M"));
   
     printMembrsWithPrdicate(List<Member> mbrs,Predicate<Member> checkMbr) {
		System.out.println("Printing Member based on Lambda Predicate Impl");
		for(Member mbr:mbrs) {
			if(checkMbr.test(mbr)) {
				mbr.printPerson();
			}
		}
	  }
	  
 **Approach-6: Explore other JDK standard interface with Lambda expression.**  
  
  We have many already predefined functional interfaces. **Consumer<T>** will accept a value and return nothing.
  This can be used when we want to pass an argument with no return type.
  
  Let's  re-write **printMembrsWithPrdicate** lambda using **Consumer<T>**. In this example m.printPerson() method will
  accept an argument but return no value.It's equivalent interface is **Consumer<T>**.
  
    printMemberWithConsumer(manageMbr.getMembers(), 
                           (Member m) -> m.getAge() >= 30 && m.getAge() <=45 
				             && m.getGender().equals("M"),m -> m.printPerson());
				          
	
	 public void printMemberWithConsumer(List<Member> mbrs,
	                                     Predicate<Member> checkMbr,
	                                     Consumer<Member> holder)
	{
     System.out.println("Printing Member based on Lambda Consumer Impl");
		for(Member mbr:mbrs) {
			if(checkMbr.test(mbr)) {
				holder.accept(mbr);
			}
		}
	}
  
  There is Function<T,R> interface which accept an argument and return a value. This is useful when we want to operate on a data and return a value.
  
  Consider use case we need to find a member who's age is greater than 30 and print the combination of their First Name and Last Name as a single string. This can be done like below. 
  
    printMemberWithFunction(manageMbr.getMembers(),                    //Member List
				             (Member m) -> m.getAge() >= 30,             //Predicate<T> Check Condition  
				              m -> m.getFirstNm()+ " " + m.getLastNm(),  //Function<T,R> Combine FN/LN and return a string
				              mbrname -> System.out.println(mbrname));   //Consumer<T> will accept that string
				              
				              
    public void printMemberWithFunction(List<Member> mbrs,
			                            Predicate<Member> checkMbr,
			                            Function<Member, String> mapper,
			                            Consumer<String> holder) {
		System.out.println("Printing Member based on Lambda using Function and Consumer Impl");
		
		for(Member mbr:mbrs) {
			if(checkMbr.test(mbr)) {
				String data = mapper.apply(mbr);
				holder.accept(data);
			}
		}
	}

  **Approach-7: Generics magic with Lambda.**  
   
   In the above example we are using Functional interfaces with defined type params like **Predicate<Member>**.Let's change this with Generics will make things more powerful.
   
    public <X, Y> void printMembersGenericLambda(Iterable<X> source, Predicate<X> tester, 
			                                      Function<X, Y> mapper,Consumer<Y> holder) {
		System.out.println("Printing Member based on Lambda using Generic Impl");
		for (X m : source) {
			if (tester.test(m)) {
				Y data = mapper.apply(m);
				holder.accept(data);
			}
		}
	}
   
   With this we can use this method for any kind of use cases where we have a collection of data and want to filter that data based on certain condition and display the result.
   
  **References:**
  	  
 [Lambda Oracle Documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
  
