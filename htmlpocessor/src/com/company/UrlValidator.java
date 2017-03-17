package com.company;

/**
 * Created by Velychko on 17.03.2017.
 */
public class UrlValidator {

    private static final String CORRECT_URL_START = "http://";

    public String validateUrl(String url) {
        if (!url.startsWith(CORRECT_URL_START)) {
            throw new RuntimeException("Not correct URL arg passed!");
        }
        return url;
    }

}
