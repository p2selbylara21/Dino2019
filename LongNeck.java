
/**
 * Write a description of class LongNeck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LongNeck extends Dinosaur
{
    
    public LongNeck()
    {
        super ("LongNeck");
    }

    public boolean attack(Dinosaur def)
    {
        if (def.getIsAlive() == true) {
            double prob = 0.0;
            if (def.getType().equals("TRex")) {
                prob = 0.40;
            }
            else if(def.getType().equals("LongNeck")){
                prob = 0.55;
            }
            else if(def.getType().equals("Stego")){
                prob = 0.65;
            }
            else 
            {
                prob = 0.60;
            }
            
            if (Math.random() <= prob)
            {
                this.update(def, true);
                return true;
            }
            else  
            {
                this.update(def, false);
                return false;
            }
        }
        else
        {
            return true;
        }
    }
}
