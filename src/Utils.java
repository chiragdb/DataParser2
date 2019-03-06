import java.io.File;
import java.io.IOException;
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
            if (line.indexOf("\"") != -1){
                String now = line.substring(line.indexOf("\"") + 1, line.length());
                now = now.substring(0, now.indexOf("\""));
                while (now.indexOf(",") != -1){
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

}

