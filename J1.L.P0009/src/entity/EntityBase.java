/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package entity;

import model.ModelBase;

/**
 *
 * @author yuyu
 */
public class EntityBase {

    private ModelBase model;

    public void eject() {
        this.model = null;
    }

    public void inject(ModelBase model) {
        this.model = model;
    }

    public boolean isInjected() {
        return model != null;
    }

    public ModelBase getModel() {
        return model;
    }
}
