import java.util.ArrayList;
import java.util.Random;

public class Game {
    private int balance;
    private int cost;
    private ArrayList<String> winningLines;


    public Game(int balance, ArrayList<String> winningLines, int cost) {
        this.balance = balance;
        this.winningLines = winningLines;
        this.cost = cost;
    }

    public Game() {

    }

    //////////////////////////
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<String> getWinningLines() {
        return winningLines;
    }

    public void setWinningLines(ArrayList<String> winningLines) {
        this.winningLines = winningLines;
    }
    /////////////////////////


    //check if line is a winner
    public boolean checkLine(String lineToCheck) {
        int winnings = 0;
        //if the line is in winningLines then we have a winner
        if (winningLines.contains(lineToCheck)) {
            winnings = Integer.parseInt(lineToCheck);
            System.out.println("You won: " + winnings);
            balance += winnings;
            if (winnings == 999) {
                displayJuiceLove();
            }
            return true;
        } else if (lineToCheck.charAt(0) == lineToCheck.charAt(2)) {
            //beginning and end match so win
            winnings = Integer.parseInt(lineToCheck) / 2;
            System.out.println("You won: " + winnings);
            balance +=  winnings;
            return true;
        } else {
            return false;
        }
    }

    //spin
    public void spin() {
        //first check to make sure that balance can cover the cost
        if (balance >= cost) {
            //proceed to spin
            //first remove the cost from balance
            balance -= cost;
            //now spin...
            //spin and generate a random line 000 --> 999
            Random rand = new Random();
            int a = rand.nextInt(10);
            int b = rand.nextInt(10);
            int c = rand.nextInt(10);
            //now we need to put them all as once
            String stringSpin = Integer.toString(a) + Integer.toString(b) + Integer.toString(c);
            //spin generated so display
            System.out.println("SPINNING!");
            System.out.println("| \t\t\t|");
            System.out.println("| \t\t\t|");
            System.out.println("|\t" + stringSpin + "\t\t|");
            System.out.println("| \t\t\t|");
            System.out.println("| \t\t\t|");
            if (checkLine(stringSpin)) {
                System.out.println("Winner");
            }
            System.out.println("Balance: " + balance);

        } else {
            System.out.println("Balance too low!");
            System.out.println("Balance: " + balance);
        }

    }


    public void displayWelcome() {
        System.out.println("Welcome to slots.");
        System.out.println("Starting balance: " + balance);
        System.out.println("Cost per spin: " + cost);
    }

    public void displayJuiceLove() {
        System.out.println("RIP JUICE!");
    }


}
