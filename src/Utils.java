import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
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
            String s = allLines[i];
            int length = s.length();
            int index = s.indexOf(",");
            s = s.substring(index, length);
            s = s.substring(0, s.indexOf("%")) + s.substring(s.indexOf("%") + 1, s.length());
            int val = s.indexOf("\"");
            if (val != -1) {
                int num = s.indexOf("\"") + 1;
                String strand = s.substring(num, s.length());
                strand = strand.substring(0, strand.indexOf("\""));
                int num2 = strand.indexOf(",");
                while (num2 != -1) {
                    strand = strand.substring(0, strand.indexOf(",")) + strand.substring(strand.indexOf(",") + 1, strand.length());
                }
                int slantIndex = s.indexOf("\"");
                s = s.substring(0, slantIndex) + strand + s.substring(s.indexOf("\"", s.indexOf("\"") + 1) + 1, s.length());
            }
            System.out.println(s);
            String[] vals = s.split(",");
            double demVotes = Double.parseDouble(vals[0]);
            double gopVotes = Double.parseDouble(vals[1]);
            double totalVotes = Double.parseDouble(vals[2]);
            double perDem = Double.parseDouble(vals[3]);
            double perGop = Double.parseDouble(vals[4]);
            int difference = Integer.parseInt(vals[5]);
            double pointDiff = Double.parseDouble(vals[6]);
            String state = vals[7];
            String country = vals[8];
            int combo = Integer.parseInt(vals[9]);
            ElectionResult result = new ElectionResult(demVotes, gopVotes, totalVotes, perDem, perGop, difference, pointDiff, state, country, combo);
            output.add(result);
        }
        return output;

    }

}

