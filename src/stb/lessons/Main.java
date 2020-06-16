package stb.lessons;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        CountMapImpl<String> countMap = new CountMapImpl<>();

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

        System.out.println(countMap);

        int count;

        System.out.println("Удаление:");
        count = countMap.remove("1");
        System.out.println(count);
        count = countMap.remove("9");
        System.out.println(count);

        System.out.println("Количество:");
        count = countMap.getCount("1");
        System.out.println(count);
        count = countMap.getCount("2");
        System.out.println(count);
        count = countMap.getCount("7");
        System.out.println(count);

        System.out.println("toMap:");
        Map<String, Integer> map = countMap.toMap();
        System.out.println(map);
    }
}
