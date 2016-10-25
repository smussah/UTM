package cs125;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by smussah on 4/22/15.
 */
public class tm_Tape  {
    ArrayList<Character> tape = new ArrayList<Character>();
    public tm_Tape(){

    }
     tm_Tape(StringBuffer w) throws FileNotFoundException {

        main_tape(tape, w);
        }
public static void main_tape(ArrayList<Character> tape, StringBuffer w) throws FileNotFoundException {
       String pound = "#";
    tape.add(0, pound.charAt(0));//add at the beginning of the tape
    for(int i = 0; i<w.length(); i++){
        if(tape.indexOf(i) != pound.charAt(0)){
            tape.add(w.charAt(i));
           }
    }
    tape.add(tape.size(), pound.charAt(0));//put # at the end of the tape
new Turing_Machine(tape);// pass tape element to Turing machine class

}


}





