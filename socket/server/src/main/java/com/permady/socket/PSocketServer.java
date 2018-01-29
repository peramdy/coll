package com.permady.socket;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author peramdy on 2018/1/29.
 */
@Component
public class PSocketServer {

    @PostConstruct
    public void createSocketServer() {

        try {
            Socket socket = null;
            InputStream in = null;
            InputStreamReader inr = null;
            BufferedReader br = null;
            OutputStream out = null;
            PrintWriter pw = null;
            //监听8080端口
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("socket server start");
            int count = 0;

            while (true) {
                try {
                    
                    socket = serverSocket.accept();
                    System.out.println("socket no: " + count++);
                    System.out.println("socket server ip: " + serverSocket.getInetAddress());
                    System.out.println("socket server port: " + serverSocket.getLocalPort());

                    //获取客户端传递信息
                    in = socket.getInputStream();
                    inr = new InputStreamReader(in);
                    br = new BufferedReader(inr);
                    String msg;
                    while ((msg = br.readLine()) != null) {
                        System.out.println("I'm server, client say: " + msg);
                    }
                    //关闭
                    socket.shutdownInput();

                    //向客户端返回信息
                    out = socket.getOutputStream();
                    pw = new PrintWriter(out);
                    pw.write("hello client, I'm server");

                    //调用flush()方法将缓冲输出
                    pw.flush();

                    //关闭
                    socket.shutdownOutput();
                    System.out.println("hello client, I'm server ");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        br.close();
                    }
                    if (inr != null) {
                        inr.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                    if (pw != null) {
                        pw.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PSocketServer server = new PSocketServer();
        server.createSocketServer();
    }

}
