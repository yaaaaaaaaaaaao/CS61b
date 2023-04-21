package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> A = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        A.addLast(4);
        A.addLast(5);
        A.addLast(6);

        B.addLast(4);
        B.addLast(5);
        B.addLast(6);

        assertEquals(A.removeLast(),B.removeLast());
        assertEquals(A.removeLast(),B.removeLast());
        assertEquals(A.removeLast(),B.removeLast());
    }


    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");

            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                //int size2 = L2.size();
                System.out.println("size: " + size);
                assertEquals(L.size(), L2.size());

            } else if (operationNumber == 2) {
                if(L.size() > 0 ){
                    int last = L.getLast();
                    //int last2 = L2.getLast();
                    System.out.println("remove: " + last);
                    assertEquals(L.removeLast(), L2.removeLast());
                }
            }

        }
    }
}
