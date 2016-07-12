#include<iostream>
//#include<windows.h>
using namespace std;

typedef unsigned long int DWORD;


struct model{
	DWORD IP;
	int type;
	char name[16];
	int index;
};

struct out1{
	int a;
	char b[1000];
};

int main(){
	cout<<"struct size is "<<sizeof(model)<<endl;
	cout<<"out 1 size is "<<sizeof(out1)<<endl;
}
