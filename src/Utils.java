import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static void main(String[] args) {

    }

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
        ArrayList<ElectionResult> output = new ArrayList<>();
        String[] allLines = data.split("\n");
        for (int i = 1; i < allLines.length; i++) {
            String line = allLines[i];
            int indexComma = line.indexOf(",");
            line = line.substring(indexComma + 1, line.length());
            int indexMod = line.indexOf("%");
            int size = line.length();
            String primary = line.substring(0, indexMod);
            String secondary = line.substring((indexMod + 1), size);
            line = primary + secondary;
            if (line.indexOf("\"") != -1) {
                String now = line.substring(line.indexOf("\"") + 1, line.length());
                now = now.substring(0, now.indexOf("\""));
                while (now.indexOf(",") != -1) {
                    now = now.substring(0, now.indexOf(",")) + now.substring(now.indexOf(",") + 1, now.length());
                }
                int indexSlash = line.indexOf("\"");
                String one = line.substring(0, indexSlash);
                String two = line.substring(line.indexOf("\"", line.indexOf("\"") + 1) + 1, line.length());
                line = one + now + two;
            }
            System.out.println(line);
            String[] values = line.split(",");
            double demVotes = Double.parseDouble(values[0]);
            double gopVotes = Double.parseDouble(values[1]);
            double totalVotes = Double.parseDouble(values[2]);
            double perDem = Double.parseDouble(values[3]);
            double perGop = Double.parseDouble(values[4]);
            int difference = Integer.parseInt(values[5]);
            double pointDiff = Double.parseDouble(values[6]);
            String state = values[7];
            String country = values[8];
            int combo = Integer.parseInt(values[9]);
            ElectionResult result = new ElectionResult(demVotes, gopVotes, totalVotes, perDem, perGop, difference, pointDiff, state, country, combo);
            output.add(result);
        }
        return output;

    }

//    public static ArrayList<Education2016> parseEducation(String data) {
//        ArrayList<Education2016> output = new ArrayList<>();
//        String[] allLines = data.split("\n");
//        for (int i = 6; i < allLines.length; i++) {
//            Education2016 education = new Education2016(0, 0, 0, 0);
//            Employment2016 employment = new Employment2016(0, 0, 0, 0);
//            Election2016 election = new Election2016(0, 0, 0);
//            String lineForFips = allLines[i];
//            String fips = lineForFips.substring(0, lineForFips.indexOf(","));
//            int fipsNum = Integer.parseInt(fips);
//            String lineForState = allLines[i];
//            lineForState = lineForState.substring(lineForState.indexOf(",") + 1, lineForState.length());
//            String stateName = lineForState.substring(0, lineForState.indexOf(","));
//            String lineForCounty = allLines[i];
//            lineForCounty = lineForCounty.substring(lineForCounty.indexOf(",") + 1, lineForCounty.length());
//            lineForCounty = lineForCounty.substring(lineForCounty.indexOf(",") + 1, lineForCounty.length());
//            String countyName = lineForCounty.substring(0, lineForCounty.indexOf(","));
//            State state = new State(stateName);
//            County county = new County(countyName, fipsNum, election, education, employment);
//            state.addCounty(county);
//        }
//        return output;
//    }

    public static void parseMortalityRates(String data) {
        String[] allLines = data.split("\n");
            for (int i = 2; i < allLines.length; i = i + 2){
                String line = allLines[i];
                String countyName = line.substring(1, line.indexOf(","));
                String stateName = line.substring(line.indexOf(",") + 2, line.indexOf(",") + 4);
                line = line.substring(line.indexOf(",") + 1, line.length());
                line = line.substring(line.indexOf(",") + 1, line.length());
                String populationString = line.substring(0, line.indexOf(","));
                String rateString = line.substring(line.indexOf(",") + 1, line.length());
                System.out.println(countyName + ", " + stateName);
                System.out.println(populationString + "        " + rateString);
            }
    }

    public static void parseObesity (String data){
        String[] allLines = data.split("\n");
        for (int i = 2; i < allLines.length; i++) {
            String line = allLines[i];
            String copy = allLines[i];
            String stateName = copy.substring(0, copy.indexOf(","));
            copy = copy.substring(copy.indexOf(",") + 1, copy.length());
            String fipsCode = copy.substring(0, copy.indexOf(","));

            line = line.substring(line.indexOf(",") + 1, line.length());
            line = line.substring(line.indexOf(",") + 1, line.length());
            String countyName = line.substring(0, line.indexOf(","));
            line = line.substring(line.indexOf(",") + 1, line.length());
            line = line.substring(line.indexOf(",") + 1, line.length());
            String percentString = line.substring(0, line.indexOf(","));
            System.out.println(stateName + ", " + fipsCode + ", " + countyName + ", " + percentString);
        }
    }


    public static void parseDiabetesData(String data) {
        String[] allLines = data.split("\n");
        for (int i = 1; i < allLines.length; i++){
            String line = allLines[i];
            String state = line.substring(0, line.indexOf(","));
            line = line.substring(line.indexOf(",") + 1);
            String fips = line.substring(0, line.indexOf(","));
            line = line.substring(line.indexOf(",") + 1);
            String countyName = line.substring(0, line.indexOf(","));
            line = line.substring(line.indexOf(",") + 1);
            line = line.substring(line.indexOf(",") + 1);
            String percentDiabetes = line.substring(0, line.indexOf(","));
            System.out.println(state + ", " + countyName + ", " + percentDiabetes + ", " + fips);
        }
    }

    public static void parseUnemployment(String data) {
        String[] allLines = data.split("\n");
        for (int i = 8; i < allLines.length; i++){
            String line = allLines[i];
            line = line.substring(line.indexOf(",") + 1);
            line = line.substring(line.indexOf(",") + 1);
            String county = line.substring(1, line.indexOf(","));
            System.out.println(county);

        }
    }


}

