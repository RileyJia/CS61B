public interface Deque<type>{

    void resize(int capacity);

    void addFirst(type x);

    void addlast(type x);

    boolean isEmpty();

    int size();

    void printDeque();
    type removeFirst();

    type removeLast();

    type get(int index);

}