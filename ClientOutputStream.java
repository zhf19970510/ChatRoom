package com.iotec.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created on 2019/10/17 0017.
 */
public class ClientOutputStream implements Runnable{
    private Socket socket = null;

    public ClientOutputStream(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            while (true){
               String line = br.readLine();
               pw.println(line);
               if(line.equals("bye")){
                   break;
               }
            }
            br.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
