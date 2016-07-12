#include <sys/socket.h>  
#include <netinet/in.h>  
#include <arpa/inet.h>  
#include <unistd.h>  
#include <stdlib.h>  
#include <string.h>  
#include <stdio.h>  
#define PORT 1111 /*使用的port*/  


struct rep{
	char a;
	char b[1000];
} rep1;



main(){  
	int sockfd,len;  
	struct sockaddr_in addr;  
	struct sockaddr_in addr2;  
	int addr_len = sizeof(struct sockaddr_in);    
	/*建立socket*/  
	if((sockfd=socket(AF_INET,SOCK_DGRAM,0))<0){  
		perror ("socket");  
		exit(1);  
	}  
	/*填写sockaddr_in 结构*/  
	bzero ( &addr, sizeof(addr) );  
	addr.sin_family=AF_INET;	  
	addr.sin_port=htons(PORT);  
	addr.sin_addr.s_addr=inet_addr("192.168.0.106");  

		
	int i;

	struct rep rep_2;
	struct rep rep_3;
	struct rep rep_4;
	{
		/* data */
	};

	rep1.a = 1;
	rep_2.a = 2;
	rep_3.a = 3;
	rep_4.a = 4;

	for(i = 0 ; i < 1000 ; i++){
		rep1.b[i] = 1;
		rep_2.b[i] = 2;
		rep_3.b[i] = 3;
		rep_4.b[i] = 4;
	}




	printf("size of rep1 is %d\n",sizeof(rep1));
		
	sendto(sockfd,&rep1,sizeof(rep1),0,(struct sockaddr *)&addr,addr_len);  
	sleep(5);
	sendto(sockfd,&rep_2,sizeof(rep1),0,(struct sockaddr *)&addr,addr_len);
	sleep(5);
	sendto(sockfd,&rep_3,sizeof(rep1),0,(struct sockaddr *)&addr,addr_len);
	sleep(5);
	sendto(sockfd,&rep_4,sizeof(rep1),0,(struct sockaddr *)&addr,addr_len);
	
	printf("done!");
} 
