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

                a.close();
        }
}

class client{
        public static void main(String args[]) throws IOException{
                Socket p=new Socket(InetAddress.getLocalHost(),9876);
                System.out.println(p+" connected");
                DataInputStream d =new DataInputStream(p.getInputStream());
                String r=new String(d.readUTF());
                p.close();

                p=new Socket(InetAddress.getLocalHost(),9877);
       		System.out.println(p+" connected");
                d=new DataInputStream(p.getInputStream());
               	r=r+" & "+new String(d.readUTF());
		System.out.println(r);		

                p.close();

        }
}                                                                                             
