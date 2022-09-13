package com.train.manage.menus;

import static com.train.manage.Constants.SCANNER;
import com.train.manage.service.AuthService;

public class AdminMenu {

    private TrainMenu trainMenu;

    private EngineMenu engineMenu;

    private EntryMenu entryMenu;

    public AdminMenu(TrainMenu trainMenu, EngineMenu engineMenu) {
        this.trainMenu = trainMenu;
        this.engineMenu = engineMenu;
        this.entryMenu = new EntryMenu(AuthService.getInstance());
    }

    public void displayMenu() {
        System.out.println("Explore your options as ADMIN: ");
        int option = -1;
        while (true) {
            System.out.println(
                    "1: Add Train\n2: Update a train.\n3: List trains.\n4: Add engine.\n5: List engines.\n-1: Log Out");
            option = SCANNER.nextInt();
            if (option == -1) {
                entryMenu.authenticate();
                return;
            }
            delatgate(option);
        }
    }

    private void delatgate(int option) {
        switch (option) {
            case 1:
                trainMenu.addTrain();
                break;
            case 2:
                trainMenu.updateTrain();
                break;
            case 3:
                trainMenu.listAllTrain();
                break;
            case 4:
                engineMenu.addEngine();
                break;
            case 5:
                engineMenu.listEngines();
                break;
            default:
                break;
        }
    }
}
