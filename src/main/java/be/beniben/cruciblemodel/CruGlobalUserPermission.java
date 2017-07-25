package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_GLOBAL_USER_PERMISSION database table.
 * 
 */
@Entity
@Table(name="CRU_GLOBAL_USER_PERMISSION")
@NamedQuery(name="CruGlobalUserPermission.findAll", query="SELECT c FROM CruGlobalUserPermission c")
public class CruGlobalUserPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruGlobalUserPermissionPK id;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruGlobalUserPermission() {
	}

	public CruGlobalUserPermissionPK getId() {
		return this.id;
	}

	public void setId(CruGlobalUserPermissionPK id) {
		this.id = id;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}