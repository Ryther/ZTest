
import chatUtils.data.ChatMessage;

/**
 *
 * @author Edoardo Zanoni
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ChatMessage chatMessage = new ChatMessage("sdfgzxdszdfgzdfgzdfgzdgzdfgfghsdhszhsfgsdfg");
        chatMessage.setDateTime();
        chatMessage.setMessage("Prova di lunghezza del messaggio, purtroppo c'è un problema con la lunghezza variabile in user e chat");
        Integer testBytes = chatMessage.getDateTime().getBytes().length;
        System.out.println(testBytes);
        testBytes = chatMessage.getUsername().getBytes().length;
        System.out.println(testBytes);
        testBytes = chatMessage.getMessage().getBytes().length;
        System.out.println(testBytes);
    }
    
}
