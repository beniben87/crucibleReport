package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_WATCH database table.
 * 
 */
@Entity
@Table(name="CRU_WATCH")
@NamedQuery(name="CruWatch.findAll", query="SELECT c FROM CruWatch c")
public class CruWatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_WATCH_ID")
	private long cruWatchId;

	@Column(name="CRU_CONSTRAINT")
	private String cruConstraint;

	@Column(name="CRU_CSN_LAST_REVISION")
	private BigDecimal cruCsnLastRevision;

	@Column(name="CRU_LAST_CHECKED")
	private BigDecimal cruLastChecked;

	@Column(name="CRU_LAST_REVISION_PATH")
	private String cruLastRevisionPath;

	@Column(name="CRU_LAST_REVISION_REV")
	private String cruLastRevisionRev;

	@Column(name="CRU_PATH")
	private String cruPath;

	@Column(name="CRU_REPOSITORY_NAME")
	private String cruRepositoryName;

	@Column(name="CRU_WATCH_KEY")
	private String cruWatchKey;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruWatch() {
	}

	public long getCruWatchId() {
		return this.cruWatchId;
	}

	public void setCruWatchId(long cruWatchId) {
		this.cruWatchId = cruWatchId;
	}

	public String getCruConstraint() {
		return this.cruConstraint;
	}

	public void setCruConstraint(String cruConstraint) {
		this.cruConstraint = cruConstraint;
	}

	public BigDecimal getCruCsnLastRevision() {
		return this.cruCsnLastRevision;
	}

	public void setCruCsnLastRevision(BigDecimal cruCsnLastRevision) {
		this.cruCsnLastRevision = cruCsnLastRevision;
	}

	public BigDecimal getCruLastChecked() {
		return this.cruLastChecked;
	}

	public void setCruLastChecked(BigDecimal cruLastChecked) {
		this.cruLastChecked = cruLastChecked;
	}

	public String getCruLastRevisionPath() {
		return this.cruLastRevisionPath;
	}

	public void setCruLastRevisionPath(String cruLastRevisionPath) {
		this.cruLastRevisionPath = cruLastRevisionPath;
	}

	public String getCruLastRevisionRev() {
		return this.cruLastRevisionRev;
	}

	public void setCruLastRevisionRev(String cruLastRevisionRev) {
		this.cruLastRevisionRev = cruLastRevisionRev;
	}

	public String getCruPath() {
		return this.cruPath;
	}

	public void setCruPath(String cruPath) {
		this.cruPath = cruPath;
	}

	public String getCruRepositoryName() {
		return this.cruRepositoryName;
	}

	public void setCruRepositoryName(String cruRepositoryName) {
		this.cruRepositoryName = cruRepositoryName;
	}

	public String getCruWatchKey() {
		return this.cruWatchKey;
	}

	public void setCruWatchKey(String cruWatchKey) {
		this.cruWatchKey = cruWatchKey;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}