package com.example.level6;

public enum UserType {
    국가유공자(0.10),
    군인(0.05),
    학생(0.03),
    일반(0.0);

    private final double discountRate;

    UserType(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}

