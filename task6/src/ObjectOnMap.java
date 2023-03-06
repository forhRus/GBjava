import java.util.HashMap;

// Объекты на карте
class ObjectOnMap {
    //  множество из объктов с ключами - id и значениями - внешним видом
    private static HashMap<Integer, String> mapObjects = new HashMap<>();
    private int[] position;
    private int id;
    private String view;

    public ObjectOnMap(int id, String view, int[] position) {
        this.id = id;
        this.view = view;
        this.position = position;
        mapObjects.put(id, view);
    }

    public int getId() {
        return id;
    }

    public int[] getPosition() {
        return position;
    }

    //  возвращаем колекцию объектов
    public static HashMap<Integer, String> getMapObjects() {
        HashMap <Integer, String> r = new HashMap<>();
        for (int k: mapObjects.keySet()) {
            r.put(k, mapObjects.get(k));
        }
        return r;
    }
}
