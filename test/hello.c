#include<stdio.h>
#pragma pack(1)
typedef struct{
	char a;
	char b;
	char c;
	float d;
}A;


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
}DATA1;//模型1用


int main(){
	printf("hello world\n");
	printf("%d\n",sizeof(A));
	char buffer[sizeof(A)] = {'a','b','c',0,0,0,0,0};
	A *ap = (A*)buffer; 		
	printf("%c\n",ap->a);
	return 0;
}

