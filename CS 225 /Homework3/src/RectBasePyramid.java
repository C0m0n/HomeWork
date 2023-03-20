public class RectBasePyramid extends Rectangle {
    private double height = 1;

    //Empty constructor
    RectBasePyramid(){
    }

    //Rectbasepyramid with side 1 
    RectBasePyramid(double side1){
        setSide1(side1);
    }

    //Rectbasepyramid with side 1 and height
    RectBasePyramid(double side1, double height){
        setSide1(side1);
        this.height = height;
    }
    //Rectbasepyramid with side 1 & 2 and height
    RectBasePyramid(double side1, double side2, double height){
        setSide1(side1);
        setSide2(side2);
        this.height = height;
    }

    //Rectbasepyramid with side 1 & 2 and height and color
    RectBasePyramid(double side1, double height, boolean filled){
        setSide1(side1);
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
        //Equation for volume of rectbasepirimid
        volume = (1 * getArea() * height) / 3;
        return volume; 
    }
}
