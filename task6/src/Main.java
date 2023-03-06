import java.util.*;

public class Main {
    private static int id = 1;
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    private static ArrayList<ObjectOnMap> objactsArList = new ArrayList<>();  // лист для хранения объектов

    public static void main(String[] args) {
        int widthMap = 15;  // параметры карты
        int heigthMap = 10;
        int countWall = 30;
        FieldOnMap road = new FieldOnMap(--id, "    ");  //  добавляем дорогу
        FieldOnMap wall = new FieldOnMap(--id,"████");  //  добавляем стену
        FieldOnMap path = new FieldOnMap(--id,"  * ");  //  добавляем путь
        //  создаём карту
        MapController mC = new MapController(widthMap, heigthMap, road.getId(), wall.getId(), countWall);

        ObjectOnMap cat = new ObjectOnMap(--id, "=^^=", mC.generatePosition()); //  создаём объект кошку (объект с позицией)
        mC.addObjectOnMap(cat);
        ObjectOnMap exit = new ObjectOnMap(--id, "exit",mC.generatePosition()); // тоже самое с объктом выходом
        mC.addObjectOnMap(exit);

        System.out.println("Объекты карты с их id" + ObjectOnMap.getMapObjects());
        System.out.println("Вывод код карты.");
        OutputMap.CodeMap(mC.getMap());

        System.out.println("Вывод карты с более дружелюбным интерфейсом.");
        OutputMap.MoreFriendlyMap(mC.getMap(), ObjectOnMap.getMapObjects(), FieldOnMap.getMapField());

        System.out.println("Вывод карты заполненой волновым алгоритмом от координат кошки.");
        OutputMap.MoreFriendlyMap(fillVawe(mC.getMap(), cat.getPosition()), ObjectOnMap.getMapObjects(), FieldOnMap.getMapField());

        System.out.println("Все возможные найденные пути.");
        OutputMap.MoreFriendlyMap(findPath(mC.getMap(), mC.getMap(), cat, exit, path), ObjectOnMap.getMapObjects(), FieldOnMap.getMapField());

    }

    //  волновой алгоритм
    private static int[][] fillVawe(int[][] result, int[] pos) {
//        int[][] result = copyMatrix(map);  // копируем карту
        ArrayList<int[]> queue = new ArrayList<int[]>(); // очередь ячеек
        int[] myPosition = new int[2];  //  координата ячейки ячейки из которой делается шаг
        queue.add(pos);  //  добавляем стартовую позицию с кошкой в очередь.
        int countTail;  // счетчик для цикла с проверкой всех ячеек добавленных за предыдущий ход
        int count = 1;   // количество ячееке которые мы пометили за ход
        int step = 1;  // текущий шаг, которым будем метить ячейки

        do {
            countTail = count;  //  следующий цикл будет выполнятся столько раз, сколько ячеек добавлено в очередь
            count = 0;  // обнуляем счетчик добавлений
            while (countTail > 0) {
                myPosition = Arrays.copyOf(queue.get(0), 2); // вытаскиваем координаты из очереди
                for (int i = 0; i < 8; i++) {
                    // присваиваем новые координаты в зависимости от направления движения относительно нашей текующей клетки
                    int[] nextPosition = nextStep(myPosition, i);
                    if (result[nextPosition[0]][nextPosition[1]] == 0) { // если следующая ячейка road (по умолчанию она 0)
                        result[nextPosition[0]][nextPosition[1]] = step;  // то присваиваем ячейке текующий шаг
                        queue.add(new int[]{nextPosition[0], nextPosition[1]});  // добавляем позицию ячейки для будущей проверки
                        count++;  // увеличиваем счетчик ячеек, добавленных в очередь
                    }
                }
                countTail--; // одну ячейку проверили
                queue.remove(0); // удаляем позицию из очереди после проверки всех направлений
            }
            if (count > 0)  // если после проверок, хотя бы одна позиция была добавлена в очередь
                step++;  //  увеличиваем шаг
        } while (queue.size() > 0);
        return result;
    }

    //      прокладываем путь до выхода
    private static int[][] findPath(int[][] result, int[][] temp, ObjectOnMap target, ObjectOnMap exit, FieldOnMap path) {
        int targetId = target.getId();  //  id цели
//        int[][] result = copyMatrix(map);  //  копируем карту
        fillVawe(temp, target.getPosition());  //  делаем карту заполненную волновым алгоритмом
        int count = 1;  // счетчик добавленных в очередь
        int countTail = 0;  //  счетчик добавленных в очередь за ход для цикла
        int[] myPosition = exit.getPosition();  //  ячейка с которой делается шаг
        int minNumber = findMinNumberAround(myPosition, temp, targetId);  //  находим минимальное число вокруг стартовой позиции
        if (minNumber == -1) { // если вокруг нас только стены
            System.out.println("Путь не найден");
            return result;
        }
        ArrayList<int[]> queue = new ArrayList<>();   // очередь
        queue.add(myPosition);  //  координаты выхода стартовая позиция

        while (queue.size() > 0) {
            countTail = count;   //  колличество ячеек для проверки на minNumber
            count = 0;   // обнуляем счетчик добавлений в очередь
            while (countTail > 0) {
                myPosition = Arrays.copyOf(queue.get(0), 2);  //  вытаскиваем новые координаты из очереди
                for (int i = 0; i < 8; i++) {
                    int[] nextPosition = nextStep(myPosition, i);   //  делаем шаг
                    if (temp[nextPosition[0]][nextPosition[1]] == targetId) {  //  нашли цель?
                        return result;
                    } else if (temp[nextPosition[0]][nextPosition[1]] == minNumber) {  //  метим путь
                        result[nextPosition[0]][nextPosition[1]] = path.getId();
                        queue.add(nextPosition);  // добавляем в очередь ячейку
                        count++;  //  для будущей проврки ячейки с тем же minNumber
                    }
                }
                countTail--;  //  уменьшаем очередь
                queue.remove(0);
            }
            minNumber--;
        }
        return result;
    }

    //  метод ищет минимальное число вокруг заданной позиции
    private static int findMinNumberAround(int[] p, int[][] temp, int target) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (temp[p[0] + i][p[1] + j] == target) return target;
                if (temp[p[0] + i][p[1] + j] > 0) al.add(temp[p[0] + i][p[1] + j]);
            }
        }
        if (al.size() == 0) { // если вокруг нас только стены
            return -1;
        }else {
            Collections.sort(al);
            return al.get(0);
        }
    }



    //  возвращаем позицию в зависимости от сделанного шага
    static int[] nextStep(int[] position, int move) {
        int[] result = Arrays.copyOf(position, position.length);
        switch (move) {
            case 0: //  up
                result[0] = position[0] - 1;
                break;
            case 1: // u-r
                result[0] = position[0] - 1;
                result[1] = position[1] + 1;
                break;
            case 2:  //  right
                result[1] = position[1] + 1;
                break;
            case 3:  // d-r
                result[0] = position[0] + 1;
                result[1] = position[1] + 1;
                break;
            case 4:  //  down
                result[0] = position[0] + 1;
                break;
            case 5:  // d-l
                result[0] = position[0] + 1;
                result[1] = position[1] - 1;
                break;
            case 6:  //  left
                result[1] = position[1] - 1;
                break;
            case 7:  // u-l
                result[0] = position[0] - 1;
                result[1] = position[1] - 1;
                break;
        }
        return result;
    }

}



