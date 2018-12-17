package codility;

/**
 * Created by Abayomi on 19/02/2016.
 */
public class CountingArrays {

    public static void main(String[] args) {
        int[] A = {12,43,4,75,8,19}, B = {93,4,75,88,82,9};
        System.out.println(solve(A, B, 93));
    }

    static int[] counting (int[] A, int m){
        int n = A.length, count[] = new int[m+1];

        for (int i = 0; i < n; i++) {
            count[A[i]] += 1;
        }

        return count;
    }

    static boolean solve(int[] A, int[] B, int m){
        int n = A.length, sum_a = sum(A), sum_b = sum(B);
        int d = sum_b - sum_a;
        if (d%2 == 1)
            return false;
        d /= 2;
        int[] count = counting(A, m);
        for (int i = 0; i < n; i++) {
            if(0 <= B[i] - d && B[i] - d <= m && count[B[i] - d] > 0)
                return true;
        }
        return false;
    }

    static int sum(int[] array){
       /* Convert array to a stream.
        IntStream s = Arrays.stream(array);
          Use reduce to sum all elements in the array.
        int sum = s.reduce(0, (a, b) -> a + b);
        OR :
        IntStream s = Arrays.stream(array);
        int sum = s.reduce(0, Integer::sum);
        Reduce function is slower. */
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
