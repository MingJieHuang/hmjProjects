package com.phone.erp.boss.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 序列化反序列化抽象类[用于redis的数据存取]
 * @author hmj
 * @create 2018-11-22 11:31
 */
public  abstract class SerializeTranscoder {
    public abstract byte[] serialize(Object value);

    public abstract Object deserialize(byte[] in) throws IOException;

    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
