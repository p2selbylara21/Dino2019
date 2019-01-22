
/**
 * Write a description of class DinoDriver3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class DinoDriver3
{
    public static void main (String[] args)
    {
        ArrayList<Dinosaur> myPop = new ArrayList<Dinosaur>();

        System.out.println("How Many Dinos:");

        Scanner scan = new Scanner(System.in);
        int dinosNum = scan.nextInt();
        System.out.println(dinosNum);

        for (int i = 0; i <dinosNum; i++)
        {
            int rand  = (int)(Math.random()*3);
            if (rand == 0)
            {
                myPop.add(new TRex());
            }
            if (rand == 1)
            {
                myPop.add(new LongNeck());
            }
            if (rand == 2)
            {
                myPop.add(new Stego());
            }
        }

        for(Dinosaur d:myPop)
        {  
            int rand = (int)(Math.random()*32);
            for (int j = 0; j<rand; j++)
            {
                d.ageUp();
            }

            System.out.println(d);
        }
        removeDeadDinos(myPop);

        int winCount = 0;
        int battleCount = 0;
        int roundNum = 0;
        int deadInRound = 0;
        int rndDead = 0;
        int dead = 0;
        while (myPop.size()>1){
            for(Dinosaur d:myPop)
            { 
                d.ageUp();

            }

            for(Dinosaur d:myPop) 
            {

                if (d.getIsAlive() == true && myPop.size()>1) {

                    battleCount++;

                    Dinosaur defend = myPop.get(DinoDriver3.getDefender(myPop, d));

                    if(d.attack(defend)){
                        winCount++;
                    } 

                }

            }

            
            int birthsNum = 0;

            Dinosaur randomMater = myPop.get( (int) (Math.random() * myPop.size()));
            while (!matable(randomMater)) {
                randomMater = myPop.get( (int) (Math.random() * myPop.size()));
            }
            if( weddingBells(danceCard(myPop), randomMater) == true ){
                for (int i =0; i < 5; i++)
                {
                    if (randomMater.getType() == "TRex") {
                        myPop.add(new TRex ());
                        birthsNum++;
                    }
                    if (randomMater.getType() == "Stego") {
                        myPop.add(new Stego ());
                        birthsNum++;
                    }
                    if (randomMater.getType() == "LongNeck") {
                        myPop.add(new LongNeck ());
                        birthsNum++;
                    }

                }
            }

            rndDead = (myPop.size() - livingDinos(myPop)) - dead;
            dead = (myPop.size() - livingDinos(myPop));
            roundNum++;

            System.out.println(" ROUND "+ roundNum + " Total battles: " + battleCount +
                " Died in Round: " + rndDead + " Total Alive:" + livingDinos(myPop) +" Dinosaurs Born: " + birthsNum);

        }
        for(Dinosaur d:myPop)
        { 
            if (myPop.size()==1  && d.getIsAlive()){
                System.out.println("THE WINNER: " + d);
            }
        }

    }

    public static boolean matable(Dinosaur d)
    {
        if ((d.getHealth() > 20) && (d.getAge() > 7  && d.getAge() < 32) )
        {
            return true;
        }
        else {
            return false;
        }
    }

    public static ArrayList danceCard(ArrayList <Dinosaur> p)
    {
        ArrayList<Dinosaur> tenPrecent = new ArrayList<Dinosaur>();
        int tenRand = (int) (p.size()*0.1);
        for(int i =0; i<tenRand; i++) {
            int rand = (int) (Math.random() * p.size());
            tenPrecent.add(p.get(rand));
        }
        return tenPrecent;
    }

    public static boolean weddingBells(ArrayList <Dinosaur> p, Dinosaur d)
    {
        boolean baby = true; 

        Dinosaur mate;

        int rand = -1;
        do 
        {
            rand = (int)(Math.random()*p.size());
            mate = p.get(rand);

        } while(mate == d || !mate.getIsAlive()); 

        if ((matable(mate) == true) && (mate.getType().compareTo(d.getType()) ) == 0 ) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int livingDinos(ArrayList <Dinosaur> p)
    {
        int living = 0;

        for (Dinosaur d: p) 
        {
            if (d.getIsAlive() == true) {
                living++;
            }
        }

        return living;
    }

    public static void removeDeadDinos( ArrayList<Dinosaur> p )
    {
        for(int i =0; i<p.size(); i++) {
            if(p.get(i).getIsAlive() == false)
            {
                System.out.println(p.get(i) + "dead");
                p.remove(i);
                i--;
            }
        }

    }

    public static int getDefender(ArrayList <Dinosaur> p, Dinosaur attc)
    {
        Dinosaur def;

        int rand = -1;
        do 
        {
            rand = (int)(Math.random()*p.size());
            def = p.get(rand);

        } while(def == attc || !def.getIsAlive()); 

        return rand;
    }

}