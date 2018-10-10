package com.kodilla.patterns.strategy.social;

public final class SnapchatPublisher implements SocialPublisher{
    @Override
    public void share() {
        System.out.println(" shares something on Snapchat.");
    }

    @Override
    public String getSocialMediaName() {
        return "Snapchat";
    }
}
