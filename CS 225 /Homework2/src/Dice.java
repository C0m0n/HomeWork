import java.util.Random;

public class Dice {
    //This class will create two dice that will have methods to be randomly rolled 
    //Create variables for the dice and object for random
    Random random = new Random();
    private int[] dice = new int[2];

    //Constructor for dice
    Dice(){
    }

    //Roll method that makes the dice values random
    void roll(){
        //Set the values for the dice that are random
        this.dice[0] = random.nextInt(6) + 1;
        this.dice[1] = random.nextInt(6) + 1;
    }

    //Return method for the dice value
    int[] getDice(){
        return dice;
    }

    //Method for adding dice
    int diceAdd(){
        int added = dice[0] + dice[1];
        return added;
    }
}
