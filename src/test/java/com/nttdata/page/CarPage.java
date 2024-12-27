package com.nttdata.page;

import org.openqa.selenium.By;

public class CarPage {
    public static By firstProduct = By.xpath("//img[@alt='Hummingbird printed t-shirt']");
    public static By añadirCantidad = By.xpath("//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']");
    public static By añadirCarrito = By.xpath("//button[@class='btn btn-primary add-to-cart']");

    public static By TituloPopup = By.xpath("//h4[@id='myModalLabel']");

    public static By ProductPrice = By.xpath("//div[@class='col-md-6']//p[@class='product-price']");

    public static By FinalizarCompra = By.xpath("//div[@class='cart-content-btn']//a[@class='btn btn-primary']");

    public static By CapturaTitulo = By.xpath("//h1[normalize-space()='Carrito']");

    public static By precio_carrito = By.xpath("//div[@class='current-price']//span[@class='price']");
    public static By cantidad_carrito = By.xpath("//input[@name='product-quantity-spin']");
    public static By precio_final_carrito = By.xpath("//span[@class='product-price']");
}
