package me.caue.atividade.models;

public class BilheteUnico {
	private int numero;
	private double saldo = 0;
	private double valorDaTarifa;
	private Usuario usuario;
	
	public BilheteUnico(int numero) {
		this.numero = numero;
	}
	
	public BilheteUnico() {
		// TODO Auto-generated constructor stub
	}
	
	public void carregar(double valor) {
		this.saldo += valor;
	}
	
	public void passar() {
		this.saldo -= valorDaTarifa;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setValorDaTarifa(double valorDaTarifa) {
		this.valorDaTarifa = valorDaTarifa;
	}
	
	public double getValorDaTarifa() {
		return valorDaTarifa;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public boolean equals(Object obj) {
		BilheteUnico bilhete = (BilheteUnico) obj;
		if(bilhete.numero == numero) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String msg = "\n";
		
		msg = numero + ": \n   " +
			  "Titular: " + usuario.getNome() + "\n   " +
			  "CPF do Titular: " + usuario.getCpf() + "\n   " + 
			  "Valor da Tarifa: R$" + String.format("%.2f", usuario.getTipoTarifa()) + "\n   " +
			  "Saldo: R$" + String.format("%.2f", saldo) + "\n";
		return msg;
	}
}
 