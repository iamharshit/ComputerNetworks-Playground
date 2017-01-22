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
	
	//recieving 
	int temp,ii;
	for(ii=0;ii<10;ii++){
		recv(fd,&temp,4,0);
		if(temp%2==0){
			temp*=2;
			send(fd,&temp,4,0);
		}
		//printf("recieved: %d\n",temp);
	}	
}
