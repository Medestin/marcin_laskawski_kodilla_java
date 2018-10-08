package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    private final TaskList toDo;
    private final TaskList inProgress;
    private final TaskList done;

    public BoardConfig(){
        this.toDo = new TaskList();
        this.inProgress = new TaskList();
        this.done = new TaskList();
    }

    @Bean
    public Board getBoard(){
        return new Board(toDo, inProgress, done);
    }
}
