package com.example.dictionary;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class API {

    public static String APITranslate(String source_lang, String target_lang, String input) {
        // chuỗi trả về
        StringBuffer result = new StringBuffer();
        try {
            // ngôn ngữ gốc
            String sourceLang = source_lang;
            // ngôn ngữ đích
            String targetLang = target_lang;
            // đầu vào
            StringBuilder tmp = new StringBuilder(input);

            // %20 - cách, %2E - chấm, \n - %0A
            String sourceText = tmp.toString();

            sourceText = sourceText.replaceAll("\n", "%0A");
            sourceText = sourceText.replaceAll("\\s+", "%20");
            sourceText = sourceText.replaceAll( "[\\s.]", "%2E");

            URL url = new URL("https://translate.googleapis.com/translate_a/single?client=gtx&sl=" + sourceLang + "&tl=" + targetLang + "&dt=t&q=" + sourceText );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Kiểm tra kết nối ổn chưa
            int responseCode = conn.getResponseCode();

            // bằng 200 là đc
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);

            } else {

                StringBuffer informationString = new StringBuffer();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()){

                    informationString.append(scanner.nextLine());

                }
                //đóng scanner
                scanner.close();

                // lần lượt qua các JsonArray và chuỗi informationString -> rm(index) -> pm

                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                String rm = dataObject.get(0).toString();
                JSONArray dataObject1 = (JSONArray) parse.parse(String.valueOf(rm));


                int size = dataObject1.size();
                for(int i = 0; i < size; i++) {
                    String pm = dataObject1.get(i).toString();
                    JSONArray dataObject2 = (JSONArray) parse.parse(String.valueOf(pm));
                    result.append(dataObject2.get(0).toString());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

}