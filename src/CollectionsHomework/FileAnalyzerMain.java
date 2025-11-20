package CollectionsHomework;

import java.io.IOException;

public class FileAnalyzerMain {
    public static void main(String[] args) {
        String txtPath = "YOUR\\PATH";
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        try {
            fileAnalyzer.wordMap(txtPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        try {
            System.out.println(fileAnalyzer.totalWordCount(txtPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        try {
            System.out.println(fileAnalyzer.uniqueWordCount(txtPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        try {
            fileAnalyzer.topFrequentWords(txtPath, 5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        try {
            System.out.println(fileAnalyzer.countWordOccurrences(txtPath, "Lorem"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}