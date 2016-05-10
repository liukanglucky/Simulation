#include<jni.h>
#include "com_platform_jni_Model.h"
#include<string.h>
#include<sys/socket.h>
#include<sys/types.h>
#include<sys/un.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<stdio.h>
#include<unistd.h>
#define PORT 21168
#define IP "192.168.220.13"

struct DATA1
{
	unsigned char s1;   //标识    
	float speed[30];        //航速    //采样率(分析方式下的解析,char类型位置不变)
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
};//模型1用 len 264

struct DATA2
{
	unsigned char s1;   //标识
	unsigned char s2;
	float speed1;       //海底纵波声速
	float speed2;       //横波声速
	float jz;           //介质密度
	float d1[4];        //纵波衰减系数
	float d2[4];        //横波衰减系数
	float num1;         //散射点数
	float pu1;          //谱强度
	float pu2;          //谱指数
	float wind[3];      //风速xyz
	float fspeed[3];    //海流速度xyz
	float depth;		//海水深度
	float speed3;       //声速
	float d3[4];        //衰减系数 
	float pu3;          //谱系数
	float pu4;		    //谱指数
	float num2;		    //散射点数
	float ang1[2];		//水平角
	float ang2[2];      //垂直角
	float ang3[2];		//方位角
	float ang4[2];		//俯仰角
	float ss;		    //声源级
	float loc[3];       //声源位置x
	float speed[3];     //声源速度x
	float lm1;          //接收灵敏度
	float cy1;          //采样率
	float fre1[4];      //中心频率
	float dk1[4];       //带宽
	float mk1;          //脉宽
	float slocx[36][3]; //阵元位置36
	unsigned char num;  //阵元个数
	unsigned char type1;//仿真类型
	unsigned char type2[4];//信号形式
	unsigned char len;  //文件名长度
	unsigned char file[255];//文件名
};//模型2用

#pragma pack(push)
#pragma pack(4)
struct DATA3A
{
	unsigned char s1;   //标识
	float weight;       //吨位
	float depth;        //水深
	float speed;        //航速
	float fre1[2];      //输出频率1-2
	float cy1;          //采样率
	float zy1;          //增益
	float lm1;          //灵敏度
	float num;  //阵元个数
	float ss;           //模拟声纳采样率
	float fre2[2];      //带通滤波频率1-2
	float time1;          //数据起始时刻
	float time2;          //数据总长度
	float zy2;          //模拟增益
	float lm2;          //模拟灵敏度
	unsigned char type1;//仿真类型
	unsigned char type2;//目标类型1:001；2:054A；3:039；4：Y7A;5：Y10
	unsigned char len;  //文件名长度
	unsigned char file[255];//文件名
};//模型3分析用(模型4A通用)
#pragma pack(pop)
struct DATA3B
{
	unsigned char s1;   //标识
	float weight;       //吨位
	float depth;        //水深
	float speed;        //航速
	float fre1[2];      //输出频率1-2
	float cy1;          //采样率
	float zy1;          //增益
	float lm1;          //灵敏度
	float num1; //阵元个数
	float ss;           //速度对应谱级
	float fre2;         //轴频频率
	float num2; //螺旋桨叶片数
	float xp1[20];      //线谱频率20
	float xp2[20];      //线谱强度20
	float de[20];       //调制深度20
	unsigned char type1;//仿真类型
	unsigned char type2;//目标类型
	unsigned char s2;
};//模型3仿真用

struct DATA5A
{
	unsigned char s1;   //标识
	float weight;       //吨位
	float depth;        //水深
	float speed;        //航速
	float fre1[2];      //输出频率1-2
	float cy1;          //采样率
	float zy1;          //增益
	float lm1;          //灵敏度
	float num;  //阵元个数
	float ss;           //模拟声纳采样率
	float fre2[2];      //带通滤波频率1-2
	float time1;          //数据起始时刻
	float time2;          //数据总长度
	float zy2;          //模拟增益
	float lm2;          //模拟灵敏度
	float rela[48];     //相关系数48
	unsigned char type1;//仿真类型
	unsigned char type2;//目标类型1:001；2:054A；3:039；4：Y7A;5：Y10
	unsigned char len;  //文件名长度
	unsigned char file[255];//文件名
};//模型5分析用(模型6A通用)

struct DATA5B
{
	unsigned char s1;   //标识
	float weight;       //吨位
	float depth;        //水深
	float speed;        //航速
	float fre1[2];      //输出频率1-2
	float cy1;          //采样率
	float zy1;          //增益
	float lm1;          //灵敏度
	float num1; //阵元个数
	float ss;           //速度对应谱级
	float fre2;         //轴频频率
	float num2; //螺旋桨叶片数
	float xp1[20];      //线谱频率20
	float xp2[20];      //线谱强度20
	float de[20];       //调制深度20
	float rela[48];     //相关系数48
	unsigned char type1;//仿真类型
	unsigned char type2;//目标类型
};//模型5仿真用(模型6B通用)


struct DATA7
{
	unsigned char s1;    //标识
	unsigned char seacon;//海况
	float wspeed;        //海面风速
	float fspeed;        //海流速度
	float rain;          //降雨量
	int num1 ;           //每平方千米舰船数
	float len;           //长度
	float speed1[30];    //水面舰典型工况航速数组30
	float speed2[30];    //与航速对应的螺旋桨转速30
	float sspeed;        //螺旋桨末端转速
	float fre;           //中心频率
};//模型7用

struct DATA8
{
	unsigned char s1;   //标识
	float fre;          //中心频率
	float wspeed;       //海面风速
	unsigned char type1;//海底地貌
	unsigned char num1; //海深个数
	float sead[3]; //海深文件[2]表示：垂直深度步长
	float ss1;          //海面反射系数
	float ss2;          //海底衰减系数
	float len1;         //输出距离步长
	float len2;         //最大距离
	int num2;           //射线数量
	float len3;         //收发间距
	unsigned char type2;//海况
	float cord[2];      //发射换能器初始坐标
	unsigned char type3;//发射阵信息
	float ss3;          //发射指向性
	float sn;           //发射声源级
	unsigned char type4;//发射信号形式
	float dep;          //接收深度
	unsigned char type5;//接收阵信息
	float frew[2];      //工作频段2
	int num3;           //计算频率点数
	unsigned char type6; //海底底质类型
};//模型8用
 struct rModel8
 {
	 unsigned char id;//1
	 float up;//上限
	 float down;// 下线
	 int namelen;//文件名长度
	 char name[50];//噪声功率谱数据文件名
	 unsigned char data[1000];//噪声功率谱
 };

 struct OUTPUT1
 {
	 unsigned char s1;//标识2/*2：仿真的冲击，3：仿真传播损失，4：声传播分析，5：海洋环境分析*/
	 unsigned char len1;//file length/
	 unsigned char name1[50];
	 unsigned char len2;//file length
	 unsigned char name2[50];
	 unsigned char data[1000];//冲击响应函数/传播损失

 };//模型8输出2


 struct DATA8_1
 {
	 unsigned char s1;
	 unsigned char s2[2];
	 unsigned char len;//海底反射长度，当前为1
	 float data[4];//海底反射系数
 };

 struct DATA8_2
 {
	 unsigned char s1;
	 unsigned char s2[2];
	 unsigned char len;//海底底质长度，当前为1
	 float data[8];//海底底质
 };

 struct DATA8_3
 {
	 unsigned char s1;
	 unsigned char s2[2];
	 int len;//水平不变声速剖面长度，当前为5
	 float data[100][2];//声速剖面
 };

 struct DATA8B/*分析方式下发送文件名*/
 {
	 unsigned char s1;//=5
	 unsigned char namelen1;
	 unsigned char name1[50];/**/
	 unsigned char namelen2;
	 unsigned char name2[50];/**/
 };

JNIEXPORT void JNICALL Java_com_platform_jni_Model_model1
  (JNIEnv *env, jobject obj1, jobject obj2){
  	struct DATA1 data2;
	int len;
	int i,j;

	jclass class = (*env)->GetObjectClass(env,obj2);//获得class
	printf("get class right\n");
	/*获取char开始 s1*/
	jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
	jchar s1 = (*env)->GetCharField(env,obj2,s1id);
	data2.s1 = s1-'0';
	/*获取char结束*/

	/*获取float开始 speed 修改为speed float[30]*/ 
	// jfieldID speedid = (*env)->GetFieldID(env,class,"speed","F");
	// jfloat speed = (*env)->GetFloatField(env,obj2,speedid);
	// data2.speed = speed;
	// printf("%f\n",speed);
	/*获取float结束*/


	/*获得float数组开始 speed30*/
	jfieldID speedid = (*env)->GetFieldID(env,class,"speed","[F");//获得属性
	jfloatArray  speedarray = (jfloatArray)(*env)->GetObjectField(env,obj2,speedid);//获得参数值
	len = (*env)->GetArrayLength(env,speedarray);
	jfloat speed[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,speedarray,0,len,speed);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",speed[i]);
	        data2.speed[i] = speed[i];
	}
	/*获得float数组结束*/

	/*获取float开始 ang*/
	jfieldID angid = (*env)->GetFieldID(env,class,"ang","F");
	jfloat ang = (*env)->GetFloatField(env,obj2,angid);
	data2.ang = ang;
	printf("%f\n",ang);
	/*获取float结束*/

	/*获取float开始 fre*/
	jfieldID freid = (*env)->GetFieldID(env,class,"fre","F");
	jfloat fre = (*env)->GetFloatField(env,obj2,freid);
	data2.fre = fre;
	printf("%f\n",fre);
	/*获取float结束*/

	/*获取float开始 bre*/
	jfieldID breid = (*env)->GetFieldID(env,class,"bre","F");
	jfloat bre = (*env)->GetFloatField(env,obj2,breid);
	data2.bre = bre;
	printf("%f\n",bre);
	/*获取float结束*/

	/*获取float开始 cre*/
	jfieldID creid = (*env)->GetFieldID(env,class,"cre","F");
	jfloat cre = (*env)->GetFloatField(env,obj2,creid);
	data2.cre = cre;
	printf("%f\n",cre);
	/*获取float结束*/

	/*获取float开始 distence*/
	jfieldID distenceid = (*env)->GetFieldID(env,class,"distence","F");
	jfloat distence = (*env)->GetFloatField(env,obj2,distenceid);
	data2.distence = distence;
	printf("%f\n",distence);
	/*获取float结束*/

	/*获取float开始 ang1*/
	jfieldID ang1id = (*env)->GetFieldID(env,class,"ang1","F");
	jfloat ang1 = (*env)->GetFloatField(env,obj2,ang1id);
	data2.ang1 = ang1;
	printf("%f\n",ang1);
	/*获取float结束*/

	/*获取float开始 ang2*/
	jfieldID ang2id = (*env)->GetFieldID(env,class,"ang2","F");
	jfloat ang2 = (*env)->GetFloatField(env,obj2,ang2id);
	data2.ang2 = ang2;
	printf("%f\n",ang2);
	/*获取float结束*/

	/*获取float开始 time*/
	jfieldID timeid = (*env)->GetFieldID(env,class,"time","F");
	jfloat ftime = (*env)->GetFloatField(env,obj2,timeid);
	data2.time = ftime;
	printf("%f\n",ang2);
	/*获取float结束*/

	/*获取float开始 cy1*/
	jfieldID cy1id = (*env)->GetFieldID(env,class,"cy1","F");
	jfloat cy1 = (*env)->GetFloatField(env,obj2,cy1id);
	data2.cy1 = cy1;
	printf("%f\n",cy1);
	/*获取float结束*/

	/*获取float开始 ss*/
	jfieldID ssid = (*env)->GetFieldID(env,class,"ss","F");
	jfloat ss = (*env)->GetFloatField(env,obj2,ssid);
	data2.ss = ss;
	printf("%f\n",ss);
	/*获取float结束*/

	/*获取float开始 ang3*/
	jfieldID ang3id = (*env)->GetFieldID(env,class,"ang3","F");
	jfloat ang3 = (*env)->GetFloatField(env,obj2,ang3id);
	data2.ang3 = ang3;
	printf("%f\n",ang3);
	/*获取float结束*/

	/*获取float开始 ang4*/
	jfieldID ang4id = (*env)->GetFieldID(env,class,"ang4","F");
	jfloat ang4 = (*env)->GetFloatField(env,obj2,ang4id);
	data2.ang4 = ang4;
	printf("%f\n",ang4);
	/*获取float结束*/

	/*获取char开始 type1*/
	jfieldID type1id = (*env)->GetFieldID(env,class,"type1","C");
	jchar type1 = (*env)->GetCharField(env,obj2,type1id);
	data2.type1 = type1-'0';
	/*获取char结束*/

	/*获取char开始 type2*/
	jfieldID type2id = (*env)->GetFieldID(env,class,"type2","C");
	jchar type2 = (*env)->GetCharField(env,obj2,type2id);
	data2.type2 = type2-'0';
	/*获取char结束*/

	/*获取char开始 type3*/
	jfieldID type3id = (*env)->GetFieldID(env,class,"type3","C");
	jchar type3 = (*env)->GetCharField(env,obj2,type3id);
	data2.type3 = type3-'0';
	/*获取char结束*/

	/*获取char开始 len1*/
	jfieldID len1id = (*env)->GetFieldID(env,class,"len1","C");
	jchar len1 = (*env)->GetCharField(env,obj2,len1id);
	data2.len1 = len1-'0';
	/*获取char结束*/

	/*获取char开始 len2*/
	jfieldID len2id = (*env)->GetFieldID(env,class,"len2","C");
	jchar len2 = (*env)->GetCharField(env,obj2,len2id);
	data2.len2 = len2-'0';
	/*获取char结束*/

	/*获得char数组开始 file1*/
	jfieldID file1id = (*env)->GetFieldID(env,class,"file1","[C");//获得属性
	jcharArray  file1array = (jcharArray)(*env)->GetObjectField(env,obj2,file1id);//获得参数值
	len = (*env)->GetArrayLength(env,file1array);
	jchar file1[len];//char数组
	(*env)->GetCharArrayRegion(env,file1array,0,len,file1);
    for( i = 0 ;i<len1-'0';i++){
            printf("%c\n",file1[i]);
            data2.file1[i] = file1[i];
    }
	/*获得char数组结束*/

    /*获得char数组开始 file2*/
	jfieldID file2id = (*env)->GetFieldID(env,class,"file2","[C");//获得属性
	jcharArray  file2array = (jcharArray)(*env)->GetObjectField(env,obj2,file2id);//获得参数值
	len = (*env)->GetArrayLength(env,file2array);
	jchar file2[len];//char数组
	(*env)->GetCharArrayRegion(env,file2array,0,len,file2);
    for( i = 0 ;i<len2-'0';i++){
            printf("%c\n",file2[i]);
            data2.file2[i] = file2[i];
    }
	/*获得char数组结束*/

	/**发送开始**/

	struct sockaddr_in out;

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr("192.168.220.11");


	int s;

	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	int flag = sendto(s,(char*)&data2,sizeof(data2),0,(struct sockaddr *)&out,len);
	if(flag == -1){
	printf("socket wrong!\n");
	}
	close(s);
	/**发送结束**/
  }


JNIEXPORT void JNICALL Java_com_platform_jni_Model_model2
  (JNIEnv *env, jobject obj1, jobject obj2){
  	struct DATA2 data2;
	int len;
	int i,j;

	jclass class = (*env)->GetObjectClass(env,obj2);//获得class
	printf("get class right\n");
	/*获取char开始 s1*/
	jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
	jchar s1 = (*env)->GetCharField(env,obj2,s1id);
	data2.s1 = s1-'0';
	/*获取char结束*/

	/*获取char开始 s2*/
	jfieldID s2id = (*env)->GetFieldID(env,class,"s2","C");
	jchar s2 = (*env)->GetCharField(env,obj2,s2id);
	data2.s2 = s2-'0';
	/*获取char结束*/

	/*获取float开始 speed1*/
	jfieldID speed1id = (*env)->GetFieldID(env,class,"speed1","F");
	jfloat speed1 = (*env)->GetFloatField(env,obj2,speed1id);
	data2.speed1 = speed1;
	printf("%f\n",speed1);
	/*获取float结束*/

	/*获取float开始 speed2*/
	jfieldID speed2id = (*env)->GetFieldID(env,class,"speed2","F");
	jfloat speed2 = (*env)->GetFloatField(env,obj2,speed2id);
	data2.speed2 = speed2;
	/*获取float结束*/

	/*获取float开始 jz*/
	jfieldID jzid = (*env)->GetFieldID(env,class,"jz","F");
	jfloat jz = (*env)->GetFloatField(env,obj2,jzid);
	data2.jz = jz;
	/*获取float结束*/
	

	/*获得float数组开始 d1*/
	jfieldID d1id = (*env)->GetFieldID(env,class,"d1","[F");//获得属性
	jfloatArray  d1array = (jfloatArray)(*env)->GetObjectField(env,obj2,d1id);//获得参数值
	len = (*env)->GetArrayLength(env,d1array);
	jfloat d1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,d1array,0,len,d1);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",d1[i]);
	        data2.d1[i] = d1[i];
	}
	/*获得float数组结束*/


	/*获得float数组结束 d2*/
	jfieldID d2id = (*env)->GetFieldID(env,class,"d2","[F");//获得属性
	jfloatArray  d2array = (jfloatArray)(*env)->GetObjectField(env,obj2,d2id);//获得参数值
	len = (*env)->GetArrayLength(env,d2array);
	jfloat d2[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,d2array,0,len,d2);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",d2[i]);
	        data2.d2[i] = d2[i];
	}
	/*获得float数组结束*/

	/*获取float开始 num1*/
	jfieldID num1id = (*env)->GetFieldID(env,class,"num1","F");
	jfloat num1 = (*env)->GetFloatField(env,obj2,num1id);
	data2.num1 = num1;
	/*获取float结束*/

	/*获取float开始 pu1*/
	jfieldID pu1id = (*env)->GetFieldID(env,class,"pu1","F");
	jfloat pu1 = (*env)->GetFloatField(env,obj2,pu1id);
	data2.pu1 = pu1;
	/*获取float结束*/

	/*获取float开始 pu2*/
	jfieldID pu2id = (*env)->GetFieldID(env,class,"pu2","F");
	jfloat pu2 = (*env)->GetFloatField(env,obj2,pu2id);
	data2.pu2 = pu2;
	/*获取float结束*/


	/*获得float数组开始 wind*/
	jfieldID fwind = (*env)->GetFieldID(env,class,"wind","[F");//获得属性
	jfloatArray  awind = (jfloatArray)(*env)->GetObjectField(env,obj2,fwind);//获得参数值
	len = (*env)->GetArrayLength(env,awind);
	jfloat wind[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,awind,0,len,wind);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",wind[i]);
	        data2.wind[i] = wind[i];
	}
	/*获得float数组结束*/

	/*获得float数组开始 fspeed*/
	jfieldID fspeedid = (*env)->GetFieldID(env,class,"fspeed","[F");//获得属性
	jfloatArray  fspeedarray = (jfloatArray)(*env)->GetObjectField(env,obj2,fspeedid);//获得参数值
	len = (*env)->GetArrayLength(env,fspeedarray);
	jfloat fspeed[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,fspeedarray,0,len,fspeed);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",fspeed[i]);
	        data2.fspeed[i] = fspeed[i];
	}
	/*获得float数组结束*/

	/*获取float开始 depth*/
	jfieldID depthid = (*env)->GetFieldID(env,class,"depth","F");
	jfloat depth = (*env)->GetFloatField(env,obj2,depthid);
	data2.depth = depth;
	/*获取float结束*/

	/*获取float开始 speed3*/
	jfieldID speed3id = (*env)->GetFieldID(env,class,"speed3","F");
	jfloat speed3 = (*env)->GetFloatField(env,obj2,speed3id);
	data2.speed3 = speed3;
	/*获取float结束*/

	/*获得float数组结束 d3*/
	jfieldID d3id = (*env)->GetFieldID(env,class,"d3","[F");//获得属性
	jfloatArray  d3array = (jfloatArray)(*env)->GetObjectField(env,obj2,d3id);//获得参数值
	len = (*env)->GetArrayLength(env,d3array);
	jfloat d3[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,d3array,0,len,d3);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",d3[i]);
	        data2.d3[i] = d3[i];
	}
	/*获得float数组结束*/

	/*获取float开始 pu3*/
	jfieldID pu3id = (*env)->GetFieldID(env,class,"pu3","F");
	jfloat pu3 = (*env)->GetFloatField(env,obj2,pu3id);
	data2.pu3 = pu3;
	/*获取float结束*/

	/*获取float开始 pu4*/
	jfieldID pu4id = (*env)->GetFieldID(env,class,"pu4","F");
	jfloat pu4 = (*env)->GetFloatField(env,obj2,pu4id);
	data2.pu4 = pu4;
	/*获取float结束*/

	/*获取float开始 num2*/
	jfieldID num2id = (*env)->GetFieldID(env,class,"num2","F");
	jfloat num2 = (*env)->GetFloatField(env,obj2,num2id);
	data2.num2 = num2;
	/*获取float结束*/


	/*获得float数组开始 ang1*/
	jfieldID ang1id = (*env)->GetFieldID(env,class,"ang1","[F");//获得属性
	jfloatArray  ang1array = (jfloatArray)(*env)->GetObjectField(env,obj2,ang1id);//获得参数值
	len = (*env)->GetArrayLength(env,ang1array);
	jfloat ang1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,ang1array,0,len,ang1);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",ang1[i]);
	        data2.ang1[i] = ang1[i];
	}
	/*获得float数组结束*/


	/*获得float数组结束 ang2*/
	jfieldID ang2id = (*env)->GetFieldID(env,class,"ang2","[F");//获得属性
	jfloatArray  ang2array = (jfloatArray)(*env)->GetObjectField(env,obj2,ang2id);//获得参数值
	len = (*env)->GetArrayLength(env,ang2array);
	jfloat ang2[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,ang2array,0,len,ang2);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",ang2[i]);
	        data2.ang2[i] = ang2[i];
	}
	/*获得float数组结束*/

	/*获得float数组结束 ang3*/
	jfieldID ang3id = (*env)->GetFieldID(env,class,"ang3","[F");//获得属性
	jfloatArray  ang3array = (jfloatArray)(*env)->GetObjectField(env,obj2,ang3id);//获得参数值
	len = (*env)->GetArrayLength(env,ang3array);
	jfloat ang3[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,ang3array,0,len,ang3);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",ang3[i]);
	        data2.ang3[i] = ang3[i];
	}
	/*获得float数组结束*/

	/*获得float数组结束 ang4*/
	jfieldID ang4id = (*env)->GetFieldID(env,class,"ang4","[F");//获得属性
	jfloatArray  ang4array = (jfloatArray)(*env)->GetObjectField(env,obj2,ang4id);//获得参数值
	len = (*env)->GetArrayLength(env,ang4array);
	jfloat ang4[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,ang4array,0,len,ang4);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",ang4[i]);
	        data2.ang4[i] = ang4[i];
	}
	/*获得float数组结束*/

	/*获取float开始 num2*/
	jfieldID ssid = (*env)->GetFieldID(env,class,"ss","F");
	jfloat ss = (*env)->GetFloatField(env,obj2,ssid);
	data2.ss = ss;
	/*获取float结束*/
	
	/*获得float数组结束 loc*/
	jfieldID locid = (*env)->GetFieldID(env,class,"loc","[F");//获得属性
	jfloatArray  locarray = (jfloatArray)(*env)->GetObjectField(env,obj2,locid);//获得参数值
	len = (*env)->GetArrayLength(env,locarray);
	jfloat loc[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,locarray,0,len,loc);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",loc[i]);
	        data2.loc[i] = loc[i];
	}
	/*获得float数组结束*/

	/*获得float数组结束 speed*/
	jfieldID speedid = (*env)->GetFieldID(env,class,"speed","[F");//获得属性
	jfloatArray  speedarray = (jfloatArray)(*env)->GetObjectField(env,obj2,speedid);//获得参数值
	len = (*env)->GetArrayLength(env,speedarray);
	jfloat speed[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,speedarray,0,len,speed);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",speed[i]);
	        data2.speed[i] = speed[i];
	}
	/*获得float数组结束*/


	/*获取float开始 lm1*/
	jfieldID lm1id = (*env)->GetFieldID(env,class,"lm1","F");
	jfloat lm1 = (*env)->GetFloatField(env,obj2,lm1id);
	data2.lm1 = lm1;
	/*获取float结束*/


	/*获取float开始 cy1*/
	jfieldID cy1id = (*env)->GetFieldID(env,class,"cy1","F");
	jfloat cy1 = (*env)->GetFloatField(env,obj2,cy1id);
	data2.cy1 = cy1;
	/*获取float结束*/

	/*获得float数组开始 fre1*/
	jfieldID fre1id = (*env)->GetFieldID(env,class,"fre1","[F");//获得属性
	jfloatArray  fre1array = (jfloatArray)(*env)->GetObjectField(env,obj2,fre1id);//获得参数值
	len = (*env)->GetArrayLength(env,fre1array);
	jfloat fre1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,fre1array,0,len,fre1);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",fre1[i]);
	        data2.fre1[i] = fre1[i];
	}
	/*获得float数组结束*/

	/*获得float数组开始 dk1*/
	jfieldID dk1id = (*env)->GetFieldID(env,class,"dk1","[F");//获得属性
	jfloatArray  dk1array = (jfloatArray)(*env)->GetObjectField(env,obj2,dk1id);//获得参数值
	len = (*env)->GetArrayLength(env,dk1array);
	jfloat dk1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,dk1array,0,len,dk1);
	for( i = 0 ;i<len;i++){
	        printf("%f\n",dk1[i]);
	        data2.dk1[i] = dk1[i];
	}
	/*获得float数组结束*/
	
	/*获取float开始 mk1*/
	jfieldID mk1id = (*env)->GetFieldID(env,class,"mk1","F");
	jfloat mk1 = (*env)->GetFloatField(env,obj2,mk1id);
	data2.mk1 = mk1;
	/*获取float结束*/

	/*获得二维float数组开始 slocx*/
	jfieldID fslocx = (*env)->GetFieldID(env,class,"slocx","[[F");//获得属性
	jobjectArray aslocx = (jobjectArray)(*env)->GetObjectField(env,obj2,fslocx);//获得参数值
	int aslocx_len = (*env)->GetArrayLength(env,aslocx);
	//printf("aslocx_len%d\n",aslocx_len );
	for( i = 0; i<aslocx_len;i++){
		//printf("slocx x %d\n", i);
		jfloatArray myarray= (jfloatArray)(*env)->GetObjectArrayElement(env,aslocx,i);
		jfloat slocx[3];    //有36行
		(*env)->GetFloatArrayRegion(env,myarray,0,3,slocx);
		int myarray_len = (*env)->GetArrayLength(env,myarray);
		for( j = 0 ;j < myarray_len;j++){  //共有3列
			printf("%f\n",slocx[j]);
			data2.slocx[i][j] = slocx[j];
		}
	}
	/*获得二维float数组结束*/

	/*获取char开始 num*/
	jfieldID numid = (*env)->GetFieldID(env,class,"num","C");
	jchar num = (*env)->GetCharField(env,obj2,numid);
	data2.num = num-'0';
	/*获取char结束*/

	/*获取char开始 type1*/
	jfieldID type1id = (*env)->GetFieldID(env,class,"type1","C");
	jchar type1 = (*env)->GetCharField(env,obj2,type1id);
	data2.type1 = type1-'0';
	/*获取char结束*/

	/*获得char数组开始 type2*/
	jfieldID type2id = (*env)->GetFieldID(env,class,"type2","[C");//获得属性
	jcharArray  type2array = (jcharArray)(*env)->GetObjectField(env,obj2,type2id);//获得参数值
	len = (*env)->GetArrayLength(env,type2array);
	jchar type2[len];//char数组
	(*env)->GetCharArrayRegion(env,type2array,0,len,type2);
    for( i = 0 ;i<len;i++){
            printf("%c\n",type2[i]);
            data2.type2[i] = type2[i]-'0';
    }
	/*获得char数组结束*/
	
	/*获取char开始 len*/
	jfieldID lenid = (*env)->GetFieldID(env,class,"len","C");
	jchar clen = (*env)->GetCharField(env,obj2,lenid);
	data2.len = clen-'0';
	/*获取char结束*/

	/*获得char数组开始 file*/
	jfieldID ffile = (*env)->GetFieldID(env,class,"file","[C");//获得属性
	jcharArray  afile = (jcharArray)(*env)->GetObjectField(env,obj2,ffile);//获得参数值
	len = (*env)->GetArrayLength(env,afile);
	jchar file[len];//char数组
	(*env)->GetCharArrayRegion(env,afile,0,len,file);
    for( i = 0 ;i<clen-'0';i++){
            printf("%c\n",file[i]);
            data2.file[i] = file[i];
    }
	/*获得char数组结束*/

	/**发送开始**/

	struct sockaddr_in out;

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr("192.168.220.11");


	int s;

	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	int flag = sendto(s,(char*)&data2,sizeof(data2),0,(struct sockaddr *)&out,len);
	if(flag == -1){
	printf("socket wrong!\n");
	}
	close(s);
	/**发送结束**/

}



JNIEXPORT void JNICALL Java_com_platform_jni_Model_model3A
(JNIEnv *env, jobject obj1, jobject obj2){
		struct DATA3A data3a;
		int len,i,j;

		jclass class = (*env)->GetObjectClass(env,obj2);//获得class
		/*获取char开始 s1*/
		jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
		jchar s1 = (*env)->GetCharField(env,obj2,s1id);
		printf("%d\n",s1);
		data3a.s1 = s1-'0';
		/*获取char结束*/

		/*获取float开始 weight*/
		jfieldID weightid = (*env)->GetFieldID(env,class,"weight","F");
		jfloat weight = (*env)->GetFloatField(env,obj2,weightid);
		data3a.weight = weight;
		/*获取float结束*/

		/*获取float开始 depth*/
		jfieldID depthid = (*env)->GetFieldID(env,class,"depth","F");
		jfloat depth = (*env)->GetFloatField(env,obj2,depthid);
		data3a.depth = depth;
		/*获取float结束*/

		/*获取float开始 speed*/
		jfieldID speedid = (*env)->GetFieldID(env,class,"speed","F");
		jfloat speed = (*env)->GetFloatField(env,obj2,speedid);
		data3a.speed = speed;
		/*获取float结束*/

		/*获得float数组开始 fre1*/
		jfieldID fre1id = (*env)->GetFieldID(env,class,"fre1","[F");//获得属性
		jfloatArray  fre1array = (jfloatArray)(*env)->GetObjectField(env,obj2,fre1id);//获得参数值
		len = (*env)->GetArrayLength(env,fre1array);
		jfloat fre1[len];//float数组 wind长度为3
		(*env)->GetFloatArrayRegion(env,fre1array,0,len,fre1);

		for( i = 0 ;i<2;i++){
		        printf("%f\n",fre1[i]);
		        data3a.fre1[i] = fre1[i];
		}
		/*获得float数组结束*/

		/*获取float开始 cy1*/
		jfieldID cy1id = (*env)->GetFieldID(env,class,"cy1","F");
		jfloat cy1 = (*env)->GetFloatField(env,obj2,cy1id);
		data3a.cy1 = cy1;
		/*获取float结束*/

		/*获取float开始 zy1*/
		jfieldID zy1id = (*env)->GetFieldID(env,class,"zy1","F");
		jfloat zy1 = (*env)->GetFloatField(env,obj2,zy1id);
		data3a.zy1 = zy1;
		/*获取float结束*/

		/*获取float开始 lm1*/
		jfieldID lm1id = (*env)->GetFieldID(env,class,"lm1","F");
		jfloat lm1 = (*env)->GetFloatField(env,obj2,lm1id);
		data3a.lm1 = lm1;
		/*获取float结束*/

		/*获取float开始 num*/
		jfieldID numid = (*env)->GetFieldID(env,class,"num","F");
		jfloat num = (*env)->GetFloatField(env,obj2,numid);
		data3a.num = num;
		/*获取float结束*/

		/*获取float开始 ss*/
		jfieldID ssid = (*env)->GetFieldID(env,class,"ss","F");
		jfloat ss = (*env)->GetFloatField(env,obj2,ssid);
		data3a.ss = ss;
		/*获取float结束*/


		/*获得float数组开始 fre2*/
		jfieldID fre2id = (*env)->GetFieldID(env,class,"fre2","[F");//获得属性
		jfloatArray  fre2array = (jfloatArray)(*env)->GetObjectField(env,obj2,fre2id);//获得参数值
		len = (*env)->GetArrayLength(env,fre2array);
		jfloat fre2[len];//float数组 wind长度为3
		(*env)->GetFloatArrayRegion(env,fre2array,0,len,fre2);

		for( i = 0 ;i<2;i++){
		        printf("%f\n",fre2[i]);
		        data3a.fre2[i] = fre2[i];
		}
		/*获得float数组结束*/

		/*获取float开始 time1*/
		jfieldID time1id = (*env)->GetFieldID(env,class,"time1","F");
		jfloat time1 = (*env)->GetFloatField(env,obj2,time1id);
		data3a.time1 = time1;
		/*获取float结束*/

		/*获取float开始 time2*/
		jfieldID time2id = (*env)->GetFieldID(env,class,"time2","F");
		jfloat time2 = (*env)->GetFloatField(env,obj2,time2id);
		data3a.time2 = time2;
		/*获取float结束*/

		/*获取float开始 zy2*/
		jfieldID zy2id = (*env)->GetFieldID(env,class,"zy2","F");
		jfloat zy2 = (*env)->GetFloatField(env,obj2,zy2id);
		data3a.zy2 = zy2;
		/*获取float结束*/

		/*获取float开始 lm2*/
		jfieldID lm2id = (*env)->GetFieldID(env,class,"lm2","F");
		jfloat lm2 = (*env)->GetFloatField(env,obj2,lm2id);
		data3a.lm2 = lm2;
		/*获取float结束*/

		/*获取char开始 type1*/
		jfieldID type1id = (*env)->GetFieldID(env,class,"type1","C");
		jchar type1 = (*env)->GetCharField(env,obj2,type1id);
		data3a.type1 = type1-'0';
		/*获取char结束*/

		/*获取char开始 type2*/
		jfieldID type2id = (*env)->GetFieldID(env,class,"type2","C");
		jchar type2 = (*env)->GetCharField(env,obj2,type2id);
		data3a.type2 = type2-'0';
		/*获取char结束*/

		/*获取char开始 len*/
		jfieldID lenid = (*env)->GetFieldID(env,class,"len","C");
		jchar lenf = (*env)->GetCharField(env,obj2,lenid);
		data3a.len = lenf-'0';
		/*获取char结束*/

		/*获得char数组开始 file*/
		jfieldID ffile = (*env)->GetFieldID(env,class,"file","[C");//获得属性
		jcharArray  afile = (jcharArray)(*env)->GetObjectField(env,obj2,ffile);//获得参数值
		len = (*env)->GetArrayLength(env,afile);
		jchar file[len];//char数组
		(*env)->GetCharArrayRegion(env,afile,0,len,file);
	    for( i = 0 ;i<lenf-'0';i++){
	            printf("%c\n",file[i]);
	            data3a.file[i] = file[i];
	    }
		/*获得char数组结束*/
	    printf("%d\n", sizeof(data3a));
	    data3a.s1 = 1;
	    data3a.len = 18;
	    sprintf(data3a.file,"%s","sig_054A_18knr.bin");
	   
	    /**发送开始**/
		
		struct sockaddr_in out;
	
		memset(&out,0,sizeof(out));
		out.sin_family = AF_INET;
		out.sin_port  = htons(PORT);
		out.sin_addr.s_addr = inet_addr(IP);


		int s;

		len = sizeof(struct sockaddr_in);
		s = socket(AF_INET,SOCK_DGRAM,0);

		if(s == -1){
			printf("can not create socket\n");
		}

		int flag = sendto(s,(char*)&data3a,sizeof(data3a),0,(struct sockaddr *)&out,len);
		if(flag == -1){
			printf("socket wrong!\n");
		}
		close(s);
		/**发送结束**/
	}


JNIEXPORT void JNICALL Java_com_platform_jni_Model_model3B
  (JNIEnv *env, jobject obj1, jobject obj2){
  	struct DATA3B data3b; 
  	int len;
	int i,j;
  	jclass class = (*env)->GetObjectClass(env,obj2);//获得class
	/*获取char开始 s1*/
	jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
	jchar s1 = (*env)->GetCharField(env,obj2,s1id);
	data3b.s1 = s1-'0';
	/*获取char结束*/

	/*获取float开始 weight*/
	jfieldID weightid = (*env)->GetFieldID(env,class,"weight","F");
	jfloat weight = (*env)->GetFloatField(env,obj2,weightid);
	data3b.weight = weight;
	/*获取float结束*/

	/*获取float开始 depth*/
	jfieldID depthid = (*env)->GetFieldID(env,class,"depth","F");
	jfloat depth = (*env)->GetFloatField(env,obj2,depthid);
	data3b.depth = depth;
	/*获取float结束*/

	/*获取float开始 speed*/
	jfieldID speedid = (*env)->GetFieldID(env,class,"speed","F");
	jfloat speed = (*env)->GetFloatField(env,obj2,speedid);
	data3b.speed = speed;
	/*获取float结束*/

	/*获得float数组开始 fre1*/
	jfieldID fre1id = (*env)->GetFieldID(env,class,"fre1","[F");//获得属性
	jfloatArray  fre1array = (jfloatArray)(*env)->GetObjectField(env,obj2,fre1id);//获得参数值
	len = (*env)->GetArrayLength(env,fre1array);
	jfloat fre1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,fre1array,0,len,fre1);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",fre1[i]);
	        data3b.fre1[i] = fre1[i];
	}
	/*获得float数组结束*/

	/*获取float开始 cy1*/
	jfieldID cy1id = (*env)->GetFieldID(env,class,"cy1","F");
	jfloat cy1 = (*env)->GetFloatField(env,obj2,cy1id);
	data3b.cy1 = cy1;
	/*获取float结束*/

	/*获取float开始 zy1*/
	jfieldID zy1id = (*env)->GetFieldID(env,class,"zy1","F");
	jfloat zy1 = (*env)->GetFloatField(env,obj2,zy1id);
	data3b.zy1 = zy1;
	/*获取float结束*/

	/*获取float开始 lm1*/
	jfieldID lm1id = (*env)->GetFieldID(env,class,"lm1","F");
	jfloat lm1 = (*env)->GetFloatField(env,obj2,lm1id);
	data3b.lm1 = lm1;
	/*获取float结束*/

	/*获取float开始 num1*/
	jfieldID num1id = (*env)->GetFieldID(env,class,"num1","F");
	jfloat num1 = (*env)->GetFloatField(env,obj2,num1id);
	data3b.num1 = num1;
	/*获取float结束*/

	/*获取float开始 ss*/
	jfieldID ssid = (*env)->GetFieldID(env,class,"ss","F");
	jfloat ss = (*env)->GetFloatField(env,obj2,ssid);
	data3b.ss = ss;
	/*获取float结束*/

	/*获取float开始 fre2*/
	jfieldID fre2id = (*env)->GetFieldID(env,class,"fre2","F");
	jfloat fre2 = (*env)->GetFloatField(env,obj2,fre2id);
	data3b.fre2 = fre2;
	/*获取float结束*/

	/*获取float开始 num2*/
	jfieldID num2id = (*env)->GetFieldID(env,class,"num2","F");
	jfloat num2 = (*env)->GetFloatField(env,obj2,num2id);
	data3b.num2 = num2;
	/*获取float结束*/

	/*获得float数组开始 xp1*/
	jfieldID xp1id = (*env)->GetFieldID(env,class,"xp1","[F");//获得属性
	jfloatArray  xp1array = (jfloatArray)(*env)->GetObjectField(env,obj2,xp1id);//获得参数值
	len = (*env)->GetArrayLength(env,xp1array);
	printf("xp1 length %d\n", len);
	jfloat xp1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,xp1array,0,len,xp1);
	
	for( i = 0 ;i<len;i++){
	        printf("xp1 id is %f\n",xp1[i]);
	        data3b.xp1[i] = xp1[i];
	}
	/*获得float数组结束*/

	/*获得float数组开始 xp2*/
	jfieldID xp2id = (*env)->GetFieldID(env,class,"xp2","[F");//获得属性
	jfloatArray  xp2array = (jfloatArray)(*env)->GetObjectField(env,obj2,xp2id);//获得参数值
	len = (*env)->GetArrayLength(env,xp2array);
	printf("xp2 length %d\n", len);
	jfloat xp2[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,xp2array,0,len,xp2);
	
	for( i = 0 ;i<len;i++){
	        printf("xp2 id is %f\n",xp2[i]);
	        data3b.xp2[i] = xp2[i];
	}
	/*获得float数组结束*/

	/*获得float数组开始 de*/
	jfieldID deid = (*env)->GetFieldID(env,class,"de","[F");//获得属性
	jfloatArray  dearray = (jfloatArray)(*env)->GetObjectField(env,obj2,deid);//获得参数值
	len = (*env)->GetArrayLength(env,dearray);
	printf("de length %d\n", len);
	jfloat de[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,dearray,0,len,de);
	
	for( i = 0 ;i<len;i++){
	        printf("de is %f\n",de[i]);
	        data3b.de[i] = de[i];
	}
	/*获得float数组结束*/

	/*获取char开始 type1*/
	jfieldID type1id = (*env)->GetFieldID(env,class,"type1","C");
	jchar type1 = (*env)->GetCharField(env,obj2,type1id);
	printf("jchar type1 is %c\n",type1);
	printf("jchar type1 is %d\n",(int)type1);
	data3b.type1 = type1-'0';
	/*获取char结束*/

	/*获取char开始 type2*/
	jfieldID type2id = (*env)->GetFieldID(env,class,"type2","C");
	jchar type2 = (*env)->GetCharField(env,obj2,type2id);
	data3b.type2 = type2-'0';
	/*获取char结束*/
	
	/*获取int开始 code*/
	jfieldID codeid = (*env)->GetFieldID(env,class,"code","I");
	jint code = (*env)->GetIntField(env,obj2,codeid);
	data3b.code = code;
	/*获取int结束*/

    /**发送开始**/
	data3b.s1 = 2;

	printf("%d\n", sizeof(data3b));
	printf("s1 is %d\n", data3b.s1);
	printf("print data3b=========\n");
	printf("weight is %f\n", data3b.weight);
	printf("depth is %f\n", data3b.depth);
	printf("speed is %f\n", data3b.speed);
	printf("fre is %f%f\n", data3b.fre1[0],data3b.fre1[1]);
	printf("cy1 is %f\n", data3b.cy1);
	printf("zy1 is %f\n", data3b.zy1);
	printf("lm1 is %f\n", data3b.lm1);
	printf("num1 is %f\n", data3b.num1);
	printf("num2 is %f\n", data3b.num2);
	printf("ss is %f\n", data3b.ss);
	printf("fre2 is %f\n", data3b.fre2);
	printf("type1 is %c\n", data3b.type1);
	printf("type2 is %c\n", data3b.type2);


	struct sockaddr_in out;

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr(IP);


	int s;

	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
		printf("can not create socket\n");
	}

	int flag = sendto(s,(char*)&data3b,sizeof(data3b),0,(struct sockaddr *)&out,len);
	if(flag == -1){
		printf("socket wrong!\n");
	}

	close(s);
	/**发送结束**/

  }



JNIEXPORT void JNICALL Java_com_platform_jni_Model_model5A
  (JNIEnv *env, jobject obj1, jobject obj2){
  	struct DATA5A data5a; 
  	int len;
	int i,j;
  	jclass class = (*env)->GetObjectClass(env,obj2);//获得class
	/*获取char开始 s1*/
	jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
	jchar s1 = (*env)->GetCharField(env,obj2,s1id);
	data5a.s1 = s1;
	/*获取char结束*/

	/*获取float开始 weight*/
	jfieldID weightid = (*env)->GetFieldID(env,class,"weight","F");
	jfloat weight = (*env)->GetFloatField(env,obj2,weightid);
	data5a.weight = weight;
	/*获取float结束*/

	/*获取float开始 depth*/
	jfieldID depthid = (*env)->GetFieldID(env,class,"depth","F");
	jfloat depth = (*env)->GetFloatField(env,obj2,depthid);
	data5a.depth = depth;
	/*获取float结束*/

	/*获取float开始 speed*/
	jfieldID speedid = (*env)->GetFieldID(env,class,"speed","F");
	jfloat speed = (*env)->GetFloatField(env,obj2,speedid);
	data5a.speed = speed;
	/*获取float结束*/

	/*获得float数组开始 fre1*/
	jfieldID fre1id = (*env)->GetFieldID(env,class,"fre1","[F");//获得属性
	jfloatArray  fre1array = (jfloatArray)(*env)->GetObjectField(env,obj2,fre1id);//获得参数值
	len = (*env)->GetArrayLength(env,fre1array);
	jfloat fre1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,fre1array,0,len,fre1);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",fre1[i]);
	        data5a.fre1[i] = fre1[i];
	}
	/*获得float数组结束*/

	/*获取float开始 cy1*/
	jfieldID cy1id = (*env)->GetFieldID(env,class,"cy1","F");
	jfloat cy1 = (*env)->GetFloatField(env,obj2,cy1id);
	data5a.cy1 = cy1;
	/*获取float结束*/

	/*获取float开始 zy1*/
	jfieldID zy1id = (*env)->GetFieldID(env,class,"zy1","F");
	jfloat zy1 = (*env)->GetFloatField(env,obj2,zy1id);
	data5a.zy1 = zy1;
	/*获取float结束*/

	/*获取float开始 lm1*/
	jfieldID lm1id = (*env)->GetFieldID(env,class,"lm1","F");
	jfloat lm1 = (*env)->GetFloatField(env,obj2,lm1id);
	data5a.lm1 = lm1;
	/*获取float结束*/

	/*获取float开始 num*/
	jfieldID numid = (*env)->GetFieldID(env,class,"num","F");
	jfloat num = (*env)->GetFloatField(env,obj2,numid);
	data5a.num = num;
	/*获取float结束*/

	/*获取float开始 ss*/
	jfieldID ssid = (*env)->GetFieldID(env,class,"ss","F");
	jfloat ss = (*env)->GetFloatField(env,obj2,ssid);
	data5a.ss = ss;
	/*获取float结束*/

	/*获得float数组开始 fre2*/
	jfieldID fre2id = (*env)->GetFieldID(env,class,"fre2","[F");//获得属性
	jfloatArray  fre2array = (jfloatArray)(*env)->GetObjectField(env,obj2,fre2id);//获得参数值
	len = (*env)->GetArrayLength(env,fre2array);
	jfloat fre2[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,fre2array,0,len,fre2);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",fre2[i]);
	        data5a.fre2[i] = fre2[i];
	}
	/*获得float数组结束*/

	/*获取float开始 time1*/
	jfieldID time1id = (*env)->GetFieldID(env,class,"time1","F");
	jfloat time1 = (*env)->GetFloatField(env,obj2,time1id);
	data5a.time1 = time1;
	/*获取float结束*/

	/*获取float开始 time2*/
	jfieldID time2id = (*env)->GetFieldID(env,class,"time2","F");
	jfloat time2 = (*env)->GetFloatField(env,obj2,time2id);
	data5a.time2 = time2;
	/*获取float结束*/

	/*获取float开始 zy2*/
	jfieldID zy2id = (*env)->GetFieldID(env,class,"zy2","F");
	jfloat zy2 = (*env)->GetFloatField(env,obj2,zy2id);
	data5a.zy2 = zy2;
	/*获取float结束*/

	/*获取float开始 lm2*/
	jfieldID lm2id = (*env)->GetFieldID(env,class,"lm2","F");
	jfloat lm2 = (*env)->GetFloatField(env,obj2,lm2id);
	data5a.lm2 = lm2;
	/*获取float结束*/

	/*获得float数组开始 rela*/
	jfieldID relaid = (*env)->GetFieldID(env,class,"rela","[F");//获得属性
	jfloatArray  relaarray = (jfloatArray)(*env)->GetObjectField(env,obj2,relaid);//获得参数值
	len = (*env)->GetArrayLength(env,relaarray);
	jfloat rela[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,relaarray,0,len,rela);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",rela[i]);
	        data5a.rela[i] = rela[i];
	}
	/*获得float数组结束*/

	/*获取char开始 type1*/
	jfieldID type1id = (*env)->GetFieldID(env,class,"type1","C");
	jchar type1 = (*env)->GetCharField(env,obj2,type1id);
	data5a.type1 = type1-'0';
	/*获取char结束*/

	/*获取char开始 type2*/
	jfieldID type2id = (*env)->GetFieldID(env,class,"type2","C");
	jchar type2 = (*env)->GetCharField(env,obj2,type2id);
	data5a.type2 = type2-'0';
	/*获取char结束*/

	/*获取char开始 len*/
	jfieldID lenid = (*env)->GetFieldID(env,class,"len","C");
	len = (*env)->GetCharField(env,obj2,lenid);
	data5a.len = len-'0';
	/*获取char结束*/

	/*获得char数组开始*/
	jfieldID ffile = (*env)->GetFieldID(env,class,"file","[C");//获得属性
	jcharArray  afile = (jcharArray)(*env)->GetObjectField(env,obj2,ffile);//获得参数值
	//len = (*env)->GetArrayLength(env,afile);
	jchar file[len];//char数组
	(*env)->GetCharArrayRegion(env,afile,0,len,file);
    for( i = 0 ;i<len-'0';i++){
            printf("%c\n",file[i]);
            data5a.file[i] = file[i];
    }
	/*获得char数组结束*/
    data5a.s1 = 1;
    data5a.len = 14;
    sprintf(data5a.file,"%s","sig-054Asn.bin");
	/**发送开始**/

    printf("print 5a\n");
    printf("s1 %d\n", data5a.s1);
    printf("type1 %d\n", data5a.type1);
    printf("type2 %d\n", data5a.type2);
    printf("len %d\n", data5a.len);
    printf("sizeof data5a %d\n", sizeof(data5a));

	struct sockaddr_in out;

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr(IP);


	int s;

	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	int flag = sendto(s,(char*)&data5a,sizeof(data5a),0,(struct sockaddr *)&out,len);
	if(flag == -1){
	printf("socket wrong!\n");
	}
	close(s);
	/**发送结束**/

  }



  JNIEXPORT void JNICALL Java_com_platform_jni_Model_model5B
  (JNIEnv *env, jobject obj1, jobject obj2){
  	struct DATA5B data5b;
  	int len;
	int i,j; 
  	jclass class = (*env)->GetObjectClass(env,obj2);//获得class
	/*获取char开始 s1*/
	jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
	jchar s1 = (*env)->GetCharField(env,obj2,s1id);
	data5b.s1 = s1-'0';
	/*获取char结束*/

	/*获取float开始 weight*/
	jfieldID weightid = (*env)->GetFieldID(env,class,"weight","F");
	jfloat weight = (*env)->GetFloatField(env,obj2,weightid);
	data5b.weight = weight;
	/*获取float结束*/

	/*获取float开始 depth*/
	jfieldID depthid = (*env)->GetFieldID(env,class,"depth","F");
	jfloat depth = (*env)->GetFloatField(env,obj2,depthid);
	data5b.depth = depth;
	/*获取float结束*/

	/*获取float开始 speed*/
	jfieldID speedid = (*env)->GetFieldID(env,class,"speed","F");
	jfloat speed = (*env)->GetFloatField(env,obj2,speedid);
	data5b.speed = speed;
	/*获取float结束*/

	/*获得float数组开始 fre1*/
	jfieldID fre1id = (*env)->GetFieldID(env,class,"fre1","[F");//获得属性
	jfloatArray  fre1array = (jfloatArray)(*env)->GetObjectField(env,obj2,fre1id);//获得参数值
	len = (*env)->GetArrayLength(env,fre1array);
	jfloat fre1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,fre1array,0,len,fre1);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",fre1[i]);
	        data5b.fre1[i] = fre1[i];
	}
	/*获得float数组结束*/

	/*获取float开始 cy1*/
	jfieldID cy1id = (*env)->GetFieldID(env,class,"cy1","F");
	jfloat cy1 = (*env)->GetFloatField(env,obj2,cy1id);
	data5b.cy1 = cy1;
	/*获取float结束*/

	/*获取float开始 zy1*/
	jfieldID zy1id = (*env)->GetFieldID(env,class,"zy1","F");
	jfloat zy1 = (*env)->GetFloatField(env,obj2,zy1id);
	data5b.zy1 = zy1;
	/*获取float结束*/

	/*获取float开始 lm1*/
	jfieldID lm1id = (*env)->GetFieldID(env,class,"lm1","F");
	jfloat lm1 = (*env)->GetFloatField(env,obj2,lm1id);
	data5b.lm1 = lm1;
	/*获取float结束*/

	/*获取float开始 num1*/
	jfieldID num1id = (*env)->GetFieldID(env,class,"num1","F");
	jfloat num1 = (*env)->GetFloatField(env,obj2,num1id);
	data5b.num1 = num1;
	/*获取float结束*/

	/*获取float开始 ss*/
	jfieldID ssid = (*env)->GetFieldID(env,class,"ss","F");
	jfloat ss = (*env)->GetFloatField(env,obj2,ssid);
	data5b.ss = ss;
	/*获取float结束*/

	/*获取float开始 fre2*/
	jfieldID fre2id = (*env)->GetFieldID(env,class,"fre2","F");
	jfloat fre2 = (*env)->GetFloatField(env,obj2,fre2id);
	data5b.fre2 = fre2;
	/*获取float结束*/

	/*获取float开始 num2*/
	jfieldID num2id = (*env)->GetFieldID(env,class,"num2","F");
	jfloat num2 = (*env)->GetFloatField(env,obj2,num2id);
	data5b.num2 = num2;
	/*获取float结束*/

	/*获得float数组开始 xp1*/
	jfieldID xp1id = (*env)->GetFieldID(env,class,"xp1","[F");//获得属性
	jfloatArray  xp1array = (jfloatArray)(*env)->GetObjectField(env,obj2,xp1id);//获得参数值
	len = (*env)->GetArrayLength(env,xp1array);
	jfloat xp1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,xp1array,0,len,xp1);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",xp1[i]);
	        data5b.xp1[i] = xp1[i];
	}
	/*获得float数组结束*/

	/*获得float数组开始 xp2*/
	jfieldID xp2id = (*env)->GetFieldID(env,class,"xp2","[F");//获得属性
	jfloatArray  xp2array = (jfloatArray)(*env)->GetObjectField(env,obj2,xp2id);//获得参数值
	len = (*env)->GetArrayLength(env,xp2array);
	jfloat xp2[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,xp2array,0,len,xp2);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",xp2[i]);
	        data5b.xp2[i] = xp2[i];
	}
	/*获得float数组结束*/

	/*获得float数组开始 de*/
	jfieldID deid = (*env)->GetFieldID(env,class,"de","[F");//获得属性
	jfloatArray  dearray = (jfloatArray)(*env)->GetObjectField(env,obj2,deid);//获得参数值
	len = (*env)->GetArrayLength(env,dearray);
	jfloat de[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,dearray,0,len,de);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",de[i]);
	        data5b.de[i] = de[i];
	}
	/*获得float数组结束*/

	/*获得float数组开始 rela*/
	jfieldID relaid = (*env)->GetFieldID(env,class,"rela","[F");//获得属性
	jfloatArray  relaarray = (jfloatArray)(*env)->GetObjectField(env,obj2,relaid);//获得参数值
	len = (*env)->GetArrayLength(env,relaarray);
	jfloat rela[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,relaarray,0,len,rela);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",rela[i]);
	        data5b.rela[i] = rela[i];
	}
	/*获得float数组结束*/

	/*获取char开始 type1*/
	jfieldID type1id = (*env)->GetFieldID(env,class,"type1","C");
	jchar type1 = (*env)->GetCharField(env,obj2,type1id);
	data5b.type1 = type1-'0';
	/*获取char结束*/

	/*获取char开始 type2*/
	jfieldID type2id = (*env)->GetFieldID(env,class,"type2","C");
	jchar type2 = (*env)->GetCharField(env,obj2,type2id);
	data5b.type2 = type2-'0';
	/*获取char结束*/
	data5b.s1 = 2;
	/**发送开始**/

	struct sockaddr_in out;

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr(IP);


	int s;

	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	int flag = sendto(s,(char*)&data5b,sizeof(data5b),0,(struct sockaddr *)&out,len);
	if(flag == -1){
	printf("socket wrong!\n");
	}
	close(s);
	/**发送结束**/
  }



  JNIEXPORT void JNICALL Java_com_platform_jni_Model_model7
(JNIEnv *env, jobject obj1, jobject obj2){
  	struct DATA7 data7; 
  	int len;
	int i,j;
  	jclass class = (*env)->GetObjectClass(env,obj2);//获得class
	/*获取char开始 s1*/
	jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
	jchar s1 = (*env)->GetCharField(env,obj2,s1id);
	data7.s1 = s1-'0';
	/*获取char结束*/

	/*获取char开始 seacon*/
	jfieldID seaconid = (*env)->GetFieldID(env,class,"seacon","C");
	jchar seacon = (*env)->GetCharField(env,obj2,seaconid);
	data7.seacon = seacon-'0';
	/*获取char结束*/

	/*获取float开始 wspeed*/
	jfieldID wspeedid = (*env)->GetFieldID(env,class,"wspeed","F");
	jfloat wspeed = (*env)->GetFloatField(env,obj2,wspeedid);
	data7.wspeed = wspeed;
	/*获取float结束*/

	/*获取float开始 fspeed*/
	jfieldID fspeedid = (*env)->GetFieldID(env,class,"fspeed","F");
	jfloat fspeed = (*env)->GetFloatField(env,obj2,fspeedid);
	data7.fspeed = fspeed;
	/*获取float结束*/

	/*获取float开始 rain*/
	jfieldID rainid = (*env)->GetFieldID(env,class,"rain","F");
	jfloat rain = (*env)->GetFloatField(env,obj2,rainid);
	data7.rain = rain;
	/*获取float结束*/

	/*获取float开始 num1*/
	jfieldID num1id = (*env)->GetFieldID(env,class,"num1","I");
	jint num1 = (*env)->GetIntField(env,obj2,num1id);
	data7.num1 = num1;
	/*获取float结束*/

	/*获取float开始 lenth*/
	jfieldID lenid = (*env)->GetFieldID(env,class,"lenth","F");
	jfloat jlen = (*env)->GetFloatField(env,obj2,lenid);
	data7.len = jlen;
	/*获取float结束*/

	/*获得float数组开始 speed1*/
	jfieldID speed1id = (*env)->GetFieldID(env,class,"speed1","[F");//获得属性
	jfloatArray  speed1array = (jfloatArray)(*env)->GetObjectField(env,obj2,speed1id);//获得参数值
	len = (*env)->GetArrayLength(env,speed1array);
	jfloat speed1[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,speed1array,0,len,speed1);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",speed1[i]);
	        data7.speed1[i] = speed1[i];
	}
	/*获得float数组结束*/

	/*获得float数组开始 speed2*/
	jfieldID speed2id = (*env)->GetFieldID(env,class,"speed2","[F");//获得属性
	jfloatArray  speed2array = (jfloatArray)(*env)->GetObjectField(env,obj2,speed2id);//获得参数值
	len = (*env)->GetArrayLength(env,speed2array);
	jfloat speed2[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,speed2array,0,len,speed2);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",speed2[i]);
	        data7.speed2[i] = speed2[i];
	}
	/*获得float数组结束*/

	/*获取float开始 sspeed*/
	jfieldID sspeedid = (*env)->GetFieldID(env,class,"sspeed","F");
	jfloat sspeed = (*env)->GetFloatField(env,obj2,sspeedid);
	data7.sspeed = sspeed;
	/*获取float结束*/

	/*获取float开始 fre*/
	jfieldID freid = (*env)->GetFieldID(env,class,"fre","F");
	jfloat fre = (*env)->GetFloatField(env,obj2,freid);
	data7.fre = fre;
	/*获取float结束*/
	
	data7.s1 = 5;
	printf("seacon %d\n", data7.seacon);
	/**发送开始**/

	struct sockaddr_in out;

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr("192.168.220.16");


	int s;

	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	int flag = sendto(s,(char*)&data7,sizeof(data7),0,(struct sockaddr *)&out,len);
	if(flag == -1){
	printf("socket wrong!\n");
	}
	close(s);
	/**发送结束**/
  }



  JNIEXPORT void JNICALL Java_com_platform_jni_Model_model8
  (JNIEnv *env, jobject obj1, jobject obj2){
  	struct DATA8 data8; 
  	int len;
	int i,j;
  	jclass class = (*env)->GetObjectClass(env,obj2);//获得class
	/*获取char开始 s1*/
	jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
	jchar s1 = (*env)->GetCharField(env,obj2,s1id);
	data8.s1 = s1-'0';
	/*获取char结束*/

	/*获取float开始 fre*/
	jfieldID freid = (*env)->GetFieldID(env,class,"fre","F");
	jfloat fre = (*env)->GetFloatField(env,obj2,freid);
	data8.fre = fre;
	/*获取float结束*/

	/*获取float开始 wspeed*/
	jfieldID wspeedid = (*env)->GetFieldID(env,class,"wspeed","F");
	jfloat wspeed = (*env)->GetFloatField(env,obj2,wspeedid);
	data8.wspeed = wspeed;
	/*获取float结束*/

	/*获取char开始 type1*/
	jfieldID type1id = (*env)->GetFieldID(env,class,"type1","C");
	jchar type1 = (*env)->GetCharField(env,obj2,type1id);
	data8.type1 = type1-'0';
	/*获取char结束*/

	/*获取char开始 num1*/
	jfieldID num1id = (*env)->GetFieldID(env,class,"num1","C");
	jchar num1 = (*env)->GetCharField(env,obj2,num1id);
	data8.num1 = num1-'0';
	/*获取char结束*/

	/*获得float数组开始 sead*/
	jfieldID seadid = (*env)->GetFieldID(env,class,"sead","[F");//获得属性
	jfloatArray  seadarray = (jfloatArray)(*env)->GetObjectField(env,obj2,seadid);//获得参数值
	len = (*env)->GetArrayLength(env,seadarray);
	jfloat sead[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,seadarray,0,len,sead);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",sead[i]);
	        data8.sead[i] = sead[i];
	}
	/*获得float数组结束*/

	/*获取float开始 ss1*/
	jfieldID ss1id = (*env)->GetFieldID(env,class,"ss1","F");
	jfloat ss1 = (*env)->GetFloatField(env,obj2,ss1id);
	data8.ss1 = ss1;
	/*获取float结束*/

	/*获取float开始 ss2*/
	jfieldID ss2id = (*env)->GetFieldID(env,class,"ss2","F");
	jfloat ss2 = (*env)->GetFloatField(env,obj2,ss2id);
	data8.ss2 = ss2;
	/*获取float结束*/

	/*获取float开始 len1*/
	jfieldID len1id = (*env)->GetFieldID(env,class,"len1","F");
	jfloat len1 = (*env)->GetFloatField(env,obj2,len1id);
	data8.len1 = len1;
	/*获取float结束*/

	/*获取float开始 len2*/
	jfieldID len2id = (*env)->GetFieldID(env,class,"len2","F");
	jfloat len2 = (*env)->GetFloatField(env,obj2,len2id);
	data8.len2 = len2;
	/*获取float结束*/

	/*获取int开始 num2*/
	jfieldID num2id = (*env)->GetFieldID(env,class,"num2","I");
	jint num2 = (*env)->GetIntField(env,obj2,num2id);
	data8.num2 = num2;
	/*获取int结束*/

	/*获取float开始 len3*/
	jfieldID len3id = (*env)->GetFieldID(env,class,"len3","F");
	jfloat len3 = (*env)->GetFloatField(env,obj2,len3id);
	data8.len3 = len3;
	/*获取float结束*/

	/*获取char开始 type2*/
	jfieldID type2id = (*env)->GetFieldID(env,class,"type2","C");
	jchar type2 = (*env)->GetCharField(env,obj2,type2id);
	data8.type2 = type2-'0';
	/*获取char结束*/

	/*获得float数组开始 cord*/
	jfieldID cordid = (*env)->GetFieldID(env,class,"cord","[F");//获得属性
	jfloatArray  cordarray = (jfloatArray)(*env)->GetObjectField(env,obj2,cordid);//获得参数值
	len = (*env)->GetArrayLength(env,cordarray);
	jfloat cord[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,cordarray,0,len,cord);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",cord[i]);
	        data8.cord[i] = cord[i];
	}
	/*获得float数组结束*/

	/*获取char开始 type3*/
	jfieldID type3id = (*env)->GetFieldID(env,class,"type3","C");
	jchar type3 = (*env)->GetCharField(env,obj2,type3id);
	data8.type3 = type3-'0';
	/*获取char结束*/

	/*获取float开始 ss3*/
	jfieldID ss3id = (*env)->GetFieldID(env,class,"ss3","F");
	jfloat ss3 = (*env)->GetFloatField(env,obj2,ss3id);
	data8.ss3 = ss3;
	/*获取float结束*/

	/*获取float开始 sn*/
	jfieldID snid = (*env)->GetFieldID(env,class,"sn","F");
	jfloat sn = (*env)->GetFloatField(env,obj2,snid);
	data8.sn = sn;
	/*获取float结束*/

	/*获取char开始 type4*/
	jfieldID type4id = (*env)->GetFieldID(env,class,"type4","C");
	jchar type4 = (*env)->GetCharField(env,obj2,type4id);
	data8.type4 = type4-'0';
	/*获取char结束*/

	/*获取float开始 dep*/
	jfieldID depid = (*env)->GetFieldID(env,class,"dep","F");
	jfloat dep = (*env)->GetFloatField(env,obj2,depid);
	data8.dep = dep;
	/*获取float结束*/

	/*获取char开始 type5*/
	jfieldID type5id = (*env)->GetFieldID(env,class,"type5","C");
	jchar type5 = (*env)->GetCharField(env,obj2,type5id);
	data8.type5 = type5-'0';
	/*获取char结束*/

	/*获得float数组开始 frew*/
	jfieldID frewid = (*env)->GetFieldID(env,class,"frew","[F");//获得属性
	jfloatArray  frewarray = (jfloatArray)(*env)->GetObjectField(env,obj2,frewid);//获得参数值
	len = (*env)->GetArrayLength(env,frewarray);
	jfloat frew[len];//float数组 wind长度为3
	(*env)->GetFloatArrayRegion(env,frewarray,0,len,frew);
	
	for( i = 0 ;i<len;i++){
	        printf("%f\n",frew[i]);
	        data8.frew[i] = frew[i];
	}
	/*获得float数组结束*/

	/*获取int开始 num3*/
	jfieldID num3id = (*env)->GetFieldID(env,class,"num3","I");
	jint num3 = (*env)->GetIntField(env,obj2,num3id);
	data8.num3 = num3;
	/*获取int结束*/

	/*获取char开始 type6*/
	jfieldID type6id = (*env)->GetFieldID(env,class,"type6","C");
	jchar type6 = (*env)->GetCharField(env,obj2,type6id);
	data8.type6 = type6-'0';
	/*获取char结束*/


	//根据中心频率fre 和 标志位选择数据
	if(fre > 3000)
	{/*高频*/
		data8.sead[0]=0;
		data8.sead[1]=6;
		data8.sead[2]=1;
	}
	else
	{/*低频*/
		data8.sead[0]=0;
		data8.sead[1]=100;
		data8.sead[2]=1;
	}	


	/**发送开始 报文1**/
	data8.s1 = 1;
	struct sockaddr_in out;

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr("192.168.220.16");

	printf("data8 len2 is %f\n", data8.len2);

	int s;

	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	int flag = sendto(s,(char*)&data8,sizeof(data8),0,(struct sockaddr *)&out,len);
	if(flag == -1){
	printf("socket wrong!\n");
	}
	close(s);

	/**发送结束**/
	printf("pack 1 end\n");
	sleep(5);
	struct DATA8_1 tt1;
	struct DATA8_2 tt2;
	struct DATA8_3 tt3;
	tt1.s1=2;
	tt1.len=1;
	tt1.data[0]=0;
	tt1.data[1]=90;
	tt1.data[2]=0.8;
	tt1.data[3]=0;
	
	/**发送开始 报文2**/

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr("192.168.220.16");


	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	flag = sendto(s,(char*)&tt1,sizeof(tt1),0,(struct sockaddr *)&out,len);
	if(flag == -1){
		printf("socket wrong!\n");
	}
	close(s);
	printf("pack 2 end\n");
	sleep(5);
	/**发送结束**/

	if(fre>3000)
	{/*高频*/
		/*tt2.data[0]=0;
		tt2.data[1]=1836;
		tt2.data[2]=2.034;
		tt2.data[3]=0.47;
		tt2.data[4]=10;
		tt2.data[5]=1650;
		tt2.data[6]=2.035;
		tt2.data[7]=0;*/
		tt2.data[0]=0;
		tt2.data[1]=1836;
		tt2.data[2]=2.034;
		tt2.data[3]=0.47;
		tt2.data[4]=10;
		tt2.data[5]=1650;
		tt2.data[6]=2.035;
		tt2.data[7]=0;
	}
	else
	{/*低频*/
		tt2.data[0]=0;
		tt2.data[1]=1650;
		tt2.data[2]=2.034;
		tt2.data[3]=0.0001;
		tt2.data[4]=10;
		tt2.data[5]=1650;
		tt2.data[6]=2.034;
		tt2.data[7]=0.5;
		// tt2.data[0]=0;
		// tt2.data[1]=1582;
		// tt2.data[2]=1.575;
		// tt2.data[3]=0.0001;
		// tt2.data[4]=100;
		// tt2.data[5]=1650;
		// tt2.data[6]=2.034;
		// tt2.data[7]=0.5;
	}
	
	/**发送开始 报文3**/

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr("192.168.220.16");


	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	flag = sendto(s,(char*)&tt2,sizeof(tt2),0,(struct sockaddr *)&out,len);
	if(flag == -1){
		printf("socket wrong!\n");
	}
	close(s);
	printf("pack 3 end\n");
	sleep(5);

	/**发送结束**/


	tt3.s1=4;
	tt3.len=5;
	if(fre>3000)
	{/*高频*/
		/*	tt3.data[0][0]=0;
		tt3.data[0][1]=1450;
		tt3.data[1][0]=20;
		tt3.data[1][1]=1450;
		tt3.data[2][0]=30;
		tt3.data[2][1]=1450;
		tt3.data[3][0]=60;
		tt3.data[3][1]=1450;
		tt3.data[4][0]=100;
		tt3.data[4][1]=1450;*/
		tt3.data[0][0]=0;
		tt3.data[0][1]=1521.276;
		tt3.data[1][0]=0.102;	    
		tt3.data[1][1]=1521.057;
		tt3.data[2][0]=0.204;	    
		tt3.data[2][1]=1520.498;
		tt3.data[3][0]=0.301;	  
		tt3.data[3][1]= 1520.307;
		tt3.data[4][0]=0.409;	   
		tt3.data[4][1]=1520.286;
		tt3.data[5][0]=0.503;	 
		tt3.data[5][1]=1520.224;
		tt3.data[6][0]=0.601;	   
		tt3.data[6][1]=1520.116;
		tt3.data[7][0]=0.702;	   
		tt3.data[7][1]=1520.015;
		tt3.data[8][0]=0.81;	   
		tt3.data[8][1]= 1519.779;
		tt3.data[9][0]=0.904;	   
		tt3.data[9][1]=1519.702;
		tt3.data[10][0]=1;	         
		tt3.data[10][1]=1519.514;
		tt3.data[11][0]=1.1;	        
		tt3.data[11][1]=1519.413;
		tt3.data[12][0]=1.202;	
		tt3.data[12][1]=1519.303;
		tt3.data[13][0]=1.304;	
		tt3.data[13][1]=1519.23;
		tt3.data[14][0]=1.403;	
		tt3.data[14][1]=1519.217;
		tt3.data[15][0]=1.505;	
		tt3.data[15][1]=1519.156;
		tt3.data[16][0]=1.601;	
		tt3.data[16][1]=1518.94;
		tt3.data[17][0]=1.703;	
		tt3.data[17][1]=1518.81;
		tt3.data[18][0]=1.813;	
		tt3.data[18][1]=1518.784;
		tt3.data[19][0]=1.907;	
		tt3.data[19][1]=1518.761;
		tt3.data[20][0]=2.003;	
		tt3.data[20][1]=1518.734;
		tt3.data[21][0]=2.101;	
		tt3.data[21][1]=1518.708;
		tt3.data[22][0]=2.202;	
		tt3.data[22][1]=1518.667;
		tt3.data[23][0]=2.303;	
		tt3.data[23][1]=1518.593;
		tt3.data[24][0]=2.402;	 
		tt3.data[24][1]=1518.541;
		tt3.data[25][0]=2.505;	
		tt3.data[25][1]=1518.542;
		tt3.data[26][0]=2.614;	
		tt3.data[26][1]=1518.49;
		tt3.data[27][0]=2.706;	
		tt3.data[27][1]=1518.486;
		tt3.data[28][0]=2.805;	
		tt3.data[28][1]=1518.46;
		tt3.data[29][0]=2.906;	
		tt3.data[29][1]=1518.457;
		tt3.data[30][0]=3.001;	
		tt3.data[30][1]=1518.457;
		tt3.data[31][0]=3.109;	
		tt3.data[31][1]=1518.452;
		tt3.data[32][0]=3.211;	
		tt3.data[32][1]=1518.442;
		tt3.data[33][0]=3.309;	
		tt3.data[33][1]=1518.378;
		tt3.data[34][0]=3.407;	 
		tt3.data[34][1]=1518.343;
		tt3.data[35][0]=3.501;	
		tt3.data[35][1]=1518.329;
		tt3.data[36][0]=3.604;	
		tt3.data[36][1]=1518.319;
		tt3.data[37][0]=3.706;	
		tt3.data[37][1]=1518.294;
		tt3.data[38][0]=3.804;	
		tt3.data[38][1]=1518.294;
		tt3.data[39][0]=3.905;	
		tt3.data[39][1]=1518.279;
		tt3.data[40][0]=4.008;	
		tt3.data[40][1]=1518.19;
		tt3.data[41][0]=4.109;	
		tt3.data[41][1]=1518.092;
		tt3.data[42][0]=4.205;	
		tt3.data[42][1]=1518.035;
		tt3.data[43][0]=4.302;	 
		tt3.data[43][1]=1517.986;
		tt3.data[44][0]=4.41;	
		tt3.data[44][1]=1517.857;
		tt3.data[45][0]=4.511;	
		tt3.data[45][1]=1517.591;
		tt3.data[46][0]=4.602;	 
		tt3.data[46][1]=1517.435;
		tt3.data[47][0]=4.705;	
		tt3.data[47][1]=1517.425;
		tt3.data[48][0]=4.803;	 
		tt3.data[48][1]=1517.424;
		tt3.data[49][0]=4.911;	
		tt3.data[49][1]=1517.405;
		tt3.data[50][0]=5.007;	
		tt3.data[50][1]=1517.408;
		tt3.data[51][0]=4.965;	
		tt3.data[51][1]=1517.425;
		tt3.data[52][0]=4.891;	
		tt3.data[52][1]=1517.454;
		tt3.data[53][0]=5.025;	
		tt3.data[53][1]=1517.406;
		tt3.data[54][0]=5.067;	
		tt3.data[54][1]=1517.404;
		tt3.data[55][0]=5.105;	
		tt3.data[55][1]=1517.4;
		tt3.data[56][0]=5.202;	
		tt3.data[56][1]=1517.406;
		tt3.data[57][0]=5.309;	 
		tt3.data[57][1]=1517.408;
		tt3.data[58][0]=5.408;	
		tt3.data[58][1]=1517.411;
		tt3.data[59][0]=5.507;	
		tt3.data[59][1]=1517.411;
		tt3.data[60][0]=5.604;	
		tt3.data[60][1]=1517.407 ;
		tt3.data[61][0]=5.705;	
		tt3.data[61][1]=1517.399;
		tt3.data[62][0]=5.812;	
		tt3.data[62][1]=1517.391;
		tt3.data[63][0]=5.902;	
		tt3.data[63][1]=1517.349;
		tt3.data[64][0]=6.00; 	
		tt3.data[64][1]=1517.284;

	}
	else
	{/*低频*/
		tt3.data[0][0]=0;
		tt3.data[0][1]=1500;
		tt3.data[1][0]=30;
		tt3.data[1][1]=1500;
		tt3.data[2][0]=50;
		tt3.data[2][1]=1500;
		tt3.data[3][0]=70;
		tt3.data[3][1]=1500;
		tt3.data[4][0]=100;
		tt3.data[4][1]=1500;
	 //    tt3.data[0][0]=0.0;
		// tt3.data[0][1]=1530.0;
		// tt3.data[1][0]=19.422;
		// tt3.data[1][1]=1529.71;
		// tt3.data[2][0]=81.80;
		// tt3.data[2][1]=1523.49;
		// tt3.data[3][0]=168.87;
		// tt3.data[3][1]=1515.13;
		// tt3.data[4][0]=264.66;
		// tt3.data[4][1]=1510.41;
		// tt3.data[5][0]=372.97;
		// tt3.data[5][1]=1504.4;
		// tt3.data[6][0]=445.39;
		// tt3.data[6][1]=1500.1;
		// tt3.data[7][0]=529.33;
		// tt3.data[7][1]=1495.81;
		// tt3.data[8][0]=661.50;
		// tt3.data[8][1]=1488.73;
		// tt3.data[9][0]=942.95;
		// tt3.data[9][1]=1484.28;
		// tt3.data[10][0]=1070.18;
		// tt3.data[10][1]=1481.62;
		// tt3.data[11][0]=1254.53;
		// tt3.data[11][1]=1481.61;
		// tt3.data[12][0]=1403.15;
		// tt3.data[12][1]=1483.09;
		// tt3.data[13][0]=1597.54;
		// tt3.data[13][1]=1485.01;
		// tt3.data[14][0]=1814.64;
		// tt3.data[14][1]=1487.34;
		// tt3.data[15][0]=2042.43;
		// tt3.data[15][1]=1490.75;
		// tt3.data[16][0]=2270.23;
		// tt3.data[16][1]=1494.16;
		// tt3.data[17][0]=2589.21;
		// tt3.data[17][1]=1498.85;
		// tt3.data[18][0]=2919.38;
		// tt3.data[18][1]=1503.96;
		// tt3.data[19][0]=3226.68;
		// tt3.data[19][1]=1508.87;
		// tt3.data[20][0]=3466.00;
		// tt3.data[20][1]=1512.27;
		// tt3.data[21][0]=3750.41;
		// tt3.data[21][1]=1516.96;
		// tt3.data[22][0]=4045.86;
		// tt3.data[22][1]=1522.3;
		// tt3.data[23][0]=4238.92;
		// tt3.data[23][1]=1525.92;
		// tt3.data[24][0]=4523.67;
		// tt3.data[24][1]=1530.18;
		// tt3.data[25][0]=4717.06;
		// tt3.data[25][1]=1533.38;
		// tt3.data[26][0]=4887.42;
		// tt3.data[26][1]=1536.58;
		// tt3.data[27][0]=4966.75;
		// tt3.data[27][1]=1538.29;
		// tt3.data[28][0]=5000.00;
		// tt3.data[28][1]=1540.00;
}
	/**发送开始 报文3**/

	memset(&out,0,sizeof(out));
	out.sin_family = AF_INET;
	out.sin_port  = htons(PORT);
	out.sin_addr.s_addr = inet_addr("192.168.220.16");


	len = sizeof(struct sockaddr_in);
	s = socket(AF_INET,SOCK_DGRAM,0);

	if(s == -1){
	printf("can not create socket\n");
	}

	flag = sendto(s,(char*)&tt3,sizeof(tt3),0,(struct sockaddr *)&out,len);
	if(flag == -1){
		printf("socket wrong!\n");
	}
	printf("pack 4 end\n");
	close(s);
	/**发送结束**/
}
