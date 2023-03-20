#include <stdio.h>
#include <stdlib.h>

typedef struct s
{
    int id;
    float gpa;
} DATA_TYPE;

typedef struct listnode
{
    DATA_TYPE * dPtr;
    struct listnode * next;
}LIST_NODE_TYPE;

void append(LIST_NODE_TYPE **, DATA_TYPE *);
void prepend(LIST_NODE_TYPE **, DATA_TYPE *);
void traverse(LIST_NODE_TYPE *);
void insert(LIST_NODE_TYPE **, DATA_TYPE *);
LIST_NODE_TYPE * findPosOnList(LIST_NODE_TYPE *, int id);
int main(int argc, char * argv[])
{
    LIST_NODE_TYPE * headPtr = NULL;

    int id = 0;
    printf("Enter an id or enter a non-positive number to quit: ");
    scanf("%d", &id);
    while (id > 0)
    {
        float gpa;
        printf("Enter the gpa for id %d: ", id);
        scanf("%f", &gpa);
        DATA_TYPE * dPtr = (DATA_TYPE *) malloc(sizeof(DATA_TYPE));
        dPtr->id = id;
        dPtr->gpa = gpa;
        //append(&headPtr, dPtr);
	    //prepend(&headPtr, dPtr);
        insert(&headPtr, dPtr);
        printf("Enter an id or enter a non-positive number to quit: ");
        scanf("%d", &id);
    }

    printf("List contents after entering data\n");
    traverse(headPtr);
    return 0;
}

void append(LIST_NODE_TYPE ** headPtrPtr, DATA_TYPE * data)
{
    LIST_NODE_TYPE * nodePtr = (LIST_NODE_TYPE *) malloc(sizeof(LIST_NODE_TYPE));
    nodePtr->dPtr = data;
    nodePtr->next = NULL;
    if (*headPtrPtr == NULL)
    {
        *headPtrPtr = nodePtr;
        return;
    }

    LIST_NODE_TYPE * currPtr = *headPtrPtr;
    LIST_NODE_TYPE * prevPtr = NULL;
    while(currPtr)
    {
        prevPtr = currPtr;
        currPtr = currPtr->next;
    }

    prevPtr->next = nodePtr;
}

void traverse(LIST_NODE_TYPE * headPtr)
{
    printf("Current data on list:\n");
    LIST_NODE_TYPE * currPtr = headPtr;
    while(currPtr)
    {
        int id = currPtr->dPtr->id;
        float gpa = currPtr->dPtr->gpa;
        printf("ID: %d, GPA: %f\n", id, gpa);
        currPtr = currPtr->next;
    }
}

void prepend(LIST_NODE_TYPE ** headPtrPtr, DATA_TYPE * dataPtr)
{
    LIST_NODE_TYPE * nodePtr = (LIST_NODE_TYPE *) malloc(sizeof(LIST_NODE_TYPE));
    nodePtr->dPtr = dataPtr;
    nodePtr->next = NULL;
    if (*headPtrPtr == NULL)
    {
        *headPtrPtr = nodePtr;
        return;
    }
    nodePtr->next = *headPtrPtr;
    *headPtrPtr = nodePtr;
}

void insert(LIST_NODE_TYPE ** headPtrPtr, DATA_TYPE * dataPtr){

    LIST_NODE_TYPE * nodePtr = (LIST_NODE_TYPE *) malloc(sizeof(LIST_NODE_TYPE));
    nodePtr->dPtr = dataPtr;
    nodePtr->next = NULL;
    if (*headPtrPtr == NULL) {
        *headPtrPtr = nodePtr;
        return;
    }
    LIST_NODE_TYPE * whichPtr = findPosOnList(*headPtrPtr, dataPtr->id);
    if(whichPtr == NULL){
        prepend(headPtrPtr, dataPtr);
        return;
    }
    nodePtr->next = whichPtr->next;
    whichPtr->next = nodePtr;
}

LIST_NODE_TYPE * findPosOnList(LIST_NODE_TYPE * headPtr , int id){

    LIST_NODE_TYPE * currPtr = headPtr;
    LIST_NODE_TYPE * prevPtr = NULL;
    while (currPtr != NULL && currPtr->next->dPtr->id < id){
        prevPtr = currPtr;
        currPtr = currPtr->next;
    }
    return prevPtr;
}