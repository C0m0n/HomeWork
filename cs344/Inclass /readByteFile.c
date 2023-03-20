#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct FORMSTRUCT
{
   int numOfBytes;
   unsigned char * bytPtr;

}FORMSTRUCT;


int main(int argc, char const *argv[])
{
    FILE * fptr = fopen("bytefile.bin", "rb");

    FORMSTRUCT data;
    fread(&data.numOfBytes, sizeof(data.numOfBytes), 1, fptr);
    printf("Read Data..................\n");
    data.bytPtr = (unsigned char * ) malloc(sizeof(unsigned char)*data.numOfBytes);
    fread(data.bytPtr, 1, data.numOfBytes, fptr);
    printf("Number of bytes: %d\n", data.numOfBytes); 
    for(int i = 0; i < (data.numOfBytes); i++){
        printf("%02x", data.bytPtr[i]);
        printf(" ");
        if (((i+1)%16) == 0 && i != 0){
            printf("\n");
        }
    }
    printf("\n");
    return 0;
}
