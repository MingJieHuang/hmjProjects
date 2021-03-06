package com.phone.erp.boss.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 集合序列化,反序列化类
 * @author hmj
 * @create 2018-11-22 11:42
 */
public class ListTranscoder<M extends Serializable> extends SerializeTranscoder {

    @SuppressWarnings("unchecked")
    public List<M> deserialize(byte[] in) throws IOException {
        List<M> list = new ArrayList<M>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    M m = (M)is.readObject();
                    if (m == null) {
                        break;
                    }
                    list.add(m);
                }
                is.close();
                bis.close();
            }
        } catch (Exception e) {
            //  e.printStackTrace();
        }  finally {
            is.close();
            bis.close();
        }
        return  list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public byte[] serialize(Object value) {
        if (value == null)
            throw new NullPointerException("Can't serialize null");

        List<M> values = (List<M>) value;
        byte[] results = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;

        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (M m : values) {
                os.writeObject(m);
            }
            results = bos.toByteArray();
            os.close();
            bos.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            close(os);
            close(bos);
        }
        return results;
    }
}
