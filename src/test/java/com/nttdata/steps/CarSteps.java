package com.nttdata.steps;

import com.nttdata.page.CarPage;
import com.nttdata.page.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class CarSteps {
    private WebDriver driver;
    public CarSteps(WebDriver driver){
        this.driver = driver;
    }
    public void clickitem(int unidades){
        WebElement firstProductElement = driver.findElement(CarPage.firstProduct);
        firstProductElement.click();
        WebElement añadirCantidad = driver.findElement(CarPage.añadirCantidad);
        for(int  i=1; i<unidades; i++){
            añadirCantidad.click();
        }
    }

    public void ValidarPopup(){
        WebElement añadirCarrito = driver.findElement(CarPage.añadirCarrito);
        añadirCarrito.click();
        PopupDisplayed();
    }

    public void PopupDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Popup = wait.until(ExpectedConditions.visibilityOfElementLocated(CarPage.TituloPopup));
        Assert.assertTrue(Popup.isDisplayed());
    }

    public void ValidarMonto(){
        WebElement ProductPrices = driver.findElement(CarPage.ProductPrice);
        String A = ProductPrices.getText();
        ExtraerTexto(A);
    }
    public void ExtraerTexto(String A){
        double Price = Double.parseDouble(A.replace("S/","").trim());
        System.out.print(Price);

    }

    public void FinalizarCompra(){
        WebElement CompraFinalizada = driver.findElement(CarPage.FinalizarCompra);
        CompraFinalizada.click();
    }

    public void ValidarTitulo(){
        WebElement TituloValidado = driver.findElement(CarPage.CapturaTitulo);
        Assert.assertTrue(TituloValidado.isDisplayed());
    }

    public void CalculoPreciosCarrito(){
        WebElement precio = driver.findElement(CarPage.precio_carrito);
        WebElement cantidad = driver.findElement(CarPage.cantidad_carrito);
        WebElement montofinal = driver.findElement(CarPage.precio_final_carrito);
        double preciof = Double.parseDouble(precio.getText().replace("S/","").trim());
        int cantidadf = Integer.parseInt(cantidad.getAttribute("value"));
        double montofinalf = Double.parseDouble(montofinal.getText().replace("S/","").trim());

        if(preciof * cantidadf == montofinalf){
            System.out.println("Validación del monto final del carrito exitosa");
        }
    }
}
