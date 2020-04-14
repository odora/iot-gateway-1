package neu.manikkumar.connecteddevices.project;
import java.net.SocketException;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.server.resources.CoapExchange;

import neu.manikkumar.connecteddevices.project.TempSensorDataHandler;

/**
 * CoAPServer
 */
public class CoAPServer extends CoapServer {
    /**
     * CoAPServer
     * Class responsible for creating and running the CoAP server
     */
    CoapServer coapServer;
    TempSensorDataHandler tempResourceHandler;

    public CoAPServer() throws SocketException {
        /*
         Constructor
         */

        this.coapServer = new CoapServer();
        //Adding resource to the server
        this.tempResourceHandler = new TempSensorDataHandler("SPO2");
        this.coapServer.add(this.tempResourceHandler);
    }

    public Boolean serverStarter() throws SocketException{
        //Starting the server
        coapServer.start();
        return true;
    }

    
}