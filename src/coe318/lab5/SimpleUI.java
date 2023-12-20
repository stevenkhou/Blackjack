package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("House Holds: \n-=-=-=-=-=-" + this.game.getHouseCards().toString()); 
        System.out.println("You Hold: \n-=-=-=-=-=-" + this.game.getYourCards().toString()); 
    }

    @Override
    public boolean hitMe() {
        System.out.println("Another card? (y/n)");
        String choice = user.nextLine();
        boolean hit = false;
        switch(choice){
            case "y":
                hit = true;
                break;
            case "n":
                hit = false;
                break;
            default:
                System.out.println("Type either 'y' or 'n'.");
                hitMe();
        }
        return(hit);
    }

    @Override
    public void gameOver() {
        this.display();
        int yourScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());
        System.out.println("House Score: " + houseScore + ", Your Score: " + yourScore);
        if( (yourScore > houseScore || houseScore > 21) && (yourScore <= 21)){
            System.out.println("You Win!");
        }else{
            System.out.println("House Wins!");
        }
       System.out.println("Game end");

    }

}