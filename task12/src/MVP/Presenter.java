package MVP;

import db.Config;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    View v;
    Model m;

    public Presenter(View v, Model m) {
        this.v = v;
        this.m = m;
    }

    public void powerNumber() {
        List<int[]> list = m.loadVariables();
       List<String> resList = new ArrayList<>();
        for (int[] arr:list ) {
            int a = arr[0];
            int b = arr[1];
            String result = m.stringPower(a, b);
            resList.add(String.format("%d в степени %d = %s\n", a, b, result));
        }
        m.saveResult(resList);
    }
}

