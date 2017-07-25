package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_PS_USER database table.
 * 
 */
@Entity
@Table(name="CRU_PS_USER")
@NamedQuery(name="CruPsUser.findAll", query="SELECT c FROM CruPsUser c")
public class CruPsUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruPsUserPK id;

	//bi-directional many-to-one association to CruPermScheme
	@ManyToOne
	@JoinColumn(name="CRU_PS")
	private CruPermScheme cruPermScheme;

	public CruPsUser() {
	}

	public CruPsUserPK getId() {
		return this.id;
	}

	public void setId(CruPsUserPK id) {
		this.id = id;
	}

	public CruPermScheme getCruPermScheme() {
		return this.cruPermScheme;
	}

	public void setCruPermScheme(CruPermScheme cruPermScheme) {
		this.cruPermScheme = cruPermScheme;
	}

}