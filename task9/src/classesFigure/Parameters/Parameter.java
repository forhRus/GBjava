package classesFigure.Parameters;

public abstract class Parameter {
    public int value;

    public Parameter(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
