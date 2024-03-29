package me.gameisntover.kirbyql.object;

import java.util.Map;

public class DBObject<T> implements Map.Entry<String,T> {
    public T value;
    public String name;
    public String type;
    public boolean primaryKey;

    public boolean doNotUpdate;

    protected DBObject(String name, T obj, boolean pk, boolean doNotUpdate) {
        this.name = name;
        this.value = obj;
        this.primaryKey = pk;
        this.doNotUpdate = doNotUpdate;
    }

    protected DBObject(String name, String type, T obj, boolean pk, boolean doNotUpdate) {
        this.name = name;
        this.type = type;
        this.value = obj;
        this.primaryKey = pk;
        this.doNotUpdate = doNotUpdate;
    }

    public static <T> DBObject<T> of(String name, T value) {
        return of(name, value, false);
    }

    public static <T> DBObject<T> of(String name, T value, boolean primaryKey) {
        return of(name, value, primaryKey, false);
    }

    public static <T> DBObject<T> of(DBObject<String> obj, T value) {
        return new DBObject<>(obj.name, value, obj.primaryKey, obj.doNotUpdate);
    }

    public static <T> DBObject<T> of(String name, T value, boolean primaryKey, boolean doNotUpdate) {
        return new DBObject<>(name, value, primaryKey, doNotUpdate);
    }

    public DBObject<?> clone(java.io.Serializable value) {
        return of((DBObject<String>) this, value);
    }


    @Override
    public String getKey() {
        return name;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public T setValue(T value) {
        this.value = value;
        return value;
    }
}
