/*
* CSCI 305 - Java Programming Lab
*
* Zachariah Fahsi
* zachariah.fahsi@student.montana.edu
*/
package csci305.javalab;

public abstract class Element {
    String name = null;
    String win = null;
    
    public String getName() {
        return name;
    }
    // For each compareTo class, it compares to the 2 Elements it beats, and the same element
    // This will know if it wins, ties, or loses
    public abstract String compareTo(Element el);
}

class Rock extends Element {
    Rock(String nm) {
        name = nm;
    }
    @Override public String compareTo(Element el) {
        if(el.name.equals("Lizard") || el.name.equals("Scisssors")) {
            win = "Win";
        } else if (el.name.equals(name)) {
            win = "Tie";
        } else {
            win = "Lose";
        }
        Outcome out = new Outcome(el.name, name, win);
        return out.getOutcome();
    }
}
class Paper extends Element {
    Paper(String nm) {
        name = nm;
    }
    @Override public String compareTo(Element el) {
        if(el.name.equals("Rock") || el.name.equals("Spock")) {
            win = "Win";
        } else if (el.name.equals(name)) {
            win = "Tie";
        } else {
            win = "Lose";
        }
        Outcome out = new Outcome(el.name, name, win);
        return out.getOutcome();
    }
}
class Scisssors extends Element {
    Scisssors(String nm) {
        name = nm;
    }
    @Override public String compareTo(Element el) {
        if(el.name.equals("Paper") || el.name.equals("Lizard")) {
            win = "Win";
        } else if (el.name.equals(name)) {
            win = "Tie";
        } else {
            win = "Lose";
        }
        Outcome out = new Outcome(el.name, name, win);
        return out.getOutcome();
    }
}
class Lizard extends Element {
    Lizard(String nm) {
        name = nm;
    }
    @Override public String compareTo(Element el) {
        if(el.name.equals("Spock") || el.name.equals("Paper")) {
            win = "Win";
        } else if (el.name.equals(name)) {
            win = "Tie";
        } else {
            win = "Lose";
        }
        Outcome out = new Outcome(el.name, name, win);
        return out.getOutcome();
    }
}
class Spock extends Element {
    Spock(String nm) {
        name = nm;
    }
    @Override public String compareTo(Element el) {
        if(el.name.equals("Scisssors") || el.name.equals("Rock")) {
            win = "Win";
        } else if (el.name.equals(name)) {
            win = "Tie";
        } else {
            win = "Lose";
        }
        Outcome out = new Outcome(el.name, name, win);
        return out.getOutcome();
    }
}
