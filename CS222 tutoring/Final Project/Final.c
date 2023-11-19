#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

int main(int argc, char const *argv[])
{
    char choice;
    FILE *ptr;
    char ch;
    int i = 0;
    char names[4];
    char colors[4];
    char types[4];
    int nums[4];
    ptr = fopen("test.txt", "r");
    while(fscanf(ptr, "%s %s %d %s", &names[i], &types[i], &nums[i], &colors[i]) == 1){
        printf("%s %s %d %s \n", names[i], types[i], nums[i], colors[i]);
        i++;
    }
    fclose(ptr);
    bool win = false;
    printf("Would you like to play in automatic mode (a) or manual mode(m)?: ");
    scanf("%c", &choice);

    if(choice == 'a' || choice == 'A')
    {
        printf("Automatic mode selected\n");

    }
    else if(choice == 'm' || choice == 'M')
    {
        
    }
    else
    {
        printf("Invalid choice\n");
    }

    return 0;
}


