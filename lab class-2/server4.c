#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<fcntl.h>

main(){
	int sockfd,fd,len,i,p,q,tw,squa,ans;
	char b[200];
	struct sockaddr_in sa,ca;
	
	//specifying standards
	len = sizeof(sa);
	sockfd=socket(AF_INET,SOCK_STREAM,0);
	sa.sin_addr.s_addr=INADDR_ANY;
	sa.sin_port=6666; //specifying port no.
	//printf("atet");
	i=bind(sockfd,(struct sockaddr *)&sa,len); 
	printf("(%d,%d)\n",sockfd,i);
	listen(sockfd,5);
	
	//making connection
	fd = accept(sockfd, (struct sockaddr *)&ca,&len);
	printf("[%d]\n",fd);
	
	//recieving number
	int a[2];
	recv(fd,a,8,0);
	printf("client sent:%d,%d\n",a[0],a[1]);	

}
