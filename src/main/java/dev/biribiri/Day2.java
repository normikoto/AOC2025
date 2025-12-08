package dev.biribiri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.LongStream;

public class Day2 {
    public static void run(String inputFile) throws IOException {
        long part1 = 0;
        long part2 = 0;
        try (var reader = new BufferedReader(new FileReader(inputFile))) {
            String input = reader.readLine();
            String[] ranges = input.split(",");
            for (String range : ranges) {
                String[] rangeParts = range.split("-");
                long start = Long.parseLong(rangeParts[0]);
                long end = Long.parseLong(rangeParts[1]);

                part1 += LongStream.range(start, end + 1).filter(l -> {
                    String longStr = Long.toString(l);
                    String first = longStr.substring(0, longStr.length() / 2);
                    String second = longStr.substring(longStr.length() / 2);

                    return first.equals(second);
                }).sum();

                part2 += LongStream.range(start, end + 1).filter(l -> {
                    String longStr = Long.toString(l);

                    for (int n = 2; n <= longStr.length(); n++) {
                        String prefix = longStr.substring(0, longStr.length() / n);
                        if (prefix.repeat(n).equals(longStr)) {
                            return true;
                        }
                    }

                    return false;
                }).sum();
            }
        }

        IO.println("Part 1: " + part1);
        IO.println("Part 2: " + part2);
    }

    static void main() throws IOException {
        run("src/main/resources/input-day-2");
    }
}
