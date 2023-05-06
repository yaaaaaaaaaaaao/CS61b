package deque;

import java.util.Iterator;


/** creates a circular sentinel doubly linked list */
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class StuffNode {
        private StuffNode previous;
        private T item;
        private StuffNode next;

        StuffNode(StuffNode p, T i, StuffNode n) {
            previous = p;
            item = i;
            next = n;
        }

    }

    private StuffNode sentinel;
    private int size;
    private T stuff;

    /**
     * Creates an empty list
     */
    public LinkedListDeque() {
        sentinel = new StuffNode(sentinel, stuff, sentinel);
        size = 0;
    }

//    public LinkedListDeque(T item) {
//        sentinel = new StuffNode(sentinel, stuff, sentinel);
//        sentinel.next = new StuffNode(sentinel, item, sentinel);
//        sentinel.previous = sentinel.next;
//        size = 1;
//    }


    /**
     * Returns the size of Deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds x to the front of Deque
     */
    @Override
    public void addFirst(T item) {

        if (size == 0) {
            sentinel.next = new StuffNode(sentinel, item, sentinel);
            sentinel.previous = sentinel.next;
        } else {
            sentinel.next = new StuffNode(sentinel, item, sentinel.next);
            sentinel.next.next.previous = sentinel.next;
        }
        size++;
    }

    /**
     * Adds x to the last of Deque
     */
    @Override
    public void addLast(T item) {

        if (size == 0) {
            sentinel.previous = new StuffNode(sentinel, item, sentinel);
            sentinel.next = sentinel.previous;
        } else {
            sentinel.previous = new StuffNode(sentinel.previous, item, sentinel);
            sentinel.previous.previous.next = sentinel.previous;
        }
        size++;
    }


    /**
     * Removes the first element of Deque
     */
    @Override
    public T removeFirst() {

        if (this.size() > 1) {
            //if (! this.isEmpty()){
            T firstItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.previous = new StuffNode(null, null, null);
            sentinel.next.previous = sentinel;
            size--;
            return firstItem;
        } else if (this.size() == 1) {
            T firstItem = sentinel.next.item;
            sentinel = new StuffNode(sentinel, stuff, sentinel);
            size--;
            return firstItem;
        }

        return null;
    }

    /**
     * Removes the last element of Deque
     */
    @Override
    public T removeLast() {

        if (this.size() > 1) {
            T lastItem = sentinel.previous.item;
            sentinel.previous = sentinel.previous.previous;
            sentinel.previous.next = new StuffNode(null, null, null);
            sentinel.previous.next = sentinel;
            size--;
            return lastItem;
        } else if (this.size() == 1) {
            T lastItem = sentinel.previous.item;
            sentinel = new StuffNode(sentinel, stuff, sentinel);
            size--;
            return lastItem;
        }
        return null;
    }

    /**
     * Get the index th item
     */
    @Override
    public T get(int index) {
        StuffNode p = sentinel;
        for (int i = 0; i < size; i++) {
            T item = p.next.item;
            if (i == index) {
                return item;
            }
            p = p.next;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index >= this.size || index < 0) {
            return null;
        } else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    private T getRecursiveHelper(StuffNode p, int index) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursiveHelper(p.next, index - 1);
        }
    }

    /**
     * Print all the items in Deque
     */
    @Override
    public void printDeque() {
        StuffNode p = sentinel;
        StringBuilder returnString = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            T item = p.next.item;
            returnString.append(item.toString());
            returnString.append(" ");
            p = p.next;
        }
        System.out.println(returnString);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || this == null) {
            return false;
        }
        if (o instanceof Deque) {
            Deque otherLLD = (Deque) o;
            if (otherLLD.size() != size) {
                return false;
            }
            for (int i = 0; i < this.size(); i++) {
                if (!get(i).equals(otherLLD.get(i))) {
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    /**
     * Creates an iterator
     */
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    /**
     * Overrides the hasNext() and next() methods
     */
    private class DequeIterator implements Iterator<T> {
        private StuffNode p = sentinel;

        @Override
        public boolean hasNext() {
            if (p.next == sentinel || isEmpty()) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            p = p.next;
            return p.item;
        }

    }
}



//    public static void main(String[] args) {
//        /* Creates a list of one integer, namely 1 */
////        LinkedListDeque<Integer> L = new LinkedListDeque(1);
////        L.addFirst(3);
////        L.addFirst(5);
////        L.addLast(10);
////        //L.removeLast();
////        int a = L.get(0);
////        System.out.println(L.printDeque());
////        System.out.println(L.get(3));
//
//        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
//
//            lld1.addLast("first");
//            lld1.addLast("second");
//            lld1.addLast("third");
//            lld1.printDeque();
//
//
//        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();
//
//            lld2.addLast("first");
//            lld2.addLast("second");
//            lld2.addLast("third");
//            //System.out.println(lld1.size());
//
//
//        System.out.println(lld1.equals(lld2));
//        //LinkedListDeque<Integer> L2 = new LinkedListDeque("s");
//        //System.out.println(L2.isEmpty());
//    }}

