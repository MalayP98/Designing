package com.train.manage.repository;

import java.util.ArrayList;
import java.util.List;
import com.train.manage.engine.Engine;

public class EngineRepository implements Repository<Engine> {

    public static final List<Engine> ENGINES = new ArrayList<>();

    @Override
    public boolean add(Engine engine) {
        return ENGINES.add(engine);
    }

    @Override
    public boolean update(int index, Engine engine) {
        ENGINES.add(index, engine);
        return true;
    }

    @Override
    public boolean delete(int index) {
        ENGINES.remove(index);
        return true;
    }

    @Override
    public Engine get(int index) {
        return ENGINES.get(index);
    }

    public List<Engine> getAll() {
        return ENGINES;
    }
}
