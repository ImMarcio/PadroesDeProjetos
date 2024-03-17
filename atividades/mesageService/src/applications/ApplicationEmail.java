package applications;

import no.dependency.injection.EmailService;
import no.dependency.injection.interfaces.MessageHandler;

/**
 * O código de cliente que usará a classe Application para enviar mensagens de e-mail será como abaixo.
 * @author alexs
 *
 */
public class ApplicationEmail implements Consumer {
	// classe está responsável por criar e inicializar o serviço de e-mail, para posteriormente utilizá-lo.
	// Isso leva à "dependência codificada"
	private MessageHandler servico = new EmailService();
	public void processMessages(String msg, String rec){
		//aqui teríamos algumas mensagens de validação, manipulação da lógica, etc.
		this.servico.processMessages(msg, rec);
	}

}


