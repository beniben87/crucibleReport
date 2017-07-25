package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_GLOBAL_USER_PERMISSION database table.
 * 
 */
@Embeddable
public class CruGlobalUserPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_USER_ID", insertable=false, updatable=false)
	private long cruUserId;

	@Column(name="CRU_GLOBAL_PERMISSION")
	private String cruGlobalPermission;

	public CruGlobalUserPermissionPK() {
	}
	public long getCruUserId() {
		return this.cruUserId;
	}
	public void setCruUserId(long cruUserId) {
		this.cruUserId = cruUserId;
	}
	public String getCruGlobalPermission() {
		return this.cruGlobalPermission;
	}
	public void setCruGlobalPermission(String cruGlobalPermission) {
		this.cruGlobalPermission = cruGlobalPermission;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CruGlobalUserPermissionPK)) {
			return false;
		}
		CruGlobalUserPermissionPK castOther = (CruGlobalUserPermissionPK)other;
		return 
			(this.cruUserId == castOther.cruUserId)
			&& this.cruGlobalPermission.equals(castOther.cruGlobalPermission);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cruUserId ^ (this.cruUserId >>> 32)));
		hash = hash * prime + this.cruGlobalPermission.hashCode();
		
		return hash;
	}
}