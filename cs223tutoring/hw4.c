#include <stdio.h>

int main(int argc, char *argv[]){	

    int valid = 0;
    double speed = 0.0;
    double mpg = 0.0;
    double distance = 0.0;
    double time = 0.0;
    double gallons = 0.0;

    do {
	printf("Plese enter speed:");
	scanf("%lf", &speed);

	if (speed < 25.0 || speed > 120.0){
	    printf("The speed you entered is invalid\n");
	    valid = 1;
	} else {

	    printf("The speed you entered is %f\n", speed);
	    printf("Plese enter MPG:");
	    scanf("%lf", &mpg);

	    if (mpg < 8.0 || mpg > 25.0){
		printf("The mpg you entered is invalid\n");
		valid = 1;
	    } else {
		printf("The mpg you entered is %f\n", mpg);
		printf("Plese enter distance:");
		scanf("%lf", &distance);

		if (distance < 50.0 || distance > 1000.0){
		    printf("The distance you entered is invalid\n");
		    valid = 1;
		} else {
		    printf("The distance you entered is %f\n", mpg);
		    valid = 0;
		}
	    }
	}

    } while (valid == 1);
    //distance = rate * time
    time = (distance / speed) * 60;
    //gallons = mpg(miles/gallon) distance(miles)
    gallons = (distance/mpg);

    printf("With speed of %0.2f miles per hour, it takes %0.2f Minutes and %0.2f Gallons of gas to get there.\n", speed, time, gallons);

    printf("Speed\t Distance\t Gas Used\t Travel Time\n");
    printf("-------------------------------------------------------\n");
    for(int i = 65; i < 76; i++){

	time = (distance / i) * 60;
	printf("%d\t %0.2f\t\t %0.2f\t\t %0.2f\n", i, distance, gallons, time);

    }

    return 0;
}
