package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_REVIEW_PARTICIPANT database table.
 * 
 */
@Entity
@Table(name="CRU_REVIEW_PARTICIPANT")
@NamedQuery(name="CruReviewParticipant.findAll", query="SELECT c FROM CruReviewParticipant c")
public class CruReviewParticipant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_PARTICIPANT_ID")
	private long cruParticipantId;

	@Column(name="CRU_ALL_COMPLETE")
	private BigDecimal cruAllComplete;

	@Column(name="CRU_AUTHOR")
	private BigDecimal cruAuthor;

	@Column(name="CRU_LAST_READ")
	private BigDecimal cruLastRead;

	@Column(name="CRU_MODERATOR")
	private BigDecimal cruModerator;

	@Column(name="CRU_REVIEWER")
	private BigDecimal cruReviewer;

	@Column(name="CRU_STATUS_CHANGE")
	private BigDecimal cruStatusChange;

	@Column(name="CRU_TIME_SPENT")
	private BigDecimal cruTimeSpent;

	@Column(name="CRU_TIME_SUBMITTED")
	private BigDecimal cruTimeSubmitted;

	//bi-directional many-to-one association to CruFileReadStatus
	@OneToMany(mappedBy="cruReviewParticipant")
	private List<CruFileReadStatus> cruFileReadStatuses;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW_ID")
	private CruReview cruReview;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER")
	private CruUser cruUserBean;

	public CruReviewParticipant() {
	}

	public long getCruParticipantId() {
		return this.cruParticipantId;
	}

	public void setCruParticipantId(long cruParticipantId) {
		this.cruParticipantId = cruParticipantId;
	}

	public BigDecimal getCruAllComplete() {
		return this.cruAllComplete;
	}

	public void setCruAllComplete(BigDecimal cruAllComplete) {
		this.cruAllComplete = cruAllComplete;
	}

	public BigDecimal getCruAuthor() {
		return this.cruAuthor;
	}

	public void setCruAuthor(BigDecimal cruAuthor) {
		this.cruAuthor = cruAuthor;
	}

	public BigDecimal getCruLastRead() {
		return this.cruLastRead;
	}

	public void setCruLastRead(BigDecimal cruLastRead) {
		this.cruLastRead = cruLastRead;
	}

	public BigDecimal getCruModerator() {
		return this.cruModerator;
	}

	public void setCruModerator(BigDecimal cruModerator) {
		this.cruModerator = cruModerator;
	}

	public BigDecimal getCruReviewer() {
		return this.cruReviewer;
	}

	public void setCruReviewer(BigDecimal cruReviewer) {
		this.cruReviewer = cruReviewer;
	}

	public BigDecimal getCruStatusChange() {
		return this.cruStatusChange;
	}

	public void setCruStatusChange(BigDecimal cruStatusChange) {
		this.cruStatusChange = cruStatusChange;
	}

	public BigDecimal getCruTimeSpent() {
		return this.cruTimeSpent;
	}

	public void setCruTimeSpent(BigDecimal cruTimeSpent) {
		this.cruTimeSpent = cruTimeSpent;
	}

	public BigDecimal getCruTimeSubmitted() {
		return this.cruTimeSubmitted;
	}

	public void setCruTimeSubmitted(BigDecimal cruTimeSubmitted) {
		this.cruTimeSubmitted = cruTimeSubmitted;
	}

	public List<CruFileReadStatus> getCruFileReadStatuses() {
		return this.cruFileReadStatuses;
	}

	public void setCruFileReadStatuses(List<CruFileReadStatus> cruFileReadStatuses) {
		this.cruFileReadStatuses = cruFileReadStatuses;
	}

	public CruFileReadStatus addCruFileReadStatus(CruFileReadStatus cruFileReadStatus) {
		getCruFileReadStatuses().add(cruFileReadStatus);
		cruFileReadStatus.setCruReviewParticipant(this);

		return cruFileReadStatus;
	}

	public CruFileReadStatus removeCruFileReadStatus(CruFileReadStatus cruFileReadStatus) {
		getCruFileReadStatuses().remove(cruFileReadStatus);
		cruFileReadStatus.setCruReviewParticipant(null);

		return cruFileReadStatus;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

	public CruUser getCruUserBean() {
		return this.cruUserBean;
	}

	public void setCruUserBean(CruUser cruUserBean) {
		this.cruUserBean = cruUserBean;
	}

}