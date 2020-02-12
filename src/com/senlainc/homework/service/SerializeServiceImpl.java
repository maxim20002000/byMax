package com.senlainc.homework.service;


import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeServiceImpl implements SerializeService {

    private final String path = "./serialized";
    private LoggerService logger;

    public SerializeServiceImpl() {

        logger = new LoggerServiceImpl();
    }

    @Override
    public void serialize(Object object, String fileName) {
        String fullPathToFile = path + "/" + fileName + ".data";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(fullPathToFile)))) {
            out.writeObject(object);
            out.reset();
        } catch (IOException e) {
            logger.error(this, String.format("File %s not found!", fullPathToFile));
        }
    }


    @Override
    public Object deserialize(Object object, String fileName) {
        String fullPathToFile = path + "/" + fileName + ".data";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(fullPathToFile)))) {
            object = in.readObject();
        } catch (EOFException e) {
            logger.debug(this, "File " + fullPathToFile + " is empty");
        } catch (IOException e) {
            logger.debug(this, "File " + fullPathToFile + " not found!");
        } catch (ClassNotFoundException e) {
            logger.error(this, "Cannot read object " + "ob" + object.getClass().getSimpleName() + " . Check type!");
        }
        return object;

    }
}
