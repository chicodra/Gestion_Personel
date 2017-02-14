package dtai.gp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries(
{@NamedQuery(name="SANCTION.FINDALL", query="select dts from DetailSanction dts"),
@NamedQuery(name = "SANCTION.FINDBYCODE", query = "select s from DetailSanction s where s.iddetailsanction=:cod")
})
public class DetailSanction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetailsanction;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateSanction;

	private String motif;

	@ManyToOne
	@JoinColumn(name = "typesanction")
	private TypeSanction typesanction;

	@ManyToOne
	@JoinColumn(name = "agent")
	private Agent agent;

	

	public DetailSanction(int iddetailsanction, Date dateSanction,
			String motif, TypeSanction typesanction, Agent agent) {
		super();
		this.iddetailsanction = iddetailsanction;
		this.dateSanction = dateSanction;
		this.motif = motif;
		this.typesanction = typesanction;
		this.agent = agent;
	}

	public DetailSanction() {
		super();
	}

	public int getIddetailsanction() {
		return iddetailsanction;
	}

	public void setIddetailsanction(int iddetailsanction) {
		this.iddetailsanction = iddetailsanction;
	}

	public java.util.Date getDateSanction() {
		return dateSanction;
	}

	public void setDateSanction(java.util.Date dateSanction) {
		this.dateSanction = dateSanction;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}


	public TypeSanction getTypesanction() {
		return typesanction;
	}

	public void setTypesanction(TypeSanction typesanction) {
		this.typesanction = typesanction;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
