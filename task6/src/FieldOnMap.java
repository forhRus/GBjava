import java.util.HashMap;


class FieldOnMap {
    //  множество из объктов с ключами - id и значениями - внешним видом
    private static HashMap<Integer, String> mapField = new HashMap<>();
    private int id;
    private String view;

    public FieldOnMap(int id, String view) {
        this.id = id;
        this.view = view;
        mapField.put(id, view);
    }

    public int getId() {
        return id;
    }

    //  возвращаем колекцию полей
    public static HashMap<Integer, String> getMapField() {
        HashMap <Integer, String> r = new HashMap<>();
        for (int k: mapField.keySet()) {
            r.put(k, mapField.get(k));
        }
        return r;
    }
}
