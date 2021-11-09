package com.example.dictionary;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class MyJDBC extends DictionaryManagement {
    // lấy dữ liệu từ cơ sở dữ liệu
    public static void readSQL() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dictionary",
                "root", "hieu6969" );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from tbl_edict");

        while(resultSet.next()){
            String new_word = resultSet.getString("word");
            String detail = resultSet.getString("detail");
            Word word1 = new Word(new_word, detail);
            newDictionary.pushWord(word1);
        }
        // lấy từ file txt
        String[] strings;
        String path = "./database/word.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                strings = line.split(":");
                if(strings.length >= 2) {
                    Word word = new Word(strings[0], strings[1]);
                    newDictionary.pushWord(word);
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

}