package com.withlee.dbm.enums;

/**
 * Created by zilongye on 15/9/5.
 */
public enum ScoreType {

    EVENT(0);

    private int code;

    private ScoreType(int code){
        this.code = code;
    }
    public int value(){
        return this.code;
    }
}
