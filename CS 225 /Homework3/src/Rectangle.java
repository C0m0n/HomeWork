public class Rectangle extends GeometricObject {
    //Radius for the circle default is 1
    private double side1 = 1; 
    private double side2 = 1;

    //Empty constructor
    Rectangle(){
    }

    //Constructor with just one side
    Rectangle(double side1){
        this.side1 = side1;
    }

    //Rectangle with both sides
    Rectangle(double side1, double side2){
        this.side1 = side1;
        this.side2 = side2;
    }
    //Constructor with color and sides
    Rectangle(double side1, double side2, String color, boolean filled){
        this.side1 = side1;
        this.side2 = side2;
        setColor(color);
        setFilled(filled);
    }

    //Set method for side1
    void setSide1(double side1){
        this.side1 = side1;
    }
    //Set method for side2
    void setSide2(double side2){
        this.side2 = side2;
    }
    //Get method for side1
    double getSide1(){
        return side1;
    }
    //Get method for side2
    double getSide2(){
        return side2;
    }

    //Get area method
    @Override
    double getArea(){
        double area = side1 * side2; 
        return area;
    }
}
