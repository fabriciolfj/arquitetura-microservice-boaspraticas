package com.github.fabriciolfj.entity.state;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.Status;

public class StateInactive extends State {

    @Override
    public void execute(Product product) {
        product.setStatus(Status.INACTIVE.getCode());
    }
}
