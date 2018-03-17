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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player[] allPlayers = {new Human("Human"),new StupidBot("StupidBot"),
            new RandomBot("RandomBot"),new IterativeBot("IterativeBot"),
            new LastPlayBot("LastPlayBot"),new MyBot("MyBot")};

        System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock, "
                + "implemented by Zachariah Fahsi.\n\nPlease choose two players:"
                + "\n(1) Human\n(2) StupidBot\n(3) RandomBot\n(4) IterativeBot"
                + "\n(5) LastPlayBot\n(6) MyBot");
        int player1 = -1, player2 = -1;
        while(player1 < 1 || player1 > 6) {
            System.out.print("Select player 1: ");
            player1 = reader.nextInt();
            if(player1 < 1 || player1 > 6)
                System.out.println("Invalid player. Please pick again.");
        }
        while(player2 < 1 || player2 > 6) {
            System.out.print("Select player 2: ");
            player2 = reader.nextInt();
            if(player2 < 1 || player2 > 6)
                System.out.println("Invalid player. Please pick again.");
        }
        Player p1 = allPlayers[player1-1];
        Player p2 = allPlayers[player2-1];
        for (int i = 0; i < 5; i++) {
            Element p1move = p1.play();
            Element p2move = p2.play();
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
        System.out.println(winner());
    } 
    static String winner() {
        String endText = null;
        if(win>lose)
            endText = "Player 1 wins";
        else if(win<lose)
            endText = "Player 2 wins";
        else
            endText = "Game was a draw";
        return "\nThe score is "+win+" to "+lose+".\n"+endText;
    }
}