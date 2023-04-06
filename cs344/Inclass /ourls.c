#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <time.h>
#include <sys/types.h>
#include <dirent.h>
#include <libgen.h>
#include <unistd.h>
#include <errno.h>

int ls_file(char * fname);
int ls_dir(char * dname);
void printNames(char *[], int, char *);
void sortNames(char *[], int);

struct stat mystat, *sp;
char * t1 ="rwxrwxrwx-------";
char * t2 = "----------------";

int main(int argc, char * argv[])
{
	struct stat mystat, *sp = &mystat;
	int r;
	char *filename, path[1024], cwd[256];
	filename = "./";
	if (argc > 1)
		filename = argv[1];
	
	if ((r = lstat(filename, sp)) < 0)
	{
		printf("No such file %s\n", filename);
		exit(1);
	}
	strcpy(path, filename);
	if (path[0] != '/')  //filename is relative
	{
		getcwd(cwd, 256);
		strcpy(path, cwd);
		strcat(path, "/");
		strcat(path, filename);
	}
	
	if(S_ISDIR(sp->st_mode)){
		ls_dir(path);
  }else{
		ls_file(path);
  } 
	
	return 0;
}

int ls_file(char * fname)
{
	struct stat fstat, *sp;
	int r, i;
	char ftime[64];
	sp = &fstat;
	if ((r = lstat(fname, &fstat)) < 0)
	{
		printf("Can't stat %s\n%d\n", fname, errno);
		return(1);
	}

	if((sp->st_mode & 0xF000) == 0x8000) // if S_ISREG()
		printf("%c", '-');
	if((sp->st_mode & 0xF000) == 0x4000) // if S_ISDIR()
		printf("%c", 'd');
	if((sp->st_mode & 0xF000) == 0xA000) // if S_ISLNK()
		printf("%c", 'l');

	for(i = 8; i >= 0; i--)
	{
		if (sp->st_mode & (1 << i))  //print r | w | x
			printf("%c", t1[i]);
		else
			printf("%c", t2[i]);  //print a -
	}
	
	printf("%4d ", sp->st_nlink);  //link count
	printf("%4d ", sp->st_gid);	//group id
	printf("%4d ", sp->st_uid);	// user id
	printf("%4lld ", sp->st_size); // file size
	
	strcpy(ftime, ctime(&sp->st_ctime));
	ftime[strlen(ftime)-1] = 0;
	printf("%s  ", ftime);
	
	// print name
	printf("%s", basename(fname)); 
	// print link name if file is a symbolic link file
	if ((sp->st_mode & 0xF000) == 0xA000)
	{
		//get link name using readlink()
		char linkname[256];
		ssize_t size = readlink(fname, linkname, 256);
		linkname[size] = '\0';
		printf(" -> %s", linkname);
	}
	printf("\n");
	return 0;
}

int ls_dir(char * dname)
{
    DIR *dp;
    struct dirent *dirp;
    dp = opendir(dname);
    char dnamecpy[1024]; 
    int numofelements = 0;
    while ((dirp = readdir(dp)) != NULL){
      numofelements++;
    }
    char *names[numofelements];
    DIR * dp2 = opendir(dname);
    for(int i = 0; i < numofelements; i++){
      dirp = readdir(dp2);
      names[i] = dirp->d_name;
    }

    sortNames(names, numofelements);
    printNames(names, numofelements, dname);

    closedir(dp);
	
}

void printNames(char *names[], int numofelements, char * dname){

  char dnamecpy[1024]; 

  for(int i = 0; i < numofelements; i++){
    strcpy(dnamecpy, dname);
    strcat(dnamecpy,"/");
    strcat(dnamecpy, names[i]);
    ls_file(dnamecpy);
  }

}

void sortNames(char *names[], int numofelements){
  for(int i = 0; i < numofelements; i++){
    for(int j = 0; j < numofelements-1; j++){
      if(strcmp(names[j], names[j+1]) > 0){
        char * temp = names[j];
        names[j] = names[j+1];
        names[j+1] = temp;
      }
    }
  }

}


