/*
* CSCI 305 - Java Programming Lab
*
* Zachariah Fahsi
* zachariah.fahsi@student.montana.edu
*/
package csci305.javalab;

import java.util.Random;

public abstract class Player {
    String name = null;
    int iterate = 0;
    Element last = null;
    public String getName() {
        return name;
    }
    public Player(String nm) {
        name = nm;
    }
    public abstract Element play();
}

class StupidBot extends Player { //Always plays rock
    public StupidBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        // Always returns rock
        return RPSLS.moves[0];
    }
}
class RandomBot extends Player { //Random choice
    public RandomBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        Random rand = new Random();
        // Chooses a random int between 0 and total # of moves to play
        return RPSLS.moves[rand.nextInt(RPSLS.moves.length)];
    }
}
class IterativeBot extends Player { //Chooses next in series
    public IterativeBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        // Adds one to iterate variable
        ++iterate;
        // Sets itterate variable back to 0 if exceeds number of total moves
        if(iterate==RPSLS.moves.length)
            iterate = 0;
        return RPSLS.moves[iterate];
    }
}
class LastPlayBot extends Player { //Chooses last of oppenent
    public LastPlayBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        // Return rock if no last move, or pick last move of opponent
        return (last == null) ? RPSLS.moves[0] : last;
    }
}
class Human extends Player { //User chooses
    public Human(String nm) {
        super(nm);
    }
    @Override public Element play() {
        // Give human throw options
        System.out.println("(1) : Rock\n(2) : Paper\n(3) : Scissors"
                + "\n(4) : Lizard\n(5) : Spock");
        // Make sure it goes thru the while loop at least once
        int humanMove = -1;
        // Loop until human has picked valid bumber
        while(humanMove < 1 || humanMove > 5) {
            System.out.print("Enter your move: ");
            // Read human input
            humanMove = RPSLS.reader.nextInt();
            // If not valid, tell human
            if(humanMove < 1 || humanMove > 5)
                System.out.println("Invalid move. Please try again.");
        }
        // Return move human picked
        return RPSLS.moves[humanMove-1];
    }
}
class MyBot extends Player { //Random that beats previous move
    public MyBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        Random rand = new Random();
        // Randomly pick 0 or 1
        int rd = (rand.nextInt()%2 == 0) ? 0 : 1;
        Element[] win = new Element[2];
        // If first move, pick rock
        if(last == null)
            return RPSLS.moves[0];
        else {
            System.out.println(last.name);
                // Sitch stateement based on last move, will randomly pick a move that beats the last move
            switch(last.name) {
                case "Rock":
                    win[0] = RPSLS.moves[1];
                    win[1] = RPSLS.moves[4];
                    break;
                case "Paper":
                    win[0] = RPSLS.moves[2];
                    win[1] = RPSLS.moves[3];
                    break;
                case "Scisssors":
                    win[0] = RPSLS.moves[0];
                    win[1] = RPSLS.moves[4];
                    break; 
                case "Lizard":
                    win[0] = RPSLS.moves[0];
                    win[1] = RPSLS.moves[2];
                    break;
                case "Spock":
                    win[0] = RPSLS.moves[1];
                    win[1] = RPSLS.moves[3];
                    break;
            }
        }
        return win[rd];
    }
}