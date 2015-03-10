package test;
import java.io.*;
import java.net.*;
import util.*;

public class Test {
	public static void main(String args[]){
		DatagramSocket serverSocket=null;
		try {
			serverSocket=new DatagramSocket(9091);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte temp=1;
		while(true){
			byte[] buf=new byte[4];
			buf[0]=temp;

			try {
				DatagramPacket datagramPacket =new DatagramPacket(buf,4,InetAddress.getByName("192.168.100.33"),9091);
				serverSocket.send(datagramPacket);


				System.out.println(JavaDataConverter.bytesToInt(datagramPacket.getData()));

				if(JavaDataConverter.bytesToInt(datagramPacket.getData())==255){
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			temp++;

		}
		System.out.println("app end");
	}
}
