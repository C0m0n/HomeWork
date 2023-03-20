#include <stdio.h>


int main (int argc, char * argv[] ){
    int num = 12;
    int * intPrt;
    intPrt = &num;

    printf("%d is stored at %p\n", num, &num);
    printf("%d is stored at %p\n", *intPrt, intPrt);

    char nums[5] = {'A', 'B', 'C', 'D', 'E'};
    printf("Address is at %p\n", nums);

    char * numsPtr = nums;
    printf("Address is at %p\n", numsPtr);
    printf("The character at the head of the array %c\n", *numsPtr);
    return 0;
}