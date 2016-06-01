package client;

import chatUtils.data.ChatMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 *
 * @author Edoardo Zanoni<edoardo.zanoni@gmail.com>
 */
public class ClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
 
        InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1111);
        SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);

        log("Connecting to Server on port 1111...");

        ArrayList<String> companyDetails = new ArrayList<String>();

        // create a ArrayList with companyName list
        companyDetails.add("Facebook");
        companyDetails.add("Twitter");
        companyDetails.add("IBM");
        companyDetails.add("Google");
        companyDetails.add("Crunchify");

        ChatMessage chatMessage = new ChatMessage("test");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Channels.newOutputStream(crunchifyClient));
        for (String companyName : companyDetails) {

            chatMessage.setMessage(companyName);
            chatMessage.setDateTime();
            byte[] message;
//            Integer messageBufferSize = chatMessage.toString().getBytes().length;
//            byte[] messageLength = messageBufferSize.toString().getBytes();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutput oOut = null;
            try {
                oOut = new ObjectOutputStream(baos);
                oOut.writeObject(chatMessage);
                message = baos.toByteArray();
            } finally {
                oOut.close();
                baos.close();
            }
//            byte[] message = chatMessage.toString().getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            crunchifyClient.write(buffer);
//            buffer = ByteBuffer.wrap(message);
//            crunchifyClient.write(buffer);
            
            
//            messageBufferSize = chatMessage.getMessage().getBytes().length;
//            messageLength = messageBufferSize.toString().getBytes();
//            message = chatMessage.getMessage().getBytes();
//            buffer = ByteBuffer.wrap(messageLength);
//            crunchifyClient.write(buffer);
//            buffer = ByteBuffer.wrap(message);
//            crunchifyClient.write(buffer);
//            
//            
//            messageBufferSize = chatMessage.getDateTime().getBytes().length;
//            messageLength = messageBufferSize.toString().getBytes();
//            message = chatMessage.getDateTime().getBytes();
//            buffer = ByteBuffer.wrap(messageLength);
//            crunchifyClient.write(buffer);
//            buffer = ByteBuffer.wrap(message);
//            crunchifyClient.write(buffer);
//            objectOutputStream.writeObject(chatMessage);
            
            log("sending: " + companyName);
            buffer.clear();

            // wait for 2 seconds before sending next message
            Thread.sleep(2000);
        }
        
//        byte[] message = "Crunchify".getBytes();
//        ByteBuffer buffer = ByteBuffer.wrap(message);
//        crunchifyClient.write(buffer);
        crunchifyClient.close();
    }

    private static void log(String str) {
            System.out.println(str);
    }
}
