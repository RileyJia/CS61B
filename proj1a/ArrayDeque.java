/**
 * Created by jia on 17/4/16.
 */
public class ArrayDeque<type> {

    type[] items;
    int size, nextLast, nextFirst;


    public ArrayDeque(){
        items = (type[]) new Object[3];
        size = 0;
        nextFirst = items.length / 2;
        nextLast = nextFirst + 1;
    }

    public void resize(int capacity) {
        int currentSize = items.length;
        type[] newItems = (type[]) new Object[capacity];
        if (nextFirst >= nextLast) {
            System.arraycopy(items, nextFirst + 1, newItems, 0, currentSize - nextFirst - 1);
            System.arraycopy(items, 0, newItems, currentSize - nextFirst - 1, nextLast);
        }
        else {
            System.arraycopy(items, nextFirst + 1, newItems, 0, size);
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(type x){
        items[nextFirst] = x;
        size++;
        if (nextFirst == 0){
            nextFirst = items.length - 1;
        }else {
            nextFirst --;
        }
        if(nextFirst == nextLast){
            resize(items.length * 2);
        }
    }

    public void addlast(type x) {
        items[nextLast] = x;
        size ++;
        if (nextLast == items.length -1){
            nextLast = 0;
        }else{
            nextLast ++;
        }
        if (nextLast == nextFirst){
            resize(items.length * 2);
        }
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int i;
        if (nextFirst >= nextLast){
            for (i = nextFirst + 1; i < items.length; i ++)
            {
                System.out.print(items[i] + " ");
            }
        }
        for (i = 0; i < nextLast; i++)
        {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public type removeFirst(){
        if (nextFirst == items.length - 1){
            nextFirst = 0;
        }else {
            nextFirst ++;
        }
        type temp = items[nextFirst];
        items[nextFirst]= null;
        size --;
        return temp;
    }

    public type removeLast(){
        if (nextLast == 0){
            nextLast = items.length - 1;
        }else {
            nextLast --;
        }
        type temp = items[nextLast];
        items[nextLast]= null;
        size --;
        return temp;
    }

    public type get(int index){
        if (nextFirst + index + 1 <= items.length - 1){
            return items[nextFirst + index + 1];
        }
        if (size - index > 0){
            return items[index + nextFirst +1 - items.length];
        }
        return null;
    }

    public static void main(String args[]){

    }

}
