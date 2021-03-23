package com.shilei.dp.bridge;

public abstract class Gift {
    protected GiftImpl impl;

    public Gift(GiftImpl impl) {
        this.impl = impl;
    }
}
