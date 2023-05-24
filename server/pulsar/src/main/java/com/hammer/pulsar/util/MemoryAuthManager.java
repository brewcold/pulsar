package com.hammer.pulsar.util;

public class MemoryAuthManager {

    private static int loginMember;

    private MemoryAuthManager() {};

    public static void setLoginMember(int memberId) {
        loginMember = memberId;
    }

    public static int getLoginMember() {
        return loginMember;
    }

    public static void removeLoginMember() {
        loginMember = 0;
    }

}
