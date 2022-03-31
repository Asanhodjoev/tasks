package com.example.tasks.exeption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniversalExeption extends RuntimeException{
    String title;

    public UniversalExeption(String message, String title) {
        super(message);
        this.title = title;
    }
}
