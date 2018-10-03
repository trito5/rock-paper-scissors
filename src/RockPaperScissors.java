import java.util.*;

/*This is a rock paper scissors game to play with the computer. First one to get 3 rounds get 1 win.
* The program keep track of the total wins.*/
public class RockPaperScissors {


    public static void main(String[] args){

        Player Player1 = new Player();
        Player Player2 = new Player();
        boolean spel = true;


        ArrayList<String> listaVal = new ArrayList<>();
        listaVal.add(".");
        listaVal.add("x");
        listaVal.add("o");

        Random randomGenerator = new Random();

        while (spel== true) {
            System.out.println("-------------------------------------");
            System.out.println("Välj sten(.), sax(x) eller påse(o)!");
            System.out.println("Eller välj Q för att avsluta spelet.");
            Scanner sc = new Scanner(System.in);
            String x = sc.nextLine();

            //dator slumpar

            if (x.equals(".") || x.equals("x") || x.equals("o")) {
                System.out.println("Du valde " + checkString(x));
                int randomNr = randomGenerator.nextInt(listaVal.size());
                String datorVal = listaVal.get(randomNr);
                System.out.println("Datorn valde " + checkString(datorVal));
                if (isPlayerWinner(x,datorVal)) {
                    Player1.setScore();
                    if (Player1.getScore() < 3) {
                        System.out.println("Du vann! Din poäng: " + Player1.getScore() + ". Datorns poäng: " + Player2.getScore());
                    } else {
                        Player1.setWins();
                        System.out.println("\n-------------------------------------");
                        System.out.println("Du har 3 poäng och vann!");
                        System.out.println("Totala vinster för dig: " + Player1.getwins());
                        System.out.println("Totala vinster för datorn: " + Player2.getwins());
                        Player1.resetScore();
                        Player2.resetScore();
                    }

                } else if (isPlayerWinner(datorVal, x)) {
                    Player2.setScore();
                    if (Player2.getScore() < 3) {
                        System.out.println("Datorn vann! Din poäng: " + Player1.getScore() + ". Datorns poäng: " + Player2.getScore());
                    } else {
                        Player2.setWins();
                        System.out.println("\n-------------------------------------");
                        System.out.println("Datorn har 3 poäng och vann!");
                        System.out.println("Totala vinster för dig: " + Player1.getwins());
                        System.out.println("Totala vinster för datorn: " + Player2.getwins());
                        Player1.resetScore();
                        Player2.resetScore();
                    }
                } else {
                    System.out.println("Oavgjort! Din poäng: " + Player1.getScore() + ". Datorns poäng: " + Player2.getScore());

                }

            } else if (x.equals("Q") || x.equals("q")) {
                spel = false;
                System.out.println("Du har valt att avsluta spelet nu.");
                System.out.println("Totala vinster för dig: " + Player1.getwins());
                System.out.println("Totala vinster för datorn: " + Player2.getwins());
            } else {
                System.out.println("Felaktig inmatning. Försök igen!");
            }


        }


    }
    public static String checkString(String ch) {
        String val =" ";
        if (ch.equals(".")) {
            val = "sten";
        } else if (ch.equals("x")) {
            val = "sax";
        } else if (ch.equals("o")) {
            val = "påse";
        }
        return val;
    }

    public static boolean isPlayerWinner(String p1, String p2) {
        if (p1.equals(".") && p2.equals("x")) { return true; }
        else if (p1.equals("x") && p2.equals("o")) { return true; }
        else if (p1.equals("o") && p2.equals(".")) { return true; }
        else {return false; }

    }


}
