package com.itdr.pojo;

import java.math.BigDecimal;

public class Products {
    Integer id ;
    Integer categoryld;
    String name ;
    String subtitle;
    String mainlmage;
    Integer status;
    BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryld() {
        return categoryld;
    }

    public void setCategoryld(Integer categoryld) {
        this.categoryld = categoryld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainlmage() {
        return mainlmage;
    }

    public void setMainlmage(String mainlmage) {
        this.mainlmage = mainlmage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", categoryld=" + categoryld +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", mainlmage='" + mainlmage + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}
