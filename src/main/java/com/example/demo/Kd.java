package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Kd {
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ftime;
    private String context;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date time;

}
