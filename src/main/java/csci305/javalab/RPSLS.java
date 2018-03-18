/*
* CSCI 305 - Java Programming Lab
*
* Zachariah Fahsi
* zachariah.fahsi@student.montana.edu
*/
package csci305.javalab;

import java.util.Scanner;

public class RPSLS {
static Scanner reader = new Scanner(System.in);
static int win, tie, lose;
// Create all the instances of moves, so they only have to be created once
static final Element[] moves = {new Rock("Rock"),new Paper("Paper"),
        new Scisssors("Scisssors"),new Lizard("Lizard"),new Spock("Spock")};
    // Main class that is called
    public static void main(String[] args) {
        // Create Array of players
        Player[] allPlayers = {new Human("Human"),new StupidBot("StupidBot"),
            new RandomBot("RandomBot"),new IterativeBot("IterativeBot"),
            new LastPlayBot("LastPlayBot"),new MyBot("MyBot")};
        // Print out initial game start rules/instructions
        System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock, "
                + "implemented by Zachariah Fahsi.\n\nPlease choose two players:"
                + "\n(1) Human\n(2) StupidBot\n(3) RandomBot\n(4) IterativeBot"
                + "\n(5) LastPlayBot\n(6) MyBot");
        // Make sure goes through asking for each player loop once
        int player1 = -1, player2 = -1;
        // Ask for player 1
        while(player1 < 1 || player1 > 6) {
            System.out.print("Select player 1: ");
            player1 = reader.nextInt();
            // Tell user input is invalid
            if(player1 < 1 || player1 > 6)
                System.out.println("Invalid player. Please pick again.");
        }
        // Ask for player 2
        while(player2 < 1 || player2 > 6) {
            System.out.print("Select player 2: ");
            player2 = reader.nextInt();
            // Tell user input is invalid
            if(player2 < 1 || player2 > 6)
                System.out.println("Invalid player. Please pick again.");
        }
        // Sets user input to players that were created above
        Player p1 = allPlayers[player1-1];
        Player p2 = allPlayers[player2-1];
        // Plays the game 5 times
        for (int i = 0; i < 5; i++) {
            // Each player throws an Element
            Element p1move = p1.play();
            Element p2move = p2.play();
            // Set the last variable for the LastPlayBot and MyBot
            if(p1.name.equals("LastPlayBot") || p1.name.equals("MyBot"))
                p1.last = p2move;
            if(p2.name.equals("LastPlayBot") || p2.name.equals("MyBot")) 
                p2.last = p1move;
            System.out.println("\nRound "+(i+1)+":");
            System.out.println("  "+p1.name+" vs "+p2.name+". Go!");
            System.out.println("  Player 1 chooses "+p1move.name);
            System.out.println("  Player 2 chooses "+p2move.name);
            System.out.println("  "+p1move.compareTo(p2move));
        }
        // Print out winner the correct format
        System.out.println(winner());
    } 
    // Calculates and prints the winner
    static String winner() {
        String endText = null;
        // Keeps track for player 1, so everything is based on that
        if(win>lose)
            endText = "Player 1 wins";
        else if(win<lose)
            endText = "Player 2 wins";
        else
            endText = "Game was a draw";
        return "\nThe score is "+win+" to "+lose+".\n"+endText;
    }
}