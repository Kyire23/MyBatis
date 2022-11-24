package com.oumuanode.mybatis.pojo;

public class Student {
    private Long sid;
    private String sname;
    private Clazz clazz;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student(Long sid, String sname, Clazz clazz) {
        this.sid = sid;
        this.sname = sname;
        this.clazz = clazz;
    }
}
