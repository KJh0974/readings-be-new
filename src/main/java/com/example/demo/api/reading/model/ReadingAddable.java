package com.example.demo.api.reading.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReadingAddable {

    private Long value;
    private Long meterId;
    private Long periodId;
}
