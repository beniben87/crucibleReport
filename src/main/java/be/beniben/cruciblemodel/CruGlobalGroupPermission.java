package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_GLOBAL_GROUP_PERMISSION database table.
 * 
 */
@Entity
@Table(name="CRU_GLOBAL_GROUP_PERMISSION")
@NamedQuery(name="CruGlobalGroupPermission.findAll", query="SELECT c FROM CruGlobalGroupPermission c")
public class CruGlobalGroupPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruGlobalGroupPermissionPK id;

	public CruGlobalGroupPermission() {
	}

	public CruGlobalGroupPermissionPK getId() {
		return this.id;
	}

	public void setId(CruGlobalGroupPermissionPK id) {
		this.id = id;
	}

}