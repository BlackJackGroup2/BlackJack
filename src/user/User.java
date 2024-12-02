package user;

import java.util.ArrayList;
import java.util.List;

import deckManagement.Card;

public class User {

    // Fields
    private String username;
    private String password;
    protected double balance;  // Standardized from accBalance
    private AccountType accountType;
    private Status status;
    protected ArrayList<Card> hand;  // Added hand to manage shared functionality
    
    // Enum for account type
    public enum AccountType {
        PLAYER, DEALER
    }

    // Enum for player status
    public enum Status {
        ACTIVE, STANDING, BUSTED
    }

    
    // Constructor
    public User(String username, String password, double balance, AccountType accountType) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.accountType = accountType;
        this.hand = new ArrayList<>();  // Initialize the hand here
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }
  
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Status getStatus() {
    	return status;
    }
    
    public void setStatus(Status status) {
    	this.status = status;
    }
    
    public List<Card> getHand() {
        return hand;
    }
    
    // Methods

    public int getHandValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getRank() == Card.Rank.ACE) {
                aceCount++;
            }
        }

        // Adjust ACE values (if any) to be 1 if the hand value is over 21
        while (value > 21 && aceCount > 0) {
            value -= 10; // Change ACE from 11 to 1
            aceCount--;
        }

        return value;
    }

    public void resetHand() {
        hand.clear();
    }

    //** Simulates user login
    //public boolean login(String inputUsername, String inputPassword) {
    //    if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
    //        System.out.println("Login successful!");
    //        return true;
    //    } else {
    //        System.out.println("Invalid username or password.");
    //        return false;
    //    }
    //}

    // Simulates user registration
    //public static User register(String username, String password, double initialBalance, AccountType accountType) {
    //    System.out.println("Registration successful! Welcome, " + username + "!");
    //    return new User(username, password, initialBalance, accountType);
    //}

    // Simulates joining a game
    //public void joinGame() {
    //    if (balance > 0) {
    //        System.out.println(username + " joined the game.");
    //    } else {
    //        System.out.println("Insufficient balance to join the game.");
    //    }
    //}

    // Simulates leaving a game
    //public void leaveGame() {
    //   System.out.println(username + " left the game.");
    //}
}