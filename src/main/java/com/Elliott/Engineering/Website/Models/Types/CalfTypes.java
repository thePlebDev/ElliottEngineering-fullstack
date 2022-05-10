package com.Elliott.Engineering.Website.Models.Types;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CalfTypes {
    BULL ("BULL"),
    HEIFER ("HEIFER");

    private final String sex;
    private CalfTypes(String sex){
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

//    @JsonCreator
//    public static CalfTypes getCalfTypesFromCode(String value){
//        for (CalfTypes type: CalfTypes.values()){
//            if(type.getSex().equals(value)){
//                return type;
//            }
//        }
//        return null;
//    }
}
