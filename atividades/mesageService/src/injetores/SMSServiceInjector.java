package injetores;

import applications.ApplicationSms;
import applications.Consumer;

public class SMSServiceInjector extends InjetorServicoMensagem {

	@Override
	public Consumer getConsumidor() {
		this.consumidor = new ApplicationSms();
		return consumidor;
		
	}
	
}
