package com.company.heaps;

import java.util.*;

public class RunningMedian {
    /*
     * Complete the runningMedian function below.
     */

    static double add(PriorityQueue<Integer> min, PriorityQueue<Integer> max, int i) {

        if (max.isEmpty() || i < max.peek()) {
            max.add(i);

        } else {
            min.add(i);
        }

        PriorityQueue<Integer> bigHeap = max.size() > min.size() ? max : min;
        PriorityQueue<Integer> smallHeap = max.size() <= min.size() ? max : min;

        if (bigHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(bigHeap.poll());
        }


        return smallHeap.size() == bigHeap.size() ? (((double) smallHeap.peek()) + bigHeap.peek()) / 2 : bigHeap.peek();
    }

    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        double[] medians = new double[a.length];

        for (int i=0; i < a.length; i++) {
            double median = add(minHeap, maxHeap, a[i]);
            medians[i] = median;
        }

        return medians;

    }

    public static void main(String[] args) {
        double[] result = runningMedian(new int[]{1,2,3,4,5,6,7,8,9,10});
        for (int i=0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
