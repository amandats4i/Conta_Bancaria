package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// CRIAR COLLECTION PARA ARMAZENAR OS DADOS
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// VARIAVEL PARA RECEBER NUMERO DA CONTA
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			conta.get().visualizar(); // Esse "get()" vazio só funciona dentro do Optional, e ele serve pra abrir a
										// "caixinha" do Optional e pegar as infos de lá.
		else
			System.err.println("A conta numero " + numero + " não foi encontrada.\n");

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

		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent()){
			listaContas.set( (listaContas.indexOf(buscaConta.get())), conta);
				System.out.println("A conta numero: " + conta.getNumero() + " foi atualizada com sucesso.\n");
		} else
				System.err.println("A conta numero " + conta.getNumero() + " não foi encontrada.\n");

	}

	@Override
	public void deletar(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			if (listaContas.remove(conta.get()) == true)
				System.out.println("A conta numero: " + numero + " foi excluída com sucesso.\n");
			else
				System.err.println("A conta numero " + numero + " não foi encontrada.\n");

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

	// MÉTODO AUXILIAR QUE VAI GERAR NUMERO DA CONTA AUTOMATICAMENTE

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {

		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}

}
