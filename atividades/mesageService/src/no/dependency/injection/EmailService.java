package no.dependency.injection;

import no.dependency.injection.interfaces.MessageHandler;

/**
 * Classe contém a lógica para enviar uma mensagem de e-mail para o endereço de e-mail do destinatário.
 * @author alexs
 *
 */
public class EmailService implements MessageHandler {
	
	@Override
	public void processMessages(String message, String receiver){
		// Neste ponto teríamos a lógica (conjunto de instruções) para enviar um email
		System.out.println("Email sent to "+receiver+ " with Message="+message);
	}
}
