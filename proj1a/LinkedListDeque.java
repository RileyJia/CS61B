import com.sun.org.apache.bcel.internal.generic.IINC;

/**
 * Created by jia on 17/4/16.
 */
public class LinkedListDeque<type> {
    public class TypeNode {
        public type item;
        public TypeNode next;
        public TypeNode prev;
        public TypeNode ( TypeNode p,type i, TypeNode n){
            item = i;
            next = n;
            prev = p;
        }
    }

    private TypeNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TypeNode(null,null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(type x) {
        sentinel = new TypeNode(null, null, null);
        sentinel.next = new TypeNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(type x){
        sentinel.next = new TypeNode( sentinel, x, sentinel.next);
        if (size == 0){
            sentinel.prev = sentinel.next;
            sentinel.next.next = sentinel;
        }
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }

    public void addLast(type x) {
        size ++;
        sentinel.prev = new TypeNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    public boolean isEmpty(){
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        TypeNode pointer = sentinel;
        while (pointer.next != sentinel){
            pointer = pointer.next;
            System.out.print(pointer.item + " ");
        }
        System.out.println();
    }

    public type removeFirst(){
        if(size == 0) {
            return null;
        }
        type first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size --;
        return first;
    }

    public type removeLast(){
        if (size == 0) {
            return null;
        }
        type last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size --;
        return last;
    }
    public type get(int index){
        TypeNode pointer = sentinel.next;
        int i = 0;
        while (pointer != sentinel){
            if (i == index){
                return pointer.item;
            }
            i++;
            pointer = pointer.next;
        }
        return null;
    }

    public type getRecursive(int index) {
        TypeNode pointer = sentinel.next;
        if (index >= size) {
            return null;
        }
        return recursiveHelper(pointer, index);
    }
    public type recursiveHelper (TypeNode pointer,int index){
        if (index == 0) {
            return pointer.item;
        }
        return recursiveHelper(pointer.next,index - 1);
    }


    public static void main (String[] args) {

    }
}

