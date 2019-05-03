/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Richardyogi
 */
public class FXMLControllerServer implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextArea chatHistoryServer,textChatServer;
    @FXML
    private Button sendServer,connectServer,disconnectServer;
    
    public void disconnectButton() throws SocketException {
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.close();
    }
    
    public void receiveMessage() throws SocketException, IOException{
        DatagramSocket ds = new DatagramSocket(443);
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null; 
        while(true){
            DpReceive = new DatagramPacket(receive,receive.length);
            ds.receive(DpReceive);
            chatHistoryServer.setText("Client : " + data(receive));
            if(data(receive).toString().equals("bye")){
                System.out.println("Client sent bye");
                break;
            }
        }
        receive = new byte[443];
        
    }
    
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
