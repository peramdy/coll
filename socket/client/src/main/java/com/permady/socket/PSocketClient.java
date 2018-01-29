package com.permady.socket;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

/**
 * @author peramdy on 2018/1/29.
 */
@Component
public class PSocketClient {

    public void createSocketClient() {
        Socket socket = null;
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            socket = new Socket("192.168.136.130", 8080);

            //2.获取输出流，向服务器端发送信息
            //字节输出流
            os = socket.getOutputStream();

            //将输出流包装为打印流
            pw = new PrintWriter(os);
            pw.write("hello server");
            pw.flush();

            //关闭输出流
            socket.shutdownOutput();

            //3.获取输入流，并读取服务器端的响应信息
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            char[] chars = new char[1024];
            StringBuffer sb = new StringBuffer();
            int len;
            while ((len = br.read(chars)) != -1) {
                sb.append(new String(chars, 0, len));
            }
            socket.shutdownInput();
            System.out.println("I'm client, server say: " + sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.关闭资源
                if (os != null) {
                    os.close();
                }
                if (pw != null) {
                    pw.close();
                }
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    br.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {
        PSocketClient client = new PSocketClient();
        client.createSocketClient();
    }

}
