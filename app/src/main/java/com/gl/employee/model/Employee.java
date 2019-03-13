package com.gl.employee.model;

public class Employee {

    private String name;
    private String designation;
    private int resourceId;

    public Employee() {}

    public Employee(String name, String designation, int resourceId) {
        this.name = name;
        this.designation = designation;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
