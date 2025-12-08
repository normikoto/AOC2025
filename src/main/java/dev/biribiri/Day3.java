package dev.biribiri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
    public static void run(String inputFile) throws IOException {
        long joltageTwoBatt = 0;
        long joltageTwelveBatt = 0;
        try (var reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                joltageTwoBatt += getJoltage(line, 2);
                joltageTwelveBatt += getJoltage(line, 12);
            }
        }

        IO.println("Part 1: " + joltageTwoBatt);
        IO.println("Part 2: " + joltageTwelveBatt);
    }
    
    private static long getJoltage(String line, int n) {
        StringBuilder batteries = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int maxIdx = 0;
            for (int j = 0; j < line.length() - (n - i - 1); j++) {
                if (line.charAt(j) > line.charAt(maxIdx)) {
                    maxIdx = j;
                }
            }
            batteries.append(line.charAt(maxIdx));
            line = line.substring(maxIdx + 1);
        }

        return Long.parseLong(batteries.toString());
    }

    static void main() throws IOException {
        run("src/main/resources/input-day-3");
    }
}
