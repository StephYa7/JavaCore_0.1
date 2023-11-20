package lesson2;


import java.util.*;

/**Написать структуру данных, хранящую целые числа и поддерживающую следующие операции:
   *     добавление значения в множество
   *     проверка есть ли значение в множестве
   *     удаление значения из множества
   *     получение равномерно случайного значения из множества.
   *     все операции O(1)
   */
public class RandomSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public void add(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
        }
    }

    public boolean contains(int val) {
        return map.containsKey(val);
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public void remove(int val) {
        if (map.containsKey(val)) {
            int lastElement = list.get(list.size() - 1);
            int index = map.get(val);

            list.set(index, lastElement);
            map.put(lastElement, index);

            list.remove(list.size() - 1);
            map.remove(val);
        }
    }
}
