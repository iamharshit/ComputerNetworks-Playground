import java.net.*;
import java.io.*;

class ram{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket();
		//reading string 
		DataInputStream y=new DataInputStream(System.in);
		String b=y.readLine();	
		byte a[]=new byte[100];
		a=b.getBytes();

		//send
		ds.send(new DatagramPacket(a,6,InetAddress.getLocalHost(),9841));
		
		
		//recieve
		byte bq[]=new byte[100];
		DatagramPacket q=new DatagramPacket(bq,6);
		ds.receive(q);
		System.out.println(new String(q.getData()) +" is sent by "+q.getPort());
	}
}

class hari{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket(9841,InetAddress.getLocalHost());
		
		//recieve from ram
		byte b[]=new byte[100];
		DatagramPacket q=new DatagramPacket(b,6);
		ds.receive(q);
		System.out.println(new String(q.getData()) +" is sent by "+q.getPort());
		
		//recieve from ram
		byte c[]=new byte[100];
		DatagramPacket r=new DatagramPacket(c,6);
		ds.receive(r);
		System.out.println(new String(r.getData()) +" is sent by "+r.getPort());
		
		
		//send
		ds.send(new DatagramPacket(q.getData(),6,InetAddress.getLocalHost(),r.getPort()));
		ds.send(new DatagramPacket(r.getData(),6,InetAddress.getLocalHost(),q.getPort()));
		
	}
}
