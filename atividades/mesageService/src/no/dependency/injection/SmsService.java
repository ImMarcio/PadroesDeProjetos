package no.dependency.injection;

import no.dependency.injection.interfaces.MessageHandler;

public class SmsService implements MessageHandler{
	
	
	@Override
	public void processMessages(String message, String receiver){
		// Neste ponto teríamos a lógica (conjunto de instruções) para enviar um email
		System.out.println("Email sent to "+receiver+ " with Message="+message);
	}
}
