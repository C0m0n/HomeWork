#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
//David Greni
//Worked with Casey Elder
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
void addToFront(LIST_NODE_TYPE **);
void addToBack(LIST_NODE_TYPE **);
void removeFromFront(LIST_NODE_TYPE **);
void removeFromBack(LIST_NODE_TYPE **);
void findItemOnList(LIST_NODE_TYPE **);
void traverse(LIST_NODE_TYPE *);
void processChoice(int , LIST_NODE_TYPE ** ); 
void displayData(LIST_NODE_TYPE **);
void writeToFile(LIST_NODE_TYPE *, char *);
void loadData(LIST_NODE_TYPE **, char *);
DATA_TYPE * search(int, LIST_NODE_TYPE **);
DATA_TYPE * getDataFromUser();
int menu();


int main(int argc, char * argv[])
{
   LIST_NODE_TYPE * headPtr = NULL;
   char * outfileName = "studentData.bin";
   loadData(&headPtr, outfileName);
   int choice = 0;
   while (choice != 7)
   {
      choice = menu();
      processChoice(choice, &headPtr);
   }
   writeToFile(headPtr, outfileName);
   return 0;
}

int menu(){
   int choice;
   printf("1. Add to back of list \n");
   printf("2. Add to front of list  \n");
   printf("3. Remove from back of list \n");
   printf("4. Remove from front of list \n");
   printf("5. Find item on list \n");
   printf("6. Display all data on list \n");
   printf("7. Quit. \n");
   scanf("%d", &choice);
   return choice;
}

void processChoice(int choice, LIST_NODE_TYPE ** headPtrPtr){

   switch (choice)
   {
   case 1:
      addToBack(headPtrPtr);
      break;
   case 2:
      addToFront(headPtrPtr);
      break;
   case 3:
      removeFromBack(headPtrPtr);
      break;
   case 4:
      removeFromFront(headPtrPtr);
      break;
   case 5:
      findItemOnList(headPtrPtr);
      break;
   case 6:
      displayData(headPtrPtr);
      break;
   case 7:
      printf("Bye.\n");
      break;
   
   default:
      printf("Choice not valid!\n");
      break;
    }

}

void addToFront(LIST_NODE_TYPE ** headPtrPtr){
   DATA_TYPE * data = getDataFromUser();
   prepend(headPtrPtr, data);
}

void addToBack(LIST_NODE_TYPE ** headPtrPtr){
   DATA_TYPE * data = getDataFromUser();
   append(headPtrPtr, data);
}

void removeFromFront(LIST_NODE_TYPE ** headPtrPtr){

   if (*headPtrPtr == NULL){
      return;
   }
   LIST_NODE_TYPE * currPtr = *headPtrPtr;

   *headPtrPtr = currPtr->next;
   free(currPtr->dPtr);
   free(currPtr);
}

void removeFromBack(LIST_NODE_TYPE ** headPtrPtr){
   if (*headPtrPtr == NULL)    
   {
      return;
   }
   LIST_NODE_TYPE * currPtr = *headPtrPtr;
   LIST_NODE_TYPE * prevPtr;
   while (currPtr->next){
      prevPtr = currPtr;
      currPtr = currPtr->next;
   }
   if (currPtr == *headPtrPtr){
      *headPtrPtr = 0; 
   } else {
      prevPtr->next = NULL;
   }
   free(currPtr->dPtr);
   free(currPtr);

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
      printf("ID: %d, GPA: %.2f\n", id, gpa);
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

DATA_TYPE * getDataFromUser(){
   DATA_TYPE * dataPtr = (DATA_TYPE*) malloc(sizeof(DATA_TYPE));

   int id;
   float gpa;
   printf("Please input id: \n");
   scanf("%d", &id);
   printf("Please input gpa: \n");
   scanf("%f", &gpa);

   dataPtr->id = id;
   dataPtr->gpa = gpa;

   return dataPtr;
}

void displayData(LIST_NODE_TYPE ** headPtrPtr){
   LIST_NODE_TYPE * currPtr = *headPtrPtr;
   if (!currPtr){
      printf("Nothing to display\n");
   }

   while (currPtr){
      DATA_TYPE * data = currPtr->dPtr;
      printf("ID: %d\n", data->id);
      printf("GPA: %.2f\n", data->gpa);
      currPtr = currPtr->next;
   }
}

void findItemOnList(LIST_NODE_TYPE ** headPtrPtr){
   int id;
   printf("Please enter the id you wish to find: ");
   scanf("%d", &id);
   DATA_TYPE * data = search(id, headPtrPtr);
   if (data){
      printf("The id was found!\n");
      printf("ID: %d\n", data->id);
      printf("GPA: %.2f\n", data->gpa);
   } else{
      printf("ID not found!\n");
   }
}

DATA_TYPE * search(int id, LIST_NODE_TYPE ** headPtrPtr){
   LIST_NODE_TYPE * currPtr = *headPtrPtr; 
   DATA_TYPE * data;
   while (currPtr->next)
   {
      data = currPtr->dPtr;
      if (data->id == id){
         return data;
      }
      currPtr = currPtr->next;
   }
   
   return NULL;
}

void writeToFile(LIST_NODE_TYPE * headPtr, char * outfileName)
{
   FILE * f = fopen(outfileName, "wb");
   LIST_NODE_TYPE * currPtr = headPtr;
   while (currPtr)
   {
      fwrite(currPtr->dPtr, sizeof(DATA_TYPE), 1, f);
      currPtr = currPtr->next;
   }
   fclose(f);
}

void loadData(LIST_NODE_TYPE ** headPtrPtr, char * outfileName)
{
   int f;
   f = open(outfileName, O_RDONLY);
   if (f < 0){
      printf("Couldnt find file\n");
      headPtrPtr = NULL;
      return;
   } else {
      int result = 1;
      while(result != 0){ 
         DATA_TYPE * data = (DATA_TYPE *) malloc(sizeof(DATA_TYPE));
         result = read(f, data, sizeof(DATA_TYPE));
         if (result != 0){
            append(headPtrPtr, data);
         }
      }
   }

}