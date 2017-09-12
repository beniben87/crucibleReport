package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_CHANGESET_COMMENT database table.
 * 
 */
@Entity
@Table(name="CRU_CHANGESET_COMMENT")
@NamedQuery(name="CruChangesetComment.findAll", query="SELECT c FROM CruChangesetComment c")
public class CruChangesetComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_COMMENT_ID")
	private long cruCommentId;

	@Column(name="CRU_CREATE_DATE")
	private BigDecimal cruCreateDate;

	@Column(name="CRU_CSID")
	private String cruCsid;

	@Column(name="CRU_DEFECT_RAISED")
	private BigDecimal cruDefectRaised;

	@Column(name="CRU_DELETED")
	private BigDecimal cruDeleted;

	@Column(name="CRU_DRAFT")
	private BigDecimal cruDraft;

	@Lob
	@Column(name="CRU_MESSAGE")
	private String cruMessage;

	@Column(name="CRU_REPOSITORY")
	private String cruRepository;

	@Column(name="CRU_UPDATED_DATE")
	private BigDecimal cruUpdatedDate;

	//bi-directional many-to-one association to CruChangesetComment
	@ManyToOne
	@JoinColumn(name="CRU_REPLY_TO_COMMENT_ID")
	private CruChangesetComment cruChangesetComment;

	//bi-directional many-to-one association to CruChangesetComment
	@OneToMany(mappedBy="cruChangesetComment")
	private List<CruChangesetComment> cruChangesetComments;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruChangesetComment() {
	}

	public long getCruCommentId() {
		return this.cruCommentId;
	}

	public void setCruCommentId(long cruCommentId) {
		this.cruCommentId = cruCommentId;
	}

	public BigDecimal getCruCreateDate() {
		return this.cruCreateDate;
	}

	public void setCruCreateDate(BigDecimal cruCreateDate) {
		this.cruCreateDate = cruCreateDate;
	}

	public String getCruCsid() {
		return this.cruCsid;
	}

	public void setCruCsid(String cruCsid) {
		this.cruCsid = cruCsid;
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

	public String getCruMessage() {
		return this.cruMessage;
	}

	public void setCruMessage(String cruMessage) {
		this.cruMessage = cruMessage;
	}

	public String getCruRepository() {
		return this.cruRepository;
	}

	public void setCruRepository(String cruRepository) {
		this.cruRepository = cruRepository;
	}

	public BigDecimal getCruUpdatedDate() {
		return this.cruUpdatedDate;
	}

	public void setCruUpdatedDate(BigDecimal cruUpdatedDate) {
		this.cruUpdatedDate = cruUpdatedDate;
	}

	public CruChangesetComment getCruChangesetComment() {
		return this.cruChangesetComment;
	}

	public void setCruChangesetComment(CruChangesetComment cruChangesetComment) {
		this.cruChangesetComment = cruChangesetComment;
	}

	public List<CruChangesetComment> getCruChangesetComments() {
		return this.cruChangesetComments;
	}

	public void setCruChangesetComments(List<CruChangesetComment> cruChangesetComments) {
		this.cruChangesetComments = cruChangesetComments;
	}

	public CruChangesetComment addCruChangesetComment(CruChangesetComment cruChangesetComment) {
		getCruChangesetComments().add(cruChangesetComment);
		cruChangesetComment.setCruChangesetComment(this);

		return cruChangesetComment;
	}

	public CruChangesetComment removeCruChangesetComment(CruChangesetComment cruChangesetComment) {
		getCruChangesetComments().remove(cruChangesetComment);
		cruChangesetComment.setCruChangesetComment(null);

		return cruChangesetComment;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}