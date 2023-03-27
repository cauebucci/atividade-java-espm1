package me.caue.atividade.models;

public class Usuario {
	private String nome;
	private String cpf;
	private double tipoTarifa;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getTipoTarifa() {
		return tipoTarifa;
	}
	public void setTipoTarifa(double tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}
	
	
	public void setTipoTarifa(String tipoTarifa) {
		if(tipoTarifa.equalsIgnoreCase("Professor") || tipoTarifa.equalsIgnoreCase("Estudante")) {
			this.tipoTarifa = 2.20;
		}else {
			this.tipoTarifa = 4.40;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		Usuario usuario = (Usuario) obj;
		if(usuario.cpf.equalsIgnoreCase(cpf) || usuario.nome.equalsIgnoreCase(nome)) {
			return true;
		}
		return false;
	}
	
	
}
