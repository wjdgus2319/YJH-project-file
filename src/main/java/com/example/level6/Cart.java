package com.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    List<MenuItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("[ Orders ]");
            items.forEach(item -> System.out.printf("%s | W %.1f | %s%n", item.getName(), item.getPrice(), item.getDescription()));
        }
    }

    public double getTotal(UserType userType) {
        double total = items.stream().mapToDouble(MenuItem::getPrice).sum();
        double discount = total * userType.getDiscountRate();
        return total - discount;
    }

    public void clear() {
        items.clear();
        System.out.println("장바구니가 초기화되었습니다.");
    }

    public void removeItemByName(String name) {
        items = items.stream()
                .filter(item -> !item.getName().equals(name))
                .collect(Collectors.toList());
        System.out.println(name + "이(가) 장바구니에서 제거되었습니다.");
    }
}
