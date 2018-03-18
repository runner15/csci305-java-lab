/*
* CSCI 305 - Java Programming Lab
*
* Zachariah Fahsi
* zachariah.fahsi@student.montana.edu
*/
package csci305.javalab;

import java.util.HashMap;
import java.util.Map;

public class Outcome {
    String out = null;
    String result = null;
    Outcome(String el1, String el2, String result) {
        this.result = result;
        // Counts total number of wins/ties/loses
        switch (result) {
            case "Win":
                RPSLS.win++;
                break;
            case "Lose":
                RPSLS.lose++;
                break;
            default:
                RPSLS.tie++;
                break;
        }
        // Creates hashmap of all the elements and assigns them to numbers
        Map<String, Integer> elem = new HashMap<>();
        elem.put("Rock",0);elem.put("Paper",1);elem.put("Scisssors",2);elem.put("Lizard",3);elem.put("Spock",4);
        // Check if tied
        if (el1 == el2) {
            out = el1+" equals "+el2;
        } else {
            // If element 1 is bigger than element 2, switch them, to make the following switch statement shorter
            if(elem.get(el1)>elem.get(el2)) {
                String temp = el1;
                el1 = el2;
                el2 = temp;
            } 
            // Switch statement to determine what to print on the win condition
            switch(el1) {
                case "Rock":
                    switch(el2) {
                        case "Paper":
                            out = "Paper covers Rock";
                            break;
                        case "Scisssors":
                            out = "Rock crushes Scissors";
                            break;
                        case "Lizard":
                            out = "Rock crushes Lizard";
                            break;
                        case "Spock":
                            out = "Spock vaporizes Rock";
                            break;
                    }
                    break;
                case "Paper":
                    switch(el2) {
                        case "Scisssors":
                            out = "Scissors cut Paper";
                            break;
                        case "Lizard":
                            out = "Lizard eats Paper";
                            break;
                        case "Spock":
                            out = "Paper disproves Spock";
                            break;
                    }
                    break;
                case "Scisssors":
                    switch(el2) {
                        case "Lizard":
                            out = "Scissors decapitate Lizard";
                            break;
                        case "Spock":
                            out = "Spock smashes Scissors";
                            break;
                    }
                    break;
                case "Lizard":
                    out = "Lizard poisons Spock";
            }
        }
    }
    String getOutcome() { 
        return out+" -- "+result;
    }
}
