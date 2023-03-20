/*************************************************************** 
Class: Lab02
Author: David Greni
Created: 5/23/22
Modified: 5/23/22
White box testing for test cases. 
Attributes: None 
Methods: +main(String[]): void 
**************************************************************/
import java.util.Scanner;

public class WhiteBoxTesting {
    public static void main(String[] args) {
        //create variable names
        int[] sides = new int[4];
        int area1 = 0;
        int area2 = 0;

        //Create scanner object
        Scanner input = new Scanner(System.in);

        //Promp user for input
        System.out.println("Please input 4 numbers");

        //For loop for collecting inputs to terminate the program if 0 or >0 is entered
        for(int i = 0; i < 4; i++){
            //Test variable string variable
            int testVar = input.nextInt();
            //Determine if testVar is greater than 0
            if (testVar > 0){
                //store the input in sides
                sides[i] = testVar;
            } else {
                //Print error message
                System.out.println("The input was >=0 and is invalid, try again.");
                //Terminate the loop
                i = 4;
            }
        }
        //Skip this portion if the array is not completed
        if (sides[3] != 0){
            //Calculate the area of rectangles
            area1 = sides[0] * sides[1];
            area2 = sides[2] * sides[3];

            //Output areas
            System.out.println("The area of rectangle 1 is " + area1 + " the area of area 2 is " + area2);

            //Check if the areas are different
            if (area1 > area2 && area1 != area2){
                System.out.println("Area 1 is bigger than area 2");
            } else if (area1 != area2){
                System.out.println("Area 2 is bigger than area 1");
            } else {
                System.out.println("The areas are the same.");
            }
        }
        //close the scanner
        input.close();
    }
}
