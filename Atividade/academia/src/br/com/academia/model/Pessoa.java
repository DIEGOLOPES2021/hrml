package br.com.academia.model;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
	
	private String nome;
	private double peso;
	private double altura;
	private char sexo;
	private NivelDeAtividade  nivelDeAtividade;
	private LocalDate dataNascimento;
	//*set e get nome
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	//*set e get peso
	public  void setPeso(double peso) {
		 this.peso = peso;
	}
	public double getPeso() {
		return this.peso;
	}
	//**set e get altura
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getAltura() {
		return this.altura;
	}
	//**set e get sexo
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void getSexo(char sexo) {
		this.sexo = sexo;
	}
//	**set e get nivelDeAtividade
	public void setNivelDeAtividade(NivelDeAtividade nivelDeAtividade) {
		this.nivelDeAtividade = nivelDeAtividade;
	}
	public NivelDeAtividade getNivelDeAtividade() {
		return nivelDeAtividade;
	}
//	** Data do nascimento
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	//*****   Idade
	public int getIdade() {
		LocalDate hoje = LocalDate.now();
		Period period = Period.between(this.dataNascimento, hoje);
		return period.getYears();
		}
////////////////******* imc ********
	public double getImc() {
		return this.peso / Math.pow(this.altura, 2);
	}
	//***************
	public String getStatusImc () {
		
		if (this.getImc() < 18.5) {
			return "Abaixo do Peso";
		}else if (this.getImc() > 18.5 && this.getImc() < 25) {
			return "Peso Ideal (Parab�ns)";
		}else if (this.getImc() >25 && this.getImc() <29.9) {
			return "Sobrepeso";
		}else if (this.getImc() >29.9 && this.getImc() <34) {
			return "Obesidade grau 1";
		}else if (this.getImc() >34 && this.getImc() <39.9) {
			return "Obesidade grau 2";
		}else {
			return "Obesidade M�rbida";
		}
	}
	////////***
	public double getNcd() {
		double ncd =0;
		if (this.sexo == 'M') {
		
			if (this.getIdade() >= 18 && this.getIdade() < 31 ) {
			ncd = 15.3 * this.peso + 679;
			} else if (this.getIdade() >= 31 && this.getIdade() <= 60 ) {
			ncd = 11.6 * this.peso + 879;
			} else {
			ncd = 13.5 * this.peso + 487;
			}

			// ATIVIDADE FISICA
			if (this.nivelDeAtividade == NivelDeAtividade.LEVE) {
			ncd *= 1.5;
			}
			if (this.nivelDeAtividade == NivelDeAtividade.MODERADO ) {
			ncd *= 1.8;
			}
			if (this.nivelDeAtividade == NivelDeAtividade.INTENSO ) {
			ncd *= 2.1;
			}

		}
		return ncd;
	}
}


		
			
			
			
			
			
