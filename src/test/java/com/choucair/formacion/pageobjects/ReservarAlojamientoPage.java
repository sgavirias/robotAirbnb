package com.choucair.formacion.pageobjects;

import cucumber.api.java.cs.A;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


@DefaultUrl("https://www.airbnb.com.co/")
public class ReservarAlojamientoPage extends PageObject {

    @FindBy(xpath = "//button[@class='optanon-allow-all accept-cookies-button']")
    WebElementFacade cookies;

    @FindBy(xpath = "//*[@id='Koan-magic-carpet-koan-search-bar__input']")
    WebElementFacade clickDonde;

    @FindBy(xpath = "//div[@class='_1h5uiygl']")
    WebElementFacade pagFechaSiguiente;

    @FindBy(xpath = "//div[@data-visible='true']//strong")
    WebElementFacade lblNombreMesEntrada;

    @FindBy(xpath = "//td[contains(text(),'31')]")
    WebElementFacade dateFechaLlegada;

    @FindBy(xpath = "//td[@class='_16zigr23'][contains(text(),'10')]")
    WebElementFacade dateFechaSalida;

    @FindBy(xpath = "//div[@class='_j1kt73']")
    WebElementFacade cmbHuespedes;

    @FindBy(xpath = "//div[@class='_9cfq872']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
    WebElementFacade btnMasAdultos;

    @FindBy(xpath = "//div[@class='_e296pg']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
    WebElementFacade btnMasNinos;

    @FindBy(xpath = "//button[@class='_b0ybw8s']")
    WebElementFacade btnGuardar;

    @FindBy(xpath = "//button[@class='_1vs0x720']")
    WebElementFacade btnBuscar;

    @FindBy(xpath = "//li[@class='_r4n1gzb']//div[@class='_1m76pmy']")
    WebElementFacade btnPage2;

    @FindBy(xpath = "//div[@itemprop='itemListElement']//*[contains(text(),'huéspedes')]")
    List<WebElementFacade> listDepartamentos;

    /*@FindBy(xpath = "//div[@class='_8ssblpx']")
    List<WebElementFacade> listHospedajes;*/


    public void cookies() {

        cookies.click();

    }

    public void ingreso() {
        int coor = $("//button[@class='_7ykwo4']").getCoordinates().onPage().getY();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollTo(0," + coor + ");");

        Actions act = new Actions(getDriver());
        act.moveToElement(clickDonde).click().perform();
        clickDonde.sendKeys("Kuwait City, Al Asimah, Kuwait");
        clickDonde.sendKeys(Keys.ENTER);

    }

    public void fecha() {

        Actions act = new Actions(getDriver());
        //act.moveToElement(pagFechaSiguiente).click().perform();

        for (int i = 1; i <= 12; i++) {
            String lblNombreLlegadaMesText = lblNombreMesEntrada.getTextValue();
            if (lblNombreLlegadaMesText.equals("octubre 2019")) {
                //assertThat(lblMesPpal, containsString("octubre 2019"));
                act.moveToElement(dateFechaLlegada).click().perform();

                break;
            } else {

                act.moveToElement(pagFechaSiguiente).click().perform();
            }
        }

        for (int a = 1; a <= 12; a++) {
            String lblNombreSalidaMesText = lblNombreMesEntrada.getTextValue();

            if (lblNombreSalidaMesText.equals("noviembre 2019")) {
                act.moveToElement(dateFechaSalida).click().perform();
                break;
            } else {

                act.moveToElement(pagFechaSiguiente).click().perform();
            }
        }

    }

    public void huespedes() {

        Actions act = new Actions(getDriver());
        act.moveToElement(cmbHuespedes).click().perform();
        act.moveToElement(btnMasAdultos).click().perform();
        act.moveToElement(btnMasAdultos).click().perform();
        act.moveToElement(btnMasNinos).click().perform();

    }

    public void guardar() {

        Actions act = new Actions((getDriver()));
        act.moveToElement(btnGuardar).click().perform();
    }

    public void buscar() {

        Actions act = new Actions(getDriver());
        act.moveToElement(btnBuscar).click().perform();
    }


    public void numHuespedes() {
        int coor = $("//ul[@class='_11hau3k']").getCoordinates().onPage().getY();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollTo(0," + coor + ");");

    }

    public void paginaHospedaje() {
        String[] pagina = $("//div[@class='_13e0zvs']//div[contains(@style,'margin-top:')]").getText().split(" ");
        float variable1 = Integer.parseInt(pagina[2]);
        int variable2 = Integer.parseInt(pagina[4]);
        int num = (int) Math.ceil((Double.parseDouble(pagina[4])) / variable1);
        //---------------------------------

        //ramdom

        int numero = (int) (Math.random() * (variable2 - (variable1+1)) + variable1+1);
        System.out.println(numero);
        //saca el maximo de paginas es 3
        float pag = (float) Math.ceil(numero / variable1);
        //divir el ramdom con 18
        float numpag = (numero / variable1);
        float dec = (numpag % 1);
        int numele = (int) (dec * variable1);
        int numposicionelem=(int) Math.ceil(numele);
        System.out.println(numposicionelem);
        //--------------------------------

        for (int i = 2; i <= num; i++) {
            Actions act = new Actions(getDriver());
            if (pag == 2) {
                while (i == 2) {
                    act.moveToElement($("//div[@class='_1bdke5s'][contains(text(),'" + i + "')]")).click().perform();
                    waitFor(3).seconds();
                    //if(pag==i){
                    //omanos el tamaño de la lista
                    if (Pattern.matches("[5-99]\\shuéspedes.+", listDepartamentos.get(numposicionelem).getText())) {  //* hace un get text y compara
                        //con patter machest si ka expresion tiene el mismo texto y le da click
                        listDepartamentos.get(numposicionelem).click();
                    } else {
                        act.moveToElement($("//div[@class='_1bdke5s'][contains(text(),'1')]")).click().perform();
                        paginaHospedaje();
                    }
                    break;
                }
                break;
            } else if (pag == i) {
                while (i <= num) {

                        act.moveToElement($("//div[@class='_1bdke5s'][contains(text(),'" + i + "')]")).click().perform();
                        waitFor(3).seconds();
                        if (Pattern.matches("[5-99]\\shuéspedes.+", listDepartamentos.get(numposicionelem-1).getText())) {  //* hace un get text y compara
                            //con patter machest si ka expresion tiene el mismo texto y le da click
                            System.out.println(listDepartamentos.get(numposicionelem-1).getText());
                            listDepartamentos.get(numposicionelem-1).click();
                            break;
                        } else {
                            System.out.println(listDepartamentos.get(numposicionelem-1).getText());
                            act.moveToElement($("//div[@class='_1bdke5s'][contains(text(),'1')]")).click().perform();
                            paginaHospedaje();
                        }

                }
                break;

            }
        }
    }


}
