# Задача 9
## Написать программу на языках Java, в которой идёт со следующими геометрическими фигурами:
1. Треугольник
2. Квадрат
3. Прямоугольник
4. Круг

В программе имеется массив фигур, с которым можно сделать следующие операции:
1. Добавить новую фигуру
2. Посчитать периметр у всех фигур
3. Посчитать площадь у всех фигур

Для фигуры использовать базовый абстрактный класс фигуры, у которого есть методы посчитать 
периметр и посчитать площадь фигуры.

Создать класс-коллекцию фигур В классе-коллекции реализовать методы.
1. Вывода информации о всех периметах, площадях и длиннах окружности всех фигур, где это возможно,
2. добавления новой фигуры,
3. удаления фигуры,
4. изменения фигуры по ндексу,
5. сортировки по площади, вывод информации о всех фигурах.  

При создании фигур необходимо осуществлять проверку входных данных на возможность создания данной фигуры и в случае
ошибки выдавать соответствующие сообщения. Перодумать собственную иерархию исключений

## Декомпозиция.
### Классы
1. Интерфейс фигура (Figure) с методом получения площади и имени;
2. Классы окружность (Circle), многоугольник (Poligon).
3. Дочерние классы многоугольника - триугольник (Triangular), четырёхугольник (Quadrilateral).
4. Дочерние классы триугольника - прямоугольный триугольник (RightTringle), простой триугольник (SimpleTriangle)
5. Дочерние классы четырехугольника - квадрат (Quadrate), прямоугольник (Rectangle).
6. Класс коллекция (Collection)
7. Класс программа (Program)  
### Интерфейсы
1. Периметр (Perimeter)
2. Длина окружности (Lenght)
3. Площадь (Square)
### Методы и поля
1. Фигура.
* Поле лист параметров, будет актуален, если параметры фигур вводить с клавиатуры, 
и если многоугольники будут иметь куда больше 4 строно;
* name - для более дружелюбного вывода
* square - площадь имеют все фигуры.
* методы возврата площади и имени, для работы в объектами фигур в классе колекции
* проверки на положительное число, чтобы отъсеять фигуры с отрицательными параметрами или 0
* compareTo - для сортировки коллекции фигур
2. Окружность.
* Длина окружности есть только у окружности (length = 2 * PI * radius);
  * конструктор принимает radius, который не может быть меньше 0 и рассчитывает площадь и длину окружности;
  * метод для возврата длины окружности
3. Многоугольник.
* Периметр есть только у многоугольников.
* метод для вычисление периметра (удобен если есть большое 
количество сторон и ввод с клавиытуры. Можно завязать все многоугольники)
3. Треугольник.
* конструктор принимает 3 стороны side;
  * проверка параметров сторон
  * коллекция из трёх сторон отправляется в метод подсчёта периметра;
  * вычисление площади.
* Метод вычисления площади (Math.sqrt(p * (p - a) * (p - b) * (p - c));
4. Прямоугольный треугольник. - 
* метод вычисления площади. (squre = sqr(sideA ^ 2 + sideB & 2))
4. Многоугольник -
5. Четырёхугольник. актуален если будут ромбы, трапеции и прочие четурёхугольники -
6. Квадрат.
* принимает одну сторону;
* метод вычисления площади (squre = sideA ^ 2);
* метод вычисления периметра (perimeter = sideA * 4);
7. Прямоугольник.
* принимает две стороны;
* метод вычисления площади (squre = sideA * sideB);
8. Коллекция.
   * поле ArrayList\<Figure> figures
* Добавить фигуру в коллекцию. (addFigure(Figure figure))
  * принимает фигуру, добавляет в коллекцию
* Вывести информацию  о фигуре printInfo(Figure figure)(периметр, площадь, длина окружности)
* Вывести информацию о всех фигурах printInfoAllFigures(ArrayList\<figure> figures)
  * принимает список и для каждого элемента вызывает метод вывода информации
* Удаление фигуры removeFigure(int Index)
  * принимает число > 0 и \<= длине коллекции
  * удаляет элемент из списка по индексу
* Изменение фигуры по индексу changeFigure(int Index, ...)
  * принимает число > 0 и <= длине коллекции
  * принимает значения, в зависимости т вида фигуры, 
  берёт нужное количество параметров и создают новую фигуру. 
  если создание прошло успешно, заменяет фиугур
  check(int index) - проверка на корректный индекс
* Сортирока по площади с выводом всей информации о фигурах 
sortSquare(ArrayList<figure> figures)
  * Сортирует элементы по площади compareTo() 
9. Программа.
* Сощдаём объект колекции
* Создаём фигуры
* Добавляем в коллекцию
* пробуем некорректные параметры
* выводим коллекцию
* изменяем и удаляем элеменыт
* выводим снова
* сортироуем
* выводим
