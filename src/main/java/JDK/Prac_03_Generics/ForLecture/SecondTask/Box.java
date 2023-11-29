package JDK.Prac_03_Generics.ForLecture.SecondTask;

import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruitsList;

    public void addFruitInBox(T fruit) {
        fruitsList.add(fruit);
    }

    public float getWeight() {
        return fruitsList.get(0).getWeight() * fruitsList.size();
    }

    public static void main(String[] args) {

    }

    public boolean compare(Box<?> other) {
        if (getWeight() == other.getWeight()) return true;
        return false;
    }

    public void putFruitsAnotherBox(Box<T> other) {
        if (fruitsList.size() == 0) return;
        other.fruitsList.addAll(fruitsList);
        fruitsList.clear();
    }
}