package CollectionsHomework;

import java.io.IOException;

public class FileAnalyzerMain {
    public static void main(String[] args) {
        String txtPath = "C:\\Users\\lenovo\\Desktop\\JavaCoreHomeworks\\src\\CollectionsHomework\\simpleText.txt";
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        try {
            System.out.println(fileAnalyzer.wordMap(txtPath));
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
            System.out.println(fileAnalyzer.topFrequentWords(txtPath, 5));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        try {
            System.out.println(fileAnalyzer.countWordOccurrences(txtPath, "tempor"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}