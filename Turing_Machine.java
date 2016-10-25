package cs125;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by smussah on 4/23/15.
 */
public class Turing_Machine {//main class
    public static ArrayList<Character> new_tape = null;
    public static PrintWriter write = null;
    public static ArrayList<Character> sigma = null;
    public static int headposition;
    public static char read;
    public static char moveRight;
    public static char moveLeftt;
    public static String[] TMconfiguration = {"A0B#R", "B0B0R", "C0D1L",
            "D0D0L", "E0E0L", "F0F#R",
            "A1F#R", "B1C1R", "C1C1R",
            "D1D1L", "E1E#L", "F1F#R",
            "D#E#L", "D#A#R", "E#G0R", "F#G#R","H"};
   // public static char halt;
    public static char currentstate;
    public static ArrayList<Character> inpu_language = null;

    /**
     * #param tape pass converted binaries to method Turing machine
     * #throws FileNotFoundException
     */
    public Turing_Machine(ArrayList<Character> tape) throws FileNotFoundException { // constructor passing args to method   tm_Stimulation


        sigma = new ArrayList<Character>();
        write = new PrintWriter("Turing_Machine.txt");// output text file
        new_tape = new ArrayList<Character>();

        inpu_language = tape;
        String lang_tm = "01#";// turing machine language..
        for (int i = 0; i < lang_tm.length(); i++) {
            sigma.add(lang_tm.charAt(i));//load 0, 1 and B to sigma variable

            moveLeftt = 'L';
            moveRight = 'R';
        }

        tm_Stimulation(inpu_language, TMconfiguration); // call Turing machine method & pass tape, configuration
        System.out.println("\n");

    }

    /**
     * constructor without args
     *
     * #throws FileNotFoundException
     */
    public Turing_Machine() throws FileNotFoundException { // constructor without args
        inpu_language = new ArrayList<Character>();
        read = 0;
    }

    /**
     * #param tape pass turing machine tape/ input language
     * #param tape_Str pass Turing machine configurations
     */
    public static void tm_Stimulation(ArrayList<Character> tape, String[] tape_Str) {
       // System.out.println(tape.toString());
        StringBuffer work_tape = new StringBuffer();// create Stringbuffer to append working space
        char halt ='H';
        currentstate = 'A';
        headposition = 0;
        int median = tape.size()/2;
          while (currentstate != halt) { headposition = median;
                for (int i = 0; i < tape_Str.length; i++) {
                    if (currentstate==tape_Str[i].charAt(0) && tape.get(headposition) == tape_Str[i].charAt(1))
                    {
                        currentstate = tape_Str[i].charAt(2);
                        if(tape_Str[i].charAt(4) == moveRight)
                            headposition++;
                           write.print( tape.set(i, tape_Str[i].charAt(3)));
                            work_tape.append(tape.toString().replace(",", "").replace("[", "").replace("]", "") + "\n");

                        if(tape_Str[i].charAt(4) == moveLeftt )
                            headposition--;
                            write.print(tape.set(i, tape_Str[i].charAt(3)));
                            work_tape.append(tape.toString().replace(",", "").replace("[", "").replace("]", ""));

                    }

                }
currentstate++;
            }
         //   write.print(work_tape);


            write.close();// warp-up text file



    }
}

