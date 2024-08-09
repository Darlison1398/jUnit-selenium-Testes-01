package selenium;

import org.openqa.selenium.WebDriver;

public class CampoTreinamento_Page {

	private Dsl dsl;
	
	public CampoTreinamento_Page(WebDriver driver) {
		dsl = new Dsl(driver);
	}
	
	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}
	
	public void setSobreNome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}
}
