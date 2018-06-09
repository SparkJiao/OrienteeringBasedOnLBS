package com.sdu.kkkkk.entity;

import java.io.Serializable;

/**
 * Created by kkkkk on 2018/5/7.
 */
public class FriendKey implements Serializable {
    private static final long serialVersionUID = 6811601262303871530L;

    public void setSid_1(String sid_1) {
        this.sid_1 = sid_1;
    }

    public void setSid_2(String sid_2) {
        this.sid_2 = sid_2;
    }

    public FriendKey(String sid_1, String sid_2) {
        this.sid_1 = sid_1;
        this.sid_2 = sid_2;
    }

    private String sid_1;

    public String getSid_1() {
        return sid_1;
    }

    public String getSid_2() {
        return sid_2;
    }

    private String sid_2;

    public FriendKey(){}



    /**
     * 覆盖hashCode方法，必须要有
     */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (sid_1 == null ? 0 : sid_1.hashCode());
        result = PRIME * result + (sid_2 == null ? 0 : sid_2.hashCode());
        return result;
    }

    /**
     * 覆盖equals方法，必须要有
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof FriendKey)) return false;
        FriendKey objKey = (FriendKey) obj;
        if ((sid_1.equalsIgnoreCase(objKey.sid_1) &&
                sid_2.equalsIgnoreCase(objKey.sid_2))||(sid_1.equalsIgnoreCase(((FriendKey) obj).sid_2)&&sid_2.equalsIgnoreCase(((FriendKey) obj).sid_1))){
            return true;
        }
        return false;
    }

}
