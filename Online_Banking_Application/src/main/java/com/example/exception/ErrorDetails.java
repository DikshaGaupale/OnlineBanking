package com.example.exception;

import lombok.Data; 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private String message;
    private LocalDateTime timeStamp;
    private String uri;
    
    
    
}
