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

public class TestandoElementosObrigatorios {
	
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
		// validando nome
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert =  driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
			
	}
	
	@Test
	public void validandoSobreNomeObrigatorio() {
		
		// validando sobrenome obrigatório
		driver.findElement(By.id("elementosForm:nome")).sendKeys("DARLISON");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert =  driver.switchTo().alert();
		
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
			
	}
	
	
	@Test
	public void validandoSexo() {
		
		// validando sexo obrigatório
		driver.findElement(By.id("elementosForm:nome")).sendKeys("DARLISON");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("SILVA");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert =  driver.switchTo().alert();
		
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
			
	}
	
	
	@Test
	public void validandoComida() {
		
		/*
		 * Usuário não pode dizer que é vegetariano e
		 */
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
	
	
	@Test
	public void validandoEsporte() {
		
		// validando esporte 
		driver.findElement(By.id("elementosForm:nome")).sendKeys("DARLISON");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("SILVA");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		driver.switchTo().alert();
		Alert alert =  driver.switchTo().alert();
		
		Assert.assertEquals("Voce faz esporte ou não?", alert.getText());
			
	}

}
