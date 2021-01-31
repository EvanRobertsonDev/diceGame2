/*
 * die.java
 * Evan Robertson
 * February 2 2021
 * This class takes the number of sides on a dice, and the name of the computer
 * and user, checking if both meet certain requirements. The roll method 
 * determines what would have been rolled on the dice, given the amount of sides
 * it has.
 */
package dicegame;

/**
 *
 * @author Evan Robertson
 */
public class die {
    //Constant for length of computer name
    final int COMPUTER_LENGTH = 8;
    
    //Private variables
    String computerName, userName;
    int sides, value;
    
    //Constructor given the sides
    public die(int sides) {
        this.sides = sides;
    }
    //Constructor given the names
    public die(String computerName, String userName) {
    
    }
    
    //Returns the amount of sides on the dice
    public int getSide() {
        return sides;
    }
    
    //Sets the number of sides on the dice
    public void setSide(int sides) {
        this.sides = sides;
    }
    
    //Returns the value of the dice
    public int getValue() {
        return value;
    }
    
    //Sets the value of the dice
    public void setValue(int value) {
        this.value = value;
    }
    
    //Simulates the roll of the dice given the sides
    public void roll() {
        value = 1 + (int)(Math.random() * sides);
    }
    
    //Returns the name of the computer
    public String getComputerName() {
        return computerName;
    }
    
    //Sets the name of the computer as long as it follows requirements
    public void setComputerName(String computerName) {
        
        //Check if all computer name conditions are met
        try {
            
            //Compare length to required
            if (computerName.length() == COMPUTER_LENGTH) {
                
                //Check if name contains a hyphen
                if (computerName.charAt(3) != '-') {
                    throw new IllegalArgumentException("Name must contain a "
                            + "hyphen at the 4th character");
                }       
                else {
                    
                    /*Split the name into an array and check both sides for 
                    requirements*/
                    String computerSplit[] = computerName.split("-");
                    
                    //Check that the length of each side meets requirements
                    if (computerSplit[0].length() != 3 || computerSplit[1].length() != 4) {
                        throw new IllegalArgumentException("Name must have 3 "
                                + "letters and 4 digits");
                    }
                    
                    /*Go though each string and determine that the chcaracters 
                    in each are letters and numbers respectivley*/
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < computerSplit[i].length(); j++) {
                            if (Character.isDigit(computerSplit[i].charAt(j)) == true && i == 0) {
                                throw new IllegalArgumentException("Name must "
                                        + "start with 3 letters");
                            }
                            else if (Character.isDigit(computerSplit[i].charAt(j)) == false && i == 1) {
                                throw new IllegalArgumentException("Name must "
                                        + "end with 4 digits");
                            }
                        }
                    }
                }
            }
            else {
                throw new IllegalArgumentException("Name must be 8 characters in length");
            }
        
        //If all conditions are met, set name
        this.computerName = computerName; 
        }
        catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
    
    //Returns the name of the user
    public String getUserName() {
        return userName;
    }
    
    //Sets the name of the user as long as it follows requirements
    public void setUserName(String userName) {
        //Check if string is empty
        try {
            if (userName.isEmpty() == false) {
                this.userName = userName;
            }
            else {
                throw new IllegalArgumentException("Username must not be empty");
            }
        
        }
        catch (IllegalArgumentException e) {
            System.err.println(e);
        }
        
    }
    
}
