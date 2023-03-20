public class Test {
    public static void main(String[] args) {
        /* -----------------------------------------------
    Submitted By: David Greni
    Homework Number: 3
    Credit to: 
        
    Submitted On: June 10 2022
 
    By submitting this program with my name,
    I affirm that the creation and modification
    of this program is primarily my own work.
 ------------------------------------------------ */
//This class is just a test class that insures each class works with the correct constructors


        GeometricObject[] aObjects = new GeometricObject[9];
        GeometricObject[] bObjects = new GeometricObject[13];

        aObjects[0] = new Circle();
        aObjects[1] = new Circle(2);
        aObjects[2] = new Triangle();
        aObjects[3] = new Triangle(5);
        aObjects[4] = new Rectangle();
        aObjects[5] = new Rectangle(5);        
        aObjects[6] = new Rectangle(5, 4);
        aObjects[7] = new Hexagon();
        aObjects[8] = new Hexagon(5);

        bObjects[0] = new Cone();
        bObjects[1] = new Cone(5);
        bObjects[2] = new Cone(5,5);
        bObjects[3] = new TriBasePyramid();
        bObjects[4] = new TriBasePyramid(5);
        bObjects[5] = new TriBasePyramid(5 , 7);
        bObjects[6] = new RectBasePyramid();
        bObjects[7] = new RectBasePyramid(5);
        bObjects[8] = new RectBasePyramid(5,4);
        bObjects[9] = new RectBasePyramid(5,7,8);
        bObjects[10] = new HexagoneBasePyramid();
        bObjects[11] = new HexagoneBasePyramid(5);
        bObjects[12] = new HexagoneBasePyramid(5, 7);

        for(int i = 0 ; i < aObjects.length; i++){
            System.out.println(aObjects[i].getArea());
        }
        for (int i = 0; i < bObjects.length; i++){
            System.out.println(bObjects[i].getVolume());
        }

    }
}