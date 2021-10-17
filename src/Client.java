import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/***********************************************************************************************************************
 * Client.java: Each user who has the app open also has a Client object that communicates with the Server class.
 * Establishes an output and input stream with the server, handling requests and monitoring changes for real-time
 * updates.
 *
 * @author Charles Graham, Nathan Yao
 * @version Aug 1, 2021
 **********************************************************************************************************************/

public class Client {
	private final static int PORT = 31415; //pi port number
	private final static String HOST = "localhost";

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	private static boolean serverConIssue = false;
	private static int outputtedError = 0;

	public Client() {
		try {
			//for each client, instantiate a Client object
			Socket socket = new Socket(HOST, PORT);

			this.oos = new ObjectOutputStream(socket.getOutputStream());
			this.ois = new ObjectInputStream(socket.getInputStream());

		} catch (Exception e) {
			if (outputtedError == 0) {
				String msg = "Client has refused to connect!\n\n" +
						"Has an instance of Server.java been run at " + HOST + ":" + PORT + "?";
				JOptionPane optionPane = new JOptionPane(msg, JOptionPane.INFORMATION_MESSAGE);    
				JDialog dialog = optionPane.createDialog("A Problem Occurred");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);

				serverConIssue = true;
				outputtedError = 1;
			}
			//e.printStackTrace();
		}
	}
	
	//Returns true if there was some exception in connecting to the server
	public boolean serverStatus() {
		return serverConIssue;
	}
	
	//For update thread exclusively
	public String getUpdate() throws ClassNotFoundException, IOException {
		return ois.readObject().toString();
	}
	
	public String streamReader(String request) {
		String returnedValue = "";
		try {
			oos.writeObject(request);
			oos.flush();
			returnedValue = "" + ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Client streamReader cannot connect to the server!");
			e.printStackTrace();
		}

		return returnedValue;
	}

	public void end() {
		try {
			oos.close();
			ois.close();
			System.out.println("A user has ended the program.");
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
}
