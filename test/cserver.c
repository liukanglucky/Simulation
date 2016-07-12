#include <sys/socket.h>  
#include <netinet/in.h>  
#include <arpa/inet.h>  
#include <unistd.h>  
#include <stdlib.h>  
#include <string.h>  
#include <stdio.h>  
#define PORT 1111 /*使用的port*/  

struct A{
	char a1;
	float b1[2];
	char c1[3];
};

struct rep{
	char a;
	char b[1000];
	//float c;
} rep1;


struct rep3{
	char a;
	float b[20];
	float c[20];
	float d[20];
	float e;
	float f;
	char g;
	char h;
};

struct DATA1
{
	unsigned char s1;   //标识    
	float speed;        //航速    //采样率(分析方式下的解析,char类型位置不变)
	float ang;          //航向    //声速
	float fre;          //中心频率//发射声源级
	float bre;          //带宽    //检测域
	float cre;          //脉宽    //仿真总时间
	float distence;     //中心距离//仿真开始时刻
	float ang1;         //俯仰角  //距离
	float ang2;         //水平角
	float time;         //时间周期
	float cy1;          //采样频率
	float ss;           //声源级
	float ang3;         //发射角 
	float ang4;         //接收角
	unsigned char type1;//仿真类型
	unsigned char type2;//包络
	unsigned char type3;//信号形式
	unsigned char len1;  //数据文件名长度
	unsigned char file1[100];//文件名
	unsigned char len2;  //模型文件名长度
	unsigned char file2[100];//文件名
} B;//模型1用 len 264





main(){  
	int sockfd,len;  
	struct sockaddr_in addr;  
	struct sockaddr_in addr2;  
	int addr_len = sizeof(struct sockaddr_in);  
	printf("size of struct A is %d\n",sizeof(struct A));
	char buffer[1000];  
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
	addr2.sin_family=AF_INET;	  
	addr2.sin_port=htons(1112);  
	addr2.sin_addr.s_addr=htonl(INADDR_ANY) ;  
	// if (bind(sockfd, (struct sockaddr *)&addr, sizeof(addr))<0){  
	// 	perror("connect");  
	// 	exit(1);  
	// }  
	// while(1){  
	// 	bzero(buffer,sizeof(buffer));  
	// 	len = recvfrom(sockfd,buffer,sizeof(buffer), 0 , (struct sockaddr *)&addr ,&addr_len);  
	// 	/*显示client端的网络地址*/  
	// 	printf("receive from %s\n" , inet_ntoa( addr.sin_addr));  

	// 	printf("接收的数据%s\n", buffer);

	// 	/*将字串返回给client端*/  
	// 	struct DATA1 *b = (struct DATA1*)&buffer;	
		
	// 	printf("size of DATA1 is %d ",sizeof(struct DATA1));

	// 	memcpy(&B, &buffer, sizeof(struct DATA1)); 
		
		
	// 	printf("size of response object is %d\n",sizeof(B));
		
	// 	printf("结构体%c%f\n",(int)B.s1,B.speed);	
		
	// 	char rp_data[16] = {'a','b'};
		
		int i;

		struct  rep3 rep3a;

		rep3a.a = 4;
		for(i = 0 ; i < 20 ; i++)
		{
			rep3a.b[i] = 100;
			rep3a.c[i] = 100;
			rep3a.d[i] = 100;
		}
		rep3a.e = 2.2f;
		rep3a.f = 2.5f;
		rep3a.g = 1;
		rep3a.h = 2;

		struct rep rep_2;
		struct rep rep_3;

		rep1.a = 1;
		rep_2.a = 2;
		rep_3.a = 3;

		for(i = 0 ; i < 1000 ; i++){
			rep1.b[i] = 1;
			rep_2.b[i] = 2;
			rep_3.b[i] = 3;
		}



		printf("size of rep1 is %d\n",sizeof(rep1));


		printf("size of rep3 is %d\n",sizeof(rep3a));
			
		sendto(sockfd,&rep1,sizeof(rep1),0,(struct sockaddr *)&addr,addr_len);  

		sendto(sockfd,&rep_2,sizeof(rep1),0,(struct sockaddr *)&addr,addr_len);

		sendto(sockfd,&rep_3,sizeof(rep1),0,(struct sockaddr *)&addr,addr_len);

		sendto(sockfd,&rep3a,sizeof(rep3a),0,(struct sockaddr *)&addr,addr_len);
	//}  
} 
