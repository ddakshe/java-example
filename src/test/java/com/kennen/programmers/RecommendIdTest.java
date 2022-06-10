package com.kennen.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecommendIdTest {
    @Test
    void test() {
//        String newId = "...!@BaT#*..y.abcdefghij k l m.";
        String newId = "abcdefghijklmn.p";
        List<Step> steps = new ArrayList<>();

        steps.add(new Step(Pattern.compile("[A-Z]"),matcher -> matcher.group().toLowerCase()));
        steps.add(new Step(Pattern.compile("[^\\da-z-_.\\s]"), matcher -> ""));
        steps.add(new Step(Pattern.compile("[.]+"), matcher -> "."));
        steps.add(new Step(Pattern.compile("^[.]"), matcher -> ""));
        steps.add(new Step(Pattern.compile("\\s"), matcher -> "a"));
        steps.add(new Step(Pattern.compile("[.]$"), matcher -> ""));

        StringBuilder builder = new StringBuilder(newId);

        for (Step step : steps) builder = regex(builder, step);

        if (builder.toString().isBlank()) builder.append("a");

        if (builder.length() > 15) builder.delete(15, builder.length());

        if (Pattern.compile("[.]$").matcher(builder).find()) builder.deleteCharAt(builder.length()-1);

        while(builder.toString().length() < 3){
            builder.append(builder.charAt(builder.length() -1));
        }

        Assertions.assertEquals("abcdefghijklmn", builder.toString());
    }

    private StringBuilder regex(StringBuilder builder, Step step) {
        StringBuilder newBuilder = new StringBuilder();
        Matcher matcher = step.getPattern().matcher(builder.toString());

        while (matcher.find()) {
            System.out.println("matcher.group() = " + matcher.group());
            matcher.appendReplacement(newBuilder, step.getSupplier().apply(matcher));
        }
        if (step.isAppendTailYn()) {
            matcher.appendTail(newBuilder);
        }
        System.out.println("newBuilder.toString() = " + newBuilder.toString());
        builder = new StringBuilder(newBuilder.toString());
        return builder;
    }

    static class Step{
        private Pattern pattern;
        private Function<Matcher, String> supplier;
        private boolean appendTailYn;

        public Step(Pattern pattern, Function<Matcher, String> supplier) {
            this.pattern = pattern;
            this.supplier = supplier;
            this.appendTailYn = true;
        }

        public Step(Pattern pattern, Function<Matcher, String> supplier, boolean appendTailYn) {
            this.pattern = pattern;
            this.supplier = supplier;
            this.appendTailYn = appendTailYn;
        }

        public Pattern getPattern() {
            return pattern;
        }

        public Function<Matcher, String> getSupplier() {
            return supplier;
        }

        public boolean isAppendTailYn() {
            return appendTailYn;
        }
    }

}
