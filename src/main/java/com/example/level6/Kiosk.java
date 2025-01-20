package com.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private Cart cart;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
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
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");

                    int confirm = scanner.nextInt();
                    if (confirm == 1) {
                        cart.addItem(selectedItem);
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }

            if (!cart.items.isEmpty()) {
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");

                int orderChoice = scanner.nextInt();
                if (orderChoice == 4) {
                    System.out.println("아래와 같이 주문 하시겠습니까?");
                    cart.displayItems();
                    System.out.println("[ Total ]");
                    System.out.printf("W %.1f%n", cart.getTotal(UserType.일반));  // 기본 사용자 유형을 일반으로 설정
                    System.out.println("1. 주문      2. 메뉴판");

                    int orderConfirm = scanner.nextInt();
                    if (orderConfirm == 1) {
                        System.out.println("할인 정보를 입력해주세요.");
                        System.out.println("1. 국가유공자 : 10% ");
                        System.out.println("2. 군인     :  5%");
                        System.out.println("3. 학생     :  3%");
                        System.out.println("4. 일반     :  0%");

                        int userTypeChoice = scanner.nextInt();
                        UserType userType;
                        switch (userTypeChoice) {
                            case 1: userType = UserType.국가유공자; break;
                            case 2: userType = UserType.군인; break;
                            case 3: userType = UserType.학생; break;
                            default: userType = UserType.일반; break;
                        }

                        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", cart.getTotal(userType));
                        cart.clear();
                    }
                } else if (orderChoice == 5) {
                    cart.clear();
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
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

        List<Menu> menus = new ArrayList<>();
        menus.add(burgerMenu);
        menus.add(drinksMenu);
        menus.add(dessertsMenu);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
