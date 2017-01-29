import java.net.*;

class ram{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket(9811,InetAddress.getLocalHost());
		//making string
		byte a[]=new byte[100];
		String b="gopal";
		a=b.getBytes();

		//send
		ds.send(new DatagramPacket(a,5,InetAddress.getLocalHost(),9842));

		//recieve
		DatagramPacket p=new DatagramPacket(a,5);
		ds.receive(p);
		System.out.println(new String(p.getData()) );
	}
}

class kapil{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket(9812,InetAddress.getLocalHost());
		//making string
		byte a[]=new byte[100];
		String b="mohan";
		a=b.getBytes();

		//send
		ds.send(new DatagramPacket(a,5,InetAddress.getLocalHost(),9842));

		//recieve
		DatagramPacket p=new DatagramPacket(a,5);
		ds.receive(p);
		System.out.println(new String(p.getData()) );
	}
}

class hari{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket(9842,InetAddress.getLocalHost());
		
		//recieve from kapil
		byte a[]=new byte[100];
		DatagramPacket p=new DatagramPacket(a,5);
		ds.receive(p);
		System.out.println(new String(p.getData()) +" is sent by "+p.getPort());		
 

		//recieve from ram
		byte b[]=new byte[100];
		DatagramPacket q=new DatagramPacket(b,5);
		ds.receive(q);
		System.out.println(new String(p.getData()) +" is sent by "+p.getPort());
		
		//send to kapil
		ds.send(new DatagramPacket(q.getData(),5,p.getSocketAddress()));
		
		//send to ram
		ds.send(new DatagramPacket(p.getData(),5,q.getSocketAddress()));
	}
}
