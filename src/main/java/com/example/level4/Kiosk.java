package com.example.level4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= menus.size()) {
                Menu selectedMenu = menus.get(choice - 1);
                System.out.println("[ " + selectedMenu.getCategoryName().toUpperCase() + " MENU ]");
                selectedMenu.displayMenuItems();
                System.out.println("0. 뒤로가기");

                int itemChoice = scanner.nextInt();
                if (itemChoice == 0) {
                    continue;  // 메인 메뉴로 돌아가기
                } else if (itemChoice > 0 && itemChoice <= selectedMenu.getMenuItems().size()) {
                    MenuItem selectedItem = selectedMenu.getMenuItems().get(itemChoice - 1);
                    System.out.println("선택한 메뉴: " + selectedItem);
                } else {
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        // Menu 객체 생성
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 포함된 버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 포함된 버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 포함된 버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본 버거"));

        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItem(new MenuItem("Coke", 2.0, "탄산이 강한 콜라"));
        drinksMenu.addMenuItem(new MenuItem("Diet Coke", 2.0, "칼로리를 줄인 콜라"));
        drinksMenu.addMenuItem(new MenuItem("Water", 1.0, "생수"));

        Menu dessertsMenu = new Menu("Desserts");
        dessertsMenu.addMenuItem(new MenuItem("Ice Cream", 3.5, "바닐라 아이스크림"));
        dessertsMenu.addMenuItem(new MenuItem("Brownie", 4.0, "진한 초코 브라우니"));

        // Kiosk 객체 생성
        List<Menu> menus = new ArrayList<>();
        menus.add(burgerMenu);
        menus.add(drinksMenu);
        menus.add(dessertsMenu);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
