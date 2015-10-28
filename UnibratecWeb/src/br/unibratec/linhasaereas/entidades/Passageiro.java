package br.unibratec.linhasaereas.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unibratec.entidades.Entidade;

@Entity
public class Passageiro implements Entidade {
	
	@Id
	private String		aCPF;
	
	private String		aNome;
	private String		aEMail;
	
	@Temporal(TemporalType.DATE)
	private Date		aDataNascimento;
	
	@Column(
		name="NM_TESTE",
		length=100,
		unique=true,
		nullable=true,
		//columnDefinition="VARCHAR(45)",
		insertable=true,
		updatable=true,
		precision=2,
		scale=2
	)
	private String testeColuna;
	
	private boolean		aIsPortadorNecessidadesEspeciais;
	
	public Passageiro() {}
	public Passageiro(
		String		aNome,
		String		aCPF, 
		String		aEMail, 
		Date		aDataNascimento,
		boolean		aIsPortadorNecessidadesEspeciais
	) {
		this.aCPF = aCPF;
		this.aNome = aNome;
		this.aEMail = aEMail;
		this.aDataNascimento = aDataNascimento;
		this.aIsPortadorNecessidadesEspeciais = aIsPortadorNecessidadesEspeciais;
	}
	
	public String getCPF() {
		return aCPF;
	}
	public void setCPF(String pCPF) {
		this.aCPF = pCPF;
	}
	public String getNome() {
		return aNome;
	}
	public void setNome(String pNome) {
		this.aNome = pNome;
	}
	public String getEMail() {
		return aEMail;
	}
	public void setEMail(String pEMail) {
		this.aEMail = pEMail;
	}
	public Date getDataNascimento() {
		return aDataNascimento;
	}
	public void setDataNascimento(Date pDataNascimento) {
		this.aDataNascimento = pDataNascimento;
	}
	public boolean isPortadorNecessidadesEspeciais() {
		return aIsPortadorNecessidadesEspeciais;
	}
	public void setIsPortadorNecessidadesEspeciais(boolean pIsPortadorNecessidadesEspeciais) {
		this.aIsPortadorNecessidadesEspeciais = pIsPortadorNecessidadesEspeciais;
	}
	
	@Override
	public Object getChavePrimaria() {
		return getCPF();
	}
	
	
	
}
