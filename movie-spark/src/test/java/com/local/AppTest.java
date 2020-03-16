package com.local;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael Chu
 * @since 2020-03-14 17:22
 */
public class AppTest {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        List<Object> objects = Collections.unmodifiableList(list);
    }

}
