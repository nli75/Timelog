package se.timelog.rmi;

import java.util.ArrayList;

import se.timelog.UserModel; // Change accordingly when real model is done
import se.timelog.ProjectModel;

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

	public ArrayList<String> projectCreate(ProjectModel projectModel) {

		ArrayList<String> errors = new ArrayList<String>();

		// Name
		if (projectModel.getName().length() == 0) {
			errors.add("Project name not set.");
		} else {
			if (projectModel.getName().length() < 4) {
				errors.add("Project name too short.");
			}
			if (!isAlphanumeric(projectModel.getName())) {
				errors.add("Project name contains illegal character(s).");
			}
		}

		// Budget
		if (projectModel.getBudget().length() == 0) {
			errors.add("Budget not set.");
		}
		
		// Estimated time
		if (projectModel.getEstimated_time().length() == 0) {
			errors.add("Estimated time not set.");
		}
		
		// Customer
		if (projectModel.getCustomer().length() == 0) {
			errors.add("Customer not set.");
		}
		
		return errors;
	}

	
	
	
	// other..
	private static boolean isAlphaSpace(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if ((Character.isLetter(str.charAt(i)) == false)
					&& (str.charAt(i) != ' ')) {
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
