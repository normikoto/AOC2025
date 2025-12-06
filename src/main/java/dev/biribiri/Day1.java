package dev.biribiri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    public static void run(String inputFile) throws IOException {
        int position = 50;
        int part1 = 0;
        int part2 = 0;

        try (var reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine();
            while (line != null) {
                int oldPosition = position;
                int move = Integer.parseInt(line.substring(1));
                switch (line.charAt(0)) {
                    case 'L':
                        position -= move;
                        if (position <= 0 && oldPosition > 0) {
                            part2++;
                        }
                        break;
                    case 'R':
                        position += move;
                        if (position >= 0 && oldPosition < 0) {
                            part2++;
                        }
                        break;
                }
                part2 += Math.abs(position / 100);
                position = position % 100;
                if (position == 0) {
                    part1++;
                }
                line = reader.readLine();
            }
        }

        IO.println("Part 1: " + part1);
        IO.println("Part 2: " + part2);
    }
}
