package com.master.test.helper;

import java.util.Set;

public interface MockUpHelper {

    <T> Set<T> mockUp(Class<T> clas, int count);

}