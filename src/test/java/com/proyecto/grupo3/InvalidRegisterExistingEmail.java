package com.proyecto.grupo3;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Esta clase realiza las pruebas del TC_08
public class InvalidRegisterExistingEmail {
private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tikiciaride.000webhostapp.com/signup.php");
	}
	
	//Test de registro inválido con correo ya existente
	@Test
	public void testSimoultaneousRegisters() {
		WebElement nameBox = driver.findElement(By.name("lname"));
		nameBox.clear();
		nameBox.sendKeys("Paulo Gonzalez Rojas");
		
		WebElement emailBox = driver.findElement(By.name("email"));
		emailBox.clear();
		emailBox.sendKeys("danielramirezvega@hotmail.com");
		
		WebElement passwordBox = driver.findElement(By.name("pass"));
		passwordBox.clear();
		passwordBox.sendKeys("123");
		
		WebElement pictureBox = driver.findElement(By.name("foto"));
		pictureBox.clear();
		pictureBox.sendKeys("C:\\\\\\\\Users\\\\\\\\danie\\\\\\\\OneDrive\\\\\\\\Imágenes");
		
		WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button"));
		registerButton.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Dashboard | Tikicia Ride", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
