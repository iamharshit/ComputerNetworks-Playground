import java.net.*;
import java.io.*;

class ram{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket(9811,InetAddress.getLocalHost());
		for(int i=1;i<=10;i++){
			//reading string 
			DataInputStream y=new DataInputStream(System.in);
			String b=y.readLine();	
			byte a[]=new byte[100];
			a=b.getBytes();
	
			//send
			ds.send(new DatagramPacket(a,6,InetAddress.getLocalHost(),9842));
		}
	}
}

class hari{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket(9842,InetAddress.getLocalHost());
		for(int i=1;i<=10;i++){
			//recieve from ram
			byte b[]=new byte[100];
			DatagramPacket q=new DatagramPacket(b,6);
			ds.receive(q);
			System.out.println(new String(q.getData()) +" is sent by "+q.getPort());
		}
		
	}
}
