package com.tedu.cn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp implements Serializable {
    private String name;
    private char gender;
    private int age;
    private double money;

}

