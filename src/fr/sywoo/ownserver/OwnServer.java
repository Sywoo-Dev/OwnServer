package fr.sywoo.ownserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import fr.sywoo.ownserver.sockets.Connection;

public class OwnServer {
	
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
    public static ServerSocket serverSocket;

	public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(120);
            System.out.println("Port de Socket : " + 120);
            Thread thread = new Thread(new Connection(serverSocket));
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}