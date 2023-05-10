package IntList;

public class IntListExercises {

    /**
     * Part A: (Buggy) mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static void addConstant(IntList lst, int c) {
        IntList head = lst;
<<<<<<< HEAD
        while (head != null) {
=======
        while (head.rest != null) {
>>>>>>> 160747451c147c59d8e3cbf70a7afee2b73bebdb
            head.first += c;
            head = head.rest;
        }
    }

    /**
     * Part B: Buggy method that sets node.first to zero if
     * the max value in the list starting at node has the same
     * first and last digit, for every node in L
     *
     * @param L IntList from Lecture
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L;
        while (p != null) {
            if (firstDigitEqualsLastDigit(max(p))) {
                p.first = 0;
            }
            p = p.rest;
        }
    }

<<<<<<< HEAD
    /**
     * Returns the max value in the IntList starting at L.
     */
=======
    /** Returns the max value in the IntList starting at L. */
>>>>>>> 160747451c147c59d8e3cbf70a7afee2b73bebdb
    public static int max(IntList L) {
        int max = L.first;
        IntList p = L.rest;
        while (p != null) {
            if (p.first > max) {
                max = p.first;
            }
            p = p.rest;
        }
        return max;
    }

<<<<<<< HEAD
    /**
     * Returns true if the last digit of x is equal to
     * the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        int lastDigit = x % 10;
        while (x >= 10) {
=======
    /** Returns true if the last digit of x is equal to
     *  the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        int lastDigit = x % 10;
        while (x > 10) {
>>>>>>> 160747451c147c59d8e3cbf70a7afee2b73bebdb
            x = x / 10;
        }
        int firstDigit = x % 10;
        return firstDigit == lastDigit;
    }

    /**
     * Part C: (Buggy) mutative method that squares each prime
     * element of the IntList.
     *
     * @param lst IntList from Lecture
     * @return True if there was an update to the list
     */
<<<<<<< HEAD

    public static boolean squarePrimes(IntList lst) {
        // Base Case: we have reached the end of the list
//        boolean currElemIsPrime = false;
//        if (lst == null) {
//            return currElemIsPrime;
//        }
//
//        if (Primes.isPrime(lst.first)) {
//            lst.first *= lst.first;
//            currElemIsPrime = true;
//        }
//        squarePrimes(lst.rest);
//        return currElemIsPrime;
        boolean currElemIsPrime = false;
        IntList L = lst;
        while (L != null) {
            if (Primes.isPrime(L.first)) {
                L.first *= L.first;
                currElemIsPrime = true;
            }
            L = L.rest;
        }
        return currElemIsPrime;
=======
    public static boolean squarePrimes(IntList lst) {
        // Base Case: we have reached the end of the list
        if (lst == null) {
            return false;
        }

        boolean currElemIsPrime = Primes.isPrime(lst.first);

        if (currElemIsPrime) {
            lst.first *= lst.first;
        }

        return currElemIsPrime || squarePrimes(lst.rest);
>>>>>>> 160747451c147c59d8e3cbf70a7afee2b73bebdb
    }
}
