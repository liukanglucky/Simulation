package com.platform.net;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.platform.report.receive.OneSend;


public class TestUdp {
	
	public static class TestServer implements Runnable{

		@Override
		public void run() {
			System.out.println("server");
			try {
				startServer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void startServer() throws Exception{
			String serverHost = "127.0.0.1";  
	        int serverPort = 3344;  
	        UdpServerSocket udpServerSocket = new UdpServerSocket(serverHost, serverPort);  
	        while (true) {  
	            udpServerSocket.receive();  
	            udpServerSocket.response("你好,liukang!");  
	              
	        }  
		}
		
	}
	
	
	public static class TestClient implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					sendmsg();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void sendmsg() throws Exception{
			char[] wjm = {'0','1'};
			OneSend oneSend = new OneSend('a', (float)0,(float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, '1', '2', 'z', '5',wjm);
			
			UdpClientSocket client = new UdpClientSocket();  
	        String serverHost = "127.0.0.1";  
	        int serverPort = 3344;  
	        
	        client.send(serverHost, serverPort, (oneSend.toString()).getBytes(),oneSend);  
	        byte[] info = client.receive(serverHost, serverPort);  
	        System.out.println("服务端回应数据：" + info);  
		}
	}
	
	
	public static void main(String[] args) {
		TestServer ts = new TestServer();
		TestClient tc = new TestClient();
		
		//线程池
//		ExecutorService executor = Executors.newFixedThreadPool(2);
//		executor.execute(ts);
//		executor.execute(tc);
//		executor.shutdown();
		
		Thread serverThread = new Thread(ts);
		Thread clientThread = new Thread(tc);
		
		serverThread.start();
		
		clientThread.start();
	}
	
}
