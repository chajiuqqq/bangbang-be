package com.chajiu.bangbangbe.util;

import java.util.Date;

public class CreateDate extends Date {

    @Override
    public String toString() {
        return DateUtil.toCleanDate(this);
    }
}
