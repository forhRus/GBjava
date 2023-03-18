public class Cat {
    private String name, color;
    private int height, weight, age;


    public Cat(String name, int height, int weight, int age, String color) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.color = color;
        this.name = name;
    }

    public Cat() {
        this("Барсик", 200, 5, 2, "серый");
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }


    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name=\"" + name + '\"' +
                ", color=\"" + color + '\"' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof Cat))
            return false;
        Cat cat = (Cat) obj;
        if (cat.age != this.age
                || cat.height != this.height
                || cat.weight != this.weight)
            return false;
        if (this.name == null) {
            if (this.color == null) {
                return cat.color == null && cat.name == null;
            } else {
                return this.color.equals(cat.color) && cat.name == null;
            }
        } else if (this.color == null) {
            return this.name.equals(cat.color) && cat.color == null;
        } else {
            return this.name.equals(cat.name) && this.color.equals(cat.color);
        }
    }

    @Override
    public int hashCode() {
        int sum = this.name.length() * 123 + this.color.length() * 123 +
                + this.weight * 123 + this.age * 123 + this.height * 123;
        return sum;
    }
}