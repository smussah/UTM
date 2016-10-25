package cs125;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by smussah on 4/16/15.
 */
public class  utm_cs125 {
    public static void main(String[] args) throws FileNotFoundException {
     String w = null;
        StringConverter converter = new StringConverter();//String converter class constructor
        boolean wrongEntry = true;
        //do {
            try {
        System.out.println("Enter any string to run turing machine: ");

          w= converter.ascii.nextLine();



            }
            catch (InputMismatchException e) {
                System.out.println("Wrong entry! " +e.getMessage());
                System.out.println(" ");

            }
       // } while (wrongEntry);

      converter.UTM_Language=new String[w.length()];
      converter.ascii_Converter(w);//function call
                converter.to_tape();//method in string convertor
        tm_Tape tmTape = new tm_Tape();//tape class constructor
        Turing_Machine turing_machine = new Turing_Machine();






    }
}
