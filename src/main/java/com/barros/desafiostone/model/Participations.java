package com.barros.desafiostone.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Participations implements Serializable {

	private static final long serialVersionUID = -2167364244939792184L;

	@JsonProperty(value = "participacoes")
	private List<EmployeeParticipation> participations;

	@JsonProperty(value = "total_de_funcionarios")
	private Integer totalStaff;

	@JsonProperty(value = "total_distribuido")
	private BigDecimal totalDistributed;

	@JsonProperty(value = "total_disponibilizado")
	private BigDecimal totalAvailable;

	@JsonProperty(value = "saldo_total_disponibilizado")
	private BigDecimal totalBalanceAvailable;

	public List<EmployeeParticipation> getParticipations() {
		return this.participations;
	}

	public void setParticipations(List<EmployeeParticipation> participations) {
		this.participations = participations;
	}

	public Integer getTotalStaff() {
		return this.totalStaff;
	}

	public void setTotalStaff(Integer totalStaff) {
		this.totalStaff = totalStaff;
	}

	public BigDecimal getTotalDistributed() {
		return this.totalDistributed;
	}

	public void setTotalDistributed(BigDecimal totalDistributed) {
		this.totalDistributed = totalDistributed;
	}

	public BigDecimal getTotalAvailable() {
		return this.totalAvailable;
	}

	public void setTotalAvailable(BigDecimal totalAvailable) {
		this.totalAvailable = totalAvailable;
	}

	public BigDecimal getTotalBalanceAvailable() {
		return this.totalBalanceAvailable;
	}

	public void setTotalBalanceAvailable(BigDecimal totalBalanceAvailable) {
		this.totalBalanceAvailable = totalBalanceAvailable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.participations == null ? 0 : this.participations.hashCode());
		result = prime * result + (this.totalAvailable == null ? 0 : this.totalAvailable.hashCode());
		result = prime * result + (this.totalBalanceAvailable == null ? 0 : this.totalBalanceAvailable.hashCode());
		result = prime * result + (this.totalDistributed == null ? 0 : this.totalDistributed.hashCode());
		result = prime * result + (this.totalStaff == null ? 0 : this.totalStaff.hashCode());
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
		Participations other = (Participations) obj;
		if (this.participations == null) {
			if (other.participations != null) {
				return false;
			}
		} else if (!this.participations.equals(other.participations)) {
			return false;
		}
		if (this.totalAvailable == null) {
			if (other.totalAvailable != null) {
				return false;
			}
		} else if (!this.totalAvailable.equals(other.totalAvailable)) {
			return false;
		}
		if (this.totalBalanceAvailable == null) {
			if (other.totalBalanceAvailable != null) {
				return false;
			}
		} else if (!this.totalBalanceAvailable.equals(other.totalBalanceAvailable)) {
			return false;
		}
		if (this.totalDistributed == null) {
			if (other.totalDistributed != null) {
				return false;
			}
		} else if (!this.totalDistributed.equals(other.totalDistributed)) {
			return false;
		}
		if (this.totalStaff == null) {
			if (other.totalStaff != null) {
				return false;
			}
		} else if (!this.totalStaff.equals(other.totalStaff)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final int maxLen = 3;
		StringBuilder builder = new StringBuilder();
		builder.append("Participations [");
		if (this.participations != null) {
			builder.append("participations=");
			builder.append(this.participations.subList(0, Math.min(this.participations.size(), maxLen)));
			builder.append(", ");
		}
		if (this.totalStaff != null) {
			builder.append("totalStaff=");
			builder.append(this.totalStaff);
			builder.append(", ");
		}
		if (this.totalDistributed != null) {
			builder.append("totalDistributed=");
			builder.append(this.totalDistributed);
			builder.append(", ");
		}
		if (this.totalAvailable != null) {
			builder.append("totalAvailable=");
			builder.append(this.totalAvailable);
			builder.append(", ");
		}
		if (this.totalBalanceAvailable != null) {
			builder.append("totalBalanceAvailable=");
			builder.append(this.totalBalanceAvailable);
		}
		builder.append("]");
		return builder.toString();
	}

}
