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
	float b;
	float c;
	int d;
	char e[50];
	char f[1000];
} ;



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
	addr.sin_addr.s_addr=htonl(INADDR_ANY) ;  

		
	int i;

	struct rep rep1;
	
	

	rep1.a = 1;
	rep1.b = 3.3;
	rep1.c = 4.4;
	rep1.d = 5;
	rep1.e[0] = "a";
	
	for(i = 0 ; i < 1000 ; i++){
		rep1.f[i] = 2;
	}




	printf("size of rep1 is %d\n",sizeof(rep1));
		
	sendto(sockfd,&rep1,sizeof(rep1),0,(struct sockaddr *)&addr,addr_len);  

} 
