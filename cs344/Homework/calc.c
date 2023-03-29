//David Greni worked with Caser Elder
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

void processChoice(char *[]);
int main(int argc, char *argv[])
{
  if(argc != 4){
    printf("Usage ./calc operand1 operator operand2\n");
  } else {
    processChoice(argv);
  }
  return 0;
}

void processChoice(char *argv[]){
  
  float val1 = atof(argv[1]);
  float val2 = atof(argv[3]);
  float ans;
  if(strcmp(argv[2], "+") == 0){
    ans = val1 + val2;
  } else if (strcmp(argv[2], "-") == 0){
      ans = val1 - val2;
  } else if (strcmp(argv[2], "*")== 0){
      ans = val1 * val2;
  } else if (strcmp(argv[2], "/")== 0){
      if (val2 != 0){
        ans = val1 / val2;
      } else{
        printf("No division by 0\n");
      }
  } else {
    printf("Not a operand\n");
  }

  printf("%f\n", ans);
}
