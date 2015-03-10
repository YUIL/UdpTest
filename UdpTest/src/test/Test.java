package test;
import util.JavaDataConverter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Test {
	public static void main(String args[]){
		DatagramSocket serverSocket=null;
		try {
			serverSocket=new DatagramSocket(9091);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			byte[] buf=new byte[4];
			DatagramPacket datagramPacket =new DatagramPacket(buf,4);
			try {
				serverSocket.receive(datagramPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(JavaDataConverter.bytesToInt(datagramPacket.getData()));
			if(JavaDataConverter.bytesToInt(datagramPacket.getData())==0){
				break;
			}
		}

	}

}
