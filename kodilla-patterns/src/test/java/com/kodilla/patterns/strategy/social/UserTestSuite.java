package com.kodilla.patterns.strategy.social;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTestSuite {

    @Test
    public void testPredefinedSocialMedia(){
        User facebookUser = new Millenials("Marcin");
        User snapchatUser = new YGeneration("Radek");
        User twitterUser = new ZGeneration("Mikołaj");

        facebookUser.sharePost();
        snapchatUser.sharePost();
        twitterUser.sharePost();

        assertEquals("Facebook", facebookUser.getSocialPublisher().getSocialMediaName());
        assertEquals("Snapchat", snapchatUser.getSocialPublisher().getSocialMediaName());
        assertEquals("Twitter", twitterUser.getSocialPublisher().getSocialMediaName());
    }

    @Test
    public void testSetSocialPublisher(){
        User indecisiveUser = new Millenials("John Doe");
        indecisiveUser.setSocialPublisher(new TwitterPublisher());

        indecisiveUser.sharePost();
        assertEquals("Twitter", indecisiveUser.getSocialPublisher().getSocialMediaName());
    }
}
