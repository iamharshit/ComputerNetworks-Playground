import java.util.Scanner;
import java.net.*;

class ram{
	public static void main(String args[]) throws Exception{

		//read ports
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		int q = scanner.nextInt();
	
		DatagramSocket ds=new DatagramSocket(p,InetAddress.getLocalHost());		
	
		//read string
		byte a1[]=new byte[100];
		a1=s1.getBytes();

		//send
		String s1 = scanner.next();
		ds.send(new DatagramPacket(a1,5,InetAddress.getLocalHost(),q));

		//recieve

		System.out.println()
	}
}
