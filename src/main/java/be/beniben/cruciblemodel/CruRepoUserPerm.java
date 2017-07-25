package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_REPO_USER_PERM database table.
 * 
 */
@Entity
@Table(name="CRU_REPO_USER_PERM")
@NamedQuery(name="CruRepoUserPerm.findAll", query="SELECT c FROM CruRepoUserPerm c")
public class CruRepoUserPerm implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruRepoUserPermPK id;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruRepoUserPerm() {
	}

	public CruRepoUserPermPK getId() {
		return this.id;
	}

	public void setId(CruRepoUserPermPK id) {
		this.id = id;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}