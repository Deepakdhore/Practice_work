package com.gradleProjet.Learn_spring_aop.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Arrays;
@Service
public class BussinessService2 {
    private DataService1 dataService1;
    @Autowired
    BussinessService2(DataService1 dataService1){
        this.dataService1=dataService1;
    }
    public int calculateMax() {
        int[] data = dataService1.retriveData();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Arrays.stream(data).max().orElse(0);
    }




}
