public class Triangle extends GeometricObject {
    //This class extends the Geometric object class and has its own method for calculating the area of a triangle
    
    private double sides = 1;

    //Default constructor
    Triangle(){
    }

    //Method with set sides
    Triangle(double sides){
        this.sides = sides;
    } 

    //Constructor with color and filled
    Triangle(double sides,  String color , boolean filled){
        this.sides = sides;
        setColor(color);
        setFilled(filled);
    }

    //Set method
    void setSide(double sides){
        this.sides = sides;
    }
    //Get method
    double getSides(){
        return sides;
    }

    //Override the get area method from the parent class
    @Override
    double getArea(){
        double area;
        area = (Math.sqrt(3) / 4 * Math.pow(sides, 2));
        return area;
    }
}
