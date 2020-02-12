package com.senlainc.homework.service;

public interface SerializeService {

    void serialize(Object object, String fileName);

    Object deserialize(Object object, String fileName);


}
