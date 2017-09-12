package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_FRX database table.
 * 
 */
@Entity
@Table(name="CRU_FRX")
@NamedQuery(name="CruFrx.findAll", query="SELECT c FROM CruFrx c")
public class CruFrx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_FRX_ID")
	private long cruFrxId;

	@Column(name="CRU_FRX_ORDER")
	private BigDecimal cruFrxOrder;

	@Column(name="CRU_FURTHER_ACTION")
	private BigDecimal cruFurtherAction;

	@Column(name="CRU_REVIEW_SCOPE")
	private BigDecimal cruReviewScope;

	@Column(name="CRU_REVIEWED")
	private BigDecimal cruReviewed;

	@Column(name="CRU_SHOW_AS_DIFF")
	private BigDecimal cruShowAsDiff;

	@Column(name="CRU_WHEN_ADDED")
	private BigDecimal cruWhenAdded;

	//bi-directional many-to-one association to CruFileReadStatus
	@OneToMany(mappedBy="cruFrxBean")
	private List<CruFileReadStatus> cruFileReadStatuses;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW_ID")
	private CruReview cruReview;

	//bi-directional many-to-one association to CruFrxComment
	@OneToMany(mappedBy="cruFrx")
	private List<CruFrxComment> cruFrxComments;

	//bi-directional many-to-one association to CruFrxRevision
	@OneToMany(mappedBy="cruFrx")
	private List<CruFrxRevision> cruFrxRevisions;

	//bi-directional many-to-one association to CruInlineComment
	@OneToMany(mappedBy="cruFrx")
	private List<CruInlineComment> cruInlineComments;

	public CruFrx() {
	}

	public long getCruFrxId() {
		return this.cruFrxId;
	}

	public void setCruFrxId(long cruFrxId) {
		this.cruFrxId = cruFrxId;
	}

	public BigDecimal getCruFrxOrder() {
		return this.cruFrxOrder;
	}

	public void setCruFrxOrder(BigDecimal cruFrxOrder) {
		this.cruFrxOrder = cruFrxOrder;
	}

	public BigDecimal getCruFurtherAction() {
		return this.cruFurtherAction;
	}

	public void setCruFurtherAction(BigDecimal cruFurtherAction) {
		this.cruFurtherAction = cruFurtherAction;
	}

	public BigDecimal getCruReviewScope() {
		return this.cruReviewScope;
	}

	public void setCruReviewScope(BigDecimal cruReviewScope) {
		this.cruReviewScope = cruReviewScope;
	}

	public BigDecimal getCruReviewed() {
		return this.cruReviewed;
	}

	public void setCruReviewed(BigDecimal cruReviewed) {
		this.cruReviewed = cruReviewed;
	}

	public BigDecimal getCruShowAsDiff() {
		return this.cruShowAsDiff;
	}

	public void setCruShowAsDiff(BigDecimal cruShowAsDiff) {
		this.cruShowAsDiff = cruShowAsDiff;
	}

	public BigDecimal getCruWhenAdded() {
		return this.cruWhenAdded;
	}

	public void setCruWhenAdded(BigDecimal cruWhenAdded) {
		this.cruWhenAdded = cruWhenAdded;
	}

	public List<CruFileReadStatus> getCruFileReadStatuses() {
		return this.cruFileReadStatuses;
	}

	public void setCruFileReadStatuses(List<CruFileReadStatus> cruFileReadStatuses) {
		this.cruFileReadStatuses = cruFileReadStatuses;
	}

	public CruFileReadStatus addCruFileReadStatus(CruFileReadStatus cruFileReadStatus) {
		getCruFileReadStatuses().add(cruFileReadStatus);
		cruFileReadStatus.setCruFrxBean(this);

		return cruFileReadStatus;
	}

	public CruFileReadStatus removeCruFileReadStatus(CruFileReadStatus cruFileReadStatus) {
		getCruFileReadStatuses().remove(cruFileReadStatus);
		cruFileReadStatus.setCruFrxBean(null);

		return cruFileReadStatus;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

	public List<CruFrxComment> getCruFrxComments() {
		return this.cruFrxComments;
	}

	public void setCruFrxComments(List<CruFrxComment> cruFrxComments) {
		this.cruFrxComments = cruFrxComments;
	}

	public CruFrxComment addCruFrxComment(CruFrxComment cruFrxComment) {
		getCruFrxComments().add(cruFrxComment);
		cruFrxComment.setCruFrx(this);

		return cruFrxComment;
	}

	public CruFrxComment removeCruFrxComment(CruFrxComment cruFrxComment) {
		getCruFrxComments().remove(cruFrxComment);
		cruFrxComment.setCruFrx(null);

		return cruFrxComment;
	}

	public List<CruFrxRevision> getCruFrxRevisions() {
		return this.cruFrxRevisions;
	}

	public void setCruFrxRevisions(List<CruFrxRevision> cruFrxRevisions) {
		this.cruFrxRevisions = cruFrxRevisions;
	}

	public CruFrxRevision addCruFrxRevision(CruFrxRevision cruFrxRevision) {
		getCruFrxRevisions().add(cruFrxRevision);
		cruFrxRevision.setCruFrx(this);

		return cruFrxRevision;
	}

	public CruFrxRevision removeCruFrxRevision(CruFrxRevision cruFrxRevision) {
		getCruFrxRevisions().remove(cruFrxRevision);
		cruFrxRevision.setCruFrx(null);

		return cruFrxRevision;
	}

	public List<CruInlineComment> getCruInlineComments() {
		return this.cruInlineComments;
	}

	public void setCruInlineComments(List<CruInlineComment> cruInlineComments) {
		this.cruInlineComments = cruInlineComments;
	}

	public CruInlineComment addCruInlineComment(CruInlineComment cruInlineComment) {
		getCruInlineComments().add(cruInlineComment);
		cruInlineComment.setCruFrx(this);

		return cruInlineComment;
	}

	public CruInlineComment removeCruInlineComment(CruInlineComment cruInlineComment) {
		getCruInlineComments().remove(cruInlineComment);
		cruInlineComment.setCruFrx(null);

		return cruInlineComment;
	}

}