package injetores;

import applications.ApplicationEmail;
import applications.Consumer;

public class EmailServiceInjector extends InjetorServicoMensagem {
	
	@Override
	public Consumer getConsumidor() {
		this.consumidor = new ApplicationEmail();
		return consumidor;
		
	}
	
	
}
