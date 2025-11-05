package com.copmpany.company.config;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


public class Mapping {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml"); // make sure this file is in `resources` folder
            sessionFactory = cfg.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
