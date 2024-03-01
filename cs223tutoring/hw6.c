#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAYSIZE 30
#define MAXDIST 1000
#define MINDIST 50
#define MAXMPG 35
#define MINMPG 8
#define COST 3.75

int genRand(int, int);
double costCalculation(int, int);

int main(int argc, char *argv[]){	

    int distances[ARRAYSIZE];
    int mpg[ARRAYSIZE];
    srand(time(NULL));

    for (int i = 0; i < ARRAYSIZE; i++){
	distances[i] = genRand(MAXDIST, MINDIST);
	mpg[i] = genRand(MAXMPG, MINMPG);
    }

    printf("Distance\t MPG\t\t Cost\n");
    printf("--------------------------------------\n");
    for(int i = 0; i < ARRAYSIZE; i++){
	printf("%d\t\t %d\t\t %.2f\n", distances[i], mpg[i], costCalculation(distances[i], mpg[i]));
    }

    return 0;
}

int genRand(int max, int min){

    return (rand() % (max - min) + min);
}

double costCalculation(int distance, int mpg){
    return (distance / mpg * COST);
}
