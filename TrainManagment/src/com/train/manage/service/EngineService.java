package com.train.manage.service;

import java.util.List;
import com.train.manage.engine.Engine;
import com.train.manage.engine.EngineDTO;
import com.train.manage.repository.EngineRepository;

public class EngineService {

    private EngineRepository engineRepository;

    public EngineService() {
        this.engineRepository = new EngineRepository();
    }

    public Engine addEngine(EngineDTO engineDTO) {
        return addEngine(new Engine(engineDTO.getMake(), engineDTO.getMaxSpeed()));
    }

    public Engine addEngine(Engine engine) {
        engineRepository.add(engine);
        return engine;
    }

    public List<Engine> getAllEngines() {
        return engineRepository.getAll();
    }

    public Engine getEngine(int engineIdx) {
        return engineRepository.get(engineIdx - 1);
    }
}
