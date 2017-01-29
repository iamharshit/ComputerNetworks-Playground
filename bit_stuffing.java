import java.io.*;
import java.lang.*;

//bit stuffing happens at sender
class sender{
    '''
    Outputs the stuffed msg
    '''
    private static String start = "01101";
    private static String end = "10110";
    private static String msg = "10011101101";

	public static void main(String[] args) {
        int j=0;
        int temp=0;
        for(int i=0;i<msg.length()-end.length();i++){
    		j=0;
            while(msg.charAt(i+j)==end.charAt(j)){
                j++;
                if(j==4){
                    String tmp;
                    if(msg.charAt(i+4)=='0') tmp="1";
                    else tmp="0";
                    msg = msg.substring(0, i+4) + tmp + msg.substring(i+4, msg.length());
                    break;
                }
                temp++;
            }
        }
        System.out.println(start+msg+end);
    }
}

//bit destuffing happens
class reciever{
    '''
    Outputs the destuffed msg
    '''
    private static String start = "01101";
    private static String end = "10110";
    private static String middle = "100111011101";
    private static String msg=middle+end;

	public static void main(String[] args) {
        int j=0;
        outer:
		for(int i=0;i<msg.length()-1;i++){
        		j=0;
        		while(msg.charAt(i+j)==end.charAt(j)){
        			j++;
        			if(j==4 && msg.charAt(i+j)==end.charAt(j)){
        				//quit
        				msg
                         = msg.substring(0, i+j-1);
        				break outer;
        			}
        			else if (j==4 && msg.charAt(i+j)!=end.charAt(j)) {
        				//delete it
        				msg = msg.substring(0, i+j) + msg.substring(i+j+1,msg.length());
        				break;
        			}
        		}
        }
        System.out.println(msg);
	}
}