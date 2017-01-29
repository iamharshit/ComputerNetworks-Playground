import java.net.*;

class ram{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket(9846,InetAddress.getLocalHost());
		//making string
		byte a[]=new byte[100];
		String b="gopal";
		a=b.getBytes();

		//send
		ds.send(new DatagramPacket(a,5,InetAddress.getLocalHost(),9848));

		//recieve
		DatagramPacket p=new DatagramPacket(a,5);
		ds.receive(p);
		System.out.println(new String(p.getData()) );
	}
}

class hari{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket(9848,InetAddress.getLocalHost());
		
		//recieve
		byte a[]=new byte[100];
		DatagramPacket p=new DatagramPacket(a,5);
		ds.receive(p);
		System.out.println(new String(p.getData()) +" is sent by "+p.getPort());
		a=p.getData();
		a[1]++;
		
		//send
		ds.send(new DatagramPacket(a,5,p.getSocketAddress()));
	}
}
