import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> winningLines = new ArrayList<String>();
        Boolean playing = true;
        Scanner input = new Scanner(System.in);

        winningLines.add("000");
        winningLines.add("111");
        winningLines.add("222");
        winningLines.add("333");
        winningLines.add("444");
        winningLines.add("555");
        winningLines.add("666");
        winningLines.add("777");
        winningLines.add("888");
        winningLines.add("999");

        Game game = new Game(100, winningLines, 5);
        game.setWinningLines(winningLines);
        game.displayWelcome();

        System.out.println("Spin: x");
        System.out.println("Exit: z");
        String s = input.nextLine().toUpperCase();
        while (playing == true && s != "Z")
         {
            switch (s) {
                case "X":
                    game.spin();
                    System.out.println("Spin: x");
                    System.out.println("Exit: z");
                    s = input.nextLine().toUpperCase();
                    break;
                case "Z":
                    playing = false;
                    break;
                default:
                    System.out.println("Invalid!");
                    System.out.println("Spin: x");
                    System.out.println("Exit: z");
                    s = input.nextLine().toUpperCase();
                    break;
            }

        }
        System.out.println("Thanks for playing!");
    }
}
