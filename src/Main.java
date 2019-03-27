import java.util.ArrayList;

/***
 * Main Class For Data Parser
 * Author - Chirag Bhatia
 */

public class Main {
    public static void main(String[] args) {

//        ArrayList<ElectionResult> output = new ArrayList<>();
//        ArrayList<String> out = new ArrayList<>();
//
//        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
//        System.out.println(data);
//        output = Utils.parse2016ElectionResults(data);
//        System.out.println(output);

       // String mortalityRateData = Utils.readFileAsString("data/MortalityRates.csv");
        //Utils.parseMortalityRates(mortalityRateData);

        String obesityData = Utils.readFileAsString("data/Obesity.csv.csv");
        Utils.parseObesity(obesityData);

        //String diabetesData = Utils.readFileAsString("data/Test.csv.csv");
        //Utils.parseDiabetesData(diabetesData);
    }
}
