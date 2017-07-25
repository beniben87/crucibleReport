package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_PS_ANON database table.
 * 
 */
@Entity
@Table(name="CRU_PS_ANON")
@NamedQuery(name="CruPsAnon.findAll", query="SELECT c FROM CruPsAnon c")
public class CruPsAnon implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruPsAnonPK id;

	//bi-directional many-to-one association to CruPermScheme
	@ManyToOne
	@JoinColumn(name="CRU_PS")
	private CruPermScheme cruPermScheme;

	public CruPsAnon() {
	}

	public CruPsAnonPK getId() {
		return this.id;
	}

	public void setId(CruPsAnonPK id) {
		this.id = id;
	}

	public CruPermScheme getCruPermScheme() {
		return this.cruPermScheme;
	}

	public void setCruPermScheme(CruPermScheme cruPermScheme) {
		this.cruPermScheme = cruPermScheme;
	}

}