package MVP;

public class Presenter {
    View v;
    Model m;

    public Presenter(View v, Model m) {
        this.v = v;
        this.m = m;
    }

    public void printTriangularNumber() {
        int tNumber = 0;
        int n = -1;
        while (true) {
            boolean f = false;
            v.print("Введите номер триугольного числа(n - exit): ");
            if (v.inputInt()) {
                n = v.getInput();
                if (n >= 0) {
                    tNumber = m.triangularNumber(n);
                    f = true;
                } else {
                    v.println("Число должно быть положительное");
                }
            } else {
                v.println();
                break;
            }
            if (f) {
                v.println(String.format("Число Т%d: %d", n, tNumber));
            }
            v.println();
        }

    }

}
