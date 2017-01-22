import java.io.*;
import java.net.*;

class server{
        public static void main(String args[] ) throws IOException{
		DataInputStream y=new DataInputStream(System.in);
                String s=y.readLine();
                int k=Integer.parseInt(s);

                ServerSocket a=new ServerSocket(k);
                System.out.println("address binding over");

                Socket b=a.accept();
                System.out.println("got client");

                DataInputStream d =new DataInputStream(b.getInputStream());
                String r=new String(d.readUTF());
                System.out.println("recieved "+r);

                a.close();
        }
}

class client{
        public static void main(String args[]) throws IOException{
		DataInputStream y=new DataInputStream(System.in);
		String s=y.readLine();
		int k=Integer.parseInt(s);

                Socket p=new Socket(InetAddress.getLocalHost(),k);
                System.out.println(p+" connected");
                DataOutputStream q=new DataOutputStream(p.getOutputStream());
		y=new DataInputStream(System.in);
		s=y.readLine();
                q.writeUTF(s);
		p.close();		

		DataInputStream y2=new DataInputStream(System.in);
                String s2=y2.readLine();
                int k2=Integer.parseInt(s2);
		Socket p2=new Socket(InetAddress.getLocalHost(),k2);
                System.out.println(p2+" connected");
                DataOutputStream q2=new DataOutputStream(p2.getOutputStream());
                y2=new DataInputStream(System.in);
                s2=y.readLine();
                q2.writeUTF(s2);

		p2.close();
        }
}
