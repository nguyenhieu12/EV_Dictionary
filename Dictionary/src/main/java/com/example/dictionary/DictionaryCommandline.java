package com.example.dictionary;

import java.io.IOException;

public class DictionaryCommandline extends DictionaryManagement {
    // in ra tất cả từ trong list từ
    public static void showAllWords() {
        System.out.format("%-15s %-15s %-15s\n", "No", "| English", "| Vietnamese");
        int pos = 1;
        for(int i = 0; i < dictionary.getWords().size(); i++) {
            System.out.format("%-15s %-15s %-15s\n",
                    pos, "| " + dictionary.getWords().get(i).getWordTarget(),
                    "| " + dictionary.getWords().get(i).getWordExplain());
            pos++;
        }
    }

    // gọi đến các hàm chức năng
    public static void dictionaryBasic(int choice) {
        if(choice == 1) {
            insertFromCommandline();
        } else if(choice == 2) {
            showAllWords();
        }
    }

    public static void dictionaryAdvanced(int choice) {
        if(choice == 2) {
            showAllWords();
        } else if(choice == 3) {
            dictionaryLookup();
        }
    }

    public static void main(String[] args) throws IOException {
        insertFromFile();
        int choice;
        System.out.println("=============== Dictionary ===============");
        while(true) {
            System.out.println("Enter your choice:");
            System.out.println("1.Insert word");
            System.out.println("2.Show all words");
            System.out.println("3.Search word");
            System.out.println("4.Dictionary searcher");
            System.out.println("5.Delete word");
            System.out.println("6.Edit word");
            System.out.println("7.Write all words to file");
            System.out.println("8.Exit");
            choice = scanner.nextInt();
            if(choice == 8)
                break;
            switch (choice) {
                case 1:
                    dictionaryBasic(choice);
                    break;
                case 2:
                case 3:
                    dictionaryAdvanced(choice);
                    break;
                case 4:
                    dictionarySearcher();
                    break;
                case 5:
                    dictionaryDelete();
                    break;
                case 6:
                    dictionaryEdit();
                    break;
                case 7:
                    dictionaryExportToFile();
                default:
                    break;
            }
        }
    }
}
