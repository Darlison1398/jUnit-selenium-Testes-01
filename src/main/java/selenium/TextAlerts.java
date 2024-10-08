package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TextAlerts {
	
	@Test
	public void testandoTextoAlert() {
		
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://127.0.0.1:5500/componentes.html");
		
		driver.findElement(By.id("alert")).click();
		
		// pegando o valor do alert
		Alert alert = driver.switchTo().alert();
		String textoAlert = alert.getText();
		Assert.assertEquals("Alert Simples", textoAlert);
		
		// fechando o alert
		alert.accept();
		
		// setando no textfield o texto do alert
		driver.findElement(By.id("elementosForm:nome")).sendKeys(textoAlert);
		
		driver.quit();
		
	}
	
	@Test
	public void alertConfirm() {
		// alert de confirmar
		
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://127.0.0.1:5500/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		
		// pegando o valor do alert
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Confirm Simples", alert.getText());
		// CONFIRMANDO o alert
		alert.accept();
		
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		
		/* NEGANDO O ALERT
		Assert.assertEquals("Confirm Simples", alert.getText());

		alert.dismiss();
		
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		 */
		
	
		driver.quit();
		
	}
	
	
	@Test
	public void testandoAlertPrompt() {
		
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://127.0.0.1:5500/componentes.html");
		
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Digite um numero", alert.getText());
		
		alert.sendKeys("12");
		alert.accept();
		
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
		driver.quit();
		
	}

}
