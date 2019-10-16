package com.choucair.formacion.steps;

import com.choucair.formacion.pageobjects.ReservarAlojamientoPage;
import net.thucydides.core.annotations.Step;

public class ReservarAlojamientoStep {
    ReservarAlojamientoPage reservarAlojamientoPage;

    @Step
    public void abrirExplorador(){
        reservarAlojamientoPage.open();
        reservarAlojamientoPage.cookies();
        reservarAlojamientoPage.ingreso();
        reservarAlojamientoPage.fecha();
        reservarAlojamientoPage.huespedes();
        reservarAlojamientoPage.guardar();
        reservarAlojamientoPage.buscar();
    }


    @Step
    public void buscarHabitacion() {
        reservarAlojamientoPage.numHuespedes();
        reservarAlojamientoPage.paginaHospedaje();

    }









}
