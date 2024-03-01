#include <stdio.h>
int validate(double, double, double);
void printTable(double, double, double);

int main(int argc, char *argv[]){	

    int valid = 0;
    double speed = 0.0;
    double mpg = 0.0;
    double distance = 0.0;
    double time = 0.0;
    double gallons = 0.0;
    double gasPrice = 0.0;
    double cost = 0.0;

    do {
	printf("Plese enter speed:");
	scanf("%lf", &speed);
	valid = validate(speed, 25, 120);
    } while (valid == 0);

    do {
	printf("Plese enter MPG:");
	scanf("%lf", &mpg);
	valid = validate(mpg, 8, 35);
    } while (valid == 0);

    do {
	printf("Plese enter distance:");
	scanf("%lf", &distance);
	valid = validate(distance, 50, 1000);
    } while (valid == 0);

    do {
	printf("Plese enter gas price:");
	scanf("%lf", &gasPrice);
	valid = validate(gasPrice, 2.90, 4.25);
    } while (distance < 50 || distance > 1000);

    //distance = rate * time
    time = (distance / speed) * 60;
    //gallons = mpg(miles/gallon) distance(miles)
    gallons = (distance/mpg);
    //cost = gallons * price per gallon
    cost = gallons * gasPrice;


    printf("With speed of %0.2f miles per hour, it takes %0.2f Minutes and %0.2f Gallons of gas to get there.\n", speed, time, gallons);
    printTable(distance, mpg, gasPrice);
    return 0;
}

int validate(double value, double min, double max){
    if (value < min || value > max){
	printf("The value you inputed is invalid!\n");
	return 0;
    } else {
	printf("The value you entered is %f\n", value);
	return 1;
    }
}

void printTable(double distance, double mpg, double gasPrice){

    double cost = 0.0;
    double gallons = 0.0;

    printf("Distance\t Gas Used\t Cost\n");
    printf("-------------------------------------------------------\n");
    for(int i = 0; i < 10; i++){

	gallons = (distance/mpg);
	//cost = gallons * price per gallon
	cost = gallons * gasPrice;

	printf("%0.2f\t %0.2f\t\t %0.2f\n", distance, gallons, cost);
	distance += 20;
    }
}
