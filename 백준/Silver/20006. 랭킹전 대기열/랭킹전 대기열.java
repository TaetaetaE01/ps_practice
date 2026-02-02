import java.io.*;
import java.util.*;

public class Main {

    public static class Player implements Comparable<Player> {

        int level;
        String name;
        boolean check;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player p1) {
            return name.compareTo(p1.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken()); // 플레이어의 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

//        Player[] playerList = new Player[p];
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st2.nextToken());
            String nickname = st2.nextToken();

            players.add(new Player(level, nickname));
        }

        for (int i = 0; i < p; i++) {

            // 방에 들어가지 않는 플레이어
            // 조건에 부합하는 플레이어 방에 넣기
            // 1. 처음 입장한 선수 레벨 기준 ~10 ~ +10
            // 2. m만큼 찰때까지 기달
            // 2-1. 여러개라면 먼저 생성된 곳에
            // 3. 정원이 모두 차면 시작
            if (!players.get(i).check) {
                List<Player> room = new ArrayList<>();

                for (int j = i; j < p; j++) {
                    if (room.size() == m) {
                        break;
                    }

                    Player firstPlayer = players.get(i);
                    Player targetPlayer = players.get(j);

                    if (!targetPlayer.check
                        && firstPlayer.level - 10 <= targetPlayer.level
                        && firstPlayer.level + 10 >= targetPlayer.level
                    ) {
                        targetPlayer.check = true;
                        room.add(targetPlayer);
                    }
                }
                Collections.sort(room);

                if (room.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }

                for (Player player : room) {
                    sb.append(player.level + " " + player.name).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}