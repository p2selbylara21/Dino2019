
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{
    public static void main(String[] args)
    {
        //Dinosaur d = new Dinosaur("dino"); cant do this becuase its abstract
        //t rex is a dinosour store tRex in a dinosaur but cant store dinosaur in TRex 

        Dinosaur d1 = new TRex();
        Dinosaur d2 = new TRex();
        Dinosaur d3 = new LongNeck();
        Dinosaur d4 = new Stego();
        

        // d1.setHealth(100);
        // d2.setHealth(100);
        // int winCountr = 0;
        // for(int i=0; i<1000; i++)
        // {

            // if (d1.attack(d2)==true)
            // {
                // winCountr++;
                
            // }
            // System.out.println("Dino 1:" +d1.toString() + " *** Dino 2: " + d2.toString());
            

        // }
        // System.out.println(winCountr + "out of 1000 attacks");
    }
}

