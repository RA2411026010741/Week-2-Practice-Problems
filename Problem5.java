import java.util.*;

public class Problem5 {

    static int linearSearch(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear comparisons: " + comparisons);
        return -1;
    }

    static int binarySearch(String[] arr, String target) {
        int l = 0, r = arr.length - 1;
        int comparisons = 0;

        while (l <= r) {
            comparisons++;
            int m = (l + r) / 2;

            if (arr[m].equals(target)) {
                System.out.println("Binary comparisons: " + comparisons);
                return m;
            } else if (arr[m].compareTo(target) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println("Binary comparisons: " + comparisons);
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {"accB", "accA", "accB", "accC"};

        Arrays.sort(arr);

        System.out.println(linearSearch(arr, "accB"));
        System.out.println(binarySearch(arr, "accB"));
    }
}
