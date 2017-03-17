package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Velychko on 17.03.2017.
 */
public class UrlProcessorBroker {

    private String textForProcessing;

    private List<Function<String, String>> textProcessors = new ArrayList<>();

    public UrlProcessorBroker(String url) {
        this.textForProcessing = url;
    }

    public void addForProcessing(Function<String, String> function) {
        textProcessors.add(function);
    }

    public void processInOrder() {
        textProcessors.forEach(function -> textForProcessing = function.apply(textForProcessing));
    }


}
