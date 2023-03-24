package ex1_calc;

import ex1_calc.menu.Menu;
import ex1_calc.menu.MenuRac;
import ex1_calc.menu.MenuStart;

public class Presenter {
    View view = new View();
    Model model = new Model();
    Menu menuRac = new MenuRac();
    Menu menuStart = new MenuStart();


    public void start() {
        int choice = view.choiceMenu(menuStart.getMenu(), "Калькулятор.\nС какими числами будете работать?");
        if (choice == 1)
            complexNumber();
        else if (choice == 2)
            racNumber();
    }

    private void complexNumber(){
        Complex num1 = inputComplex("Введите действительную часть первого числа: ",
                "Введите мнимую часть первого числа: ");

        int index = view.choiceMenu(menuRac.getMenu(), "Выберите действие");
        char operation = menuRac.getMenu()[index-1].charAt(0);

        Complex num2 = inputComplex("Введите действительную часть второго числа: ",
                "Введите мнимую часть второго числа: ");

        Complex result = model.getResultComplex(num1, num2, operation);
        view.printComplex(result);
        start();
    }
    private Complex inputComplex(String msgR, String msgI) {
        double real = view.inputNumber(msgR);
        double image = view.inputNumber(msgI);
        Complex number = new Complex(real, image);
        return number;
    }

    private void racNumber(){
        double number1 = view.inputNumber("введите число: ");
        int index = view.choiceMenu(menuRac.getMenu(), "Выберите действие");
        char operation = menuRac.getMenu()[index-1].charAt(0);
        double number2 = view.inputNumber("введите число: ");
        double result = model.getResult(number1, number2, operation);
        view.print(String.format("Ответ: %.1f\n", result));
        start();
    }


}
