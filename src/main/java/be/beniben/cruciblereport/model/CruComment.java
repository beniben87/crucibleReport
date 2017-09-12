package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_COMMENT database table.
 * 
 */
@Entity
@Table(name="CRU_COMMENT")
@NamedQuery(name="CruComment.findAll", query="SELECT c FROM CruComment c")
public class CruComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_COMMENT_ID")
	private long cruCommentId;

	@Column(name="CRU_COMMENT_ISSUE_KEY")
	private String cruCommentIssueKey;

	@Column(name="CRU_CREATE_DATE")
	private BigDecimal cruCreateDate;

	@Column(name="CRU_DEFECT_APPROVED")
	private BigDecimal cruDefectApproved;

	@Column(name="CRU_DEFECT_RAISED")
	private BigDecimal cruDefectRaised;

	@Column(name="CRU_DELETED")
	private BigDecimal cruDeleted;

	@Column(name="CRU_DRAFT")
	private BigDecimal cruDraft;

	@Column(name="CRU_LAST_RESOLUTION_CREATED")
	private BigDecimal cruLastResolutionCreated;

	@Column(name="CRU_LAST_RESOLUTION_STATUS")
	private String cruLastResolutionStatus;

	@Lob
	@Column(name="CRU_MESSAGE")
	private String cruMessage;

	@Column(name="CRU_UPDATED_DATE")
	private BigDecimal cruUpdatedDate;

	//bi-directional many-to-one association to CruComment
	@ManyToOne
	@JoinColumn(name="CRU_REPLY_TO_COMMENT_ID")
	private CruComment cruComment;

	//bi-directional many-to-one association to CruComment
	@OneToMany(mappedBy="cruComment")
	private List<CruComment> cruComments;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW_ID")
	private CruReview cruReview;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_LAST_RESOLUTION_USER_ID")
	private CruUser cruUser1;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser2;

	//bi-directional many-to-one association to CruCommentField
	@OneToMany(mappedBy="cruComment")
	private List<CruCommentField> cruCommentFields;

	//bi-directional many-to-one association to CruCommentReadStatus
	@OneToMany(mappedBy="cruCommentBean")
	private List<CruCommentReadStatus> cruCommentReadStatuses;

	//bi-directional one-to-one association to CruFrxComment
	@OneToOne(mappedBy="cruComment")
	private CruFrxComment cruFrxComment;

	//bi-directional one-to-one association to CruInlineComment
	@OneToOne(mappedBy="cruComment")
	private CruInlineComment cruInlineComment;

	//bi-directional many-to-many association to CruReview
	@ManyToMany(mappedBy="cruComments2")
	private List<CruReview> cruReviews;

	public CruComment() {
	}

	public long getCruCommentId() {
		return this.cruCommentId;
	}

	public void setCruCommentId(long cruCommentId) {
		this.cruCommentId = cruCommentId;
	}

	public String getCruCommentIssueKey() {
		return this.cruCommentIssueKey;
	}

	public void setCruCommentIssueKey(String cruCommentIssueKey) {
		this.cruCommentIssueKey = cruCommentIssueKey;
	}

	public BigDecimal getCruCreateDate() {
		return this.cruCreateDate;
	}

	public void setCruCreateDate(BigDecimal cruCreateDate) {
		this.cruCreateDate = cruCreateDate;
	}

	public BigDecimal getCruDefectApproved() {
		return this.cruDefectApproved;
	}

	public void setCruDefectApproved(BigDecimal cruDefectApproved) {
		this.cruDefectApproved = cruDefectApproved;
	}

	public BigDecimal getCruDefectRaised() {
		return this.cruDefectRaised;
	}

	public void setCruDefectRaised(BigDecimal cruDefectRaised) {
		this.cruDefectRaised = cruDefectRaised;
	}

	public BigDecimal getCruDeleted() {
		return this.cruDeleted;
	}

	public void setCruDeleted(BigDecimal cruDeleted) {
		this.cruDeleted = cruDeleted;
	}

	public BigDecimal getCruDraft() {
		return this.cruDraft;
	}

	public void setCruDraft(BigDecimal cruDraft) {
		this.cruDraft = cruDraft;
	}

	public BigDecimal getCruLastResolutionCreated() {
		return this.cruLastResolutionCreated;
	}

	public void setCruLastResolutionCreated(BigDecimal cruLastResolutionCreated) {
		this.cruLastResolutionCreated = cruLastResolutionCreated;
	}

	public String getCruLastResolutionStatus() {
		return this.cruLastResolutionStatus;
	}

	public void setCruLastResolutionStatus(String cruLastResolutionStatus) {
		this.cruLastResolutionStatus = cruLastResolutionStatus;
	}

	public String getCruMessage() {
		return this.cruMessage;
	}

	public void setCruMessage(String cruMessage) {
		this.cruMessage = cruMessage;
	}

	public BigDecimal getCruUpdatedDate() {
		return this.cruUpdatedDate;
	}

	public void setCruUpdatedDate(BigDecimal cruUpdatedDate) {
		this.cruUpdatedDate = cruUpdatedDate;
	}

	public CruComment getCruComment() {
		return this.cruComment;
	}

	public void setCruComment(CruComment cruComment) {
		this.cruComment = cruComment;
	}

	public List<CruComment> getCruComments() {
		return this.cruComments;
	}

	public void setCruComments(List<CruComment> cruComments) {
		this.cruComments = cruComments;
	}

	public CruComment addCruComment(CruComment cruComment) {
		getCruComments().add(cruComment);
		cruComment.setCruComment(this);

		return cruComment;
	}

	public CruComment removeCruComment(CruComment cruComment) {
		getCruComments().remove(cruComment);
		cruComment.setCruComment(null);

		return cruComment;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

	public CruUser getCruUser1() {
		return this.cruUser1;
	}

	public void setCruUser1(CruUser cruUser1) {
		this.cruUser1 = cruUser1;
	}

	public CruUser getCruUser2() {
		return this.cruUser2;
	}

	public void setCruUser2(CruUser cruUser2) {
		this.cruUser2 = cruUser2;
	}

	public List<CruCommentField> getCruCommentFields() {
		return this.cruCommentFields;
	}

	public void setCruCommentFields(List<CruCommentField> cruCommentFields) {
		this.cruCommentFields = cruCommentFields;
	}

	public CruCommentField addCruCommentField(CruCommentField cruCommentField) {
		getCruCommentFields().add(cruCommentField);
		cruCommentField.setCruComment(this);

		return cruCommentField;
	}

	public CruCommentField removeCruCommentField(CruCommentField cruCommentField) {
		getCruCommentFields().remove(cruCommentField);
		cruCommentField.setCruComment(null);

		return cruCommentField;
	}

	public List<CruCommentReadStatus> getCruCommentReadStatuses() {
		return this.cruCommentReadStatuses;
	}

	public void setCruCommentReadStatuses(List<CruCommentReadStatus> cruCommentReadStatuses) {
		this.cruCommentReadStatuses = cruCommentReadStatuses;
	}

	public CruCommentReadStatus addCruCommentReadStatus(CruCommentReadStatus cruCommentReadStatus) {
		getCruCommentReadStatuses().add(cruCommentReadStatus);
		cruCommentReadStatus.setCruCommentBean(this);

		return cruCommentReadStatus;
	}

	public CruCommentReadStatus removeCruCommentReadStatus(CruCommentReadStatus cruCommentReadStatus) {
		getCruCommentReadStatuses().remove(cruCommentReadStatus);
		cruCommentReadStatus.setCruCommentBean(null);

		return cruCommentReadStatus;
	}

	public CruFrxComment getCruFrxComment() {
		return this.cruFrxComment;
	}

	public void setCruFrxComment(CruFrxComment cruFrxComment) {
		this.cruFrxComment = cruFrxComment;
	}

	public CruInlineComment getCruInlineComment() {
		return this.cruInlineComment;
	}

	public void setCruInlineComment(CruInlineComment cruInlineComment) {
		this.cruInlineComment = cruInlineComment;
	}

	public List<CruReview> getCruReviews() {
		return this.cruReviews;
	}

	public void setCruReviews(List<CruReview> cruReviews) {
		this.cruReviews = cruReviews;
	}

}