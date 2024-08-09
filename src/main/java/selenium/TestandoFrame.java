package selenium;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class TestandoFrame {
	
	@Test
	public void testandoFrame() {
		
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://127.0.0.1:5500/componentes.html");
		
		// mudando para o frame
		driver.switchTo().frame("frame1");		
		driver.findElement(By.id("frameButton")).click();
		
		Alert alert = driver.switchTo().alert();
		String mensagemAlerta = alert.getText();
		Assert.assertEquals("Frame OK!", mensagemAlerta);
		
		// fechando o alert
		alert.accept();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagemAlerta);
		
		driver.quit();
		
	}

}
