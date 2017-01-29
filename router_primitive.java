'''
Ouputs the shortest path from one router/node to another
'''

import java.io.*;

class shortest_path{
	//space complexity=O(n^2)
	//time complexity=O(n)
	private static int total_nodes=5;

	public static void main(String args[]){
		//node names = 1....total_nodes
		int[][] routing_table = new int[total_nodes+1][total_nodes+1];

		/*           2
				    /
				1--3
			   /   |
			  5    4
		*/
		//filling routing table
	    routing_table[1]=new int[]{0,0,3,3,3,5};
	    routing_table[2]=new int[]{0,3,0,3,3,3};
	    routing_table[3]=new int[]{0,1,2,0,4,1};
	    routing_table[4]=new int[]{0,3,3,3,0,3};
	    routing_table[5]=new int[]{0,1,1,1,1,0};

	    int source=1;
	    int destination=4;

	    //shortest path
	    int curr=source;
	    while(curr!=destination){
	    	System.out.print(curr+"-->");
	    	curr=routing_table[curr][destination];
	    }
	    System.out.println(destination);
	}
}

