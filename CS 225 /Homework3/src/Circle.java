public class Circle extends GeometricObject {
//This class extends the Geometric object class and has its own method for calculating the area of a circle

    //Radius for the circle default is 1
    private double radius = 1; 

    //Empty constructor
    Circle(){
    }

    //Constructor with just radius
    Circle(double radius){
        this.radius = radius;
    }

    //Constructor with color
    Circle(double radius, String color, boolean filled){
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    //Set method for radius
    void setRadius(double radius){
        this.radius = radius;
    }

    //Get method for radius
    double getRadius(){
        return radius;
    }

    //Get area method
    @Override
    double getArea(){
        double area = radius *  radius * Math.PI;
        return area;
    }
}
