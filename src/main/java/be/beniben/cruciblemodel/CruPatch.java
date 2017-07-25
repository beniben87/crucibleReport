package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_PATCH database table.
 * 
 */
@Entity
@Table(name="CRU_PATCH")
@NamedQuery(name="CruPatch.findAll", query="SELECT c FROM CruPatch c")
public class CruPatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_PATCH_ID")
	private long cruPatchId;

	@Column(name="CRU_ANCHOR_PATH")
	private String cruAnchorPath;

	@Column(name="CRU_ANCHOR_SOURCE")
	private String cruAnchorSource;

	@Column(name="CRU_ANCHORED")
	private BigDecimal cruAnchored;

	@Column(name="CRU_AVAILABLE_FOR_ADD")
	private BigDecimal cruAvailableForAdd;

	@Column(name="CRU_STRIP_COUNT")
	private BigDecimal cruStripCount;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW")
	private CruReview cruReviewBean;

	//bi-directional many-to-one association to CruUploadItem
	@ManyToOne
	@JoinColumn(name="CRU_UPLOAD_ITEM")
	private CruUploadItem cruUploadItemBean;

	//bi-directional many-to-one association to CruPatchRevision
	@OneToMany(mappedBy="cruPatch")
	private List<CruPatchRevision> cruPatchRevisions;

	public CruPatch() {
	}

	public long getCruPatchId() {
		return this.cruPatchId;
	}

	public void setCruPatchId(long cruPatchId) {
		this.cruPatchId = cruPatchId;
	}

	public String getCruAnchorPath() {
		return this.cruAnchorPath;
	}

	public void setCruAnchorPath(String cruAnchorPath) {
		this.cruAnchorPath = cruAnchorPath;
	}

	public String getCruAnchorSource() {
		return this.cruAnchorSource;
	}

	public void setCruAnchorSource(String cruAnchorSource) {
		this.cruAnchorSource = cruAnchorSource;
	}

	public BigDecimal getCruAnchored() {
		return this.cruAnchored;
	}

	public void setCruAnchored(BigDecimal cruAnchored) {
		this.cruAnchored = cruAnchored;
	}

	public BigDecimal getCruAvailableForAdd() {
		return this.cruAvailableForAdd;
	}

	public void setCruAvailableForAdd(BigDecimal cruAvailableForAdd) {
		this.cruAvailableForAdd = cruAvailableForAdd;
	}

	public BigDecimal getCruStripCount() {
		return this.cruStripCount;
	}

	public void setCruStripCount(BigDecimal cruStripCount) {
		this.cruStripCount = cruStripCount;
	}

	public CruReview getCruReviewBean() {
		return this.cruReviewBean;
	}

	public void setCruReviewBean(CruReview cruReviewBean) {
		this.cruReviewBean = cruReviewBean;
	}

	public CruUploadItem getCruUploadItemBean() {
		return this.cruUploadItemBean;
	}

	public void setCruUploadItemBean(CruUploadItem cruUploadItemBean) {
		this.cruUploadItemBean = cruUploadItemBean;
	}

	public List<CruPatchRevision> getCruPatchRevisions() {
		return this.cruPatchRevisions;
	}

	public void setCruPatchRevisions(List<CruPatchRevision> cruPatchRevisions) {
		this.cruPatchRevisions = cruPatchRevisions;
	}

	public CruPatchRevision addCruPatchRevision(CruPatchRevision cruPatchRevision) {
		getCruPatchRevisions().add(cruPatchRevision);
		cruPatchRevision.setCruPatch(this);

		return cruPatchRevision;
	}

	public CruPatchRevision removeCruPatchRevision(CruPatchRevision cruPatchRevision) {
		getCruPatchRevisions().remove(cruPatchRevision);
		cruPatchRevision.setCruPatch(null);

		return cruPatchRevision;
	}

}