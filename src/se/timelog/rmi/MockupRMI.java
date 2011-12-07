package se.timelog.rmi;

import java.util.ArrayList;

import se.kyh.ad10.timeloggers.server.entities.Customer;
import se.kyh.ad10.timeloggers.server.entities.Timelog;
import se.kyh.ad10.timeloggers.server.entities.User;
import se.kyh.ad10.timeloggers.server.entities.Role;
import se.kyh.ad10.timeloggers.server.entities.Project;;

public class MockupRMI {

	//login start
	public boolean login(User user){
		String email = user.getEmail();
		String password = user.getPassword();
		if(email.equals("Kalle") && password.equals("apa")){
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
	public ArrayList<String> userCreate(User user) {

		ArrayList<String> errorList = new ArrayList<String>();

		// E-mail
		if (user.getEmail().length() == 0) {
			errorList.add("E-mail not set.");
		} else {
			if (user.getEmail().length() < 6) {
				errorList.add("E-mail address too short.");
			}
			if (!user.getEmail().contains("@")) {
				errorList.add("E-mail address not correct.");
			}
		}

		// First name
		if (user.getFirstName().length() == 0) {
			errorList.add("First name not set.");
		} else {
			if (user.getFirstName().length() < 6) {
				errorList.add("First name too short.");
			}
			if (!isAlphaSpace(user.getFirstName())) {
				errorList.add("First name contains illegal character(s).");
			}
		}

		// Last name
		if (user.getLastName().length() == 0) {
			errorList.add("Last name not set.");
		} else {
			if (user.getLastName().length() < 6) {
				errorList.add("Last name too short.");
			}
			if (!isAlphaSpace(user.getLastName())) {
				errorList.add("Last name contains illegal character(s).");
			}
		}

		// Password
		if (user.getPassword().length() == 0) {
			errorList.add("Password not set.");
		} else {
			if (user.getPassword().length() < 6) {
				errorList.add("Password too short.");
			}
			if (!isAlphanumeric(user.getPassword())) {
				errorList.add("Password contains illegal character(s).");
			}
		}

		return errorList;
	}

	public ArrayList<String> projectCreate(Project project) {

		ArrayList<String> errorList = new ArrayList<String>();

		// Name
		if (project.getName().isEmpty() || project.getName().length() == 0) {
			errorList.add("ProjectPage name not set.");
		} else {
			if (project.getName().length() < 6) {
				errorList.add("ProjectPage name too short.");
			}
			if (!isAlphanumeric(project.getName())) {
				errorList.add("ProjectPage name contains illegal character(s).");
			}
		}
		
		return errorList;
	}

	public ArrayList<String> customerCreate(Customer customer) {
		ArrayList<String> errorList = new ArrayList<String>();
		// Name
		if (customer.getName().length() == 0) {
			errorList.add("Name not set.");
		} else {
			if (customer.getName().length() < 6) {
				errorList.add("Name too short.");
			}
			if (!isAlphaSpace(customer.getName())) {
				errorList.add("Name contains illegal character(s).");
			}
		}
		return errorList;
	}

	public ArrayList<String> roleCreate(Role role) {
		ArrayList<String> errorList = new ArrayList<String>();
		// Name
		if (role.getName().length() == 0) {
			errorList.add("Name not set.");
		} else {
			if (role.getName().length() < 6) {
				errorList.add("Name too short.");
			}
			if (!isAlphaSpace(role.getName())) {
				errorList.add("Name contains illegal character(s).");
			}
		}
		return errorList;
	}
	
	public ArrayList<String> timelogCreate(Timelog timelog) {
		ArrayList<String> errorList = new ArrayList<String>();
		// Name
		if (timelog.getTitle().length() == 0) {
			errorList.add("Title not set.");
		} else {
			if (timelog.getTitle().length() < 6) {
				errorList.add("Title too short.");
			}
			if (!isAlphaSpace(timelog.getTitle())) {
				errorList.add("Title contains illegal character(s).");
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
