package com.platform.net;

import java.io.*;  
import java.net.*;  
import java.nio.ByteOrder;

//import struct.JavaStruct;

import com.platform.report.receive.OneSend;
import com.platform.report.receive.Response1;
import com.platform.report.send.DATA1;
import com.platform.report.send.Struct1;
import com.platform.util.ByteUtil;
  
/**    
 * UDP客户端程序，用于对服务端发送数据，并接收服务端的回应信息. 
 * @author liukang
 */  
public class UdpClientSocket {  
	
	//接收buffer
    private byte[] buffer = new byte[1200];  
  
    private DatagramSocket ds = null;  
  
    /** 
     * 构造函数，创建UDP客户端 
     * @throws Exception 
     */  
    public UdpClientSocket() throws Exception {  
        //ds = new DatagramSocket();  
        ds = new DatagramSocket(21168);
    }  
      
    /** 
     * 设置超时时间，该方法必须在bind方法之后使用. 
     * @param timeout 超时时间 
     * @throws Exception 
     */  
    public final void setSoTimeout(final int timeout) throws Exception {  
        ds.setSoTimeout(timeout);  
    }  
  
    /** 
     * 获得超时时间. 
     * @return 返回超时时间 
     * @throws Exception 
     */  
    public final int getSoTimeout() throws Exception {  
        return ds.getSoTimeout();  
    }  
  
    public final DatagramSocket getSocket() {  
        return ds;  
    }  
  
    /** 
     * 向指定的服务端发送数据信息. 
     * @param host 服务器主机地址 
     * @param port 服务端端口 
     * @param bytes 发送的数据信息 
     * @return 返回构造后俄数据报 
     * @throws IOException 
     */  
    public final DatagramPacket send(final String host, final int port,  
            final byte[] bytes) throws IOException { 
    	
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress  
                .getByName(host), port); 
        
        ds.send(dp);  
        return dp;  
    }  
  
    /** 
     * 接收从指定的服务端发回的数据. 
     * @param lhost 服务端主机 
     * @param lport 服务端端口 
     * @return 返回从指定的服务端发回的数据. 
     * @throws Exception 
     */  
    public final byte[] receive(final String lhost, final int lport)  
            throws Exception {  
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);  
        ds.receive(dp);  
        //String info = new String(dp.getData(), 0, dp.getLength());  
        return buffer;  
    }  
  
    /** 
     * 关闭udp连接. 
     */  
    public final void close() {  
        try {  
            ds.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  

    
    
    
    
    public  byte[] arraycat(byte[] buf1,byte[] buf2)
    {
	    byte[] bufret=null;
	    int len1=0;
	    int len2=0;
	    if(buf1!=null)
	    	len1=buf1.length;
	    if(buf2!=null)
	    	len2=buf2.length;
	    if(len1+len2>0)
	    	bufret=new byte[len1+len2];
	    
	    for (int i = 0; i < len1; i++) {
	    	bufret[i] = buf1[i];
		}
	    
	    for (int j = 0; j < len2; j++) {
			bufret[len1+j] = buf2[j];
		}
	    
	    return bufret;
    }
    
    public  byte[] float2byte(float f) {  
        
        // 把float转换为byte[]  
        int fbit = Float.floatToIntBits(f);  
          
        byte[] b = new byte[4];    
        for (int i = 0; i < 4; i++) {    
            b[i] = (byte) (fbit >> (24 - i * 8));    
        }   
          
        // 翻转数组  
        int len = b.length;  
        // 建立一个与源数组元素类型相同的数组  
        byte[] dest = new byte[len];  
        // 为了防止修改源数组，将源数组拷贝一份副本  
        System.arraycopy(b, 0, dest, 0, len);  
        byte temp;  
        // 将顺位第i个与倒数第i个交换  
        for (int i = 0; i < len / 2; ++i) {  
            temp = dest[i];  
            dest[i] = dest[len - i - 1];  
            dest[len - i - 1] = temp;  
        }  
          
        return dest;  
          
    }
    
    public  byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }
    
    /** 
     * 测试客户端发包和接收回应信息的方法. 
     * @param args 
     * @throws Exception 
     */  
    public static void main(String[] args) throws Exception {  
        UdpClientSocket client = new UdpClientSocket();  
        String serverHost = "127.0.0.1";  
        int serverPort = 1111;  
        
        byte[] data = {2,3};
        
        
        client.send(serverHost, serverPort, data);  
        while(true){
	        byte[] info = client.receive(serverHost, serverPort);  
	        
	        System.out.println(info.length);
	        
	        for (int i = 0; i < 1010; i++) {
	        	System.out.println("服务端回应数据："+i+"======" + info[i]);  
			}
        
        }
        
    }  
} 
