
/**
 * Abstract class Dinosaur - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Dinosaur
{
    private String type;
    private int age;
    private String gender;
    private int wins;
    private int battleCount;
    private int health; // 0 is dead 100 alive
    private boolean isAlive;

    /**
     * Dino constructor
     * there is no defalut constructor becuase it must be abstract to add to it later.
     * For futher coders down the line to edit+add new dinos. Not just to have TRex's but LongNeck's
     */

    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        this.wins = 0;
        this.health = 10;
        this.battleCount = 0;
        this.isAlive = true;
        if (Math.random() < 0.5)
        {
            this.gender = "M";
        }
        else
        {
            this.gender = "F";
        }
    }

    /**
     * **************************************SETTERS************************************************
     */
    public void setType (String t) 
    {
        this.type = t;
    }

    public void ageUp() 
    {
        this.age++;

        if (age>25)
        {
            this.health = this.health - (int)(Math.random()*20);
            //this.setHealth(this.getHealth - (int)(Math.random()*10));
        }
        else
        {
            this.health = this.health + 10;
            //this.setHealth(this.getHealth()+10);
        }

        if (this.health > 100)
        {
            this.health = 100;
        }
        this.checkHealth();
    }

    public void checkHealth()
    {
        if(this.health <= 0)
        {
            if(this.isAlive == true)//health is 0 but isAlive is true = just died
            {
                System.out.println("\t"+this.toString() + " Just Died :(");
            }
            this.isAlive = false;
            this.health = 0;
        }
        else if (this.health > 100)
        {
            this.health = 100;
        }
    }

    public void setWins(int wn) 
    {
        this.wins = wn;
    }

    public void setBattleCount(int n)
    {
        this.battleCount = n;
    }

    public void setHealth(int healh) 
    {
        this.health = healh;
    }

    public void setGender(String newGen) 
    {
        this.gender = newGen;
    }

    public void setIsAlive(boolean a)
    {
        this.isAlive = a;   
    }

    public void update(Dinosaur def, boolean winner)
    {
        this.battleCount++;
        def.setBattleCount(def.getBattleCount()+1);
        if (winner == true)
        {
            this.wins++; //increases wins of winning dinasour 
            def.setHealth(def.getHealth() - 20);
            def.checkHealth();
        }
        else
        {
            def.setWins(def.getWins() + 1); //increases wins od defednign dino becuase it won
            this.health -= 20;
            this.checkHealth();
        }
    }

    /**
     * *******************************GETTERS*************************************************
     */

    public String getType()
    {
        return this.type;
    }

    public int getAge()
    {
        return this.age;
    }

    public int getWins()
    {
        return this.wins;
    }

    public int getBattleCount()
    {
        return this.battleCount;
    }

    public int getHealth()
    {
        return this.health;
    }

    public String getGender()
    {
        return this.gender;
    }

    public boolean getIsAlive()
    {
        return this.isAlive;
    }

    /************************************METHODS********************************************
     * 
     */

    /**
     * attack is abstract becuase the resulting attacks aginst different dino types will be diffrent 
     * one dino winning all the time would result in a very short lived dinosour game with just a Trex having 
     * the same killing power as a LongNeck. 
     */
    public abstract boolean attack(Dinosaur def); //this is what makes this an abstract class you must define this method 

    public String toString() //returns private data as a string
    {
        String temp = " ";
        temp = this.type + " A:"+ this.age + " W:"+ this.wins + " H:"+ this.health + " BC:"+ this.battleCount + " G:"+ this.gender;
        return temp;
    }

}
