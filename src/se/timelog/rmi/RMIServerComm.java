package se.timelog.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.UUID;

import se.kyh.ad10.timeloggers.server.entities.Project;
import se.kyh.ad10.timeloggersPublic.server.PublicInterface;
import se.kyh.ad10.timeloggersPublic.server.SecurityLayer;

public class RMIServerComm {

	private static RMIServerComm rmiServerComm = null;

	private SecurityLayer securityLayer = null;

	private UUID sessionId;

	private RMIServerComm() throws RemoteException {
		connect();
	}

	private void connect() throws RemoteException {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			securityLayer = (SecurityLayer) registry.lookup(SecurityLayer.name); //Waiting for updated SecurityLayer class from theTimeloggers
			sessionId = securityLayer.createSession();
		} catch (NotBoundException e) {
			throw new RemoteException("", e);
		}
	}
	
	
	public PublicInterface getPublicInterface() throws RemoteException {
		PublicInterface publicInterface = null;
		try {
			publicInterface = securityLayer.getPublicInterface(sessionId);
		} catch (RemoteException e) {
			e.printStackTrace();
			connect(); // FIXME: refactor: try one more time, but better
			publicInterface = securityLayer.getPublicInterface(sessionId);
		}
		return publicInterface;
	}

	public static RMIServerComm get() throws RemoteException {
		if (null == rmiServerComm) {
			rmiServerComm = new RMIServerComm();
		}
		return rmiServerComm;
	}
/*
 * Start calling DAO's here
 */
	
	//Use this to get a serverconnection thru the interface in every funciton, get uuid, saved in our sesson. Can do this once and save in a variable.
	//RMIServerComm.get().getPublicInterface(sessionId).
	//Save session/uuid in session, and use when calling server everytime
	//SOMETHING LIKE THIS... modify
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
		
		if(RMIServerComm.get().getPublicInterface(/*sessionid*/).getProjectDAO().saveProject(project)){				
			
		}
		return errorList;		
		
	}
	//calling DAO's end
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

