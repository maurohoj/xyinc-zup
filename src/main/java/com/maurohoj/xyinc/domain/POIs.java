package com.maurohoj.xyinc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

//utilização de Serializable afim de persistir a classe POI'S
@Entity
public class POIs implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//utilização da biblioteca "spring-jpa"
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Informe o nome do POI")
	private String nome;
	//basenado-se em um usuário ideal, utilizarei valores inteiros acima de 0
	@Min(value = 0, message = "Informe um valor positivo para X")
	private int coordX;
	@Min(value = 0, message = "Informe um valor positivo para Y")
	private int coordY;
	
	//construtores
	public POIs() {
		
	}

	public POIs(Integer id, String nome, int coordX, int coordY) {
		super();
		this.id = id;
		this.nome = nome;
		this.coordX = coordX;
		this.coordY = coordY;
	}

	//gets and setters 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	//hashCode and equals (only "id")
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POIs other = (POIs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "POIs [id=" + id + ", nome=" + nome + ", coordX=" + coordX + ", coordY=" + coordY + "]";
	}
	
	//Calcula a distância entre 2 pontos de interesse
	public double distanceBetweenPOIs(POIs anotherPOI){
        return Math.sqrt(Math.pow((this.coordX-anotherPOI.getCoordX()), 2) + Math.pow((this.coordY-anotherPOI.getCoordY()), 2));
	}
	
}

