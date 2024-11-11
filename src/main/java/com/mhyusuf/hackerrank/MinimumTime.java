package com.mhyusuf.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumTime {
    public static int getMinimumTime(List<Integer> processSize, List<Integer> capacity) {
        // Create mutable lists from the input lists
        List<Integer> mutableProcessSize = new ArrayList<>(processSize);
        List<Integer> mutableCapacity = new ArrayList<>(capacity);

        // Sort process sizes in descending order to prioritize larger processes first.
        Collections.sort(mutableProcessSize, Collections.reverseOrder());

        // Sort capacities in descending order to use the most capable processors first.
        Collections.sort(mutableCapacity, Collections.reverseOrder());

        // Check if the largest process exceeds the capacity of the largest processor.
        if (mutableProcessSize.get(0) > mutableCapacity.get(0)) {
            return -1; // Return -1 if any process cannot be handled by any processor.
        }

        // PriorityQueue to track the next available time for each processor.
        PriorityQueue<Integer> availableProcessors = new PriorityQueue<>();
        for (int i = 0; i < mutableCapacity.size(); i++) {
            availableProcessors.add(0); // Initially, all processors are available at time 0.
        }

        // Iterate over each process and assign it to the most suitable processor.
        for (int process : mutableProcessSize) {
            // Find the earliest available processor.
            int earliestTime = availableProcessors.poll();

            // Assign this process to the earliest available processor, considering the capacity.
            availableProcessors.add(earliestTime + 2); // Processor will take 1 second to process + 1 second pause.
        }

        // Find the maximum time when all processes have finished.
        int maxTime = 0;
        while (!availableProcessors.isEmpty()) {
            maxTime = Math.max(maxTime, availableProcessors.poll());
        }

        return maxTime; // Return the total time after all processes are completed.
    }

    public static void main(String[] args) throws IOException {
        // Test case with a mix of process sizes and processor capacities.
        List<Integer> processSize = List.of(10, 5, 7, 3, 8);  // 5 processes
        List<Integer> capacity = List.of(6, 10, 8, 5, 7);    // 5 processors

        int result = getMinimumTime(processSize, capacity);
        System.out.println("Minimum time: " + result);  // Expected result: greater than 1, adjusted time.
    }
}
