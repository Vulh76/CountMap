package stb.lessons;

import java.util.Map;

public interface CountMap<E> extends Iterable<E>{
    // добавляет элемент в этот контейнер.
    void add(E e);

    //Возвращает количество добавлений данного элемента
    int getCount(E e);

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    int remove(E e);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значения
    void addAll(CountMap<E> source);

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map<E, Integer> toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<E, Integer> destination);
}
