package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	//CRIAR COLLECTION PARA ARMAZENAR OS DADOS
	private ArrayList <Conta> listaContas = new ArrayList<Conta> ();
	
	// VARIAVEL PARA RECEBER NUMERO DA CONTA
	int numero = 0;
	

	@Override
	public void procurarPorNumero(int numero) {
		
		
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A Conta número: " + conta.getNumero() + " foi criada com sucesso.");
		
	}

	@Override
	public void atualizar(Conta conta) {
		
		
	}

	@Override
	public void deletar(int numero) {
		
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		
	}
	
	// MÉTODOS AUXILIARES
	
	public int gerarNumero () {
		return ++ numero;
	}

}
