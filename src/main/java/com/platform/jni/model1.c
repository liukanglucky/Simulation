#include<jni.h>
#include "com_platform_jni_Model1.h"
#include<string.h>

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
};//模型1用 len 264


JNIEXPORT void JNICALL Java_com_platform_jni_Model1_getmodel1
  (JNIEnv *env, jobject obj1, jobject obj2){
	printf("Hello World\n");
	jclass class = (*env)->GetObjectClass(env,obj2);
	jfieldID s1id = (*env)->GetFieldID(env,class,"s1","C");
	jchar s1 = (*env)->GetCharField(env,obj2,s1id);
	printf("s1 is %c\n",s1);
	jfieldID f1id = (*env)->GetFieldID(env,class,"file1","[C");
	printf("file1 id is right\n");
	char* f1a = (char*)(*env)->GetObjectField(env,obj2,f1id);
	printf("file1 char array is right\n");
	//jchar file1[100];
	//(*env)->GetCharArrayRegion(env,f1a,0,100,file1);	
	//printf("file1 to array is right\n");
	printf("file1 is %s",f1a);
	struct DATA1 *data1;
	data1->s1 = s1;
	data1->file1[100] = f1a;
	//strcpy(data1->file1,f1a);
	return;
}

