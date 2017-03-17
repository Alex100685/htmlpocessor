package com.company;

/**
 * Created by Velychko on 17.03.2017.
 */
public class ForbiddenHtmlContentRemover {

    String removeForbiddenContent(String content) {
        return content.replaceAll(buildRegex(), content);
    }

    private String buildRegex() {
        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("<(");
        TagsWithContentToIgnore[] tagsToIgnore = TagsWithContentToIgnore.values();
        StringBuilder tagSequenceBuilder = new StringBuilder();
        for (int i = 0; i < tagsToIgnore.length; i++) {
            String partToAppend = i < tagsToIgnore.length - 1 ? tagsToIgnore[i].getTagName() + "|" : tagsToIgnore[i].getTagName();
            tagSequenceBuilder.append(partToAppend);
        }
        String tagSequence = tagSequenceBuilder.toString();
        regexBuilder.append(tagSequence)
                .append(")>(.+?)</(")
                .append(tagSequence)
                .append(")>");

        return regexBuilder.toString();


    }

    private enum TagsWithContentToIgnore {
        STYLE("style"),
        SCRIPT("script"),
        IMAGE("image"),
        OBJECT("object");


        private final String tagName;

        TagsWithContentToIgnore(String tagName) {
            this.tagName = tagName;
        }

        public String getTagName() {
            return tagName;
        }
    }

}
