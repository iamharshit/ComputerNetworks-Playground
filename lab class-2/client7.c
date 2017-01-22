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
	int temp,ii;
	for(ii=0;ii<10;ii++){
		printf("enter no. %d: ",ii+1);
		scanf("%d",&temp);
		send(sockfd,&temp,4,0);
		if(temp%2==0){	
			recv(sockfd,&temp,4,0);
			printf("recieved : %d\n",temp);
		}
	}	
}
