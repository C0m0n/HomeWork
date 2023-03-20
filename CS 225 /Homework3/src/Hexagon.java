public class Hexagon extends GeometricObject {
     private double sides = 1; 

 
     //Empty constructor
     Hexagon(){
     }
 
     //Constructor with side
     Hexagon(double sides){
         this.sides = sides;
     }

     //Constructor with color and side
     Hexagon(double sides, String color, boolean filled){
         this.sides = sides;
         setColor(color);
         setFilled(filled);
     }
 
     //Set method for side
     void setSide(double sides){
         this.sides = sides;
     }

     //Get method for side
     double getSide(){
         return sides;
     }

     //Get area method
     @Override
     double getArea(){
         double area = (3 * Math.sqrt(3) * (Math.pow(sides, 2) / 2));
         return area;
     }
}
