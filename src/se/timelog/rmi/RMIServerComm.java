package se.timelog.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.UUID;

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

}