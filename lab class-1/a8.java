import java.io.*;
import java.net.*;

class server{
        public static void main(String args[] ) throws IOException{
                ServerSocket a=new ServerSocket(9876);
                System.out.println("address binding over");

                Socket b1=a.accept();
                System.out.println("got client");
                DataInputStream q=new DataInputStream(b1.getInputStream());
                String r1=new String(q.readUTF());
		
		Socket b2=a.accept();
                System.out.println("got client");
                q=new DataInputStream(b2.getInputStream());
                String r2=new String(q.readUTF());
		
		DataOutputStream d=new DataOutputStream(b1.getOutputStream());
                d.writeUTF(r2);		
		
		d=new DataOutputStream(b2.getOutputStream());
                d.writeUTF(r1);

                a.close();
        }
}

class clienta{
        public static void main(String args[]) throws IOException{
                Socket p=new Socket(InetAddress.getLocalHost(),9876);
                System.out.println(p+" connected");

                DataOutputStream d =new DataOutputStream(p.getOutputStream());
                d.writeUTF("ram");

                DataInputStream q=new DataInputStream(p.getInputStream());
		String r = new String(q.readUTF());		
                System.out.println("recieved "+r);

                p.close();
        }
}

class clientb{
        public static void main(String args[]) throws IOException{
                Socket p=new Socket(InetAddress.getLocalHost(),9876);
                System.out.println(p+" connected");

                DataOutputStream d =new DataOutputStream(p.getOutputStream());
                d.writeUTF("hari");
		
		DataInputStream q=new DataInputStream(p.getInputStream());
                String r = new String(q.readUTF());
                System.out.println("recieved "+r);
		
                p.close();
        }
}
