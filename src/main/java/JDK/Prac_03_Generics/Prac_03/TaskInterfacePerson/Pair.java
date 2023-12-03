package JDK.Prac_03_Generics.Prac_03.TaskInterfacePerson;

public class Pair<T, V> {
    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair {" +
                "first = " + first +
                ", second = " + second +
                '}';
    }

    public static void main(String[] args) {
        Pair<String,Integer> test = new Pair<>("11",2);
        System.out.println(test);
        System.out.println(test.getFirst());
        System.out.println(test.getSecond());
    }
}