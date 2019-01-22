import java.util.ArrayList; //sp exam not arry list its list 
import java.util.Scanner;

public class ArrayListTester
{
    public static void main(String[] args){
       
        System.out.println("How Many Words:");
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int numWords = scan.nextInt();
        System.out.println(numWords);
        
        ArrayList<String> words = new ArrayList<String> ();
        //only objects and you specifcy the kind you want to get it out
        //<String> String data can go in
        
        words.add("fun");
        words.add("work");
        words.add(0, "sleep");
        
        System.out.println(words);
        System.out.println(words.size());
        words.remove("sleep");
        System.out.println(words);
        System.out.println(words.size());
        
        
        
        
    }
    }
