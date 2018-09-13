package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public static void beautify(String beautifyThis, PoemDecorator poemDecorator){
        System.out.println(poemDecorator.decorate(beautifyThis));
    }
}
