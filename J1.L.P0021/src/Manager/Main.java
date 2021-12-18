package Manager;

import Utilities.Validation;

/**
 *
 * @author yuyu
 */
public class Main {

    public static void main(String[] args) {
        Validation vld = new Validation();
        
        System.out.println(vld.getInteger("hello", Integer.MIN_VALUE, Integer.MAX_VALUE, true));
    }
}
