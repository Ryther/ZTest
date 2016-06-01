package data;

import chatUtils.data.ChatMessage;
import java.nio.channels.SelectionKey;

/**
 *
 * @author Edoardo Zanoni
 */
public class KeyManager {
    
    private SelectionKey selectionKey;
    private ChatMessage chatMessage;

    public KeyManager(SelectionKey selectionKey) {
        
        this.selectionKey = selectionKey;
    }
    
    
}
