package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;

import java.io.IOException;


public class DisplayDevice {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Display server starting ...");
		
		// TODO - START
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice

		RPCServer displayserver = new RPCServer(Common.DISPLAYPORT);
		DisplayImpl display = new DisplayImpl((byte)Common.READ_RPCID,displayserver);
		displayserver.run();
		displayserver.stop();
		
		// TODO - END
		
		System.out.println("Display server stopping ...");
		
	}
}
