package com.ratan.learn.restfull.springjpa.filter;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.Entity;
import java.util.Objects;


@JsonFilter("sampleBeanFilter")
public class SampleBean {

    private  String field1;
    private  String field2;
    private  String field3;

    public SampleBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleBean that = (SampleBean) o;
        return Objects.equals(field1, that.field1) &&
                Objects.equals(field2, that.field2) &&
                Objects.equals(field3, that.field3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, field3);
    }
}
