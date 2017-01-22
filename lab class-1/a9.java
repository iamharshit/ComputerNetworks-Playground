import java.io.*;
import java.net.*;

class servera{
        public static void main(String args[] ) throws IOException{
                ServerSocket a=new ServerSocket(9876);
                System.out.println("address binding over");

                Socket b=a.accept();
                System.out.println("got client");

                DataInputStream d =new DataInputStream(b.getInputStream());
                String r=new String(d.readUTF());
                System.out.println("recieved "+r);

                a.close();
        }
}

class serverb{
        public static void main(String args[] ) throws IOException{
                ServerSocket a=new ServerSocket(9877);
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
                Socket p=new Socket(InetAddress.getLocalHost(),9876);
                System.out.println(p+" connected");
                DataOutputStream q=new DataOutputStream(p.getOutputStream());
                q.writeUTF("ram");
                p.close();

		p=new Socket(InetAddress.getLocalHost(),9877);
                System.out.println(p+" connected");
                q=new DataOutputStream(p.getOutputStream());
                q.writeUTF("hari");
                p.close();

        }
}
