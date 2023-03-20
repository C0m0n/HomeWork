public class Craps {
    /* -----------------------------------------------
   Submitted By: David Greni
   Homework Number: Homework 2 
    Credit to: 
       none
   Submitted On: 01June22
 
   By submitting this program with my name,
   I affirm that the creation and modification
         of this program is primarily my own work.
 ------------------------------------------------ */
    public static void main(String[] args) {

        //Create dice  object
        Dice pairOfDice = new Dice();
        //Create variables
        boolean continueGame = true; 
        int point = 0;
        boolean pointEst = false; 
        int[] diceValue = new int[2];

        //While the game is continue is true
        while (continueGame){

            //Roll the dice
            pairOfDice.roll();

            //Determine the outcome of the dice
            diceValue = pairOfDice.getDice();
            int die1 = diceValue[0];
            int die2 = diceValue[1];

            //If the result is win set continue to false and print the message
            if (pointEst == false && (pairOfDice.diceAdd() == 7 || pairOfDice.diceAdd() == 11) ){
                continueGame = false;
                printOut("win", die1, die2, point );

            //If the outcome is lose then set continue to false and print the lose message
            } else if (pointEst == false && (pairOfDice.diceAdd() == 2 || pairOfDice.diceAdd() == 3 || pairOfDice.diceAdd() == 12)) {
                printOut("lose", die1, die2, point);
                continueGame = false;
            
            //If there has been no point established then establish the point as the value of the dice added
            } else if (pointEst == false){ 
                printOut("new", die1, die2, pairOfDice.diceAdd());
                point = pairOfDice.diceAdd();
                pointEst = true;
            
            //If there has already been a point established
            } else if (pointEst == true){ 

                //If the new values is the same as the point then lose
                if (pairOfDice.diceAdd() == 7){
                    printOut("lose", die1, die2, point);
                    continueGame = false;
                }

                else if (pairOfDice.diceAdd() == point){
                    printOut("win", die1, die2, point);
                }

                //If the new values is not the same as the old point then continue the game and print the dice value
                 else if (pairOfDice.diceAdd() != point){
                    printOut("old", die1, die2, point);

                //Error message
                } else {
                    System.out.println("Error");
                }
            }
        }
    }

    //print method for printing the outcomes
    private static void printOut(String outcome, int dice1, int dice2, int point){
        //If the user wins give them a win message
        if (outcome == "win") {
            System.out.println("You won! The dice that were rolled were " + dice1 + " " + dice2);

        //If the user loses then give them a lose message
        } else if (outcome == "lose") {
            System.out.println("You lose! The dice that were rolled were " + dice1 + " " + dice2);

        //If neither and there is a new point established then give them a message
        } else if (outcome == "new") {
            System.out.println("The point is now " + point + " and the dice you rolled were " + dice1 + " " + dice2);

        //If it is not the first dice rolled then tell what the point is and give a message
        } else if (outcome == "old"){
            System.out.println("The point is " + point + " and the dice you rolled were " + dice1 + " " + dice2);

        //error message
        } else { 
            System.out.println("Error");
        }
    }
}
