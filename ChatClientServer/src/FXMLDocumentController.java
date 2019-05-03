/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author Richardyogi
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea chatHistoryClient,textChatClient;
    @FXML
    private Button sendClient,connectClient,disconnectClient;
    
    public void disconnectButton() throws SocketException {
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.close();
    }
    
    public void sendChat() throws SocketException, UnknownHostException, IOException{
        DatagramSocket ds = new DatagramSocket();
        
        InetAddress ip = InetAddress.getLocalHost();
        byte[] buf = null;
        
        while(true){
            String chat = textChatClient.getText();
            buf = chat.getBytes();
            
            DatagramPacket DpSend = new DatagramPacket(buf,buf.length,ip,443);
            ds.send(DpSend);
            
            if(chat.equals("bye")){
                break;
            }
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
