package com.train.manage.menus;

import java.util.List;
import com.train.manage.engine.Engine;
import com.train.manage.engine.EngineDTO;
import com.train.manage.service.EngineService;
import static com.train.manage.Constants.SCANNER;

public class EngineMenu {

    private EngineService engineService;

    public EngineMenu() {
        this.engineService = new EngineService();
    }

    public Engine selectEngine() {
        System.out.println("Select engine you would like to use.");
        listEngines();
        int engineIdx;
        engineIdx = SCANNER.nextInt();
        return engineService.getEngine(engineIdx);
    }

    public EngineDTO getEngineData() {
        System.out.println("Enter make of the engine: ");
        String make = SCANNER.next();
        System.out.println("Enter max speed for the engine: ");
        Integer maxSpeed = SCANNER.nextInt();
        return new EngineDTO(make, maxSpeed);
    }

    public Engine addEngine() {
        return engineService.addEngine(getEngineData());
    }

    public void listEngines() {
        List<Engine> engines = engineService.getAllEngines();
        int i = 1;
        for (Engine engine : engines) {
            System.out.println(i++ + ": " + engine);
        }
    }
}
