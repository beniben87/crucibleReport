package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_PS_REVIEW_ROLE database table.
 * 
 */
@Entity
@Table(name="CRU_PS_REVIEW_ROLE")
@NamedQuery(name="CruPsReviewRole.findAll", query="SELECT c FROM CruPsReviewRole c")
public class CruPsReviewRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruPsReviewRolePK id;

	//bi-directional many-to-one association to CruPermScheme
	@ManyToOne
	@JoinColumn(name="CRU_PS")
	private CruPermScheme cruPermScheme;

	public CruPsReviewRole() {
	}

	public CruPsReviewRolePK getId() {
		return this.id;
	}

	public void setId(CruPsReviewRolePK id) {
		this.id = id;
	}

	public CruPermScheme getCruPermScheme() {
		return this.cruPermScheme;
	}

	public void setCruPermScheme(CruPermScheme cruPermScheme) {
		this.cruPermScheme = cruPermScheme;
	}

}