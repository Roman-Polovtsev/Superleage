package com.company.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Serializer {
    public Serializer() {
    }
    transient public static Logger logger = LoggerFactory.getLogger(Serializer.class);
    public byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        logger.trace("serialized {}",obj);
        return out.toByteArray();
    }

    public Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        logger.trace("deserialized {}",data);
        return is.readObject();
    }
}
