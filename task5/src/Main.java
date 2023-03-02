import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static final int empty = 0;
    static final int block = -1;
    static final int path = -2;
    static final int cat = -3;
    static final int exit = -4;


    public static void main(String[] args) {
        int[][] map = getMap();
        int[] catPosition = getPosition(map);
        int[] exitPosition = getPosition(map);
        map = setPositionOnMap(map, catPosition, cat);
        map = fillVawe(map, catPosition);
        map = findPath(map, catPosition, exitPosition);
        System.out.println(outputMap(map));
    }

    //  волновой алгоритм
    static int[][] fillVawe(int[][] map, int[] catPos) {
        int step = 1;
        int count = 1;
        int countTail = 0;
        ArrayList<int[]> queue = new ArrayList<int[]>();
        queue.add(catPos);
        int[] position = new int[2];
        do {
            countTail = count;
            count = 0;
            for (int j = 0; j < countTail; j++) {
                for (int i = 0; i < 8; i++) {
                    position = Arrays.copyOf(queue.get(0), 2);
                    position = getPosition(position, i);
                    if (map[position[0]][position[1]] == 0) {
                        map[position[0]][position[1]] = step;
                        queue.add(new int[]{position[0], position[1]});
                        count++;
                    }
                }
                queue.remove(0);
            }
            if (count > 0)
                step++;
        } while (queue.size() > 0);
        return map;
    }

    //  прокладываем путь до выхода
    static int[][] findPath(int[][] map, int[] catPos, int[] exitPos) {
        int num = map[exitPos[0]][exitPos[1]]-1;
        map = setPositionOnMap(map, exitPos, exit);
        ArrayList<int[]> pathList = new ArrayList<>();
        pathList.add(exitPos);
        int[] position = new int[2];
        while (pathList.size() > 0) {
            for (int i = 0; i < 8; i++) {
                position =  Arrays.copyOf(pathList.get(0), 2);
                position = getPosition(position, i);
                if (map[position[0]][position[1]] == map[catPos[0]][catPos[1]]) {
                    System.out.println("Нашли кошку");
                    return map;
                } else if (map[position[0]][position[1]] != block
                        && map[position[0]][position[1]] == num) {
                    map[position[0]][position[1]] = path;
                    pathList.add(new int[]{position[0], position[1]});
                    num--;
                    break;
                }
            }
            pathList.remove(0);

        }
        System.out.println("путь проложен");
        return map;
    }

    //  возвращаем позицию в зависимости от сделанного шага
    static int[] getPosition(int[] position, int move) {
        switch (move) {
            case 0: //  up
                position[0] = position[0] - 1;
                break;
            case 1: // u-r
                position[0] = position[0] - 1;
                position[1] = position[1] + 1;
                break;
            case 2:  //  right
                position[1] = position[1] + 1;
                break;
            case 3:  // d-r
                position[0] = position[0] + 1;
                position[1] = position[1] + 1;
                break;
            case 4:  //  down
                position[0] = position[0] + 1;
                break;
            case 5:  // d-l
                position[0] = position[0] + 1;
                position[1] = position[1] - 1;
                break;
            case 6:  //  left
                position[1] = position[1] - 1;
                break;
            case 7:  // u-l
                position[0] = position[0] - 1;
                position[1] = position[1] - 1;
                break;
        }
        return position;
    }

    //  ищем координаты для ногого объекта
    static int[] getPosition(int[][] map) {
        int[] pos = new int[2];
        do {
            pos[0] = rand.nextInt(1, map.length - 1);
            pos[1] = rand.nextInt(1, map[0].length - 1);
            System.out.println(pos[0] + " " + pos[1]);
        } while (map[pos[0]][pos[1]] != 0);
        return pos;
    }

    // разместить объект на карте. принимаем карту. координаты объекта и кодовое значение
    static int[][] setPositionOnMap(int[][] map, int[] pos, int x) {
        map[pos[0]][pos[1]] = x;
        return map;
    }

    //  готовый шаблон карты
    static int[][] getMap() {

        return new int[][]{
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, -1, -1, -1, -1, -1, 00, 00, -1},
                {-1, 00, -1, 00, 00, 00, 00, 00, -1, -1},
                {-1, 00, 00, 00, -1, -1, -1, 00, 00, -1},
                {-1, 00, -1, -1, -1, 00, -1, 00, 00, -1},
                {-1, 00, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, -1, 00, -1, 00, 00, -1, -1, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
    }

    //вывод карты
    static String outputMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        String blockS = "████";
        String emptyS = "    ";
        String catS = "=^^=";
        String exitS = "exit";
        String pathS = "  * ";
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case empty:
//                        sb.append(String.format("%4s", empty));
                        sb.append(emptyS);
                        break;
                    case block:
//                        sb.append(String.format("%4s", block));
                        sb.append(blockS);
                        break;
                    case cat:
                        sb.append(catS);
                        break;
                    case exit:
                        sb.append(exitS);
                        break;
                    case path:
                        sb.append(pathS);
                        break;
                    default:
                        sb.append(String.format("%4d", map[row][col]));
                        break;
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}




