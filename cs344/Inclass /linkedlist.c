#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_LENGTH 31

typedef struct data {

	int id;
	char name[MAX_LENGTH];
	int age;

} DATA_TYPE;

typedef struct listNode {

	DATA_TYPE data;
	struct listNode * next;

}LIST_NODE;

void copyData(LIST_NODE *, DATA_TYPE);
void dump(LIST_NODE *);
LIST_NODE * createNode(LIST_NODE *);
int main(int argc, char * argv[]){
	
	LIST_NODE * headPtr;
	LIST_NODE * newPtr;

	DATA_TYPE data;
	strcpy(data.name, "Jonny");
	data.id = 1234;
	data.age = 25;

	headPtr = (LIST_NODE * ) malloc(sizeof(LIST_NODE));
	copyData(headPtr, data);
	dump(headPtr);
	newPtr = createNode(headPtr);
	DATA_TYPE data2;
	data2.age = 21;
	data2.id = 5678;
	strcpy(data2.name, "Jane");
	printf("Pointer %p/n", newPtr);
	copyData(newPtr, data2);
	dump(headPtr);
	return 0;

}

void copyData(LIST_NODE * headPtr, DATA_TYPE data){

	headPtr->data.id = data.id;
	strcpy(headPtr->data.name, data.name);
	headPtr->data.age = data.age;

}

void dump(LIST_NODE * headPtr){
	LIST_NODE * currPtr = headPtr;
	while(currPtr){
		printf("ID: %d\n", currPtr->data.id);
		printf("Name: %s\n", currPtr->data.name);
		printf("Age: %d\n", currPtr->data.age);
		printf("*******************************\n");
		currPtr = currPtr->next;
	}

}

LIST_NODE * createNode(LIST_NODE * headPtr){
	LIST_NODE * currPtr = headPtr;

	while (currPtr)
	{
		if(currPtr){
			currPtr = currPtr->next;
		} else{
			currPtr->next = (LIST_NODE * ) malloc(sizeof(LIST_NODE));
		}
	}

	return currPtr;
}