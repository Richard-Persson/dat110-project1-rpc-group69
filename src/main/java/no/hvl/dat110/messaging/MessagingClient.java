package no.hvl.dat110.messaging;


import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

import no.hvl.dat110.TODO;

public class MessagingClient {

	// name/IP address of the messaging server
	private String server;

	// server port on which the messaging server is listening
	private int port;
	
	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	// setup of a messaging connection to a messaging server
	public MessageConnection connect () throws IOException {

		// client-side socket for underlying TCP connection to messaging server
		Socket clientSocket;
		MessageConnection connection;


		
		// TODO - START
		// connect to messaging server using a TCP socket
		// create and return a corresponding messaging connection

		 clientSocket = new Socket(server,port);
		 connection = new MessageConnection(clientSocket);

		
		// TODO - END
		return connection;
	}
}
