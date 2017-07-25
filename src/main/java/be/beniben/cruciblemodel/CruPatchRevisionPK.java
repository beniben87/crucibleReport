package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_PATCH_REVISION database table.
 * 
 */
@Embeddable
public class CruPatchRevisionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_PATCH_ID", insertable=false, updatable=false)
	private long cruPatchId;

	@Column(name="CRU_REVISION_ORDER")
	private long cruRevisionOrder;

	public CruPatchRevisionPK() {
	}
	public long getCruPatchId() {
		return this.cruPatchId;
	}
	public void setCruPatchId(long cruPatchId) {
		this.cruPatchId = cruPatchId;
	}
	public long getCruRevisionOrder() {
		return this.cruRevisionOrder;
	}
	public void setCruRevisionOrder(long cruRevisionOrder) {
		this.cruRevisionOrder = cruRevisionOrder;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruPatchRevisionPK)) {
			return false;
		}
		CruPatchRevisionPK castOther = (CruPatchRevisionPK)other;
		return 
			(this.cruPatchId == castOther.cruPatchId)
			&& (this.cruRevisionOrder == castOther.cruRevisionOrder);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruPatchId ^ (this.cruPatchId >>> 32)));
		hash = hash * prime + ((int) (this.cruRevisionOrder ^ (this.cruRevisionOrder >>> 32)));
		
		return hash;
	}
}