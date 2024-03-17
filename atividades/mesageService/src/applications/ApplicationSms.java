package applications;

import no.dependency.injection.SmsService;
import no.dependency.injection.interfaces.MessageHandler;

public class ApplicationSms implements Consumer{

	
	private MessageHandler servico = new SmsService();
	public void processMessages(String msg, String rec){
		//aqui teríamos algumas mensagens de validação, manipulação da lógica, etc.
		this.servico.processMessages(msg, rec);
	}
}
