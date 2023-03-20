#include <stdio.h>
#include <stdlib.h>

typedef struct s{
    int id;
    float gpa;
}DATA_TYPE;

typedef struct listnode{
    DATA_TYPE *dPtr;
    struct listnode *next;
}LIST_NODE_TYPE;

void append(LIST_NODE_TYPE **, DATA_TYPE *);
void prepend(LIST_NODE_TYPE **, DATA_TYPE *);
void insert(LIST_NODE_TYPE **, DATA_TYPE *);
void traverse(LIST_NODE_TYPE **);
int removeNode(LIST_NODE_TYPE **, int );
LIST_NODE_TYPE * findPosOnList(LIST_NODE_TYPE *, int id);

int main(int argc, char *argv[]){
    LIST_NODE_TYPE *headPtr = NULL;
    int id = 0;
    
    printf("Enter an id or enter a non-positive number to quit: ");
    scanf("%d", &id);

    while (id > 0 ){
        float gpa;
        printf("Enter the gpa for is %d: ", id);
        scanf("%f", &gpa);
        DATA_TYPE *dPtr = (DATA_TYPE *)malloc(sizeof(DATA_TYPE));
        dPtr -> id = id;
        dPtr -> gpa = gpa;
        //append(&headPtr, dPtr);
        //prepend(&headPtr, dPtr);
        insert(&headPtr, dPtr);
        printf("Enter an id or enter a non-positve number to quit: ");
        scanf("%d", &id);
    }
    printf("List contents arfer entering data \n");
    traverse(&headPtr);

    printf("Enter an id to remove or enter a non-positive number to quit: ");
    scanf("%d", &id);
    while (id > 0){
        if (removeNode(&headPtr, id)){
            printf("%d ID was removed!\n", id);
        } else {
            printf("%d ID was not found!\n", id);
        }
        printf("Enter an id to remove or enter a non-positive number to quit: ");
        scanf("%d", &id);
    }
    traverse(&headPtr);
    return 0;
}
void append(LIST_NODE_TYPE **headPtrPtr, DATA_TYPE *data){ //adds data tp the back of the list
    LIST_NODE_TYPE *nodePtr = (LIST_NODE_TYPE *)malloc(sizeof(LIST_NODE_TYPE));
    nodePtr -> dPtr = data;
    nodePtr -> next = NULL;
    if(*headPtrPtr == NULL){//derefecnces the address of headptr, this gives the value of the headptrptr
        *headPtrPtr = nodePtr;
        return;
    }

    LIST_NODE_TYPE *currPtr = *headPtrPtr;
    LIST_NODE_TYPE *PrevPtr = NULL;
    
    while(currPtr){
        PrevPtr = currPtr;
        currPtr = currPtr -> next;
    }
    PrevPtr -> next = nodePtr;
}

void traverse(LIST_NODE_TYPE **headPtrPtr){
    printf("Current data on list: \n");
    LIST_NODE_TYPE *currPtr = *headPtrPtr;
    if(currPtr != NULL){
        while(currPtr){
            int displayID = currPtr -> dPtr -> id;
            float displayGPA = currPtr -> dPtr -> gpa;
            printf("ID: %d, GPA: %.2f\n", displayID, displayGPA);
            currPtr = currPtr -> next;
        }
    }else{
            printf("Sorry there is no data to display.\n");
            printf("\n");
    } 
}
void prepend(LIST_NODE_TYPE **headPtrPtr, DATA_TYPE *dataPtr){ //adds data to the front of the list
    LIST_NODE_TYPE *nodePtr = (LIST_NODE_TYPE *)malloc(sizeof(LIST_NODE_TYPE));
    nodePtr -> dPtr = dataPtr;
    nodePtr -> next = NULL;
    if(*headPtrPtr == NULL){
        *headPtrPtr = nodePtr;
        return;
    }
    nodePtr -> next = *headPtrPtr;
    *headPtrPtr = nodePtr;
}

void insert(LIST_NODE_TYPE **headPtrPtr, DATA_TYPE *dataPtr){
    LIST_NODE_TYPE *nodePtr = (LIST_NODE_TYPE *)malloc(sizeof(LIST_NODE_TYPE));
    nodePtr -> dPtr = dataPtr;
    nodePtr -> next = NULL;

    if(*headPtrPtr == NULL){
        *headPtrPtr = nodePtr;
        return;
    }

    LIST_NODE_TYPE *whichPtr = findPosOnList(*headPtrPtr, dataPtr -> id);
    
    if(whichPtr == NULL){
        prepend(headPtrPtr, dataPtr);
        return;
    }
    nodePtr -> next = whichPtr -> next;
    whichPtr -> next = nodePtr;
}

LIST_NODE_TYPE *findPosOnList(LIST_NODE_TYPE * headPtr, int id){
   

    LIST_NODE_TYPE *currPtr = headPtr, *prevePtr = NULL;

    while(currPtr != NULL && currPtr -> dPtr -> id < id){
        prevePtr = currPtr;
        currPtr= currPtr -> next;
    }
    return prevePtr;
}

int removeNode(LIST_NODE_TYPE ** headPtrPtr, int id){
    if(*headPtrPtr == NULL) return 0;
    LIST_NODE_TYPE * prevPtr = NULL;
    LIST_NODE_TYPE * currPtr = *headPtrPtr;
    while (currPtr != NULL && currPtr->dPtr->id != id){
        prevPtr = currPtr;
        currPtr = currPtr->next;
    }
    if (currPtr == NULL){
        return 0;
    }
    if (prevPtr == NULL){
        *headPtrPtr = currPtr->next;
    } else{
        prevPtr->next = currPtr->next;
    }
    free(currPtr->dPtr);
    free(currPtr);
    return 1;
}
