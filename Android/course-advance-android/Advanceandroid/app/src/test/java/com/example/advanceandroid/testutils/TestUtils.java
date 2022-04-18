package com.example.advanceandroid.testutils;

import com.example.advanceandroid.model.AdapterFactory;
import com.example.advanceandroid.model.ZonedDateTimeAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class TestUtils {
    private static TestUtils INSTANCE = new TestUtils();

    private static final Moshi TEST_MOSHI = initializeMoshi();

    private TestUtils() {

    }

    public static <T> T loadJson(String path, Type type) {
        try {
            String json = getFileString(path);
            //
            return (T) TEST_MOSHI.adapter(type).fromJson(json);
        } catch (IOException exception) {
            throw new IllegalArgumentException("Could no deserialize: " + path + "into type: " + type);
        }
    }

    private static String getFileString(String path) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    INSTANCE.getClass().getClassLoader().getResourceAsStream(path)));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Could no read form resource at: " + path);
        }
    }


    private static Moshi initializeMoshi() {
        return new Moshi.Builder()
                .add(AdapterFactory.create())
                .add(new ZonedDateTimeAdapter())
                .build();
    }
}
