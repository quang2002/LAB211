/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package Utilities;

/**
 *
 * @author yuyu
 * @param <E> type of the value need to check
 */
public interface ValidationChecker<E> {

    boolean checker(E value);
}
