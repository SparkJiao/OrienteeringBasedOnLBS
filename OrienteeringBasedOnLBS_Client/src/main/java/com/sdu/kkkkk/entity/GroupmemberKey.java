package com.sdu.kkkkk.entity;

import java.io.Serializable;

/**
 * Created by kkkkk on 2018/6/4.
 */
public class GroupmemberKey implements Serializable {
    //private static final long serialVersionUID = 6811601262303871530L;
    private static final long serialVersionUID = 6811601262303871532L;

    private int gid;
    private String sid;

    public GroupmemberKey(int gid, String sid) {
        this.gid = gid;
        this.sid = sid;
    }

    public GroupmemberKey() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * 覆盖hashCode方法，必须要有
     */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (new Integer(gid)).hashCode();
        result = PRIME * result + (sid == null ? 0 : sid.hashCode());
        return result;
    }

    /**
     * 覆盖equals方法，必须要有
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof GroupmemberKey)) return false;
        GroupmemberKey objKey = (GroupmemberKey) obj;
        if (objKey.sid.equals(this.sid) && objKey.gid == this.gid) {
            return true;
        }
        return false;
    }
}
