#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STUDENTS 6

typedef struct data
{
    int id;
    char name[30];
    float gpa;
} DATA_TYPE;

int menu();
void processChoice(int , DATA_TYPE * [], int *);
void addData(DATA_TYPE * [], int *); 
void removeData(DATA_TYPE * [], int *);
void displayData(DATA_TYPE * [], int *); 
int locateSpot(DATA_TYPE * [], int *);
int findStudent(DATA_TYPE * [], int, int *);

int main (int argc, char * argv[]){
    
    DATA_TYPE *students[MAX_STUDENTS] = {0,0,0,0,0,0};
    int choice;
    int count = 0;
    do {
        choice = menu();
        processChoice(choice, students, &count);
    } while( choice !=4);
    

    return 0;
}

void processChoice(int choice, DATA_TYPE * students[], int * countPtr){

    switch (choice)
    {
    case 1:
        addData(students, countPtr);
        break;
    case 2: 
        removeData(students, countPtr);
        break;
    case 3:
        displayData(students, countPtr);
        break;
    case 4:
        printf("Bye\n");
        break;
    default:
        printf("Invalid choice\n");
    }

}

void displayData(DATA_TYPE * students[], int * countPtr){

    int i;
    for (i = 0; i < *countPtr; i++)
    {
        if (students[i]){
            printf("ID is: %d\n", students[i]->id);
            printf("GPA is: %f\n", students[i]->gpa);
            printf("Student name: %s \n", students[i]->name); 
        }
    }
    
}

void addData(DATA_TYPE * students[], int * countPtr){

    DATA_TYPE * currentPointer = students[0];
    int freeSlot = locateSpot(students, countPtr);

    if (freeSlot == -1){
        printf("No valid slots\n");
    } else if(freeSlot < (MAX_STUDENTS-1)){
        int newID = 0; 
        float newGPA = 0;
        char newName[30];
        (*countPtr)++;
        printf("Please input new ID\n");
        scanf("%d", &newID);
        printf("Please input new GPA\n");
        scanf("%f", &newGPA);
        printf("Please input new name\n");
        scanf("%s", newName);

        students[freeSlot] = (DATA_TYPE *) malloc(sizeof(DATA_TYPE));
        students[freeSlot]->gpa = newGPA;
        students[freeSlot]->id = newID;
        strcpy(students[freeSlot]->name, newName);
    } else {
        printf("No valid slots\n");
    }
    


}

int locateSpot(DATA_TYPE * students[], int * countPtr){

    if (*countPtr < MAX_STUDENTS){
        return *countPtr;
    }
    return -1;
}

int findStudent(DATA_TYPE * students[], int id, int * countPtr){

    int i;
    for (i = 0; i < *countPtr; i++){
        if (students[i] && students[i]->id == id){
            return i;
        }
    }
    return -1;
}

void removeData(DATA_TYPE * students[], int * countPtr){

    int id2Remove; 
    printf("What id would you like to remove?: \n");
    scanf("%d", &id2Remove);
    int pos = findStudent(students, id2Remove, countPtr);
    
    if(pos >= 0){
        (*countPtr)--;
        free(students[pos]);
        if (*countPtr != 0){
            students[pos] = students[*countPtr];
            students[*countPtr] = 0; 
        } else {
            
        }
        printf("ID: %d was removed\n", id2Remove);
    } else {
        printf("ID: %d does not exist\n", id2Remove);
    }
}

int menu(){

    printf("1. Add data.\n");
    printf("2. Remove data.\n");
    printf("3. Display all data.\n");
    printf("4. Quit.\n");
    int choice;
    scanf("%d", &choice);

    return choice;
}