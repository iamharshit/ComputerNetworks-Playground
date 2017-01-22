import java.io.*;
import java.net.*;

class server{
        public static void main(String args[] ) throws IOException{
                ServerSocket a=new ServerSocket(9876);
                System.out.println("address binding over");

                Socket b=a.accept();
                System.out.println("got client");
                DataInputStream q=new DataInputStream(b.getInputStream());
                String r=new String(q.readUTF());

                b=a.accept();
                System.out.println("got client");
                q=new DataInputStream(b.getInputStream());
                r=r+" & "+new String(q.readUTF());
                System.out.println("recieved "+r);

                a.close();
        }
}

class client{
        public static void main(String args[]) throws IOException{
                Socket p=new Socket(InetAddress.getLocalHost(),9876);
                System.out.println(p+" connected");
		
		//reading from terminal
		DataInputStream y=new DataInputStream(System.in);
		String g=y.readLine();

		//outputing to server
                DataOutputStream d =new DataOutputStream(p.getOutputStream());
                d.writeUTF(g);
                p.close();
        }
}
