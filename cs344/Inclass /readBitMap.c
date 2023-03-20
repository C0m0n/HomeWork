#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char const *argv[])
{
    FILE * fptr = fopen("bitmapj.txt", "r");

    char header[5];
    fgets(header, 5, fptr);
    header[2] = '\0';
    printf("Header: %s\n", header);

    char comment[255];
    fgets(comment, 255, fptr);
    comment[strlen(comment)-1] = '\0';
    printf("Comment: %s\n", comment);    
    unsigned int width, height;
    fscanf(fptr, "%u %u", &width, &height);
    printf("width:%d, height:%d\n", width, height);
    unsigned char ones[1] = "1";
    unsigned char zer[1] = "0";
    fgetc(fptr);
    fgetc(fptr);
    for (int i = 0; i < height; i++){
        unsigned char * row = (unsigned char *) malloc(sizeof(unsigned char)*width);
        fread(row, width+2, 1, fptr);
        for(int x = 0; x < width; x ++){
            if (memcmp(row, zer, 1) == 0){
                printf(" ");
            } else if (memcmp(row, ones, 1) == 0){
                printf("*");
            }
            row++;
        }
        printf("\n");
    }
    fclose(fptr);
    return 0;
}
