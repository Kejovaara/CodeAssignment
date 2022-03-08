import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Game {
    public static void main(String[] args){ new Game().program();}

    final Scanner scan = new Scanner(in);
    String input;
    Deck d;
    Hand h;

    void program(){
        initGame();
        initNumberDecks();
        while(true){
            inputLoop();
            if("exit".equals(input)){
                break;
            }
            try{
               String result = eval(input);
               out.println(result);
            }catch(Exception e){
                out.println(e.getMessage());
            }
        }
    }

    public void initGame(){
        out.println("Simple Card Game v1.0");
        h = new Hand();
        printCommandList();
    }

    public void inputLoop(){
        out.print("> ");
        input = scan.nextLine();
    }

    public void initNumberDecks(){
        out.println("Select number of decks (1-10)");
        while(true){
            inputLoop();
            if("exit".equals(input)){
                break;
            }
            try{
                int number = Integer.parseInt(input);
                if(number >= 1 && number <= 10){
                    d = new Deck(number);
                    out.println("You generated a deck with " + d.countDeck() + " cards.");
                    break;
                }else{
                    out.println("Please enter an amount between 1-10");
                }
            }catch(Exception e){
                out.println(e.getMessage());
            }
        }
    }

    public void printCommandList(){
        out.println("Available commands: ");
        out.println("shuffle :: Shuffles your deck.");
        out.println("draw :: Draw a card from the deck and add it to your hand.");
        out.println("sort :: Sort the deck.");
        out.println("exit :: Terminate");
    }

    private String eval(String input){
        switch (input) {
            case "shuffle" -> {
                d.shuffle();
                out.println("Deck was shuffled. \n Result: ");
                for (Card card : d.getDeck()) {
                    out.println(card.printCard());
                }
            }
            case "draw" -> {
                Card c = d.drawCard();
                h.addCard(c);
                out.println("A card was added to your hand: " + c.printCard());
                out.println("There is " + d.countDeck() + " cards remaining in the deck.");
                out.println("You currently have " + h.getSize() + " cards in your hand.");
            }
            case "sort" -> {
                d.sort();
                out.println("Deck was sorted. \n Result: ");
                for (Card card : d.getDeck()) {
                    out.println(card.printCard());
                }
            }
            default -> {
                out.println("Uknown command, please use one of the commands below: ");
                printCommandList();
            }
        }
        return input;
    }
}
