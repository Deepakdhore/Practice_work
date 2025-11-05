package com.gradleProjet.Learn_spring_aop.bussiness;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class DataService1 {
    public int[] retriveData(){
        return new int[]{1, 2, 3, 4, 5};
    }


}
