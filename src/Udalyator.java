import java.util.Arrays;

public class Udalyator {
    /**
     * Removes x from S, where S = {0,1, ..., n-1}.
     * Looking for a successor x that is greater than
     * or equal to x. But the smallest among the remaining numbers.
     */
    private Integer[] A;
    private int halfOfN;
    private int size;
    private int lastSuccessor = -1;



    /**
     *Creates an array of size (halfOfN / 2 + halfOfN / 2) for further operations on it.
     * @param n - the size of the array from 1 to halfOfN.
     */
    Udalyator(int n) {
        this.A = new Integer[n];
        this.halfOfN = n/2;
        this.size = n-1;

        for (int i = 0; i < n; i++){
            A[i] = i;
        }
    }

    /**
     *Deletes the given number.
     * @param X - the number to be deleted.
     * @return true if such a number is found in the array.
     */
    boolean deleteX(int X) {
//        System.out.println(X + " " + size);
        if (X > size || X < 0) {
           return false;
        }

        boolean isFindX = false;

        if (X < halfOfN) {
            for (int i = 0; i < size + 1; i++) {
                if (A[i] == X) {
                    isFindX = true;
                    lastSuccessor = A[i + 1];
                    size--;
                    halfOfN = size / 2;
                }
                if (isFindX && i <= size) {
                    A[i] = A[i + 1];
                }
            }

        } else {
            if (A[size] == X){
                lastSuccessor = -1;
                size--;
                halfOfN = size / 2;
            } else {
                for (int i = halfOfN; i < size + 1; i++) {
                    if (A[i] == X) {
                        isFindX = true;
                        lastSuccessor = A[i + 1];
                        size--;
                        halfOfN = size / 2;
                    }
                    if (isFindX && i <= size) {
                        A[i] = A[i + 1];
                    }
                }
            }
        }
        return true;
    }

    /**
     *
     * @param X - whose successor will be found
     * @return successor of x
     */
    int findSuccessorX(int X) {
        if (A[size] == X){
            return -1;
        }
        return lastSuccessor;
    }

    @Override
    public String toString() {
        return "Udalyator{" +
                "A=" + Arrays.toString(A) +
                ", halfOfN=" + halfOfN +
                ", size=" + size +
                ", lastSuccessor=" + lastSuccessor +
                '}';
    }
}
