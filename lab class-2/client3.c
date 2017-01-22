#include<stdio.h>
#include<sys/types.h>

#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>

#include<fcntl.h>

main(){
	int sockfd,len,i,a,twice,square;
	char q[200];
	struct sockaddr_in sa;
	
	//specifying standards
	len=sizeof(sa);
	sockfd=socket(AF_INET,SOCK_STREAM,0);
	sa.sin_family=AF_INET;
	sa.sin_addr.s_addr = inet_addr("127.0.0.1");
	sa.sin_port=6007;

	//making connection
	i=connect(sockfd,(struct sockaddr *)&sa,len);
	printf("(%d,%d)\n",sockfd,i);

	//sending
	printf("Enter number to be sent to server:");
	scanf("%d",&a);
	send(sockfd,&a,4,0);

	//recieving
	recv(sockfd,&twice,4,0);
	recv(sockfd,&square,4,0);
	
	//send back
	int add = twice+square;
	send(sockfd,&add,4,0);
}

