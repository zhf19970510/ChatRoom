package com.iotec.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created on 2019/10/17 0017.
 */
public class ClientInputStream implements Runnable{
    private Socket socket = null;

    public ClientInputStream(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                try {
                    String line = br.readLine();
                    System.out.println(line);
                } catch (IOException e) {
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
