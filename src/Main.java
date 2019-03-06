import java.util.ArrayList;

/***
 * Main Class For Data Parser
 * Author - Chirag Bhatia
 */

public class Main {
    public static void main(String[] args) {

        ArrayList<ElectionResult> test = new ArrayList<>();

        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        //System.out.println(data);
        System.out.println(Utils.parse2016ElectionResults("data/2016_Presidential_Results.csv"));
    }
}
