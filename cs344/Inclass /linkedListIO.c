#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

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
void insert(LIST_NODE_TYPE ** headPtrPtr, DATA_TYPE * dPtr);
LIST_NODE_TYPE * findPosOnList(LIST_NODE_TYPE * headPtr, int id);
int removeNode(LIST_NODE_TYPE ** headPtrPtr, int id);
void writeToFile(LIST_NODE_TYPE *, char *);

int main(int argc, char * argv[])
{
    LIST_NODE_TYPE * headPtr = NULL;
    char * outfileName = "linkedData.bin";
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

   printf("Enter an id to remove or enter a non-positive number to quit: ");
   scanf("%d", &id);
   while (id > 0)
    {
      if (removeNode(&headPtr, id))
      {
         printf("Node with id %d was removed\n", id);
      }
      else
      {
         printf("Node with id %d was not found\n", id);         
      }
      traverse(headPtr);
      printf("Enter an id to remove or enter a non-positive number to quit: ");
      scanf("%d", &id);
    }

    writeToFile(headPtr, outfileName);
    
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

void insert(LIST_NODE_TYPE ** headPtrPtr, DATA_TYPE * dataPtr)
{
   LIST_NODE_TYPE * nodePtr = (LIST_NODE_TYPE *) malloc(sizeof(LIST_NODE_TYPE));
   nodePtr->dPtr = dataPtr;
   nodePtr->next = NULL;
   if (*headPtrPtr == NULL)  //empty list
   {
      *headPtrPtr = nodePtr;
      return;
   }
   LIST_NODE_TYPE * whichPtr = findPosOnList(*headPtrPtr, dataPtr->id);
   if (whichPtr == NULL)
   {
      prepend(headPtrPtr, dataPtr);
      return;
   }
   nodePtr->next = whichPtr->next;
   whichPtr->next = nodePtr;
}

LIST_NODE_TYPE * findPosOnList(LIST_NODE_TYPE * headPtr, int id)
{
   LIST_NODE_TYPE * currPtr = headPtr, *prevPtr = NULL;
   while (currPtr != NULL && currPtr->dPtr->id < id)
   {
      prevPtr = currPtr;
      currPtr = currPtr->next;
   }
   return prevPtr;
}

int removeNode(LIST_NODE_TYPE ** headPtrPtr, int id)
{
   if(*headPtrPtr == NULL) return 0;
   LIST_NODE_TYPE * prevPtr = NULL;
   LIST_NODE_TYPE * currPtr = *headPtrPtr;
   while (currPtr != NULL && currPtr->dPtr->id != id)
   {
     prevPtr = currPtr;
     currPtr = currPtr->next;
   }
   if (currPtr == NULL)
   {
      return 0;
   }
   if (prevPtr == NULL)
   {
     *headPtrPtr = currPtr->next;
   }
   else
   {
      prevPtr->next = currPtr->next;
   }
   free(currPtr->dPtr);
   free(currPtr);
   return 1;
}

void writeToFile(LIST_NODE_TYPE * headPtr, char * outfileName)
{
   int fd = open(outfileName, O_WRONLY | O_CREAT, 0644);
   LIST_NODE_TYPE * currPtr = headPtr;
   while (currPtr)
   {
      write(fd, currPtr->dPtr, sizeof(DATA_TYPE));
      currPtr = currPtr->next;
   }
   close(fd);
}
