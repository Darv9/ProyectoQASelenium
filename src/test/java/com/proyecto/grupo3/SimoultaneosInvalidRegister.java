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


//Esta clase realiza las pruebas de el Test Case 14 = TC14
public class SimoultaneosInvalidRegister {

private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tikiciaride.000webhostapp.com/signup.php");
	}
	
	//Test de registro con fotografía inválida
	@Test
	public void testSimoultaneousInvalidRegisters() {
		WebElement nameBox = driver.findElement(By.name("lname"));
		nameBox.clear();
		nameBox.sendKeys("Danielito");
		
		WebElement emailBox = driver.findElement(By.name("email"));
		emailBox.clear();
		emailBox.sendKeys("danielito@gmail.com");
		
		WebElement passwordBox = driver.findElement(By.name("pass"));
		passwordBox.clear();
		passwordBox.sendKeys("123");
		
		WebElement pictureBox = driver.findElement(By.name("foto"));
		pictureBox.clear();
		pictureBox.sendKeys("hola");
		
		WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button"));
		registerButton.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Dashboard | Tikicia Ride", driver.getTitle());
	}
	
	//Test de registro sin nombre/nombre inválido
	@Test
	public void testSimoultaneousInvalidRegisters2() {
		WebElement nameBox = driver.findElement(By.name("lname"));
		nameBox.clear();
		nameBox.sendKeys("");
		
		WebElement emailBox = driver.findElement(By.name("email"));
		emailBox.clear();
		emailBox.sendKeys("danielito2@gmail.com");
		
		WebElement passwordBox = driver.findElement(By.name("pass"));
		passwordBox.clear();
		passwordBox.sendKeys("123");
		
		WebElement pictureBox = driver.findElement(By.name("foto"));
		pictureBox.clear();
		pictureBox.sendKeys("C:\\\\Users\\\\danie\\\\OneDrive\\\\Imágenes");
		
		WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button"));
		registerButton.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Dashboard | Tikicia Ride", driver.getTitle());
	}
	
	//Test de registro con correo inválido
	@Test
	public void testSimoultaneousInvalidRegisters3() {
		WebElement nameBox = driver.findElement(By.name("lname"));
		nameBox.clear();
		nameBox.sendKeys("danielito341");
		
		WebElement emailBox = driver.findElement(By.name("email"));
		emailBox.clear();
		emailBox.sendKeys("danielito341gmai.com");
		
		WebElement passwordBox = driver.findElement(By.name("pass"));
		passwordBox.clear();
		passwordBox.sendKeys("123");
		
		WebElement pictureBox = driver.findElement(By.name("foto"));
		pictureBox.clear();
		pictureBox.sendKeys("C:\\\\Users\\\\danie\\\\OneDrive\\\\Imágenes");
		
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
