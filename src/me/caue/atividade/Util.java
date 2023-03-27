package me.caue.atividade;

import java.util.Random;

import me.caue.atividade.models.BilheteUnico;
import me.caue.atividade.models.Usuario;
import me.caue.listaduplagenerica.Lista;

public class Util {
	static Random random = new Random();
	
	private static Lista<Usuario> usuarios = new Lista<Usuario>();
	private static Lista<BilheteUnico> bilhetes = new Lista<BilheteUnico>();
	
	public static boolean gerarBilhete(String nome, String cpf, String tipoTarifa) {
		
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setTipoTarifa(tipoTarifa);
		
		
		int n = random.nextInt(100, 5000);
		
		boolean repete = true;
		do {
			if(bilhetes.pesquisar(new BilheteUnico(n)) == null) {
				repete = false;
			}else {
				n = random.nextInt(100, 5000);
				repete = true;
			}
		} while (repete);
		
		BilheteUnico bilhete = new BilheteUnico();
		
		bilhete.setNumero(n);
		
		bilhete.setValorDaTarifa(usuario.getTipoTarifa());
		
		bilhete.setUsuario(usuario);
		
		if(usuarios.pesquisar(usuario) == null) {
			usuarios.inserirFim(usuario);
			bilhetes.inserirFim(bilhete);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public static boolean cadastrarUsuario(String nome, String cpf, String tipoTarifa) {
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setTipoTarifa(tipoTarifa);
		
		if(usuarios.pesquisar(usuario) == null) {
			usuarios.inserirFim(usuario);
			return true;
		}else {
			return false;
		}

		
		
	}
	
	public static String listarBilhetes() {
		if(bilhetes.getTamanho() == 0) {
			return "Nenhum bilhete cadastrado!";
		}else {
			return bilhetes.imprimir();
		}
	}
	
	public static String pesquisarBilhete(int n) {
		if(bilhetes.pesquisar(new BilheteUnico(n)) == null) {
			return "Esse bilhete único não existe!";
		}else {
			return bilhetes.pesquisarDados(new BilheteUnico(n));
		}

	}
	
	public static boolean BilheteExistente(String ns) {
		int n = Integer.parseInt(ns);
		if(bilhetes.pesquisar(new BilheteUnico(n)) == null) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public static String consultarSaldo(int n) {
		BilheteUnico bilhete = bilhetes.pesquisarDados2(new BilheteUnico(n));
		
		return "R$" +  String.format("%.2f", bilhete.getSaldo());
		
	}
	
	public static void carregar(int n, double v) {
		BilheteUnico bilhete = bilhetes.pesquisarDados2(new BilheteUnico(n));
		
		bilhete.carregar(v);
	}
	
	public static boolean passarCatraca(int n) {
		BilheteUnico bilhete = bilhetes.pesquisarDados2(new BilheteUnico(n));
		
		if(bilhete.getSaldo() > bilhete.getValorDaTarifa()) {
			bilhete.passar();
			return true;
		}else {
			return false;
		}
	}
	
}
