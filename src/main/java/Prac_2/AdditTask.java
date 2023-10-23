package Prac_2;

    /*Написать структуру данных, хранящую целые числа и поддерживающую следующие операции:
        добавление значения в множество
        проверка есть ли значение в множестве
        удаление значения из множества
        получение равномерно случайного значения из множества.
        все операции O(1)
     */

public class AdditTask {

    public class RandomSet {
        public void add(int val) {
        }

        public boolean contains(int val) {
            return true;
        }

        public int getRandom() {
            return 0;
        }

        public void remove(int val) {

        }
    }

}


class DeepestNode {
    //Дано бинарное дерево, нужно найти и вернуть элемент, находящийся на максимальной глубине от корня.
    public static class Node {
        int val;
        Node left;
        Node right;
    }

    public Node getDeepestNode(Node root) {
        // your code
        return null;
    }
}