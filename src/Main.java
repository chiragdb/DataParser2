/***
 * Main Class For Data Parser
 * Author - Chirag Bhatia
 */

public class Main {
    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        System.out.println(data);
    }
}
