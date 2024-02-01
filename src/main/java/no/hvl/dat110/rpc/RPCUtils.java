package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		// TODO - START
		// Allocating space in buffer //
		ByteBuffer buffer = ByteBuffer.allocate(payload.length+1);
		//Pack it in
		buffer.put(rpcid);
		buffer.put(payload);
		// TODO - END
		
		return buffer.array();
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		int plength = rpcmsg.length - 1;
		byte[] payload = new byte[plength >= 1 ? plength : 0];


		// TODO - START
		if (plength >= 1) {
			ByteBuffer buffer = ByteBuffer.wrap(rpcmsg);
			// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
			byte rpcid = buffer.get();
			payload = new byte[buffer.remaining()];
			buffer.get(payload);
			// TODO - END
		}

		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START 

		try{
			//Spesifiserer charset til UTF-8
			encoded = str.getBytes("UTF-8");
		} catch (UnsupportedOperationException e){
			System.out.println(e);
		} finally {


			// TODO - END

			return encoded;
		}
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 

		if (data != null) {
			decoded = new String(data, java.nio.charset.StandardCharsets.UTF_8);
		}
		
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		return new byte[0];
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		encoded[0] = (byte) (b ? 1 : 0);
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES); // BYTES er 4 av default grunn
		buffer.putInt(x);
		return buffer.array();
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		ByteBuffer buffer = ByteBuffer.wrap(data);
		return buffer.getInt();
		
	}
}
