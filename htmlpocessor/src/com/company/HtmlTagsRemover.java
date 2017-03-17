package com.company;

/**
 * Created by Velychko on 17.03.2017.
 */
public class HtmlTagsRemover {

    String removeHtmlTags(String content) {
        return content.replaceAll("\\<.*?>", "");
    }

}
