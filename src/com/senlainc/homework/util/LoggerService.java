package com.senlainc.homework.util;

public interface LoggerService {

    void info(Object obj, String message);

    void error(Object obj, String message);

    void warning(Object obj, String message);

    void debug(Object obj, String message);

}
