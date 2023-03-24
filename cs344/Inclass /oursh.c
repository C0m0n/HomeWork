#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int process(char *);
int countTokens(char *);
int main(int argc, char *argv[])
{
  char cmd[256];
  printf("Welcome to the DShell!\n");
  char exit[5] = "exit";
  

  do {
    printf("~ ");
    gets(cmd);
    // cmd[strlen(cmd-1)] = '\0';
    printf("%s\n", cmd);
    if(strcmp(cmd, exit)){
      process(cmd);
    } else {
      printf("Thanks! Bye!\n");
    }


  } while(strcmp(cmd, exit));
  return 0;
}

int process(char * cmd){
  
  // char ** argv;
  // char cmdcpy[256];
  // strcpy(cmd, cmdcpy);
  // int count = countTokens(cmdcpy);
  // argv = (char **) malloc(sizeof(char *) * (count + 1));
  // argv[count] = NULL;
  // setArgv


  if(strcmp("ls", cmd) == 0){
    printf("ls was typed\n");
    int pid = fork();
    if (pid == 0){
      execl("/bin/ls", "ls","-l", NULL);
      return -1;
    }
    int status = 0;
    wait(&status);
  } else{
    printf("didnt understnad\n");
  }
  return 0;

}

int countTokens(char * cmd){

  char * token;
  int count = 0;
  token = strtok(cmd, " ");
  while(token != NULL){
    token = strtok(NULL, " ");
    count += 1; 
  }
  return count;
}
