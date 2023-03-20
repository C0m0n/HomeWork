public class TriBasePyramid extends Triangle {
    
    private double height = 1;

    //Empty constructor
    TriBasePyramid(){
    }

    // TriBasePyramid with set radius
    TriBasePyramid(double side){
        setSide(side);
    }

    //TriBasePyramid with radius and height
    TriBasePyramid(double side, double height){
        setSide(side);
        this.height = height;
    }

    //TriBasePyramid with radius and height and color
    TriBasePyramid(double side, double height, boolean filled){
        setSide(side);
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
        volume = (1 * getArea() * height) / 3;
        return volume; 
    }
}
