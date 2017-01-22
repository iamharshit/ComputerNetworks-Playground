import java.io.*;
import java.net.*;

class server{
        public static void main(String args[] ) throws IOException{
                ServerSocket a=new ServerSocket(9876);
                System.out.println("address binding over");

                Socket b=a.accept();
                System.out.println("got client");

                DataOutputStream d =new DataOutputStream(b.getOutputStream());
                d.writeUTF("ramprasad");
		d.writeUTF("harshit");
                a.close();
        }
}

class client{
        public static void main(String args[]) throws IOException{
                Socket p=new Socket(InetAddress.getLocalHost(),9876);
                System.out.println(p+" connected");

                DataInputStream q=new DataInputStream(p.getInputStream());
                String r=new String(q.readUTF());
                System.out.println("recieved "+r);
		
		r=q.readUTF();
		System.out.println("recieved "+r);
                p.close();
        }
}

