package CollectionsHomework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        String[] words = getWords(path);

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    public int totalWordCount(String path) throws IOException {
        String[] words = getWords(path);
        return words.length;
    }

    public int uniqueWordCount(String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        String[] words = getWords(path);

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        return count;
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        String[] words = getWords(path);

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        //remove words occuring once
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getValue() == 1) {
                list.remove(i);
            }
        }
        Map<String, Integer> topMap = new HashMap<>();
        int acceptableN = Math.min(n, list.size());

            for (int i = 0; i < acceptableN; i++) {
                topMap.put(list.get(i).getKey(), list.get(i).getValue());
            }

        return topMap;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        String[] words = getWords(path);

        for (String w : words) {
            map.put(w, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(word)) {
                return entry.getValue();
            }
        }
        return 0;
    }

    //helper method
    public String[] getWords(String path) throws IOException {
        String text = Files.readString(Path.of(path));
        return text.split(" ");
    }
}