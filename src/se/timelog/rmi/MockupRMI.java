package se.timelog.rmi;

import java.util.ArrayList;

import se.timelog.User; // Change accordingly when real model is done

public class MockupRMI {

	public ArrayList<String> userCreate(User user) {
		
		ArrayList<String> errors = new ArrayList<String>();
		
		// E-mail
		if (user.email.length < 6) {
			errors.add("E-mail address too short.");
		}
		if (!user.email.contains("@")) {
			errors.add("E-mail address not correct.");
		}
		
		// First name
		if (user.firstName.length < 6) {
			errors.add("First name too short.");
		}
		if (!isAlphaSpace(user.firstName)) {
			errors.add("First name contains illegal character(s).");
		}
		
		// Last name
		if (user.lastName.length < 6) {
			errors.add("Last name too short.");
		}
		if (!isAlphaSpace(user.lastName)) {
			errors.add("Last name contains illegal character(s).");
		}
		
		// Password
		if (user.password.length < 6) {
			errors.add("Password too short.");			
		}
		if (!isAlphanumeric(user.password)) {
			errors.add("Password contains illegal character(s).");
		}
		
		return errors;
	}
	
	private static boolean isAlphaSpace(String str) {
	      if (str == null) {
	          return false;
	      }
	      int sz = str.length();
	      for (int i = 0; i < sz; i++) {
	          if ((Character.isLetter(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
	              return false;
	          }
	      }
	      return true;
	}
	
	private static boolean isAlphanumeric(String str) {
	      if (str == null) {
	          return false;
	      }
	      int sz = str.length();
	      for (int i = 0; i < sz; i++) {
	          if (Character.isLetterOrDigit(str.charAt(i)) == false) {
	              return false;
	          }
	      }
	      return true;
	  }
}
