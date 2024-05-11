package com.easybytes.easyschool.model;

import com.sun.jdi.PrimitiveValue;
import lombok.*;

@Data
public class Holiday extends BaseEntity{

    private final String day;
    private  final  String reason;
    private final Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }
}

