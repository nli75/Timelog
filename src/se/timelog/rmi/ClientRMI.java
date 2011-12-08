package se.timelog.rmi;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import se.kyh.ad10.timeloggers.server.entities.Project;
import se.kyh.ad10.timeloggersPublic.server.PublicInterface;
import se.kyh.ad10.timeloggersPublic.server.SecurityLayer;



public class ClientRMI {

	private static SecurityLayer serverObj = null; 
	private static PublicInterface pii = null;
	
	//ska detta vara main?
	public static void main(String args[]) throws IOException, NotBoundException  {
		// Get instance of SecurityLayer implementation
		serverObj = (SecurityLayer)Naming.lookup("//localhost/"+SecurityLayer.name); 

		try {
			// Create and install a security manager
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			// To get access to PublicInterface we need to use/get an UUID
			UUID uuid = serverObj.createSession();
			 pii = serverObj.getPublicInterface(uuid);


		} catch (IOException e) {
			e.printStackTrace();
		}


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
		// Save
		if(pii.getProjectDAO().saveProject(project)){				
			
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