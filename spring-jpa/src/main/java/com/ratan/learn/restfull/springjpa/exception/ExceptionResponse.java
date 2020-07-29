package com.ratan.learn.restfull.springjpa.exception;

import java.util.Date;
import java.util.Objects;

public class ExceptionResponse {

    private Date date;
    private String message;
    private String details;


    public ExceptionResponse(){

    }

    public ExceptionResponse(Date date, String message, String details) {
        super();
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionResponse that = (ExceptionResponse) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(message, that.message) &&
                Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, message, details);
    }


    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "date=" + date +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
