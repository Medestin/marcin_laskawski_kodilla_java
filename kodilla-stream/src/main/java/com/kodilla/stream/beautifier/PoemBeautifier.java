package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public static String beautify(String beautifyThis, Decorator decorator){
        return decorator.decorate(beautifyThis);
    }
}
