package com.gradleProjet.Learn_spring_aop.bussiness;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class BussinessService {
    @Autowired
    private  DataService1 dataService1;
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
