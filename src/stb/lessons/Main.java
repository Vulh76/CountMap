package stb.lessons;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        CountMap<String> countMap = new CountMapImpl<>();

        countMap.add("1");
        countMap.add("2");
        countMap.add("3");
        countMap.add("4");
        countMap.add("1");
        countMap.add("1");
        countMap.add("2");
        countMap.add("1");
        countMap.add("1");
        countMap.add("7");
        countMap.add("9");
        countMap.add("7");
        countMap.add("9");
        countMap.add("AAA");
        countMap.add("HJU");
        countMap.add("UUWIIWIWIKQ");
        countMap.add("Skkifsd");
        countMap.add("99999");
        countMap.add("123456");
        countMap.add("UUWIIWIWIKQ");
        countMap.add("123456");
        countMap.add("123456");
        countMap.add("0000");

        System.out.println("Количество элементов: " + countMap.size());
        System.out.println(countMap);
        System.out.println();
        int count;

        System.out.println("Удаление:");
        count = countMap.remove("1");
        System.out.println("1: " + count);
        count = countMap.remove("9");
        System.out.println("9: " + count);
        System.out.println();

        System.out.println("Количество:");
        count = countMap.getCount("1");
        System.out.println("1: " + count);
        count = countMap.getCount("2");
        System.out.println("2: " + count);
        count = countMap.getCount("7");
        System.out.println("7: " + count);
        System.out.println();

        System.out.println("toMap():");
        Map<String, Integer> map1 = countMap.toMap();
        System.out.println(map1);
        System.out.println();

        System.out.println("toMap(Map<K, V> destination):");
        Map<String, Integer> map2 = new HashMap<>();
        countMap.toMap(map2);
        System.out.println(map2);
        System.out.println();

        System.out.println("Добавление СountMap:");
        CountMap<String> countMapCopy = new CountMapImpl<>();
        countMapCopy.addAll(countMap);
        System.out.println(countMapCopy);
        System.out.println();

        // CollectionUtils

        int index;
        boolean res;
        List<Integer> list1 = CollectionUtils.newArrayList();
        CollectionUtils.addAll(Arrays.asList(2, 11, 81, 4, 5, 39, 4, 8, 12), list1);

        System.out.println(list1);

        index = CollectionUtils.indexOf(list1, 81);
        System.out.println(index);

        List<Integer> list2 = CollectionUtils.limit(list1, 7);
        System.out.println(list2);

        CollectionUtils.add(list2, 999);
        CollectionUtils.add(list2, 111);
        CollectionUtils.add(list2, 0);
        System.out.println(list2);

        CollectionUtils.removeAll(list2, list1);
        System.out.println(list2);

        res = CollectionUtils.containsAll(list1, Arrays.asList(2, 11, 81, 4, 5));
        System.out.println(res);
        res = CollectionUtils.containsAll(list1, Arrays.asList(2, 22, 81, 4, 5));
        System.out.println(res);

        res = CollectionUtils.containsAny(list2, Arrays.asList(2, 111, 81, 4, 5));
        System.out.println(res);
        res = CollectionUtils.containsAny(list2, Arrays.asList(2, 22, 81, 4, 5));
        System.out.println(res);

        System.out.println(list1);
        list1 = CollectionUtils.<Integer, Integer>range(list1, 3, 30);
        System.out.println(list1);

        CollectionUtils.addAll(list1, list2);
        System.out.println(list2);
        list2 = CollectionUtils.range(list2, 3, 30, Comparator.naturalOrder());
        System.out.println(list2);
        System.out.println();

        List<Child> childs = Arrays.asList(new Child(1), new Child(3), new Child(5), new Child(7), new Child(9));
        childs.forEach(System.out::println);
        System.out.println();
        List<Parent> parents = CollectionUtils.range(childs, 2, 6);
        parents.forEach(System.out::println);
        System.out.println();
    }

    static class Parent implements Comparable<Integer> {
        public int i;

        public Parent(int i) {
            this.i = i;
        }

        @Override
        public int compareTo(Integer o) {
            return new Integer(i).compareTo(o);
        }

        @Override
        public String toString() {
            return "Parent{" +
                    "i=" + i +
                    '}';
        }
    }

    static class Child extends Parent {

        public Child(int i) {
            super(i);
        }

        @Override
        public String toString() {
            return "Child{" +
                    "i=" + i +
                    '}';
        }
    }
}


