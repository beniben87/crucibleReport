package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_REVIEW_FIELD database table.
 * 
 */
@Embeddable
public class CruReviewFieldPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_REVIEW_ID", insertable=false, updatable=false)
	private long cruReviewId;

	@Column(name="CRU_FIELD_ORDER")
	private long cruFieldOrder;

	public CruReviewFieldPK() {
	}
	public long getCruReviewId() {
		return this.cruReviewId;
	}
	public void setCruReviewId(long cruReviewId) {
		this.cruReviewId = cruReviewId;
	}
	public long getCruFieldOrder() {
		return this.cruFieldOrder;
	}
	public void setCruFieldOrder(long cruFieldOrder) {
		this.cruFieldOrder = cruFieldOrder;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruReviewFieldPK)) {
			return false;
		}
		CruReviewFieldPK castOther = (CruReviewFieldPK)other;
		return 
			(this.cruReviewId == castOther.cruReviewId)
			&& (this.cruFieldOrder == castOther.cruFieldOrder);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruReviewId ^ (this.cruReviewId >>> 32)));
		hash = hash * prime + ((int) (this.cruFieldOrder ^ (this.cruFieldOrder >>> 32)));
		
		return hash;
	}
}