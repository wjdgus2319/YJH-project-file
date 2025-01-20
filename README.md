간단한 키오스크 프로그램입니다. 사용자가 메뉴를 선택하고 선택한 메뉴의 정보를 출력합니다.

목차
소개

설치

사용법

기여

라이센스

문의

소개
이 프로젝트는 Shake Shack의 메뉴를 시뮬레이션하는 간단한 키오스크 프로그램입니다. 사용자는 메뉴를 선택하고, 선택한 메뉴의 이름, 가격, 설명을 출력합니다.

설치
프로젝트를 설치하고 실행하는 방법은 다음과 같습니다.

bash
$ git clone https://github.com/wjdgus2319/YJH-project-file.git
$ cd YJH-project-file
$ javac com/example/level1/*.java
사용법
프로그램을 실행하려면 다음 명령어를 입력하세요.

bash
$ java com.example.level1.Kiosk
기여
프로젝트에 기여하려면 다음과 같은 절차를 따릅니다:

이 리포지토리를 포크합니다.

새로운 브랜치를 만듭니다 (git checkout -b feature-branch).

변경사항을 커밋합니다 (git commit -am 'Add new feature').

브랜치에 푸시합니다 (git push origin feature-branch).

풀 리퀘스트를 생성합니다.

라이센스
이 프로젝트는 MIT 라이센스를 따릅니다.

문의
프로젝트와 관련된 문의 사항이 있을 경우 이메일로 연락주세요. tprpworld01@naver.com

구현한 상황 
레벨 1에서는 기본적인 메뉴 선택 기능을 구현했습니다. 사용자가 메뉴를 선택하면 해당 메뉴의 정보가 출력됩니다.
package com.example.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;

    public Kiosk() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 포함된 버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 포함된 버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 포함된 버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본 버거"));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("[ SHAKE SHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.printf("%d. %s%n", (i + 1), item);
            }
            System.out.println("0. 종료 | 종료");
            System.out.print("메뉴를 선택하세요: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= menuItems.size()) {
                    MenuItem selectedItem = menuItems.get(choice - 1);
                    System.out.printf("선택한 메뉴: %s | W %.1f | %s%n", selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());
                } else if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                } else {
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                scanner.next();
            }

        } while (choice != 0);
        scanner.close();
    }

    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.start();
    }
}

package com.example.level1;

public class MenuItem {
    private String name;
    private double price;
    private String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s | W %.1f | %s", name, price, description);
    }
}


# YJH-project-file
