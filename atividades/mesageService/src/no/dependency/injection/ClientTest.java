package no.dependency.injection;

import applications.Consumer;
import injetores.EmailServiceInjector;
import injetores.InjetorServicoMensagem;
import injetores.SMSServiceInjector;

public class ClientTest {
	public static void main(String[] args) {
//		ApplicationEmail app = new ApplicationEmail();
//		app.processMessages("Ola Alex! Mostra um exemplo de DI.", "alex@ifpb.edu.br");
		String mensagem = "Ola Alex! Mostra um exemplo de DI.";
		String email = "alex@ifpb.edu.br";
		String telefone = "83988889999";
		// Declarando o injetor de dependência para a classe consumidora
		InjetorServicoMensagem injector = null;
		Consumer app;

		//Enviando mensagem por email: criando o Injetor concreto de
		// serviço por email
		injector = new EmailServiceInjector();
		app = injector.getConsumidor(); // Obtendo um consumidor compatível
		app.processMessages(mensagem, email); // Envia a mensagem
		//Enviando mensagem por SMS: criando o Injetor concreto
		injector = new SMSServiceInjector();
		app = injector.getConsumidor();
		app.processMessages(mensagem, telefone);
		
		
		
	}
}
