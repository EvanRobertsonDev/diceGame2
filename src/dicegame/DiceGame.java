/*
 * DiceGame.java
 * Evan Robertson
 * February 2 2021
 * This program uses the die class to simulate a game of dice, whoever had the
 * highest number the most times out of 10 rolls, wins the game.
 * You are requiresd to enter the name of the computer and your name before 
 * starting.
 */
package dicegame;
import java.util.*;

/**
 *
 * @author Evan Robertson
 */
public class DiceGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Input
        Scanner input = new Scanner(System.in);
        
        //Constants
        final int DIE1_SIDES = 6;
        final int DIE2_SIDES = 6;
        final int MAX_ROLLS = 10;
        
        //Score variables
        int compScore = 0;
        int userScore = 0;
        
        //Create dice objects
        die die1 = new die(DIE1_SIDES);
        die die2 = new die(DIE2_SIDES);
        
        //Get name of computer
        System.out.println("Enter the name of the computer");
        while (die1.getComputerName() == null) {
            die1.setComputerName(input.nextLine());
        }
        
        //Get name of user
        System.out.println("Enter the name of the user");
        while (die2.getUserName() == null) {
            die2.setUserName(input.nextLine());
        }
        
        //Print info
        System.out.println("This program simulates rolling a " + DIE1_SIDES + " sided die and a " + DIE2_SIDES + " sided die");
        System.out.println("Rolling the dice" + MAX_ROLLS + " times...");
        System.out.println("Die1  Die2");
        
        //Loop for 10 rolls
        for(int i = 0; i < MAX_ROLLS; i++) {
            
            die1.roll();
            die2.roll();
            
            //Increase scores
            if (die1.getValue() > die2.getValue()) {
                compScore++;
            }
            
            else if (die1.getValue() < die2.getValue()) {
                userScore++;
            }
            
            //Print results
            System.out.println(die1.getValue() + "     " + die2.getValue());
        }
        //Print score
        System.out.println("Computer: " + compScore);
        System.out.println("User: " + userScore);
        
        //Determine and print winner
        if (compScore > userScore) {
             System.out.println("The grand winner is computer " 
                     + die1.getComputerName());
        }
        else if (compScore < userScore) {
            System.out.println("The grand winner is computer " 
                    + die2.getUserName());
        }
        else {
            System.out.println("There is a tie between " 
                    + die1.getComputerName() + " and " + die2.getUserName());
        }
        
 

    }
    
}
