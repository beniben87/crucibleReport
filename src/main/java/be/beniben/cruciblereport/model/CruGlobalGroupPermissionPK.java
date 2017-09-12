package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CRU_GLOBAL_GROUP_PERMISSION database table.
 * 
 */
@Embeddable
public class CruGlobalGroupPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_GROUP_NAME")
	private String cruGroupName;

	@Column(name="CRU_GLOBAL_PERMISSION")
	private String cruGlobalPermission;

	public CruGlobalGroupPermissionPK() {
	}
	public String getCruGroupName() {
		return this.cruGroupName;
	}
	public void setCruGroupName(String cruGroupName) {
		this.cruGroupName = cruGroupName;
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
		if (!(other instanceof CruGlobalGroupPermissionPK)) {
			return false;
		}
		CruGlobalGroupPermissionPK castOther = (CruGlobalGroupPermissionPK)other;
		return 
			this.cruGroupName.equals(castOther.cruGroupName)
			&& this.cruGlobalPermission.equals(castOther.cruGlobalPermission);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cruGroupName.hashCode();
		hash = hash * prime + this.cruGlobalPermission.hashCode();
		
		return hash;
	}
}