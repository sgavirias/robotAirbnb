package com.choucair.formacion.definition;

import com.choucair.formacion.steps.ReservarAlojamientoStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ReservarAlojamientoDefinition {
    @Steps
    ReservarAlojamientoStep reservarAlojamientoStep;

    @Given("^que me encuentro en el sitio de airbnb$")
    public void que_me_encuentro_en_el_sitio_de_airbnb(){
        reservarAlojamientoStep.abrirExplorador();

    }

    @When("^completo los campos del formulario$")
    public void completo_los_campos_del_formulario() {
        reservarAlojamientoStep.buscarHabitacion();
    }

    @Then("^obtengo reporte de check in$")
    public void obtengo_reporte_de_check_in() {
    }
}
