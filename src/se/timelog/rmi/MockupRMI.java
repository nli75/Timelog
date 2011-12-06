package se.timelog.rmi;

import java.util.ArrayList;

import se.timelog.CustomerModel;
import se.timelog.UserModel; // Change accordingly when real model is done
import se.timelog.ProjectModel;

public class MockupRMI {

	//login start
	public boolean login(UserModel userModel){
		String username = userModel.getEmail();
		String password = userModel.getPassword();
		if(username.equals("Kalle") && password.equals("apa")){
			return true;
			//send username, password to RMI-model
			//get session object? or true?
		}		
		return false;
	}
	
	public boolean logout(){
		//destroy session
		//send false to RMI-model
		return true;
	}
	//login end
	
	//create user start
	public ArrayList<String> userCreate(UserModel userModel) {

		ArrayList<String> errorList = new ArrayList<String>();

		// E-mail
		if (userModel.getEmail().length() == 0) {
			errorList.add("E-mail not set.");
		} else {
			if (userModel.getEmail().length() < 6) {
				errorList.add("E-mail address too short.");
			}
			if (!userModel.getEmail().contains("@")) {
				errorList.add("E-mail address not correct.");
			}
		}

		// First name
		if (userModel.getFirstName().length() == 0) {
			errorList.add("First name not set.");
		} else {
			if (userModel.getFirstName().length() < 6) {
				errorList.add("First name too short.");
			}
			if (!isAlphaSpace(userModel.getFirstName())) {
				errorList.add("First name contains illegal character(s).");
			}
		}

		// Last name
		if (userModel.getLastName().length() == 0) {
			errorList.add("Last name not set.");
		} else {
			if (userModel.getLastName().length() < 6) {
				errorList.add("Last name too short.");
			}
			if (!isAlphaSpace(userModel.getLastName())) {
				errorList.add("Last name contains illegal character(s).");
			}
		}

		// Password
		if (userModel.getPassword().length() == 0) {
			errorList.add("Password not set.");
		} else {
			if (userModel.getPassword().length() < 6) {
				errorList.add("Password too short.");
			}
			if (!isAlphanumeric(userModel.getPassword())) {
				errorList.add("Password contains illegal character(s).");
			}
		}

		return errorList;
	}

	public ArrayList<String> projectCreate(ProjectModel projectModel) {

		ArrayList<String> errorList = new ArrayList<String>();

		// Name
		if (projectModel.getName().length() == 0) {
			errorList.add("Project name not set.");
		} else {
			if (projectModel.getName().length() < 4) {
				errorList.add("Project name too short.");
			}
			if (!isAlphanumeric(projectModel.getName())) {
				errorList.add("Project name contains illegal character(s).");
			}
		}

		// Budget
		if (projectModel.getBudget().length() == 0) {
			errorList.add("Budget not set.");
		}
		
		// Estimated time
		if (projectModel.getEstimated_time().length() == 0) {
			errorList.add("Estimated time not set.");
		}
		
		// Customer
		if (projectModel.getCustomer().length() == 0) {
			errorList.add("Customer not set.");
		}
		
		return errorList;
	}

	public ArrayList<String> customerCreate(CustomerModel customerModel) {
		ArrayList<String> errorList = new ArrayList<String>();
		// Name
		if (customerModel.getName().length() == 0) {
			errorList.add("Name not set.");
		} else {
			if (customerModel.getName().length() < 6) {
				errorList.add("Name too short.");
			}
			if (!isAlphaSpace(customerModel.getName())) {
				errorList.add("Name contains illegal character(s).");
			}
		}
		return errorList;
	}
	
	// control methods
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
