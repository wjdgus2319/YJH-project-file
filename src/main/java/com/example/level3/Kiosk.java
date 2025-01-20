package com.example.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("[ SHAKE SHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.printf("%d. %s%n", (i + 1), item);
            }
            System.out.println("0. 종료 | 종료");
            System.out.print("메뉴를 선택하세요: ");
            choice = scanner.nextInt();
            if (choice > 0 && choice <= menuItems.size()) {
                MenuItem selectedItem = menuItems.get(choice - 1);
                System.out.printf("선택한 메뉴: %s | W %.1f | %s%n", selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());
            } else if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 포함된 버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 포함된 버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 포함된 버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본 버거"));

        Kiosk kiosk = new Kiosk(menuItems);
        kiosk.start();
    }
}

