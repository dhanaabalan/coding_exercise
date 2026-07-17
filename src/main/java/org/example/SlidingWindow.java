package org.example;

public class SlidingWindow {

    public int maxTransactionsInWindow(long[] timestamps, long w) {
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < timestamps.length; right++) {
            // shrink window from the left while it's invalid
            while (timestamps[right] - timestamps[left] > w) {
                left++;
            }
            // window [left, right] is valid; track its size
            int windowSize = right - left + 1;
            if (windowSize > maxCount) {
                maxCount = windowSize;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        SlidingWindow sl = new SlidingWindow();
        long[] a = {1, 3, 5, 6, 8, 10, 12};
        System.out.println(sl.maxTransactionsInWindow(a, 4)); // expected 3
    }
}