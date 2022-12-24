public class ShellSort {

    private int[] arr;
    private int size;

    public ShellSort() {
        size = 10;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10) + 1;
        }
    }

    public ShellSort(int n, int lower, int upper) {
        size = n;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (upper - lower)) + lower;
        }
    }

    public void sort() {

        int interval = 1;

        while (interval <= size / 3) {
            interval = interval * 3 + 1;
        }

        while (interval >= 1) {
            for (int outer = interval; outer < size; outer++) {
                int inner = outer;
                while (inner >= interval && arr[inner] < arr[inner - interval]) {
                    int temp = arr[inner];
                    arr[inner] = arr[inner - interval];
                    arr[inner - interval] = temp;
                    inner -= interval;
                }
            }
            interval = (interval - 1) / 3;
        }
    }

    public void reverseSort() {

        int outer, inner, temp;
        int interval = 1;

        while (interval <= size / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {

            for (outer = interval; outer < size; outer++) {

                inner = outer;

                while (inner >= interval && arr[inner] > arr[inner - interval]) {
                    temp = arr[inner];
                    arr[inner] = arr[inner - interval];
                    arr[inner - interval] = temp;
                    inner -= interval;
                }
            }
            interval = (interval - 1) / 3;
        }
    }

    public void printArray() {

        int increment = 0;
        int nRows = size / 10;

        for (int r = 0; r < nRows; r++) {

            increment += 10;

            for (int i = 0; i < 71; i++) {
                System.out.print("-");
            }

            System.out.println();

            for (int i = increment - 10; i < increment; i++) {
                System.out.format("| %3s  ", i);
            }

            System.out.println("|");

            for (int i = 0; i < 71; i++) {
                System.out.print("-");
            }

            System.out.println();

            for (int i = increment - 10; i < increment; i++) {
                System.out.format("| %3s  ", arr[i]);
            }

            System.out.println("|");

            for (int i = 0; i < 71; i++) {
                System.out.print("-");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        ShellSort arr1 = new ShellSort(20, 20, 800);
        arr1.printArray();
        arr1.sort();
        arr1.printArray();
        arr1.reverseSort();
        arr1.printArray();
    }
}
