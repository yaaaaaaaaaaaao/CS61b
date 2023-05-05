package deque;
import java.util.Iterator;


public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private T[] items;

    /** keep track the next pos to put first and last */
    private int nextFirst;
    private int nextLast;

    /** Creates an empty ArrayDeque. */
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;

    }
    @Override
    public void addFirst(T item) {
        /** resize first if needed */
        if (nextFirst < 0) {
            resize(items.length * 2, 0);
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (nextLast >= items.length) {
            resize(items.length * 2, 1);
        }
        items[nextLast] = item;
        nextLast++;
        size++;
    }


    public T get(int index) {
        return items[nextFirst + index + 1];
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if ((size > 16) && (size < items.length / 4)) {
            resize(items.length / 4, 1);
        }
        T firstItem = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst++;
        size--;
        return firstItem;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if ((size > 16) && (size < items.length / 4)) {
            resize(items.length / 4, 1);
        }
        T lastItem = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast--;
        size--;
        return lastItem;
    }



    @Override
    /** Returns size of items */
    public int size() {
        return size;
    }


    /** Resizes the ArrayDeque passes in two parameters: capacity and pos */
    private void resize(int capacity, int pos) {
        //int newSize = capacity + items.length;
        T[] a = (T[]) new Object[capacity];
        // add capacity first and starts copy: start copy from position capacity
        if (pos == 0) {
            for (int i = items.length; i < capacity; i += 1) {
                a[i] = items[i - items.length];
            }
            items = a;
            nextFirst = items.length / 2 - 1;
            nextLast = nextFirst + size + 1;
        }

        // add capacity to the end and copy from pos 0: start copy from position capacity
        if (pos == 1) {
            for (int i = nextFirst + 1; i < nextLast; i += 1) {
                a[i] = items[i];
            }
            items = a;
        }

        //nextLast = nextLast + capacity;
    }


    @Override
    public void printDeque() {
        StringBuilder returnSB = new StringBuilder("");
        int startPos = nextFirst + 1;
        for (int i = startPos; i < size + startPos; i++) {
            T item = items[i];
            returnSB.append(item);
            returnSB.append(" ");
        }
        System.out.println(returnSB);
    }


    /** Returns true if o and this has the same content */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || this == null) {
            return false;
        }
        if (o instanceof ArrayDeque) {
            Deque otherArray = (Deque) o;
            if (otherArray.size() != this.size()) {
                return false;
            }
            for (int i = 0; i < this.size(); i++) {
                if (!get(i).equals(otherArray.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /** Returns new iterator ADIterator */
    public Iterator<T> iterator() {
        return new ADIterator();
    }

    /** Overrides ADIterator hasNext() and Next() method */
    private class ADIterator implements Iterator<T> {
        private int pos;
        private int curr = 0;
        @Override
        public boolean hasNext() {
            if (curr < size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            curr++;
            return items[curr - 1];
        }

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

        for(int i = 0; i < 10; i ++){
            ad.addFirst(i);
            ad.removeLast();
        }
        ad.removeLast();
        ad.printDeque();
        System.out.println(ad.size());
    }

}


