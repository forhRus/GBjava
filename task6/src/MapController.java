import java.util.Arrays;
import java.util.Random;

// Управление картой
class MapController {
    private Random rand = new Random();
    int[][] map;

    public MapController(int w, int h, int idGraund, int idWall, int countWall) {
        map = new int[h][w];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], idGraund);
        }
        addFrame(idWall);
        addWallsOnMap(idWall, countWall);
    }

    private void addWallsOnMap(int idWall, int countWall) {
        while (countWall > 0) {
            int[] p = generatePosition();
            map[p[0]][p[1]] = idWall;
            countWall--;
        }
    }

    // создаём рамку из стен
    private void addFrame(int idWalls) {
        for (int i = 0; i < map.length; i++) {
            if (i == 0 || i == map.length - 1) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = idWalls;
                }
            } else {
                map[i][0] = idWalls;
                map[i][map[0].length - 1] = idWalls;
            }
        }
    }

    public int[] generatePosition() {
        int[] pos = new int[2];
        do {
            pos[0] = rand.nextInt(1, map.length - 1);
            pos[1] = rand.nextInt(1, map[0].length - 1);
        } while (map[pos[0]][pos[1]] != 0);
        return pos;
    }

    public int[][] getMap() {
        int[][] r = new int[map.length][];
        for (int i = 0; i < map.length; i++) {
            r[i] = Arrays.copyOf(map[i], map[i].length);
        }
        return r;
    }

    public void addObjectOnMap(ObjectOnMap o) {
        int[] p = o.getPosition();
        map[p[0]][p[1]] = o.getId();
    }
}
