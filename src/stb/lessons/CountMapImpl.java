package stb.lessons;

import java.util.*;

public class CountMapImpl<E> implements CountMap<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE;

    private Object[] data;
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;

    public CountMapImpl() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(E e) {
        CountMapItem<E> item = findItem(e);
        if (item != null) {
            item.setCount(item.getCount() + 1);
        }
        else {
            ensureCapacity(this.size + 1);
            data[size++] = new CountMapItem<>(e);
        }
    }

    @Override
    public int getCount(E e) {
        CountMapItem<E> item = findItem(e);
        if (item != null)
            return item.getCount();
        return 0;
    }

    @Override
    public int remove(E e) {
        int index = findItemIndex(e);
        if (index >= 0) {
            CountMapItem<E> item = getItem(index);
            int count = item.getCount();
            if(count > 1)
                item.setCount(count - 1);
            else
                remove(index);
            return count;
        }
        return 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addAll(CountMap<E> source) {
        for (E e : source) {
            this.add(e);
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        Map<E, Integer> map = new HashMap<>();
        for (int i = 0; i < this.size; i++) {
            CountMapItem<E> item = getItem(i);
            map.put(item.getValue(), item.getCount());
        }
        return map;
    }

    @Override
    public void toMap(Map<E, Integer> destination) {
        if(destination == null)
            throw new IllegalArgumentException();

        destination.clear();
        for (int i = 0; i < this.size; i++) {
            CountMapItem<E> item = getItem(i);
            destination.put(item.getValue(), item.getCount());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CountMapImpl{\r\n");
        for (int i = 0; i < this.size; i++) {
            CountMapItem<E> item = getItem(i);
            sb.append("\tValue: ").append(item.getValue()).append("\tCount: ").append(item.getCount()).append("\r\n");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                return current < size - 1;
            }

            @Override
            public E next() {
                if (current == size - 1)
                    throw new NoSuchElementException();
                current++;
                return (getItem(current).getValue()) ;
            }
        };
    }

    private CountMapItem<E> getItem(int index) {
        @SuppressWarnings("unchecked")
        CountMapItem<E> item = (CountMapItem<E>) data[index];
        return item;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    private void ensureCapacity(int minCapacity) {
        if (this.capacity < minCapacity) {
            int newCapacity = this.capacity * 2;
            this.data = Arrays.copyOf(data, newCapacity);
            capacity = newCapacity;
        }
    }

    private CountMapItem<E> findItem(E e) {
        int index = findItemIndex(e);
        if (index >= 0) {
            return getItem(index);
        }
        return null;
    }

    private int findItemIndex(E e) {
        for (int i = 0; i < this.size; i++) {
            CountMapItem<E> item = getItem(i);
            if(e.equals(item.getValue())) return i;
        }
        return -1;
    }

    private void remove(int index) {
        rangeCheck(index);

        int numMoved = this.size - index - 1;
        if (numMoved > 0)
            System.arraycopy(this.data, index + 1, this.data, index, numMoved);
        data[--size] = null;
    }

    private class CountMapItem<T> {
        private final T value;
        private int count;

        public CountMapItem(T value) {
            this.value = value;
            this.count = 1;
        }

        public T getValue() {
            return this.value;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            @SuppressWarnings("unchecked")
            CountMapItem<?> that = (CountMapItem<?>) o;
            return getValue().equals(that.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }
    }
}
