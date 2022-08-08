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


//Esta clase realiza las pruebas de el test case 2
public class InvalidEmailLogin {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tikiciaride.000webhostapp.com/login.php");
	}
	
	//Test de login inválido por correo erroneo
	@Test
	public void testInvalidLogin() {
		WebElement emailBox = driver.findElement(By.name("email"));
		emailBox.clear();
		emailBox.sendKeys("danielramirezvegahotmail.com");
		
		WebElement passwordBox = driver.findElement(By.name("password"));
		passwordBox.clear();
		passwordBox.sendKeys("123");
		
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/button"));
		loginButton.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Dashboard | Tikicia Ride", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
