import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String n, double r, double v) {
        name = n;
        returnRate = r;
        volatility = v;
    }

    public String toString() {
        return name + ":" + returnRate;
    }
}

public class Problem4 {

    static void mergeSort(Asset[] arr, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(Asset[] arr, int l, int m, int r) {
        Asset[] temp = new Asset[r - l + 1];

        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i].returnRate <= arr[j].returnRate)
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l; i <= r; i++) arr[i] = temp[i - l];
    }

    static void quickSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    static int partition(Asset[] arr, int l, int r) {
        Asset pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j].returnRate > pivot.returnRate) {
                i++;
                Asset t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        Asset t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;

        return i + 1;
    }

    public static void main(String[] args) {
        Asset[] arr = {
            new Asset("AAPL", 12, 3),
            new Asset("TSLA", 8, 5),
            new Asset("GOOG", 15, 2)
        };

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
