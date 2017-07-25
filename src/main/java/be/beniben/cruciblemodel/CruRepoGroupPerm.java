package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_REPO_GROUP_PERM database table.
 * 
 */
@Entity
@Table(name="CRU_REPO_GROUP_PERM")
@NamedQuery(name="CruRepoGroupPerm.findAll", query="SELECT c FROM CruRepoGroupPerm c")
public class CruRepoGroupPerm implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruRepoGroupPermPK id;

	public CruRepoGroupPerm() {
	}

	public CruRepoGroupPermPK getId() {
		return this.id;
	}

	public void setId(CruRepoGroupPermPK id) {
		this.id = id;
	}

}