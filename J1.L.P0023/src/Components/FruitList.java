/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package Components;

import java.util.ArrayList;

/**
 *
 * @author yuyu
 */
public class FruitList extends ArrayList<Fruit> {

    public FruitList() {
    }

    /**
     * Find a fruit in list by it's id
     *
     * @param id id of fruit that need to find
     * @return if can found that fruit then return instance of that fruit,
     * otherwise return null
     */
    public Fruit find(int id) {
        for (Fruit fruit : this) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * check if a fruit is existing or not
     *
     * @param id if of food that need to check
     * @return if fruit is existing then return {@code true}, otherwise return
     * {@code false}
     */
    public boolean exist(int id) {
        return find(id) != null;
    }

    public void clean() {
        for (int i = 0; i < this.size(); i++) {
            Fruit fruit = get(i);
            if (fruit.getQuantity() <= 0) {
                this.remove(i);
                i--;
            }
        }
    }
}
