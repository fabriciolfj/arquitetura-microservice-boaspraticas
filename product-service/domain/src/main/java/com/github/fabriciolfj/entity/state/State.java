package com.github.fabriciolfj.entity.state;

import com.github.fabriciolfj.entity.Product;

public abstract class State {

    public abstract void execute(final Product product);
}
