package cs125;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by smussah on 4/22/15.
 */
public class StringConverter{
    public static int ascii_to_int = 0;
    public static String[] UTM_Language;
    //StringConverter stringConverter = new StringConverter();
    Scanner ascii = new Scanner(System.in);

    public static void ascii_Converter(String w) {
        ArrayList<String> e = new ArrayList<String>();
        for (int i = 0; i < w.length(); i++) {
            char t = w.charAt(i);
            ascii_to_int = t;
            Integer x = new Integer(ascii_to_int);
            String binary = Integer.toBinaryString(x);
            UTM_Language[i] = binary;


        }

    }

    public static void to_tape() throws FileNotFoundException {
        StringBuffer str_to_tape = new StringBuffer("");
        for(int i = 0; i<10; i++){
            str_to_tape.append("#");
        }
        for(int i = 0; i<UTM_Language.length; i++){
            str_to_tape.append(UTM_Language[i]);
        }
        new tm_Tape(str_to_tape);
      // tm_Tape.main_tape(str_to_tape);
    }

}