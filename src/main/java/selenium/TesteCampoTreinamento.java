package selenium;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class TesteCampoTreinamento {
	
	@Test
	public void textField() {
		// pegar o textFiel
		
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
		
        // aqui é o caminho do projeto. Isso pq ele está em localhost
		driver.get("http://127.0.0.1:5500/componentes.html");
		
		// adicionar valores em um campo input
		driver.findElement(By.id("elementosForm:nome")).sendKeys("EU QUERO ESCREVER");
		
		Assert.assertEquals("EU QUERO ESCREVER", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		
		// pra fechar o driver
		driver.quit();
	}
	
	@Test
	public void interagirComTextArea() {
		// pegar o textArea
		
				WebDriver driver = new FirefoxDriver();
		        driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://127.0.0.1:5500/componentes.html");
				
				driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Texto para o TextArea. Inserido automaticamente.");
				Assert.assertEquals("Texto para o TextArea. Inserido automaticamente.", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
				
				driver.quit();
	}
	
	@Test
	public void interagirComRadiuButtom() {
		// pegar o radiuButtom
		
				WebDriver driver = new FirefoxDriver();
		        driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://127.0.0.1:5500/componentes.html");
				
				driver.findElement(By.id("elementosForm:sexo:0")).click();
				Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
				
				driver.quit();
	}
	
	@Test
	public void interagirComTextBox() {
		// pegar o textBox
		
				WebDriver driver = new FirefoxDriver();
		        driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://127.0.0.1:5500/componentes.html");
				
				driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
				//Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
				
				driver.quit();
	}
	
	
	@Test
	public void interagirComComboBox() {
		// pegar o ComboBox
		
				WebDriver driver = new FirefoxDriver();
		        driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://127.0.0.1:5500/componentes.html");
				
				WebElement element =  driver.findElement(By.id("elementosForm:escolaridade"));
			    Select combo = new Select(element);
			    //combo.selectByIndex(5);
			    //combo.selectByValue("superior");
			    combo.selectByVisibleText("2o grau completo");
			    
			    Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
			    		
				driver.quit();
	}
	
	
	@Test
	public void verificarValoresDoComboBox() {
		// verificar os valores do ComboBox
		
				WebDriver driver = new FirefoxDriver();
		        driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://127.0.0.1:5500/componentes.html");
				
				WebElement element =  driver.findElement(By.id("elementosForm:escolaridade"));
			    Select combo = new Select(element);
			    List<WebElement> options = combo.getOptions();
			    
			    Assert.assertEquals(8, options.size());
			    
			    boolean encontrou = false;
			    
			    for(WebElement option: options) {
			    	if (option.getText().equals("Mestrado")) {
			    		encontrou = true;
			    		break;
			    	}
			    }
			    
			    Assert.assertTrue(encontrou);
			    
			    		
				driver.quit();
	}
	
	
	@Test
	public void interagirBotao() {
		// verificar interação com o botão
		
				WebDriver driver = new FirefoxDriver();
		        driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://127.0.0.1:5500/componentes.html");
				
				//driver.findElement(By.id("buttonSimple")).click();
				
				// pode ser assim também:
				WebElement botao = driver.findElement(By.id("buttonSimple"));
				botao.click();
				
				Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
					
				driver.quit();
				
	}
	
	
	@Test
	//@Ignore //essa anotação  serve para ignorar esse teste
	public void testarLink() {
		// testando Link
		
				WebDriver driver = new FirefoxDriver();
		        driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://127.0.0.1:5500/componentes.html");
				
				driver.findElement(By.linkText("Voltar")).click();
				
				Assert.assertEquals("Voltou!", 
						driver.findElement(By.id("resultado")).getText());
				
				// vai falhar o text propositalmente
				//Assert.fail();
				
				driver.quit();
				
	}
	
	
	@Test
	public void buscarTextosNaPagina() {
		// buscando textos na página
		
				WebDriver driver = new FirefoxDriver();
		        driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://127.0.0.1:5500/componentes.html");
				
				//driver.findElement(By.tagName("body"));
				
				// texto da página inteira
				//System.out.println(driver.findElement(By.tagName("body")).getText());
					
				/*Assert.assertTrue(driver.findElement(By.tagName("body"))
						.getText().contains("Campo de Treinamento"));*/
				
				// pegando diretamente pela tag
				Assert.assertTrue(driver.findElement(By.tagName("h3"))
						.getText().contains("Campo de Treinamento"));
				
				Assert.assertEquals("Cuidado onde clica muitas armadilhas...", 
						driver.findElement(By.className("facilAchar")).getText());
				
				
				driver.quit();
				
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
