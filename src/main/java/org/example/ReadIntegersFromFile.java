package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadIntegersFromFile {

    public static void main(String[] args) {
        // Reading integers from the two files
        List<Integer> List1 = readIntegersFromFile("src/main/resources/input/input1.txt");
        List<Integer> List2 = readIntegersFromFile("src/main/resources/input/input2.txt");

        // Merging the lists
        List<Integer> mergedList = new ArrayList<>(List1);
        mergedList.addAll(List2);
        writeIntegersToFile(mergedList, "src/main/resources/output/merged.txt");

        // Finding and writing common integers to common.txt
        List<Integer> commonList = findCommonIntegers(List1, List2);
        writeIntegersToFile(commonList, "src/main/resources/output/common.txt");

        System.out.println("Merged content written to merged.txt successfully.");
        System.out.println("Common integers written to common.txt successfully.");
    }

    // Method to read integers from a file
    public static List<Integer> readIntegersFromFile(String fileName) {
        List<Integer> integers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                integers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from " + fileName + ": " + e.getMessage());
        }
        return integers;
    }

    // Method to write integers to a file
    public static void writeIntegersToFile(List<Integer> integers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int number : integers) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to " + fileName + ": " + e.getMessage());
        }
    }

    // Method to find common integers between two lists
    public static List<Integer> findCommonIntegers(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        List<Integer> commonIntegers = new ArrayList<>();
        for (Integer number : list2) {
            if (set1.contains(number)) {
                commonIntegers.add(number);
            }
        }
        return commonIntegers;
    }
}
