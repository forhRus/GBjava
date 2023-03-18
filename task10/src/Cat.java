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
        if(obj instanceof Cat) {
            Cat t = (Cat)obj;
            return t.name == this.name
            && t.age == this.age
            && t.color == this.color
            && t.height == this.height
            && t.weight == this.weight;
        } else
            return false;
    }
    public int hashCode() {
        return  weight;
    }
}