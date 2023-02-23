package com.jb.test;

import com.jb.utils.SMSUtils;

public class SMSTest {
    public static void main(String[] args) throws Exception{
        SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,"17612003512","1234");
    }
}
