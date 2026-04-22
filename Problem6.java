import java.util.*;

public class Problem6 {

    static int linearSearch(int[] arr, int target) {
        int comps = 0;

        for (int i = 0; i < arr.length; i++) {
            comps++;
            if (arr[i] == target) {
                System.out.println("Linear comparisons: " + comps);
                return i;
            }
        }

        System.out.println("Linear comparisons: " + comps);
        return -1;
    }

    static int floor(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ans = -1, comps = 0;

        while (l <= r) {
            comps++;
            int m = (l + r) / 2;

            if (arr[m] <= target) {
                ans = arr[m];
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println("Floor comparisons: " + comps);
        return ans;
    }

    static int ceiling(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ans = -1, comps = 0;

        while (l <= r) {
            comps++;
            int m = (l + r) / 2;

            if (arr[m] >= target) {
                ans = arr[m];
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.println("Ceiling comparisons: " + comps);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        System.out.println(linearSearch(arr, 30));
        System.out.println("Floor: " + floor(arr, 30));
        System.out.println("Ceiling: " + ceiling(arr, 30));
    }
}
