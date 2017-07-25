package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CRU_STORED_PATH database table.
 * 
 */
@Entity
@Table(name="CRU_STORED_PATH")
@NamedQuery(name="CruStoredPath.findAll", query="SELECT c FROM CruStoredPath c")
public class CruStoredPath implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_PATH_ID")
	private long cruPathId;

	@Column(name="CRU_HASH")
	private String cruHash;

	@Column(name="CRU_PATH")
	private String cruPath;

	//bi-directional many-to-one association to CruRevision
	@OneToMany(mappedBy="cruStoredPath")
	private List<CruRevision> cruRevisions;

	public CruStoredPath() {
	}

	public long getCruPathId() {
		return this.cruPathId;
	}

	public void setCruPathId(long cruPathId) {
		this.cruPathId = cruPathId;
	}

	public String getCruHash() {
		return this.cruHash;
	}

	public void setCruHash(String cruHash) {
		this.cruHash = cruHash;
	}

	public String getCruPath() {
		return this.cruPath;
	}

	public void setCruPath(String cruPath) {
		this.cruPath = cruPath;
	}

	public List<CruRevision> getCruRevisions() {
		return this.cruRevisions;
	}

	public void setCruRevisions(List<CruRevision> cruRevisions) {
		this.cruRevisions = cruRevisions;
	}

	public CruRevision addCruRevision(CruRevision cruRevision) {
		getCruRevisions().add(cruRevision);
		cruRevision.setCruStoredPath(this);

		return cruRevision;
	}

	public CruRevision removeCruRevision(CruRevision cruRevision) {
		getCruRevisions().remove(cruRevision);
		cruRevision.setCruStoredPath(null);

		return cruRevision;
	}

}