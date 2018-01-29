package com.permady.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author peramdy on 2018/1/29.
 */
public class PSocketPoolServer implements Runnable {


    private Socket socket;

    public PSocketPoolServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            in = socket.getInputStream();
            isr = new InputStreamReader(in);
            br = new BufferedReader(isr);
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println("thread socket server ,client say:" + msg);
            }
            socket.shutdownInput();

            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("hello client,I'm  thread server");
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
