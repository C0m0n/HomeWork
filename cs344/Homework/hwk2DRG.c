#include <stdio.h>
#include <stdlib.h>
//Worked with Casey Elder
typedef struct data
{
    int id;
    float gpa;
} DATA_TYPE;

int menu();
void processChoice(int , DATA_TYPE * []);
void addData(DATA_TYPE * []); 
void displayData(DATA_TYPE * []); 

int main (int argc, char * argv[]){
    
    DATA_TYPE *data_array[6] = {0,0,0,0,0,0};
    int running = 1;
    while (running){
        int choice = menu();
        processChoice(choice, data_array);
        if (choice == 3) {
            running = 0;
        }
    }
    

    return 0;
}

int menu(){

    printf("1. Add data.\n");
    printf("2. Display all data.\n");
    printf("3. Quit.\n");
    int choice;
    scanf("%d", &choice);

    return choice;
}

void processChoice(int choice, DATA_TYPE * data_array[]){

    switch (choice)
    {
    case 1:
        addData(data_array);
        break;
    case 2:
        displayData(data_array);
        break;
    case 3:
        printf("Bye\n");
        break;
    default:
        printf("Invalid choice\n");
    }

}

void addData(DATA_TYPE * data_array[]){
    DATA_TYPE * currentPointer = data_array[0];
    int freeSlot = 0;
    while (currentPointer)
    {
        currentPointer = data_array[freeSlot+1];
        freeSlot++;
    }

    if (freeSlot < 5){
        int newID = 0; 
        float newGPA = 0;
        printf("Please input new ID\n");
        scanf("%d", &newID);
        printf("Please input new GPA\n");
        scanf("%f", &newGPA);

        data_array[freeSlot] = (DATA_TYPE *) malloc(sizeof(DATA_TYPE));
        data_array[freeSlot]->gpa = newGPA;
        data_array[freeSlot]->id = newID;
    } else {
        printf("No valid slots\n");
    }


}

void displayData(DATA_TYPE * data_array[]){

    DATA_TYPE * currentPointer = data_array[0];
    int i = 0;
    while (currentPointer)
    {
        printf("ID is %d\n", currentPointer->id);
        printf("GPA is %f\n", currentPointer->gpa);
        currentPointer = data_array[i+1];
        i++;
    }
    
}

