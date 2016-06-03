package client;

import chatUtils.data.ChatMessage;
import chatUtils.data.Consts;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import utils.data.DataHandler;

/**
 *
 * @author Edoardo Zanoni<edoardo.zanoni@gmail.com>
 */
public class ClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
 
        InetSocketAddress crunchifyAddr = new InetSocketAddress(Consts.INETADDRESS, Consts.PORT);
        SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);

        log("Connecting to Server on port 1111...");

        ArrayList<String> companyDetails = new ArrayList<String>();

        // create a ArrayList with companyName list
        companyDetails.add("Facebook");
        companyDetails.add("Twitter");
        companyDetails.add("IBM");
        companyDetails.add("Google");
        companyDetails.add("Crunchify");

        ChatMessage chatMessage = new ChatMessage("Ryther");

        for (String companyName : companyDetails) {

            chatMessage.setMessage(companyName);
            chatMessage.setDateTime();
            ByteBuffer buffer = DataHandler.objectToByteBuffer(chatMessage);
            crunchifyClient.write(buffer);
            buffer.clear();
            
            log("sending: " + companyName);

            // wait for 2 seconds before sending next message
            Thread.sleep(2000);
        }
        
        crunchifyClient.close();
    }

    private static void log(String str) {
            System.out.println(str);
    }
}
