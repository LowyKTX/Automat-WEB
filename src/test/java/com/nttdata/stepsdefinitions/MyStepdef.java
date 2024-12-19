package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

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
    @When("^navego a la categoria \"([^\"]*)\" y subcategoria \"([^\"]*)\"$")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^agrego (\\d+) unidades del primer producto al carrito$")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
    }

    @Then("^valido en el popup la confirmación del producto agregado$")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
    }

    @And("^valido en el popup que el monto total sea calculado correctamente$")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
    }

    @When("^finalizo la compra$")
    public void finalizoLaCompra() {
    }

    @Then("^valido el titulo de la pagina del carrito$")
    public void validoElTituloDeLaPaginaDelCarrito() {
    }

    @And("^vuelvo a validar el calculo de precios en el carrito$")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }


    }
