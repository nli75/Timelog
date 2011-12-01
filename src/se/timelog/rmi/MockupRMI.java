package se.timelog.rmi;

import java.util.ArrayList;

import se.timelog.UserModel; // Change accordingly when real model is done

public class MockupRMI {

	public ArrayList<String> userCreate(UserModel userModel) {
		
		ArrayList<String> errors = new ArrayList<String>();
		
		// E-mail
		if (userModel.getEmail().length() == 0) {
			errors.add("E-mail not set.");
		} else {
			if (userModel.getEmail().length() < 6) {
				errors.add("E-mail address too short.");
			}
			if (!userModel.getEmail().contains("@")) {
				errors.add("E-mail address not correct.");
			}
		}
		
		// First name
		if (userModel.getFirstName().length() == 0) {
			errors.add("First name not set.");
		} else {
			if (userModel.getFirstName().length() < 6) {
				errors.add("First name too short.");
			}
			if (!isAlphaSpace(userModel.getFirstName())) {
				errors.add("First name contains illegal character(s).");
			}
		}
		
		// Last name
		if (userModel.getLastName().length() == 0) {
			errors.add("Last name not set.");
		} else {
			if (userModel.getLastName().length() < 6) {
				errors.add("Last name too short.");
			}
			if (!isAlphaSpace(userModel.getLastName())) {
				errors.add("Last name contains illegal character(s).");
			}
		}
		
		// Password
		if (userModel.getPassword().length() == 0) {
			errors.add("Password not set.");
		} else {
			if (userModel.getPassword().length() < 6) {
				errors.add("Password too short.");			
			}
			if (!isAlphanumeric(userModel.getPassword())) {
				errors.add("Password contains illegal character(s).");
			}
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
