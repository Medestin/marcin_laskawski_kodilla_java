package com.kodilla.patterns.strategy.social;

public final class FacebookPublisher implements SocialPublisher {
    @Override
    public void share() {
        System.out.println(" shares something on Facebook.");
    }

    @Override
    public String getSocialMediaName() {
        return "Facebook";
    }
}
