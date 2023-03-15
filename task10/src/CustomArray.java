import java.util.ArrayList;
import java.util.List;

public class CustomArray<T> {
    List<T> customArr;

    public CustomArray(T o, T o1, T o2, T o3) {
        this.customArr = new ArrayList<>();
        if(o != null) customArr.add(o);
        if(o != null) customArr.add(o1);
        if(o != null) customArr.add(o2);
        if(o != null) customArr.add(o3);

    }
    public CustomArray(T o, T o1, T o2) {
        this(o, o1, o2, null);
    }
    public CustomArray(T o, T o1) {
        this(o, o1, null, null);
    }
    public CustomArray(T o) {
        this(o, null, null, null);
    }

    public CustomArray() {
    }
}
