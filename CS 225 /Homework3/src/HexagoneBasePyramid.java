public class HexagoneBasePyramid extends Hexagon {
    private double height = 1;

    //Empty constructor
    HexagoneBasePyramid(){
    }

    //Rectbasepyramid with side 
    HexagoneBasePyramid(double side){
        setSide(side);
    }

    //Rectbasepyramid with side and height
    HexagoneBasePyramid(double side, double height){
        setSide(side);
        this.height = height;
    }

    //Rectbasepyramid with side  and height and color
    HexagoneBasePyramid(double side, double height, boolean filled){
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
        //Equation for volume of hexbasepirimid
        volume = (1 * getArea() * height) / 3;
        return volume; 
    }
}
