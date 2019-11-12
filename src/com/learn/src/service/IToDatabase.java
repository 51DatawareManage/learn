package com.learn.src.service;

public interface IToDatabase<T> {
    public boolean saveToDatabase(T object);
}
