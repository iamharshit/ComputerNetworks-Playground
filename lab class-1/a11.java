import java.io.*;
import java.net.*;

class servera{
        public static void main(String args[] ) throws IOException{
                ServerSocket a=new ServerSocket(9876);
                System.out.println("address binding over");

                Socket b=a.accept();
                System.out.println("got client");

                DataOutputStream q=new DataOutputStream(b.getOutputStream());
                q.writeUTF("ram");
		
		DataInputStream d =new DataInputStream(b.getInputStream());
                String r=new String(d.readUTF());	
		System.out.println(r);				

                a.close();
        }
}

class serverb{
        public static void main(String args[] ) throws IOException{
                ServerSocket a=new ServerSocket(9877);
                System.out.println("address binding over");
	
                Socket b=a.accept();
                System.out.println("got client");

                DataOutputStream q=new DataOutputStream(b.getOutputStream());
                q.writeUTF("ok");

		DataInputStream d =new DataInputStream(b.getInputStream());
                String r=new String(d.readUTF()); 
                System.out.println(r);

                a.close();
        }
}

class client{
        public static void main(String args[]) throws IOException{
                Socket p1=new Socket(InetAddress.getLocalHost(),9876);
                System.out.println(p1+" connected");
                DataInputStream d =new DataInputStream(p1.getInputStream());
                String r1=new String(d.readUTF());

                Socket p2=new Socket(InetAddress.getLocalHost(),9877);
                System.out.println(p2+" connected");
                d=new DataInputStream(p2.getInputStream());
                String r2=new String(d.readUTF());
		
	       DataOutputStream q1=new DataOutputStream(p1.getOutputStream());
                q1.writeUTF(r2);
	       DataOutputStream q2=new DataOutputStream(p2.getOutputStream());
                q2.writeUTF(r1);
		
                p1.close();
		p2.close();

        }
}
