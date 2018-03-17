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
    Element[] moves = {new Rock("Rock"),new Paper("Paper"),
            new Scisssors("Scisssors"),new Lizard("Lizard"),new Spock("Spock")};
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
        return moves[0];
    }
}
class RandomBot extends Player { //Random choice
    public RandomBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        Random rand = new Random();
        return moves[rand.nextInt(moves.length)];
    }
}
class IterativeBot extends Player { //Chooses next in series
    public IterativeBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        ++iterate;
        if(iterate==moves.length)
            iterate = 0;
        return moves[iterate];
    }
}
class LastPlayBot extends Player { //Chooses last of oppenent
    public LastPlayBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        return (last == null) ? moves[0] : last;
    }
}
class Human extends Player { //User chooses
    public Human(String nm) {
        super(nm);
    }
    @Override public Element play() {
        System.out.println("(1) : Rock\n(2) : Paper\n(3) : Scissors"
                + "\n(4) : Lizard\n(5) : Spock");
        int humanMove = -1;
        while(humanMove < 1 || humanMove > 5) {
            System.out.print("Enter your move: ");
            humanMove = RPSLS.reader.nextInt();
            if(humanMove < 1 || humanMove > 5)
                System.out.println("Invalid move. Please try again.");
        }
        return moves[humanMove-1];
    }
}
class MyBot extends Player { //Random that beats previous move
    public MyBot(String nm) {
        super(nm);
    }
    @Override public Element play() {
        Random rand = new Random();
        int rd = (rand.nextInt()%2 == 0) ? 0 : 1;
        Element[] win = new Element[2];
        if(last == null)
            return moves[0];
        else {
            System.out.println(last.name);
            switch(last.name) {
                case "Rock":
                    win[0] = moves[1];
                    win[1] = moves[4];
                    break;
                case "Paper":
                    win[0] = moves[2];
                    win[1] = moves[3];
                    break;
                case "Scisssors":
                    win[0] = moves[0];
                    win[1] = moves[4];
                    break; 
                case "Lizard":
                    win[0] = moves[0];
                    win[1] = moves[2];
                    break;
                case "Spock":
                    win[0] = moves[1];
                    win[1] = moves[3];
                    break;
            }
        }
        return win[rd];
    }
}