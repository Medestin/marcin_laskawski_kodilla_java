package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum(){
        userList.add(new ForumUser("Medestin", 1, 'M', LocalDate.of(1992, 8, 26), 123));
        userList.add(new ForumUser("Koe", 2, 'F', LocalDate.of(1982, 5, 12), 654));
        userList.add(new ForumUser("Hassi", 3, 'M', LocalDate.of(2005, 2, 6), 456));
        userList.add(new ForumUser("Lena", 4, 'F', LocalDate.of(1989, 11, 30), 164));
        userList.add(new ForumUser("Myrtana", 5, 'F', LocalDate.of(2000, 1, 22), 3000));
        userList.add(new ForumUser("JakasLaska", 6, 'F', LocalDate.of(1993, 7, 1), 18));
        userList.add(new ForumUser("JakisKoles", 7, 'M', LocalDate.of(1990, 5, 18), 15));
        userList.add(new ForumUser("Z3000", 8, 'M', LocalDate.of(1939, 4, 23), 0));
        userList.add(new ForumUser("Kenny", 9, 'M', LocalDate.of(1945, 12, 20), 189));
        userList.add(new ForumUser("MałgorzataMistrza", 10, 'F', LocalDate.of(1977, 9, 3), 456));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(userList);
    }
}
