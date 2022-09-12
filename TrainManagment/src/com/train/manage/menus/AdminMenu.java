package com.train.manage.menus;

import static com.train.manage.Constants.SCANNER;

public class AdminMenu {

    private TrainMenu trainMenu;

    private EngineMenu engineMenu;

    public AdminMenu(TrainMenu trainMenu, EngineMenu engineMenu) {
        this.trainMenu = trainMenu;
        this.engineMenu = engineMenu;
    }

    public void displayMenu() {
        System.out.println("Explore your options as ADMIN: ");
        int option = -1;
        while (true) {
            System.out.println(
                    "1: Add Train\n2: Update a train.\n3: List trains.\n4: Add engine.\n5: List engines.\n-1: Log Out");
            option = SCANNER.nextInt();
            if (option == -1)
                break;
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
