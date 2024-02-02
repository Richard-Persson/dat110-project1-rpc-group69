package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		
		// TODO - START

		// implement marshalling, call and unmarshalling for write RPC method
		byte[] msg  = RPCUtils.marshallString(message);

		byte[] response = rpcclient.call((byte) Common.WRITE_RPCID,msg);

		RPCUtils.unmarshallVoid(response);
		
		// TODO - END
		
	}
}
