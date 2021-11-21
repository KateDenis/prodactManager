package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String company;

    public Smartphone(int id, String name, int price, String company) {
        super(id, name, price);
        this.company = company;
    }

    public Smartphone() {
        super();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone Smartphone = (Smartphone) o;
        return Objects.equals(company, Smartphone.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company);
    }
}
