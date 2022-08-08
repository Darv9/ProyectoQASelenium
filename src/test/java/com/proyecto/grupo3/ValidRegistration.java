package com.proyecto.grupo3;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Esta clase realiza las pruebas del TC_06
public class ValidRegistration {
private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tikiciaride.000webhostapp.com/signup.php");
	}
	
	//Test de registro válido
	@Test
	public void testSimoultaneousRegisters() {
		WebElement nameBox = driver.findElement(By.name("lname"));
		nameBox.clear();
		nameBox.sendKeys("Paulo Gonzalez Rojas");
		
		WebElement emailBox = driver.findElement(By.name("email"));
		emailBox.clear();
		emailBox.sendKeys("loremIpsum@gmail.com");
		
		WebElement passwordBox = driver.findElement(By.name("pass"));
		passwordBox.clear();
		passwordBox.sendKeys("12345");
		
		WebElement pictureBox = driver.findElement(By.name("foto"));
		pictureBox.clear();
		pictureBox.sendKeys("E:\\Martha\\Pictures");
		
		WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button"));
		registerButton.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Dashboard | Tikicia Ride", driver.getTitle());
	}
}
