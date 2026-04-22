import java.util.*;

class Client {
    String name;
    int riskScore;
    int balance;

    Client(String name, int riskScore, int balance) {
        this.name = name;
        this.riskScore = riskScore;
        this.balance = balance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class Problem2 {

    static void bubbleSort(Client[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        System.out.println("Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                  (arr[j].riskScore < key.riskScore ||
                  (arr[j].riskScore == key.riskScore &&
                   arr[j].balance < key.balance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Client[] arr = {
            new Client("C", 80, 5000),
            new Client("A", 20, 3000),
            new Client("B", 50, 4000)
        };

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Top Risks:");
        for (int i = 0; i < Math.min(3, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }
}
