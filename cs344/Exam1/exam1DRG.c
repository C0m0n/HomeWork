#include <stdio.h>
#include <string.h>
#include <stdlib.h>
//David Greni
typedef struct student
{
    char itemName[30];
    float price;
}ITEM_TYPE;


int main(){
    ITEM_TYPE *itemArray[10] = {0};

    int id = 0;
    printf("Please input an ID: \n");
    scanf("%d", &id);
    while(id >= 1 && id <= 10){
        id--;
        if (itemArray[id] == 0){
            char name[30];
            int price = 0;
            printf("Please provide a name: \n");
            scanf("%s", name);
            printf("Please provide a price: \n"); 
            scanf("%d", &price);
            itemArray[id] = (ITEM_TYPE*) malloc(sizeof(ITEM_TYPE));
            strcpy(itemArray[id]->itemName, name);
            itemArray[id]->price = price;
        } else{
            printf("Item already exists\n");
        }
        printf("Please input an ID: \n");
        scanf("%d", &id);
    }
    for(int i = 0; i < 10; i++){
        if (itemArray[i] != 0){
            printf("Item id: %d \nItem name: %s\nItem price: %f\n", i, itemArray[i]->itemName, itemArray[i]->price);
        }
    }

    return 0; 
}