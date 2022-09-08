package com.train.manage;

class TrainManagementApp {
    public static void main(String[] args) {
        Environment env = Environment.getInstance();
        env.create(15);
        env.start();
    }
}
