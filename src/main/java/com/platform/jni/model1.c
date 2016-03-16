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
  (JNIEnv *env, jobject obj, jchar s1, jfloat speed, jcharArray file1){
	printf("Hello\n");
	char* f1a = (char*)(*env)->GetCharArrayElements(env,file1,NULL);
	printf("file1 is %s",f1a);
	jchar f1c[100];
	(*env)->GetCharArrayRegion(env,file1,0,2,f1c);
	int i;
	for( i = 0 ;i<2;i++){
		printf("%c\n",f1c[i]);
	}
	//jboolean *buf;
	//buf = (jboolean *)calloc(100,sizeof(jboolean));
	//int i ;
	//struct DATA1 *data1;
	//for(i=0;i<100;i++){
	//	if((*(f1a+i)) != NULL){
	//	*(buf+i) = (jboolean)(*(f1a+i));
	//	data1->file1[i] = *(buf+i);
	//	printf("%c\n",data1->file1[i]);
	//	}
	//}

	//free(buf);
}
JNIEXPORT void JNICALL Java_com_platform_jni_Model1_getmodel1Object
  (JNIEnv *env, jobject obj1, jobject obj2){
	//env obj1 系统默认加的，后面的为传递的参数
	jclass class = (*env)->GetObjectClass(env,obj2);//获得class
	/*获得char数组开始*/
	jfieldID f1id = (*env)->GetFieldID(env,class,"file1","[C");//获得属性
	jcharArray  f1a = (jcharArray)(*env)->GetObjectField(env,obj2,f1id);//获得参数值
	jchar f1c[100];//char数组
	(*env)->GetCharArrayRegion(env,f1a,0,2,f1c);
        int i;
        for( i = 0 ;i<2;i++){
                printf("%c\n",f1c[i]);
        }
	/*获得char数组结束*/
}
