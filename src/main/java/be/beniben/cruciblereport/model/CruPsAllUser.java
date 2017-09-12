package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_PS_ALL_USER database table.
 * 
 */
@Entity
@Table(name="CRU_PS_ALL_USER")
@NamedQuery(name="CruPsAllUser.findAll", query="SELECT c FROM CruPsAllUser c")
public class CruPsAllUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruPsAllUserPK id;

	//bi-directional many-to-one association to CruPermScheme
	@ManyToOne
	@JoinColumn(name="CRU_PS")
	private CruPermScheme cruPermScheme;

	public CruPsAllUser() {
	}

	public CruPsAllUserPK getId() {
		return this.id;
	}

	public void setId(CruPsAllUserPK id) {
		this.id = id;
	}

	public CruPermScheme getCruPermScheme() {
		return this.cruPermScheme;
	}

	public void setCruPermScheme(CruPermScheme cruPermScheme) {
		this.cruPermScheme = cruPermScheme;
	}

}