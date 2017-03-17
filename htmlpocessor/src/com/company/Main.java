package com.company;

import java.io.IOException;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new RuntimeException("No URL arg passed!");
        }

        UrlProcessorBroker urlProcessorBroker = new UrlProcessorBroker(args[0]);
        Function<String, String> checkUrl = url -> new UrlValidator().validateUrl(url);
        Function<String, String> readHtml = url -> new HtmlReader().readHtml(url);
        Function<String, String> removeForbiddenTags = content -> new ForbiddenHtmlContentRemover().removeForbiddenContent(content);
        Function<String, String> removeHtmlTags = content -> new HtmlTagsRemover().removeHtmlTags(content);
        Function<String, String> doReport = content -> new Reporter().report(content);
        urlProcessorBroker.addForProcessing(checkUrl);
        urlProcessorBroker.addForProcessing(readHtml);
        urlProcessorBroker.addForProcessing(removeForbiddenTags);
        urlProcessorBroker.addForProcessing(removeHtmlTags);
        urlProcessorBroker.addForProcessing(doReport);
        urlProcessorBroker.processInOrder();
    }
}
