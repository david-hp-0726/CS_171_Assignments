public class DutchNationalFlag {

    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;
    private int n;
    private int[] bucket;
    public int callColorNum = 0;
    public int callSwapNum = 0;

    public DutchNationalFlag(int[] arr) {
        n = arr.length;
        bucket = arr;
    }

    public void sort() {
        int lo = 0, current = 0, hi = n - 1;

        while (current <= hi) {
            int c = color(current);
            if (c == RED) {
                if (current != lo) {
                    swap(current, lo);
                }
                lo++;
                current++;
                continue;
            } else if (c == BLUE) {
                if (current != hi) {
                    swap(current, hi);
                }
                hi--;
                current++;
                continue;
            } else {
                current++;
            }
        }
    }

    private void swap(int i, int j) {
        callSwapNum++;
        int temp = bucket[i];
        bucket[i] = bucket[j];
        bucket[j] = temp;
    }

    private int color(int i) {
        callColorNum++;
        return bucket[i];
    }

    public void printBucket() {

        int increment = 0;
        int nRows = n / 10;
        int numElement;

        if (n % 10 != 0) {
            nRows++;
        }

        for (int r = 0; r < nRows; r++) {

            increment += 10;

            if (r == nRows - 1 && n % 10 != 0) {
                numElement = n % 10;
            } else {
                numElement = 10;
            }

            for (int i = 0; i < numElement * 6 + 1; i++) {
                System.out.print("-");
            }

            System.out.println();

            for (int i = increment - 10; i < increment - 10 + numElement; i++) {
                System.out.format("| %3s ", i);
            }

            System.out.println("|");

            for (int i = 0; i < numElement * 6 + 1; i++) {
                System.out.print("-");
            }

            System.out.println();

            for (int i = increment - 10; i < increment - 10 + numElement; i++) {
                System.out.format("| %3s ", bucket[i]);
            }

            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        int[] bucket = new int[16];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = (int) (Math.random() * 3);
        }
        DutchNationalFlag dnf = new DutchNationalFlag(bucket);
        dnf.printBucket();
        dnf.sort();
        System.out.println("The method color() has been called " + dnf.callColorNum + " times.");
        System.out.println("The method swap() has been called " + dnf.callSwapNum + " times.");
        dnf.printBucket();
    }
}
