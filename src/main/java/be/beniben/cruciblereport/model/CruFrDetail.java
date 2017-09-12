package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_FR_DETAIL database table.
 * 
 */
@Entity
@Table(name="CRU_FR_DETAIL")
@NamedQuery(name="CruFrDetail.findAll", query="SELECT c FROM CruFrDetail c")
public class CruFrDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruFrDetailPK id;

	@Lob
	@Column(name="CRU_VALUE")
	private String cruValue;

	//bi-directional many-to-one association to CruRevision
	@ManyToOne
	@JoinColumn(name="CRU_REVISION_ID")
	private CruRevision cruRevision;

	public CruFrDetail() {
	}

	public CruFrDetailPK getId() {
		return this.id;
	}

	public void setId(CruFrDetailPK id) {
		this.id = id;
	}

	public String getCruValue() {
		return this.cruValue;
	}

	public void setCruValue(String cruValue) {
		this.cruValue = cruValue;
	}

	public CruRevision getCruRevision() {
		return this.cruRevision;
	}

	public void setCruRevision(CruRevision cruRevision) {
		this.cruRevision = cruRevision;
	}

}