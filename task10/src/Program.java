public class Program {
    public static void main(String[] args) {
        int num = 5;
        double numD = 3.15;
        String str = "Строка";
        char c = 88;
        Cat cat = new Cat();
        CustomArray customArr = new CustomArray<>(num, numD, str, cat);
        customArr.add(c);
        System.out.println(customArr);
    }
}
