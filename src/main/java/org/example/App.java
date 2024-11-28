package org.example;

import org.example.domain.wiseSaying.controller.WiseSayingController;
import org.example.system.controller.SystemController;

import java.util.Scanner;

public class App {
    //다른 클래스와 공유하지않는 것들은 private로 정의함.
    private final Scanner scanner;
    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;

    //메인 함수를 실행하면 App의 run메서드가 실행됨
    public App() {
        scanner = new Scanner(System.in);
        wiseSayingController = new WiseSayingController(scanner);
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        wiseSayingController.makeSampleData();

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            //각 컨트롤러에 해당되는 메서드를 수행함.
            if (cmd.equals("종료")) {
                systemController.actionExit();
                break;
            } else if (cmd.equals("등록")) {
                wiseSayingController.actionAdd();
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList();
            } else if (cmd.startsWith("삭제")) {
                wiseSayingController.actionDelete(cmd);
            } else if (cmd.startsWith("수정")) {
                wiseSayingController.actionModify(cmd);
            }
        }

        scanner.close();
    }
}
