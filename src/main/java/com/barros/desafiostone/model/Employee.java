package com.barros.desafiostone.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.barros.desafiostone.util.serialize.MoneyDeserializer;
import com.barros.desafiostone.util.serialize.MoneySerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;

@FirebaseDocument("/Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 8886872789257163141L;
	
	@FirebaseId
	@JsonProperty(value = "matricula")
	private String matricula;
	
    private String nome;
    
    private String area;
    
    private String cargo;
    
    @JsonDeserialize(using = MoneyDeserializer.class)
    @JsonSerialize(using = MoneySerializer.class)
    @JsonProperty(value = "salario_bruto")
    private BigDecimal salarioBruto;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonProperty(value = "data_de_admissao")
    private LocalDate dataAdmissao;
    
	public Employee() {
		super();
	}

	public Employee(String matricula, String nome, String area, String cargo, BigDecimal salarioBruto,
			LocalDate dataAdmissao) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.area = area;
		this.cargo = cargo;
		this.salarioBruto = salarioBruto;
		this.dataAdmissao = dataAdmissao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(BigDecimal salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salarioBruto == null) ? 0 : salarioBruto.hashCode());
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
		Employee other = (Employee) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salarioBruto == null) {
			if (other.salarioBruto != null)
				return false;
		} else if (!salarioBruto.equals(other.salarioBruto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [matricula=");
		builder.append(matricula);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", area=");
		builder.append(area);
		builder.append(", cargo=");
		builder.append(cargo);
		builder.append(", salarioBruto=");
		builder.append(salarioBruto);
		builder.append(", dataAdmissao=");
		builder.append(dataAdmissao);
		builder.append("]");
		return builder.toString();
	}

}
