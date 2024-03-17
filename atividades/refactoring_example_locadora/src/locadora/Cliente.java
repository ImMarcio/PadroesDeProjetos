package locadora;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	private String nome;
	private List<Aluguel> dvdsAlugados = new ArrayList<Aluguel>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaAluguel(Aluguel aluguel) {
			
		dvdsAlugados.add(aluguel);
	}



	
	public double calcularValorAluguel(Aluguel aluguel) {
		double valorCorrente = 0.0;
		Aluguel aluguelPesquisado = this.dvdsAlugados.get(this.dvdsAlugados.indexOf(aluguel));
		if(aluguelPesquisado != null) {
			// determina valores para cada linha
			switch(aluguelPesquisado.getDVD().getCódigoDePreço()) {
			case DVD.NORMAL: // R$ 2.00 por 2 dias. O dia adicional acrescenta R$ 1.50
				valorCorrente += 2.0;
				if(aluguelPesquisado.getDiasAlugado() > 2) {
					valorCorrente += (aluguelPesquisado.getDiasAlugado() - 2) * 1.5;
				}
				break;

			case DVD.LANÇAMENTO: // R$ 3.00 por dia
				valorCorrente += aluguelPesquisado.getDiasAlugado() * 3.00;
				break;

			case DVD.INFANTIL: // R$ 1.50 por 3 dias. O dia adicional acrescenta R$ 1.50 
				valorCorrente += 1.5;

				if(aluguelPesquisado.getDiasAlugado() > 3) {
					valorCorrente += (aluguelPesquisado.getDiasAlugado() - 3) * 1.5;
				}
				break;
			} //switch
		}
		
		return valorCorrente;
	}
	public int calcularPontos() {
		int pontosDeAlugadorFrequente = 0;
		
		pontosDeAlugadorFrequente++;
		
		for(Aluguel aluguel : dvdsAlugados) {
			pontosDeAlugadorFrequente++;
			
			if(aluguel.getDVD().getCódigoDePreço() == DVD.LANÇAMENTO &&
					aluguel.getDiasAlugado() > 1) {
					pontosDeAlugadorFrequente++;
				}
		}
		
		// adiciona bonus para aluguel de um lançamento por pelo menos 2 dias
		
		return pontosDeAlugadorFrequente;

	}
	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
		 
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;
		pontosDeAlugadorFrequente = this.calcularPontos();
		
		for(Aluguel aluguel : dvdsAlugados) {
			
			resultado += "\t" + aluguel.getDVD().getTitulo() + "\t R$ " + this.calcularValorAluguel(aluguel) + fimDeLinha;
			valorTotal += this.calcularValorAluguel(aluguel);
		}
		
		resultado += "Valor total pago: R$ " + valorTotal + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente +
              " pontos de alugador frequente";

		return resultado;
	}

}