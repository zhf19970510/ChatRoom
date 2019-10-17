package com.iotec.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created on 2019/10/17 0017.
 */
public class ServerStream implements Runnable {
    private Socket socket = null;
    private int number;

    public ServerStream(Socket socket, int number) {
        this.socket = socket;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String line = br.readLine();
                System.out.println("客户端" + number + ":" + line);
                pw.println(line.toUpperCase());
                if (line.equals("bye")) {
                    System.out.println("客户端：" + number + "已经断开连接");
                    break;
                }
            }
            br.close();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
