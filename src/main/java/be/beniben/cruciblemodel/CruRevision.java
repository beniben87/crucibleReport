package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_REVISION database table.
 * 
 */
@Entity
@Table(name="CRU_REVISION")
@NamedQuery(name="CruRevision.findAll", query="SELECT c FROM CruRevision c")
public class CruRevision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_REVISION_ID")
	private long cruRevisionId;

	@Column(name="CRU_ADDED")
	private BigDecimal cruAdded;

	@Column(name="CRU_AUTHOR_NAME")
	private String cruAuthorName;

	@Column(name="CRU_BINARY")
	private BigDecimal cruBinary;

	@Column(name="CRU_COMMIT_DATE")
	private BigDecimal cruCommitDate;

	@Column(name="CRU_COPIED")
	private BigDecimal cruCopied;

	@Column(name="CRU_CREATE_DATE")
	private BigDecimal cruCreateDate;

	@Column(name="CRU_DELETION")
	private BigDecimal cruDeletion;

	@Column(name="CRU_DETAIL_VERSION")
	private BigDecimal cruDetailVersion;

	@Column(name="CRU_FILE_TYPE")
	private String cruFileType;

	@Column(name="CRU_MODIFIED")
	private BigDecimal cruModified;

	@Column(name="CRU_MOVED")
	private BigDecimal cruMoved;

	@Column(name="CRU_OVERSIZE")
	private BigDecimal cruOversize;

	@Column(name="CRU_REVISION")
	private String cruRevision;

	@Column(name="CRU_REVISION_DISPLAY_NAME")
	private String cruRevisionDisplayName;

	@Column(name="CRU_SOURCE_NAME")
	private String cruSourceName;

	//bi-directional many-to-one association to CruFeindexMsg
	@OneToMany(mappedBy="cruRevision")
	private List<CruFeindexMsg> cruFeindexMsgs;

	//bi-directional many-to-one association to CruFrxRevision
	@OneToMany(mappedBy="cruRevisionBean")
	private List<CruFrxRevision> cruFrxRevisions;

	//bi-directional many-to-one association to CruFrDetail
	@OneToMany(mappedBy="cruRevision")
	private List<CruFrDetail> cruFrDetails;

	//bi-directional many-to-one association to CruPatchRevision
	@OneToMany(mappedBy="cruRevision")
	private List<CruPatchRevision> cruPatchRevisions;

	//bi-directional many-to-one association to CruStoredPath
	@ManyToOne
	@JoinColumn(name="CRU_PATH")
	private CruStoredPath cruStoredPath;

	//bi-directional many-to-one association to CruUploadItem
	@ManyToOne
	@JoinColumn(name="CRU_UPLOAD_ITEM")
	private CruUploadItem cruUploadItemBean;

	public CruRevision() {
	}

	public long getCruRevisionId() {
		return this.cruRevisionId;
	}

	public void setCruRevisionId(long cruRevisionId) {
		this.cruRevisionId = cruRevisionId;
	}

	public BigDecimal getCruAdded() {
		return this.cruAdded;
	}

	public void setCruAdded(BigDecimal cruAdded) {
		this.cruAdded = cruAdded;
	}

	public String getCruAuthorName() {
		return this.cruAuthorName;
	}

	public void setCruAuthorName(String cruAuthorName) {
		this.cruAuthorName = cruAuthorName;
	}

	public BigDecimal getCruBinary() {
		return this.cruBinary;
	}

	public void setCruBinary(BigDecimal cruBinary) {
		this.cruBinary = cruBinary;
	}

	public BigDecimal getCruCommitDate() {
		return this.cruCommitDate;
	}

	public void setCruCommitDate(BigDecimal cruCommitDate) {
		this.cruCommitDate = cruCommitDate;
	}

	public BigDecimal getCruCopied() {
		return this.cruCopied;
	}

	public void setCruCopied(BigDecimal cruCopied) {
		this.cruCopied = cruCopied;
	}

	public BigDecimal getCruCreateDate() {
		return this.cruCreateDate;
	}

	public void setCruCreateDate(BigDecimal cruCreateDate) {
		this.cruCreateDate = cruCreateDate;
	}

	public BigDecimal getCruDeletion() {
		return this.cruDeletion;
	}

	public void setCruDeletion(BigDecimal cruDeletion) {
		this.cruDeletion = cruDeletion;
	}

	public BigDecimal getCruDetailVersion() {
		return this.cruDetailVersion;
	}

	public void setCruDetailVersion(BigDecimal cruDetailVersion) {
		this.cruDetailVersion = cruDetailVersion;
	}

	public String getCruFileType() {
		return this.cruFileType;
	}

	public void setCruFileType(String cruFileType) {
		this.cruFileType = cruFileType;
	}

	public BigDecimal getCruModified() {
		return this.cruModified;
	}

	public void setCruModified(BigDecimal cruModified) {
		this.cruModified = cruModified;
	}

	public BigDecimal getCruMoved() {
		return this.cruMoved;
	}

	public void setCruMoved(BigDecimal cruMoved) {
		this.cruMoved = cruMoved;
	}

	public BigDecimal getCruOversize() {
		return this.cruOversize;
	}

	public void setCruOversize(BigDecimal cruOversize) {
		this.cruOversize = cruOversize;
	}

	public String getCruRevision() {
		return this.cruRevision;
	}

	public void setCruRevision(String cruRevision) {
		this.cruRevision = cruRevision;
	}

	public String getCruRevisionDisplayName() {
		return this.cruRevisionDisplayName;
	}

	public void setCruRevisionDisplayName(String cruRevisionDisplayName) {
		this.cruRevisionDisplayName = cruRevisionDisplayName;
	}

	public String getCruSourceName() {
		return this.cruSourceName;
	}

	public void setCruSourceName(String cruSourceName) {
		this.cruSourceName = cruSourceName;
	}

	public List<CruFeindexMsg> getCruFeindexMsgs() {
		return this.cruFeindexMsgs;
	}

	public void setCruFeindexMsgs(List<CruFeindexMsg> cruFeindexMsgs) {
		this.cruFeindexMsgs = cruFeindexMsgs;
	}

	public CruFeindexMsg addCruFeindexMsg(CruFeindexMsg cruFeindexMsg) {
		getCruFeindexMsgs().add(cruFeindexMsg);
		cruFeindexMsg.setCruRevision(this);

		return cruFeindexMsg;
	}

	public CruFeindexMsg removeCruFeindexMsg(CruFeindexMsg cruFeindexMsg) {
		getCruFeindexMsgs().remove(cruFeindexMsg);
		cruFeindexMsg.setCruRevision(null);

		return cruFeindexMsg;
	}

	public List<CruFrxRevision> getCruFrxRevisions() {
		return this.cruFrxRevisions;
	}

	public void setCruFrxRevisions(List<CruFrxRevision> cruFrxRevisions) {
		this.cruFrxRevisions = cruFrxRevisions;
	}

	public CruFrxRevision addCruFrxRevision(CruFrxRevision cruFrxRevision) {
		getCruFrxRevisions().add(cruFrxRevision);
		cruFrxRevision.setCruRevisionBean(this);

		return cruFrxRevision;
	}

	public CruFrxRevision removeCruFrxRevision(CruFrxRevision cruFrxRevision) {
		getCruFrxRevisions().remove(cruFrxRevision);
		cruFrxRevision.setCruRevisionBean(null);

		return cruFrxRevision;
	}

	public List<CruFrDetail> getCruFrDetails() {
		return this.cruFrDetails;
	}

	public void setCruFrDetails(List<CruFrDetail> cruFrDetails) {
		this.cruFrDetails = cruFrDetails;
	}

	public CruFrDetail addCruFrDetail(CruFrDetail cruFrDetail) {
		getCruFrDetails().add(cruFrDetail);
		cruFrDetail.setCruRevision(this);

		return cruFrDetail;
	}

	public CruFrDetail removeCruFrDetail(CruFrDetail cruFrDetail) {
		getCruFrDetails().remove(cruFrDetail);
		cruFrDetail.setCruRevision(null);

		return cruFrDetail;
	}

	public List<CruPatchRevision> getCruPatchRevisions() {
		return this.cruPatchRevisions;
	}

	public void setCruPatchRevisions(List<CruPatchRevision> cruPatchRevisions) {
		this.cruPatchRevisions = cruPatchRevisions;
	}

	public CruPatchRevision addCruPatchRevision(CruPatchRevision cruPatchRevision) {
		getCruPatchRevisions().add(cruPatchRevision);
		cruPatchRevision.setCruRevision(this);

		return cruPatchRevision;
	}

	public CruPatchRevision removeCruPatchRevision(CruPatchRevision cruPatchRevision) {
		getCruPatchRevisions().remove(cruPatchRevision);
		cruPatchRevision.setCruRevision(null);

		return cruPatchRevision;
	}

	public CruStoredPath getCruStoredPath() {
		return this.cruStoredPath;
	}

	public void setCruStoredPath(CruStoredPath cruStoredPath) {
		this.cruStoredPath = cruStoredPath;
	}

	public CruUploadItem getCruUploadItemBean() {
		return this.cruUploadItemBean;
	}

	public void setCruUploadItemBean(CruUploadItem cruUploadItemBean) {
		this.cruUploadItemBean = cruUploadItemBean;
	}

}