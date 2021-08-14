package FinalExam.Mine_14_08_21;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLines = scan.nextLine();
        Map<String, followerInfo> followers = new LinkedHashMap<>();
        while (!"Log out".equals(inputLines)) {
            String[] commands = inputLines.split(": ");
            String command = commands[0];
            String username = commands[1];
            switch (command) {
                case "New follower":
                    followers.putIfAbsent(username, new followerInfo());
                    break;
                case "Like":
                    int likeCount = Integer.parseInt(commands[2]);
                    if (followers.containsKey(username)) {
                        int currentLikes = followers.get(username).getLikes();
                        followers.get(username).setLikes(currentLikes + likeCount);
                    } else {
                        followers.put(username, new followerInfo(likeCount, 0));
                    }
                    break;
                case "Comment":
                    if (followers.containsKey(username)) {
                        int currentComments = followers.get(username).getComments();
                        followers.get(username).setComments(currentComments + 1);
                    } else {
                        followers.put(username, new followerInfo(0, 1));
                    }
                    break;
                case "Blocked":
                    if (followers.containsKey(username)) {
                        followers.remove(username);
                    } else {
                        System.out.println(username + " doesn't exist.");
                    }
                    break;
                default:
                    break;
            }
            inputLines = scan.nextLine();
        }
        System.out.printf("%d followers%n", followers.size());
        followers.entrySet().stream().sorted((f1, f2) -> {
            int result = Integer.compare(f2.getValue().getSum(), f1.getValue().getSum());
            if (result == 0) {
                result = f1.getKey().compareTo(f2.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().getSum()));
    }

    private static class followerInfo {
        private int likes;
        private int comments;
        private int sum;

        public followerInfo() {
        }

        public followerInfo(int likes, int comments) {
            this.likes = likes;
            this.comments = comments;
        }

        public int getSum() {
            return this.likes + this.comments;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }
    }
}
