
package com.barros.desafiostone.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.barros.desafiostone.util.serialize.MoneySerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class EmployeeParticipation implements Serializable {

	private static final long serialVersionUID = -3654559384136747106L;

	private String matricula;

	private String nome;

	@JsonProperty(value = "valor_da_participacao")
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal totalParticipation;

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTotalParticipation() {
		return this.totalParticipation;
	}

	public void setTotalParticipation(BigDecimal totalParticipation) {
		this.totalParticipation = totalParticipation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.matricula == null ? 0 : this.matricula.hashCode());
		result = prime * result + (this.nome == null ? 0 : this.nome.hashCode());
		result = prime * result + (this.totalParticipation == null ? 0 : this.totalParticipation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		EmployeeParticipation other = (EmployeeParticipation) obj;
		if (this.matricula == null) {
			if (other.matricula != null) {
				return false;
			}
		} else if (!this.matricula.equals(other.matricula)) {
			return false;
		}
		if (this.nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!this.nome.equals(other.nome)) {
			return false;
		}
		if (this.totalParticipation == null) {
			if (other.totalParticipation != null) {
				return false;
			}
		} else if (!this.totalParticipation.equals(other.totalParticipation)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeParticipation [");
		if (this.matricula != null) {
			builder.append("matricula=");
			builder.append(this.matricula);
			builder.append(", ");
		}
		if (this.nome != null) {
			builder.append("nome=");
			builder.append(this.nome);
			builder.append(", ");
		}
		if (this.totalParticipation != null) {
			builder.append("totalParticipation=");
			builder.append(this.totalParticipation);
		}
		builder.append("]");
		return builder.toString();
	}

}
