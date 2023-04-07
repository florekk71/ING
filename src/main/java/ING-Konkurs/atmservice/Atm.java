package com.example.myapp;

import java.util.Objects;

public class Atm {

    private int region;
    private int atmId;
    private RequestType requestType;

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return region == atm.region && atmId == atm.atmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, atmId);
    }

    @Override
    public String toString() {
        return "Atm{" +
                "region=" + region +
                ", atmId=" + atmId +
                ", requestType=" + requestType +
                '}';
    }

    public Atm(int region, int atmId, RequestType requestType) {
        this.region = region;
        this.atmId = atmId;
        this.requestType = requestType;
    }
}
