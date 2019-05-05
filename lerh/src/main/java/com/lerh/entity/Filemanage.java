package com.lerh.entity;

import java.io.Serializable;
import java.util.Date;

public class Filemanage implements Serializable {
    private String id;

    private String name;

    private String savaname;

    private Date createtime;

    private String createuserid;

    private String createusername;

    private String fileroute;

    private String uploadip;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSavaname() {
        return savaname;
    }

    public void setSavaname(String savaname) {
        this.savaname = savaname == null ? null : savaname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid == null ? null : createuserid.trim();
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername == null ? null : createusername.trim();
    }

    public String getFileroute() {
        return fileroute;
    }

    public void setFileroute(String fileroute) {
        this.fileroute = fileroute == null ? null : fileroute.trim();
    }

    public String getUploadip() {
        return uploadip;
    }

    public void setUploadip(String uploadip) {
        this.uploadip = uploadip == null ? null : uploadip.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", savaname=").append(savaname);
        sb.append(", createtime=").append(createtime);
        sb.append(", createuserid=").append(createuserid);
        sb.append(", createusername=").append(createusername);
        sb.append(", fileroute=").append(fileroute);
        sb.append(", uploadip=").append(uploadip);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}