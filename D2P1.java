import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CubeGame {
    int id;
    List<int[]> rounds;

    public CubeGame(int id) {
        this.id = id;
        this.rounds = new ArrayList<>();
    }

    public void addRound(int red, int green, int blue) {
        rounds.add(new int[]{red, green, blue});
    }

    public boolean isPossible(int maxRed, int maxGreen, int maxBlue) {
        for (int i = 0; i < rounds.size(); i++) {
            int[] round = rounds.get(i);
            if (round[0] > maxRed || round[1] > maxGreen || round[2] > maxBlue) {
                return false;
            }
        }
        return true;
    }
}

public class D2P1 {
    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D2Input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                inputList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] input = inputList.toArray(new String[0]);
        List<CubeGame> games = parseGames(input);
        int sumOfPossibleGameIds = 0;

        for (int i = 0; i < games.size(); i++) {
            CubeGame game = games.get(i);
            if (game.isPossible(12, 13, 14)) {
                sumOfPossibleGameIds += game.id;
            }
        }

        System.out.println("Sum of IDs of possible games: " + sumOfPossibleGameIds);
    }

    private static List<CubeGame> parseGames(String[] input) {
        List<CubeGame> games = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String line = input[i];
            String[] parts = line.split(": ");
            int gameId = Integer.parseInt(parts[0].split(" ")[1]);
            CubeGame game = new CubeGame(gameId);

            String[] rounds = parts[1].split("; ");
            for (int j = 0; j < rounds.length; j++) {
                String round = rounds[j];
                String[] counts = round.split(", ");
                int red = 0, green = 0, blue = 0;
                for (int k = 0; k < counts.length; k++) {
                    String count = counts[k];
                    String[] details = count.split(" ");
                    int number = Integer.parseInt(details[0]);
                    switch (details[1]) {
                        case "red":
                            red = number;
                            break;
                        case "green":
                            green = number;
                            break;
                        case "blue":
                            blue = number;
                            break;
                    }
                }
                game.addRound(red, green, blue);
            }
            games.add(game);
        }
        return games;
    }
}