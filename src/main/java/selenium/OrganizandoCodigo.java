package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class OrganizandoCodigo {
	
	/*
	 * VAMOS USAR o conceito de raproveitamento do nosso código para deixá-lo 
	 * mais limpo
	 */
	
	// devemos criar uma variável global
	private WebDriver driver;
	
	@Before  //executa esse método antes de cada teste
	public void inicializa() {
		driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://127.0.0.1:5500/componentes.html");
	}
	
	@After   // vai executar esse método depois de cada teste
	public void finalizar() {
		driver.quit();
	}
	
	
	@Test
	public void validandoNomeObrigatorio() {
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert =  driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
			
	}
	
	@Test
	public void validandoSobreNomeObrigatorio() {

		driver.findElement(By.id("elementosForm:nome")).sendKeys("DARLISON");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert =  driver.switchTo().alert();	
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
			
	}
	
	
	@Test
	public void validandoSexo() {

		driver.findElement(By.id("elementosForm:nome")).sendKeys("DARLISON");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("SILVA");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert =  driver.switchTo().alert();
		
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
			
	}
	
	
	@Test
	public void validandoComida() {

		driver.findElement(By.id("elementosForm:nome")).sendKeys("DARLISON");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("SILVA");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert alert =  driver.switchTo().alert();
		
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
			
	}
	
	
	

}
