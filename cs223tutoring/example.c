#include <stdio.h>
#include <unistd.h>
int main(int argc, char *argv[])
{
    int speed = 0;
    int time = 1;
    int i = 1;
    while(i == 1){
	printf("speed %d\n", speed);
	speed++;
	printf("time %d\n", time);
	time += time;
	sleep(1);
    }
	return 0;
}
