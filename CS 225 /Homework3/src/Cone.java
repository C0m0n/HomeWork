public class Cone extends Circle {
    /* -----------------------------------------------
    Submitted By: David Greni
    Homework Number: 3
    Credit to: 
        
    Submitted On: June 10 2022
 
    By submitting this program with my name,
    I affirm that the creation and modification
    of this program is primarily my own work.
 ------------------------------------------------ */
    //This class extends the Circle class and has its own method for calculating the volume of a cone
    
    //Default height to be 1
    private double height = 1;

    //Empty constructor
    Cone(){
    }

    //Cone with set radius
    Cone(double radius){
        setRadius(radius);
    }

    //Cone with radius and height
    Cone(double radius, double height){
        setRadius(radius);
        this.height = height;
    }

    //Cone with radius and height and color
    Cone(double radius, double height, boolean filled){
        setRadius(radius);
        this.height = height;
        setFilled(filled);
    }

    //Get method for height
    double getHeight(){
        return height;
    }

    //Setter method for height
    void setHeight(double height){
        this.height = height; 
    }

    //Get volume method
    @Override
    double getVolume(){
        double volume; 
        //Equation for volume of cone
        volume = (Math.PI * Math.pow(getRadius(), 2)) * (height / 3 );
        return volume; 
    }
}
