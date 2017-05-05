package ocsf;

import java.io.IOException;
import java.util.Scanner;

import com.lloseng.ocsf.client.ObservableClient;

/**
 * Using Object Client Server Framework to connect client and server.
 * 
 * @author Noppawan Kulchol
 *
 */
public class Client extends ObservableClient {

	/**
	 * Set the address and port of the server to connect to.
	 * 
	 * @param host
	 *            IP server's address
	 * @param port
	 *            5001
	 */
	public Client(String host, int port) {
		super(host, port);
	}

	/**
	 * Client invoked this method when client receives a message from server.
	 */
	@Override
	protected void handleMessageFromServer(Object message) {
		System.out.println(message);
	}

	/**
	 * Connected the client and server by calling openConnection().
	 */
	public void run() {
		try {
			openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Running connected client and server, when I use run() client can sent the
	 * message to the server then close.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client("10.2.12.83", 5001);
		Scanner scanner = new Scanner(System.in);
		client.run();
		try {
			while (client.isConnected()) {
				client.sendToServer(scanner.nextLine());
			}
			client.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
