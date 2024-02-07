package day03;

import java.util.Scanner;

public class MenuChoiceModified01 {

    public static void main(String[] args) {

/*		메뉴판을 출력 후 금액을 입력 받은 뒤 메뉴를 선택하면 거스름돈과 주문한 메뉴가 출력된다.
		 ------- 메뉴판 -------
		 1. 햄버거(9,000원)
		 2. 피자(11,000원)
		 3. 치킨(32,000원)
		 4. 금액 반환
		 -----------------------
		 ※ 만약 금액을 입력했을 때 가장 저렴한 금액의 메뉴보다 적은 금액이 입력되었다면, "주문할 수 있는 메뉴 없음 xxxx원 반환" 을 출력
		 ※ 투입 금액보다 비싼 음식을 선택하는 경우 "투입 금액이 부족합니다. xxxx원 반환" 을 출력
		 ※ 메뉴판에 없는 메뉴 선택 시 "올바른 주문이 아닙니다. xxxx원 반환" 을 출력
		 ※ 메뉴를 선택할때 4번을 선택 시 "투입 금액 xxxx원 반환" 을 출력

		 ※ 주문 시 ( 1. 포장, 2. 매장식사 ) 선택지를 출력하여 선택하게한 뒤 최종 메세지는 아래와 같이 출력한다
		 ( 1, 2 외에 다른 숫자 선택 시 "선택 오류 xxxx원 반환" 을 출력 )
		 -----------------------
		 주문 메뉴 : xxxx
		 포장 or 매장식사
		 거스름돈 : xxxx원
		 ----------------------*/


        System.out.println("-------메뉴판-------");
        System.out.println("1. 햄버거(9,000원)");
        System.out.println("2. 피자(11,000원)");
        System.out.println("3. 치킨(32,000원)");
        System.out.println("4. 금액 반환");
        System.out.println("--------------------");

        int coin = 0;
        int menunum = 0;
        int menucost = 0;
        String menuname = null;
        int wherenum = 0;
        String where = null;
        Boolean isValid; //최소 금액이 넘었는지 확인


        /**
         * 금액 투입
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("금액을 투입하세요 : ");
        coin = sc.nextInt();

        //coin이 최소 금액은 넘어야지 기본적으로 주문이 가능함.
        if (coin >= 9000) {
            isValid = true;
        }
        else{
            isValid = false;
        }

        /**
         * 메뉴 선택
         */
        if(isValid){

            System.out.print("메뉴를 선택하세요 : ");
            menunum = sc.nextInt();

            if (menunum == 1) {
                menucost = 9000;
                menuname = "김치찌개";

            }else if (menunum == 2) {
                menucost = 11000;
                menuname = "피자";

            }else if (menunum == 3) {
                menucost = 32000;
                menuname = "치킨";
            }
            else{
                System.out.printf("올바른 주문이 아닙니다. %d원 반환", coin);
            }
        }
        else{
            System.out.printf("주문할 수 있는 메뉴 없음 %d원 반환\n", coin);
        }

        /**
         * 구매 가능 여부 확인
         */
        if ((menunum == 1) || (menunum == 2) || (menunum == 3)) {

            if ((coin - menucost) >= 0) {

                System.out.print("식사 방식을 선택하세요. (1. 포장, 2.매장식사)");
                wherenum = sc.nextInt();
                if (wherenum == 1) {
                    where = "포장";
                }else{
                    where = "매장식사";
                }

                System.out.println("------------------");
                System.out.printf("주문 메뉴 : %s\n", menuname);
                System.out.println(where);
                System.out.printf("거스름돈 : %d원\n", (coin - menucost));
                System.out.println("------------------");
            }
            else{

                System.out.printf("투입 금액이 부족합니다. %d원 반환\n", coin);
            }
        }
    }
}
