package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();
        Map<Integer, ForumUser> filteredUserMap = forum.getUserList().stream()
                .filter(n -> n.getSex() == 'M')
                .filter(n -> LocalDate.now().getYear() - n.getDateOfBirth().getYear() >= 20)
                .filter(n -> n.getPostCount() > 0)
                .collect(Collectors.toMap(ForumUser::getId, ForumUser -> ForumUser));

        filteredUserMap.entrySet().stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .forEach(System.out::println);

    }
}