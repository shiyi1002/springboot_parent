package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo implements Serializable{
    private int id;
    private String name;
    private int age;
    private int classesId;
    private String cname;
}
