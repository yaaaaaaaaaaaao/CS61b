package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD

        AList<Integer> Ns = new AList<>(1);
        AList<Double> times = new AList<>(1);
        AList<Integer> opCounts = new AList<>(1);


        for(int N = 1000; N <= 128000; N = 2 * N) {
            SLList<Integer> L = new SLList<>(1,null);
            int opCount = 0;
            /** add N element to sslist */
            for (int i = 0; i < N; i++) {
                L.addLast(1);
            }
            /** start timer and add M element to sslist */
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < 10000; i++) {
                L.addLast(1);
                opCount ++;
            }
            double time = sw.elapsedTime();
            Ns.addLast(N);
            times.addLast(time);
            opCounts.addLast(opCount);
        }
        printTimingTable(Ns, times, opCounts);
    }
    }


=======
    }

}
>>>>>>> 160747451c147c59d8e3cbf70a7afee2b73bebdb
