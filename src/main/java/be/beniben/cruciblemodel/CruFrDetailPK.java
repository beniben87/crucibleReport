package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_FR_DETAIL database table.
 * 
 */
@Embeddable
public class CruFrDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_REVISION_ID", insertable=false, updatable=false)
	private long cruRevisionId;

	@Column(name="CRU_NAME")
	private String cruName;

	public CruFrDetailPK() {
	}
	public long getCruRevisionId() {
		return this.cruRevisionId;
	}
	public void setCruRevisionId(long cruRevisionId) {
		this.cruRevisionId = cruRevisionId;
	}
	public String getCruName() {
		return this.cruName;
	}
	public void setCruName(String cruName) {
		this.cruName = cruName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruFrDetailPK)) {
			return false;
		}
		CruFrDetailPK castOther = (CruFrDetailPK)other;
		return 
			(this.cruRevisionId == castOther.cruRevisionId)
			&& this.cruName.equals(castOther.cruName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruRevisionId ^ (this.cruRevisionId >>> 32)));
		hash = hash * prime + this.cruName.hashCode();
		
		return hash;
	}
}