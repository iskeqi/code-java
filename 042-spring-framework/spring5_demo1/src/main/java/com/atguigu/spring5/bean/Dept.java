package com.atguigu.spring5.bean;

import java.util.List;

public class Dept {

    private String name;

    private List<Emp> empList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", empList=" + empList +
                '}';
    }
}
