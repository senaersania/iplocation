package com.example.demo.dto;

import com.example.demo.models.IpLocation;

import java.util.List;

public class IpLocationDto {
    public List<IpLocation> iplocationList;

    public List<IpLocation> getIplocationList() {
        return iplocationList;
    }

    public void setIplocationList(List<IpLocation> iplocationList) {
        this.iplocationList = iplocationList;
    }

    @Override
    public String toString() {
        return "IpLocationDto{" +
                "iplocationList=" + iplocationList +
                '}';
    }
}
