package de.gernotpointner.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DummyWebserverMain {

    public static void main(String[] args) {
        while(true){
            Socket s;
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                s = serverSocket.accept();
                String payload = new String(s.getInputStream().readAllBytes());
                System.out.println(payload);
            } catch (IOException e){
                System.err.println(e);
            }
        }
    }
}
