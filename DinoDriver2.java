import java.util.Scanner;
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static void main(String[] args)
    {
        
        Scanner s = new Scanner(System.in);
        String youChose = "";
        System.out.println("How many Dinos");
        youChose = s.nextLine();
        Integer td = Integer.valueOf(youChose);
        

        
        int port = (int)(td/3);
        
        
        Dinosaur[] pop = new Dinosaur[td]; //null assinged if nothing there all intlaized to false

        for (int i = 0; i<port; i++)
        {
            pop[i] = new TRex();
        }
        for (int i = port; i<port*2; i++)
        {
            pop[i] = new LongNeck();
        }
        for (int i = port*2; i<(port*3)+1; i++)
        {
            pop[i] = new Stego();
        }

        int deadCount = 0;
        int rand = 0;
        //for each loop moves through entire list except no itterate option; d:pop d gets reasgined to each elemnt in list
        for(Dinosaur d:pop)
        {  
            rand = (int)(Math.random()*32);
            for (int j = 0; j<rand; j++)
            {
                d.ageUp();
            }
            
        }

        int winCount = 0;
        int battleCount = 0;
        int roundNum = 0;
        int deadInRound = 0;
        int rndDead = 0;
        int dead = 0;
        while (livingDinos(pop)>1){
            for(Dinosaur d:pop)
            { 
                d.ageUp();
            }
            for(Dinosaur d:pop) //for evey single data type do somthing ///will out put some thing above
            {

                if (d.getIsAlive() == true && livingDinos(pop)>1) {

                    battleCount++;

                    Dinosaur defend = getDefender(pop, d);

                    if(d.attack(defend)){
                        winCount++;
                    } 

                }
            

            }
            rndDead = (pop.length - livingDinos(pop)) - dead;
            dead = (pop.length - livingDinos(pop));
            roundNum++;
            System.out.println(" ROUND "+ roundNum + " Total battles: " + battleCount +
                " Died in Round: " + rndDead + " Total Alive:" + livingDinos(pop));
            
        }
        for(Dinosaur d:pop)
            { 
                if (livingDinos(pop)==1 && d.getIsAlive()){
            System.out.println("THE WINNER: " + d);
            }
            }
    }

    public static int livingDinos(Dinosaur[] p)
    {
        int living = 0;

        for (Dinosaur d: p) //for each go through each one
        {
            if (d.getIsAlive() == true) {
                living++;
            }

        }

        return living;
    }
    

    public static Dinosaur getDefender(Dinosaur[] p, Dinosaur attc)
    {
        Dinosaur def;//could set it to null but it mean you dont have to not iltized but can if set return null

        if (livingDinos(p) == 1){ //without this check that while at the bottom will loop forever
            return null;
        }

        do //want it to go through once its common //condtion is at end so it runs code once then checks at end 
        {
            int rand = (int)(Math.random()*p.length);
            def = p[rand];

        } while(def == attc || !def.getIsAlive()); // runs code check at end // or == false

        return def;
    }

}
