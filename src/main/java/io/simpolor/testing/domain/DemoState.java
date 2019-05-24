package io.simpolor.testing.domain;

public enum DemoState {
    INSERT,
    UPDATE,
    DELETE;

    public String getName(){
        return this.name();
    }

    public boolean isInsert(){
        return this == INSERT;
    }

    public boolean isUpdate(){
        return this == UPDATE;
    }

    public boolean isDelete(){
        return this == DELETE;
    }
}
