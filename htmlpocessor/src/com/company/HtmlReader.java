package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Velychko on 17.03.2017.
 */
class HtmlReader {

    String readHtml(String textUrl) {
        URL url;
        URLConnection conn;
        BufferedReader br = null;
        StringBuilder sb;
        try {
            try {
                url = new URL(textUrl);
                conn = url.openConnection();
                if (conn.getContentType().equals("text/html")) {
                    throw new RuntimeException("Content of " + textUrl + " URL is not HTML!");
                }
                ;
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String str;
                sb = new StringBuilder();
                while ((str = br.readLine()) != null) {
                    sb.append(str).append("\n");
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read content from url " + textUrl);
        }
        return sb.toString();
    }

}
