package fr.sywoo.ownserver.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class Reception implements Runnable {

	private BufferedReader in;
	private Socket socket;
	private String message;

	public Reception(BufferedReader in, Socket socket) {
		this.in = in;
		this.socket = socket;
	}

	@Override
	public void run() {
		boolean running = true;
		if (!socket.getRemoteSocketAddress().toString().split(":")[0].contains("127.0.0.1") && !socket.getRemoteSocketAddress().toString().split(":")[0].contains("91.175.145.129")
				&& !socket.getRemoteSocketAddress().toString().split(":")[0].contains("37.167.105.72")) {
			System.out.println("UN FDP A ESSAYER DE SE CO A VOS SOCKETS " + socket.getRemoteSocketAddress());
			return;
		}
		
		while (running) {
			try {
				message = in.readLine();
				if (message == null) {
					System.out.println("Le message Socket envoyer est null");
					return;
				}
				
				
				System.out.println("Message: " + message);


			} catch (IOException e) {
				running = false;
				e.printStackTrace();
				new IOException("THE SOCKET ARE CLOSED BEACAUSE " + e.getCause());
			}
		}
	}
}
