import java.util.HashMap;

// Вывод карты
class OutputMap {
    //  печать кода карты
    public static void CodeMap(int[][] map) {
        String sf = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                sf = String.format("%02d", map[i][j]);  // для ровной печати карты выводим по два  элемета -1 или 00
                System.out.print(sf + (j == map[0].length - 1 ? "\n" : " "));
            }
        }
        System.out.println();
    }

    //  печать более дружелюбной карты
    public static void MoreFriendlyMap(int[][] map, HashMap<Integer, String> colO, HashMap<Integer, String> colF) {
        String sf;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (colO.containsKey(map[i][j])) {
                    System.out.print(colO.get(map[i][j]) + " ");
                } else if (colF.containsKey(map[i][j])) {
                    System.out.print(colF.get(map[i][j]) + (j == map[0].length - 1 ? "\n" : " "));
                } else {
                    sf = String.format("%3d ", map[i][j]);
                    System.out.print(sf + (j == map[0].length - 1 ? "\n" : " "));
                }
            }
        }
        System.out.println();
    }
}
