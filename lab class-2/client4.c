#include<stdio.h>
#include<sys/types.h>

#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>

#include<fcntl.h>

main(){
	int sockfd,len,i,twice,square;
	char q[200];
	struct sockaddr_in sa;
	
	//specifying standards
	len=sizeof(sa);
	sockfd=socket(AF_INET,SOCK_STREAM,0);
	sa.sin_family=AF_INET;
	sa.sin_addr.s_addr = inet_addr("127.0.0.1");
	sa.sin_port=6666;

	//making connection
	i=connect(sockfd,(struct sockaddr *)&sa,len);
	printf("(%d,%d)\n",sockfd,i);
	
	//sending
	int a[2];
	printf("Enter numbers:");
	scanf("%d%d",&a[0],&a[1]);
	send(sockfd,a,8,0);
}
