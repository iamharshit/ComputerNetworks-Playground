#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<fcntl.h>

main(){
	int sockfd,fd,len,i,p,q;
	char b[200];
	struct sockaddr_in sa,ca;
	
	//specifying standards
	len = sizeof(sa);
	sockfd=socket(AF_INET,SOCK_STREAM,0);
	sa.sin_addr.s_addr=INADDR_ANY;
	sa.sin_port=6666; //specifying port no.
	i=bind(sockfd,(struct sockaddr *)&sa,len); 
	printf("(%d,%d)\n",sockfd,i);
	listen(sockfd,5);
	
	//making connection
	fd = accept(sockfd, (struct sockaddr *)&ca,&len);
	printf("[%d]\n",fd);
	
	//sending numbers
	int a[2];
	printf("enter 2 numbers:");
	scanf("%d%d",&a[0],&a[1]);
	send(fd,&a,8,0);	
	
	//recieving sum
	int sum;
	recv(fd,&sum,4,0);
	printf("client sent:%d\n",sum);

	//sending double
	int dub=2*sum;	
	send(fd,&dub,4,0);

	//recieving
	int sub,add;
	recv(fd,&sub,4,0);
	recv(fd,&add,4,0);
	printf("client send: %d , %d\n",add,sub);
}
