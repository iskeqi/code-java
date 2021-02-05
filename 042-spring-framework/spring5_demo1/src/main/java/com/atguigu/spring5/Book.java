package com.atguigu.spring5;

public class Book {

    private String bname;

    private String bauthor;

    private String address;

    private String saa;

    public String getBauthor() {
        return bauthor;
    }

    public String getSaa() {
        return saa;
    }

    public void setSaa(String saa) {
        this.saa = saa;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBname() {
        return bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    // set 方法注入属性
    public void setBname(String bname) {
        this.bname = bname;
    }

    public Book() {
    }

    // 有参构造函数注入
    public Book(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }
}
