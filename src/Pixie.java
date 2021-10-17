import javax.swing.SwingUtilities;

/***********************************************************************************************************************
 * Pixie.java - Course Final Project: (removed all references to course and performed modifications to make project
 * public) Apparently our app is branded as "Pixie" for some reason (pixes are mythical creatures in folklore and
 * children's stories). Pixie.java calls PixieThread and acts as the launcher for the app. Analyses server status to
 * provide a real-time updates.
 *
 * @author Nathan Yao, Charles Graham
 * @version Oct 17, 2021
 **********************************************************************************************************************/

public class Pixie implements Runnable {
	private final Client updateClient = new Client();
	private static PixieThread pixieApp;

	public Pixie() {
		pixieApp = new PixieThread();
		SwingUtilities.invokeLater(pixieApp);
	}

	@Override
	public void run() {
		if (updateClient.serverStatus()) {
    		//stops thread execution
    		return;
    	}
		
		//configure the server thread for this object appropriately
		updateClient.streamReader("updateStream");
		
		while (true) {
			//wait for new update requests
			try {
				//refreshing page
				updateClient.getUpdate();
				pixieApp.refreshPage();
				Thread.sleep(1);
			} catch (Exception e) {
				System.out.println("Refreshing system failed");
				return;
			}
		}
	}

	public static void main(String[] args) {
		//run application on event dispatch thread (EDT)
		Pixie app = new Pixie();
		new Thread(app).start();
	}
}
