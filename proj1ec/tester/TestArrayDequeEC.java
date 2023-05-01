package tester;
import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.introcs.StdRandom;


public class TestArrayDequeEC {
    @Test
    public void basicRandomizedTest() {
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution();
        StudentArrayDeque<Integer> student = new StudentArrayDeque();
        StringBuilder errorMessage = new StringBuilder();
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                solution.addLast(i);
                student.addLast(i);
                String operation = "addLast(" + i +")";
                errorMessage.append(operation);
                errorMessage.append("\n");
            } else {
                solution.addFirst(i);
                student.addFirst(i);
                String operation = "addFirst(" + i +")";
                errorMessage.append(operation);
                errorMessage.append("\n");
            }
        }

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                Integer slt = solution.removeFirst();
                Integer stu = student.removeFirst();
                errorMessage.append("removeFirst()\n");
                String returnMessage = errorMessage.toString();
                assertEquals(returnMessage, slt, stu);
            } else {
                Integer slt = solution.removeLast();
                Integer stu = student.removeLast();
                errorMessage.append("removeLast()\n");
                String returnMessage = errorMessage.toString();
                assertEquals(returnMessage, slt, stu);
            }
        }
    }
}
