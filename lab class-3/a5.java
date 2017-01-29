import java.util.Scanner;
import java.net.*;

class ram{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket();
		//making string
		byte a[]=new byte[100];
		String b="gopal";
		a=b.getBytes();

		//send
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		ds.send(new DatagramPacket(a,5,InetAddress.getLocalHost(),p));
	}
}

class hari{
	public static void main(String args[]) throws Exception{
		Scanner scanner = new Scanner(System.in);
		int port = scanner.nextInt();
		DatagramSocket ds=new DatagramSocket(port,InetAddress.getLocalHost());
		
		//recieve
		byte a[]=new byte[100];
		DatagramPacket p=new DatagramPacket(a,5);
		ds.receive(p);
		System.out.println(new String(p.getData()) +" is sent by "+p.getPort());
	}
}
