package com.choucair.formacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="src/test/resources/features/ReservarAlojamiento.feature")

public class RunnerFeatures {
    @Before
    public void startDriver() {
        System.out.println("startDriver");
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    @After
    public void closeDriver() {
        System.out.println("closeDriver");
    }
}