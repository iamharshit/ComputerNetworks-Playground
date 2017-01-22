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
	
	//recieve
	int a[2];
	recv(sockfd,&a,8,0);
	printf("server sent:%d %d\n",a[0],a[1]);	

	//sending
	int sum=a[0]+a[1];
	send(sockfd,&sum,4,0);

	//recieving double
	int dub;
	recv(sockfd,&dub,4,0);
	printf("server sent:%d\n",dub);

	//send	
	int new;
	printf("enter no:");
	scanf("%d",&new);
	int sub=dub-new,add=dub+new;
	send(sockfd,&sub,4,0);
	send(sockfd,&add,4,0);		
}
