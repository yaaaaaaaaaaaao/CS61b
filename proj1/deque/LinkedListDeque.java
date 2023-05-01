package deque;

import java.util.Iterator;


/** creates a circular sentinel doubly linked list */
public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private class stuffNode{
        public stuffNode previous;
        public T item;
        public stuffNode next;

        public stuffNode(stuffNode p,T i, stuffNode n){
            previous = p;
            item = i;
            next = n;
        }

    }
    private stuffNode sentinel;
    private int size;
    private T stuff;

    /** Creates an empty list */
    public LinkedListDeque(){
        sentinel = new stuffNode(sentinel, stuff, sentinel);
        size = 0;
    }

    public LinkedListDeque(T item){
        sentinel = new stuffNode(sentinel, stuff, sentinel);
        sentinel.next = new stuffNode(sentinel, item, sentinel);
        sentinel.previous = sentinel.next;
        size = 1;
    }


    /** Returns the size of Deque */
    @Override
    public int size(){
        return size;
    }

    /** Adds x to the front of Deque */
    @Override
    public void addFirst(T item){

        if (size == 0){
            sentinel.next = new stuffNode(sentinel, item, sentinel);
            sentinel.previous = sentinel.next;
        } else {
            sentinel.next = new stuffNode(sentinel, item, sentinel.next);
            sentinel.next.next.previous = sentinel.next;
        }
        size ++;
    }

    /** Adds x to the last of Deque */
    @Override
    public void addLast(T item){

        if (size == 0){
            sentinel.previous = new stuffNode(sentinel, item, sentinel);
            sentinel.next = sentinel.previous;
        }else {
            sentinel.previous = new stuffNode(sentinel.previous, item, sentinel);
            sentinel.previous.previous.next = sentinel.previous;
        }
        size ++;
    }

    /** Returns true is Deque is empty, else return false */
    @Override
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }return false;
    }

    /** Removes the first element of Deque */
    @Override
    public T removeFirst(){
        if (this.size() > 1){
        //if (! this.isEmpty()){
            T First = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.previous = new stuffNode(null, null, null);
            sentinel.next.previous = sentinel;

            size --;
            return First;
        } else if (this.size() == 1) {
            T First = sentinel.next.item;
            sentinel = new stuffNode(sentinel, stuff, sentinel);
            size --;
            return First;
        }

        return null;
    }

    /** Removes the last element of Deque */
    @Override
    public T removeLast(){
        if (this.size() > 1){
            T Last = sentinel.previous.item;
            sentinel.previous = sentinel.previous.previous;
            sentinel.previous.next =  new stuffNode(null, null, null);
            sentinel.previous.next = sentinel;
            size --;
            return Last;
        } else if (this.size() == 1) {
            T Last = sentinel.previous.item;
            sentinel = new stuffNode(sentinel, stuff, sentinel);
            size --;
            return Last;
        }return null;
    }

    /** Get the index th item */
    @Override
    public T get(int index){
        stuffNode p = sentinel;
        for(int i = 0; i < size; i ++){
            T item = p.next.item;
            if (i == index){
                return item;
            }
            p = p.next;
        }
        return null;
    }

    /** Print all the items in Deque */
    @Override
    public void printDeque(){
        stuffNode p = sentinel;
        StringBuilder returnString = new StringBuilder("");
        for(int i = 0; i < size; i ++){
            T item = p.next.item;
            returnString.append(item.toString());
            returnString.append(" ");
            p = p.next;
            }
        System.out.println(returnString);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof LinkedListDeque otherLLD){
            if (otherLLD.size() != size) {
                return false;
            }
            stuffNode otherp = otherLLD.sentinel;
            for (T i: this){
            //for(int i = 0; i < size; i ++)
                otherp = otherp.next;
                if (! i.equals(otherp.item)){
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    /** Creates an iterator */
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    /** Overrides the hasNext() and next() methods */
    public class DequeIterator implements Iterator<T>{
        private stuffNode p = sentinel;
        @Override
        public boolean hasNext(){
            if (p.next == sentinel){
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


    public static void main(String[] args) {
        /* Creates a list of one integer, namely 1 */
//        LinkedListDeque<Integer> L = new LinkedListDeque(1);
//        L.addFirst(3);
//        L.addFirst(5);
//        L.addLast(10);
//        //L.removeLast();
//        int a = L.get(0);
//        System.out.println(L.printDeque());
//        System.out.println(L.get(3));

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

            lld1.addLast("first");
            lld1.addLast("second");
            lld1.addLast("third");
            //System.out.println(lld1.size());


        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();

            lld2.addLast("first");
            lld2.addLast("second");
            lld2.addLast("third");
            //System.out.println(lld1.size());


        System.out.println(lld1.equals(lld2));
        //LinkedListDeque<Integer> L2 = new LinkedListDeque("s");
        //System.out.println(L2.isEmpty());
    }
}
