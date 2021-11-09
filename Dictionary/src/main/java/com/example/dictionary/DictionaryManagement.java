package com.example.dictionary;

import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    protected static final Scanner scanner = new Scanner(System.in);
    protected static Dictionary dictionary = new Dictionary();
    protected static Dictionary newDictionary = new Dictionary();

    // chèn 1 từ vào từ điển
    public static void insertFromCommandline() {
        System.out.print("Enter the number of words you want to add: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;i < number;i++) {
            System.out.print("Enter English word: ");
            String word_target = scanner.nextLine();
            System.out.print("Enter Vietnamese word: ");
            String word_explain = scanner.nextLine();
            Word word = new Word(word_target, word_explain);
            dictionary.pushWord(word);
            System.out.println("Add successfully!");
        }
    }

    // dịch nghĩa từ được nhập
    public static void dictionaryLookup() {
        scanner.nextLine();
        System.out.print("Enter the word you want to look up: ");
        String wordSearch = scanner.nextLine();
        for(Word listWord : dictionary.getWords()) {
            if(wordSearch.equals(listWord.getWordTarget())) {
                System.out.println("-> Explain: " + listWord.getWordExplain());
                break;
            }
        }
    }

    // in ra các từ có các kí tự được nhập
    public static void dictionarySearcher() {
        scanner.nextLine();
        System.out.print("Enter keyword: ");
        String wordSearch = scanner.nextLine();
        for(Word listWord : dictionary.getWords()) {
            if(listWord.getWordTarget().contains(wordSearch)) {
                System.out.println(listWord.getWordTarget());
            }
        }
    }

    // xóa 1 từ trong list từ
    public static void dictionaryDelete() {
        scanner.nextLine();
        System.out.print("Enter the English word you want to delete: ");
        String deleteWord = scanner.nextLine();
        for(int i = 0;i < dictionary.getWords().size();i++) {
            if(dictionary.getWords().get(i).getWordTarget().equals(deleteWord)) {
                dictionary.getWords().remove(i);
                break;
            }
        }
    }

    // sửa 1 từ
    public static void dictionaryEdit() {
        scanner.nextLine();
        System.out.print("Enter the English word you want to edit: ");
        String editWord = scanner.nextLine();
        System.out.print("Enter the new English word: ");
        String newWordTarget = scanner.nextLine();
        System.out.print("Enter the new Vietnamese word: ");
        String newWordExplain = scanner.nextLine();
        for(int i = 0;i < dictionary.getWords().size();i++) {
            if(dictionary.getWords().get(i).getWordTarget().equals(editWord)) {
                dictionary.getWords().get(i).setWordTarget(newWordTarget);
                dictionary.getWords().get(i).setWordExplain(newWordExplain);
                break;
            }
        }
    }

    // lấy dữ liệu từ file
    public static void insertFromFile() {
        String[] strings;
        String path = "D:/dictionaries.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                strings = line.split("/");
                if(strings.length >= 2) {
                    Word word = new Word(strings[0], strings[1]);
                    dictionary.pushWord(word);
                }
            }
            br.close();
            fr.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Unable to the file: '" + path + "'");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // in danh sách từ có trong list từ ra file
    public static void dictionaryExportToFile() throws IOException {
        String filePath = "D:/data_dictionaries.txt";
        String data;
        File file = new File(filePath);
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        for(int i = 0;i < dictionary.getWords().size();i++) {
            data = dictionary.getWords().get(i).getWordTarget() + " "
                    + dictionary.getWords().get(i).getWordExplain() + "\n";
            outputStreamWriter.write(data);
        }
        outputStreamWriter.flush();
    }

    public static Dictionary getDictionary() {
        return dictionary;
    }

}
