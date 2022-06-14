package com.github.fabriciolfj.springconfig;

import java.util.ResourceBundle;

public enum EnumErrors {

    ERROR_01;

    public String getMessage() {
        var bundle = ResourceBundle.getBundle("exceptions");
        return bundle.getString(this.name() + ".message");
    }
}
