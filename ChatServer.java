package com.iotec.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created on 2019/10/17 0017.
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        int number = 0; // 保存客户端的个数
        while (true) {
            Socket socket = serverSocket.accept();
            number++;
            System.out.println("客户端" + number + "连接成功!");
            //服务端开启一个独立的线程来对客户端进行读写操作
            new Thread(new ServerStream(socket,number)).start();
        }

    }
}
