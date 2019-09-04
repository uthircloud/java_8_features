/**
 * 
 */
package com.learnjava.lab.lambda;

import com.learnjava.lab.lambda.intf.CheckMember;
import com.learnjava.lab.lambda.model.Member;

/**
 * @author UthirNew
 *
 */
public class CheckMemberEligibilbleForPrint implements CheckMember {

	@Override
	public boolean test(Member mbr) {
		
		if(mbr.getAge() >= 30 
				&& mbr.getAge() <=45
				&& mbr.getGender().equals("M")){
			return true;
		}
		return false;
	}

	

}
