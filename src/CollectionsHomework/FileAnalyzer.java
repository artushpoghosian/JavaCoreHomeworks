package CollectionsHomework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        return null;
    }

    public int totalWordCount(String path) throws IOException {
        List<String> words = new LinkedList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }
            return words.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int uniqueWordCount(String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
            int count = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    count++;
                }
            }
            return count;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<>() {
                @Override
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                    return b.getValue().compareTo(a.getValue());
                }
            });
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).getValue() == 1) {
                    list.remove(i);
                }
            }
            for (int i = 1; i <= n; i++) {
                System.out.println(i + ". \"" + list.get(i - 1).getKey() + "\" reapeating " + list.get(i - 1).getValue() + " time(s).");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There are less than " + n + " Top Frequent Words in the file." +
                    " (Words repeating once in the file are omitted)");
        }
        return null;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String w : words) {
                    map.put(w, map.getOrDefault(w, 0) + 1);
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<>() {
                @Override
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                    return b.getValue().compareTo(a.getValue());
                }
            });
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(word)) {
                    return entry.getValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}