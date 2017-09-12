package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_PS_GROUP database table.
 * 
 */
@Entity
@Table(name="CRU_PS_GROUP")
@NamedQuery(name="CruPsGroup.findAll", query="SELECT c FROM CruPsGroup c")
public class CruPsGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruPsGroupPK id;

	//bi-directional many-to-one association to CruPermScheme
	@ManyToOne
	@JoinColumn(name="CRU_PS")
	private CruPermScheme cruPermScheme;

	public CruPsGroup() {
	}

	public CruPsGroupPK getId() {
		return this.id;
	}

	public void setId(CruPsGroupPK id) {
		this.id = id;
	}

	public CruPermScheme getCruPermScheme() {
		return this.cruPermScheme;
	}

	public void setCruPermScheme(CruPermScheme cruPermScheme) {
		this.cruPermScheme = cruPermScheme;
	}

}