package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_PATCH_REVISION database table.
 * 
 */
@Entity
@Table(name="CRU_PATCH_REVISION")
@NamedQuery(name="CruPatchRevision.findAll", query="SELECT c FROM CruPatchRevision c")
public class CruPatchRevision implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruPatchRevisionPK id;

	//bi-directional many-to-one association to CruPatch
	@ManyToOne
	@JoinColumn(name="CRU_PATCH_ID")
	private CruPatch cruPatch;

	//bi-directional many-to-one association to CruRevision
	@ManyToOne
	@JoinColumn(name="CRU_REVISION_ID")
	private CruRevision cruRevision;

	public CruPatchRevision() {
	}

	public CruPatchRevisionPK getId() {
		return this.id;
	}

	public void setId(CruPatchRevisionPK id) {
		this.id = id;
	}

	public CruPatch getCruPatch() {
		return this.cruPatch;
	}

	public void setCruPatch(CruPatch cruPatch) {
		this.cruPatch = cruPatch;
	}

	public CruRevision getCruRevision() {
		return this.cruRevision;
	}

	public void setCruRevision(CruRevision cruRevision) {
		this.cruRevision = cruRevision;
	}

}