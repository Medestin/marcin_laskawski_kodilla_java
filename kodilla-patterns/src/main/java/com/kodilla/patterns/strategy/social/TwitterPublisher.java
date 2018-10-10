package com.kodilla.patterns.strategy.social;

public final class TwitterPublisher implements SocialPublisher {
    @Override
    public void share() {
        System.out.println(" shares something on Twitter.");
    }

    @Override
    public String getSocialMediaName() {
        return "Twitter";
    }
}
