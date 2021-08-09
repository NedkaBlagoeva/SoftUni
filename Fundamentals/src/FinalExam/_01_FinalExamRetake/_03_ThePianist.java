package FinalExam._01_FinalExamRetake;

import java.util.*;
import java.util.function.Function;

public class _03_ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfPieces = Integer.parseInt(scan.nextLine());

        Map<String, PianoPiecesData> pianoPieces = new TreeMap<>();
        for (int i = 0; i < numOfPieces; i++) {
            String input = scan.nextLine();
            String[] pieceData = input.split("\\|");
            String piece = pieceData[0];
            String composer = pieceData[1];
            String key = pieceData[2];
            pianoPieces.put(piece, new PianoPiecesData(composer, key));
        }
        String input = scan.nextLine();
        while (!"Stop".equals(input)) {
            String[] commands = input.split("\\|");
            String command = commands[0];
            String piece = commands[1];
            switch (command) {
                case "Add":
                    String composer = commands[2];
                    String key = commands[3];
                    if (pianoPieces.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        pianoPieces.put(piece, new PianoPiecesData(composer, key));
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (pianoPieces.containsKey(piece)) {
                        pianoPieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commands[2];
                    if (pianoPieces.containsKey(piece)) {
                        pianoPieces.get(piece).setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        pianoPieces.entrySet().stream()
                .sorted(Comparator.comparing((Function<Map.Entry<String, PianoPiecesData>, String>) Map.Entry::getKey).thenComparing(p -> p.getValue().getComposer())).
                forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), e.getValue().getComposer(), e.getValue().getKey()));
    }

    private static class PianoPiecesData {
        private final String composer;
        private String key;

        public PianoPiecesData(String composer, String key) {
            this.composer = composer;
            this.key = key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getComposer() {
            return composer;
        }

        public String getKey() {
            return key;
        }


    }
}
