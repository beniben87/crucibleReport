package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_COMMENT_FIELD database table.
 * 
 */
@Embeddable
public class CruCommentFieldPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_COMMENT_ID", insertable=false, updatable=false)
	private long cruCommentId;

	@Column(name="CRU_FIELD_ORDER")
	private long cruFieldOrder;

	public CruCommentFieldPK() {
	}
	public long getCruCommentId() {
		return this.cruCommentId;
	}
	public void setCruCommentId(long cruCommentId) {
		this.cruCommentId = cruCommentId;
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
		if (!(other instanceof CruCommentFieldPK)) {
			return false;
		}
		CruCommentFieldPK castOther = (CruCommentFieldPK)other;
		return 
			(this.cruCommentId == castOther.cruCommentId)
			&& (this.cruFieldOrder == castOther.cruFieldOrder);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruCommentId ^ (this.cruCommentId >>> 32)));
		hash = hash * prime + ((int) (this.cruFieldOrder ^ (this.cruFieldOrder >>> 32)));
		
		return hash;
	}
}