package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[128];
		byte[] data = message.getData();
		int length = message.getData().length;
		
		// TODO - START
		for(int i = 0; i<data.length; i++)
			segment[i + 1] = data[i];


		segment[0] = (byte) length;
			
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		byte[] messageByte = new byte[segment[0]];
		
		// TODO - START
		// decapsulate segment and put received payload data into a message
		
	for(byte b = 0; b<segment[0]; b++)
		messageByte[b] = segment[b+1];

	message = new Message(messageByte);
		// TODO - END
		
		return message;
		
	}
	
}
