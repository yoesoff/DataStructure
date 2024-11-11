package com.mhyusuf.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            int earliestTime = availableProcessors.poll();
            availableProcessors.add(earliestTime + 2); // Processor available again after current time + 2 seconds.
        }

        // Find the maximum time when all processes have finished.
        int maxTime = 0;
        while (!availableProcessors.isEmpty()) {
            maxTime = Math.max(maxTime, availableProcessors.poll());
        }

        return maxTime - 1; // Adjust to exclude the extra pause after the last process.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String outputPath = System.getenv("OUTPUT_PATH");
        if (outputPath == null) {
            outputPath = "output.txt"; // Default file path
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

        int processSizeCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> processSize = IntStream.range(0, processSizeCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int capacityCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> capacity = IntStream.range(0, capacityCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = MinimumTime.getMinimumTime(processSize, capacity);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}