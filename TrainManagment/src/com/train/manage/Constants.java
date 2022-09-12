package com.train.manage;

import java.util.Scanner;
import com.train.manage.engine.Engine;

public interface Constants {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Engine DEFAULT_ENGINE = new Engine("CompanyA", 8);
}
