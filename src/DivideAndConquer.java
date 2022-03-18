import java.util.Random;

public class DivideAndConquer {
    private boolean isSomething(int start, int end) {
        return start >= end;
    }

    // primitive type 원시 변수 [int, char, float, double, bool, short, long]
    // instance variable
    // 객체 [String, int[], Animal]: String str = new String("hello"); //

    public void mergeSort(int[] arr, int start, int end) { // 6
        if (isSomething(start, end)) { return; }   // 빠져나올 수 있는 조건

        int mid = (start + end) / 2;        // start = 0, end = 5, mid = 2

        mergeSort(arr, 0, mid);         // 왼쪽 분할 [0-2]
        mergeSort(arr, mid+1, end);     // 오른쪽 분할 [3-5]

        merge(arr, start, mid, end);         // 왼쪽 오른쪽 병합
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int p = start;
        int q = mid + 1;
        int idx = p;

        int[] tmp = new int[arr.length];

        while(p <= mid || q <= end) {
            if (q > end || (p <= mid && arr[p] < arr[q])) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }

        if (end + 1 - start >= 0) System.arraycopy(tmp, start, arr, start, end + 1 - start);
    }

    public static void main(String[] args) {
        Random r = new Random();

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1000);   // (0, 1000]
        }

        for (int k : arr) {
            System.out.printf("%d ", k);
        }
        System.out.println();

        DivideAndConquer dac = new DivideAndConquer();
        dac.mergeSort(arr, 0, arr.length - 1);

        for (int j : arr) {
            System.out.printf("%d ", j);
        }

        System.out.println();

        System.out.println("hello world");
    }
}
