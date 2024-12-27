package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CarSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStepdef {
    private WebDriver driver;

    @Given("^estoy en la página de la tienda$")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        screenShot();
    }
    @And("me logueo con mi usuario {string}y clave {string}")
    public void meLogueoConMiUsuarioYClave(String username, String password) {
        LoginSteps loginstep = new LoginSteps(driver);
        loginstep.typeUser(username);
        loginstep.typePassword(password);
        loginstep.login();
        screenShot();
    }
    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria){
        String menuXpath = "//a[contains(., '"+categoria+"')]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menuXpath)));
            Assertions.assertTrue(menu.isDisplayed());
            menu.click();
        } catch (TimeoutException e) {
            Assertions.fail("No se encontro el menu. Deteniendo prueba");
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a[text()='" + subcategoria + "']")));
        String submenuXpath = "//li/a[text()='"+subcategoria+"']";
        this.driver.findElement(By.xpath(submenuXpath)).click();
    }
    @And("^agrego (\\d+) unidades del primer producto al carrito$")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        CarSteps carSteps = new CarSteps(driver);
        carSteps.clickitem(unidades);
    }

    @Then("^valido en el popup la confirmación del producto agregado$")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        CarSteps carSteps = new CarSteps(driver);
        carSteps.ValidarPopup();
    }


    @And("^valido en el popup que el monto total sea calculado correctamente$")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        CarSteps carSteps = new CarSteps(driver);
        carSteps.ValidarMonto();
    }

    @When("^finalizo la compra$")
    public void finalizoLaCompra() {
        CarSteps carSteps = new CarSteps(driver);
        carSteps.FinalizarCompra();
    }

    @Then("^valido el titulo de la pagina del carrito$")
    public void validoElTituloDeLaPaginaDelCarrito() {
        CarSteps carSteps = new CarSteps(driver);
        carSteps.ValidarTitulo();
    }

    @And("^vuelvo a validar el calculo de precios en el carrito$")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        CarSteps carSteps = new CarSteps(driver);
        carSteps.CalculoPreciosCarrito();
    }


}
