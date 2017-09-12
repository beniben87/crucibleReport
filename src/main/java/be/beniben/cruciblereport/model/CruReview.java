package be.beniben.cruciblereport.model;

import be.beniben.cruciblereport.model.converter.LocalDateTimeAttributeConverter;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the CRU_REVIEW database table.
 * 
 */
@Entity
@Table(name="CRU_REVIEW")
@NamedQuery(name="CruReview.findAll", query="SELECT c FROM CruReview c")
public class CruReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_REVIEW_ID")
	private Long cruReviewId;

	@Column(name="CRU_ALLOW_REVIEWER_TO_JOIN")
	private BigDecimal cruAllowReviewerToJoin;

	@Column(name="CRU_CREATE_DATE")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime cruCreateDate;

	@Column(name="CRU_DEFAULT_SOURCE")
	private String cruDefaultSource;

	@Lob
	@Column(name="CRU_DESCRIPTION")
	private String cruDescription;

	@Column(name="CRU_DUE_DATE")
	private BigDecimal cruDueDate;

	@Column(name="CRU_ISSUE_KEY")
	private String cruIssueKey;

	@Column(name="CRU_METRICS_VERSION")
	private BigDecimal cruMetricsVersion;

	@Column(name="CRU_NAME")
	private String cruName;

	@Column(name="CRU_REMINDER_DATE")
	private BigDecimal cruReminderDate;

	@Column(name="CRU_REVIEW_TYPE")
	private BigDecimal cruReviewType;

	@Column(name="CRU_STATE")
	private String cruState;

	@Lob
	@Column(name="CRU_SUMMARY")
	private String cruSummary;

	//bi-directional many-to-one association to CruComment
	@OneToMany(mappedBy="cruReview")
	private List<CruComment> cruComments;

	//bi-directional many-to-one association to CruFrx
	@OneToMany(mappedBy="cruReview")
	private List<CruFrx> cruFrxs;

	//bi-directional many-to-one association to CruLogitem
	@OneToMany(mappedBy="cruReview")
	private List<CruLogitem> cruLogitems;

	//bi-directional many-to-one association to CruNotification
	@OneToMany(mappedBy="cruReviewBean")
	private List<CruNotification> cruNotifications;

	//bi-directional many-to-one association to CruPatch
	@OneToMany(mappedBy="cruReviewBean")
	private List<CruPatch> cruPatches;

	//bi-directional many-to-one association to CruProject
	@ManyToOne
	@JoinColumn(name="CRU_PROJECT")
	private CruProject cruProjectBean;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_PARENT_REVIEW")
	private CruReview cruReview;

	//bi-directional many-to-one association to CruReview
	@OneToMany(mappedBy="cruReview")
	private List<CruReview> cruReviews;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_CREATOR")
	private CruUser cruUser;

	//bi-directional many-to-many association to CruComment
	@ManyToMany
	@JoinTable(
		name="CRU_REVIEW_COMMENT"
		, joinColumns={
			@JoinColumn(name="CRU_REVIEW_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CRU_COMMENT_ID")
			}
		)
	private List<CruComment> cruComments2;

	//bi-directional many-to-one association to CruReviewField
	@OneToMany(mappedBy="cruReview")
	private List<CruReviewField> cruReviewFields;

	//bi-directional many-to-one association to CruReviewParticipant
	@OneToMany(mappedBy="cruReview")
	private List<CruReviewParticipant> cruReviewParticipants;

	//bi-directional many-to-one association to CruReviewProperty
	@OneToMany(mappedBy="cruReview")
	private List<CruReviewProperty> cruReviewProperties;

	//bi-directional many-to-one association to CruRevpermaid
	@OneToMany(mappedBy="cruReview")
	private List<CruRevpermaid> cruRevpermaids;

	public CruReview() {
	}

	public long getCruReviewId() {
		return this.cruReviewId;
	}

	public void setCruReviewId(long cruReviewId) {
		this.cruReviewId = cruReviewId;
	}

	public BigDecimal getCruAllowReviewerToJoin() {
		return this.cruAllowReviewerToJoin;
	}

	public void setCruAllowReviewerToJoin(BigDecimal cruAllowReviewerToJoin) {
		this.cruAllowReviewerToJoin = cruAllowReviewerToJoin;
	}

	public LocalDateTime getCruCreateDate() {
		return this.cruCreateDate;
	}

	public void setCruCreateDate(LocalDateTime cruCreateDate) {
		this.cruCreateDate = cruCreateDate;
	}

	public String getCruDefaultSource() {
		return this.cruDefaultSource;
	}

	public void setCruDefaultSource(String cruDefaultSource) {
		this.cruDefaultSource = cruDefaultSource;
	}

	public String getCruDescription() {
		return this.cruDescription;
	}

	public void setCruDescription(String cruDescription) {
		this.cruDescription = cruDescription;
	}

	public BigDecimal getCruDueDate() {
		return this.cruDueDate;
	}

	public void setCruDueDate(BigDecimal cruDueDate) {
		this.cruDueDate = cruDueDate;
	}

	public String getCruIssueKey() {
		return this.cruIssueKey;
	}

	public void setCruIssueKey(String cruIssueKey) {
		this.cruIssueKey = cruIssueKey;
	}

	public BigDecimal getCruMetricsVersion() {
		return this.cruMetricsVersion;
	}

	public void setCruMetricsVersion(BigDecimal cruMetricsVersion) {
		this.cruMetricsVersion = cruMetricsVersion;
	}

	public String getCruName() {
		return this.cruName;
	}

	public void setCruName(String cruName) {
		this.cruName = cruName;
	}

	public BigDecimal getCruReminderDate() {
		return this.cruReminderDate;
	}

	public void setCruReminderDate(BigDecimal cruReminderDate) {
		this.cruReminderDate = cruReminderDate;
	}

	public BigDecimal getCruReviewType() {
		return this.cruReviewType;
	}

	public void setCruReviewType(BigDecimal cruReviewType) {
		this.cruReviewType = cruReviewType;
	}

	public String getCruState() {
		return this.cruState;
	}

	public void setCruState(String cruState) {
		this.cruState = cruState;
	}

	public String getCruSummary() {
		return this.cruSummary;
	}

	public void setCruSummary(String cruSummary) {
		this.cruSummary = cruSummary;
	}

	public List<CruComment> getCruComments() {
		return this.cruComments;
	}

	public void setCruComments(List<CruComment> cruComments) {
		this.cruComments = cruComments;
	}

	public CruComment addCruComments(CruComment cruComments) {
		getCruComments().add(cruComments);
		cruComments.setCruReview(this);

		return cruComments;
	}

	public CruComment removeCruComments(CruComment cruComments) {
		getCruComments().remove(cruComments);
		cruComments.setCruReview(null);

		return cruComments;
	}

	public List<CruFrx> getCruFrxs() {
		return this.cruFrxs;
	}

	public void setCruFrxs(List<CruFrx> cruFrxs) {
		this.cruFrxs = cruFrxs;
	}

	public CruFrx addCruFrx(CruFrx cruFrx) {
		getCruFrxs().add(cruFrx);
		cruFrx.setCruReview(this);

		return cruFrx;
	}

	public CruFrx removeCruFrx(CruFrx cruFrx) {
		getCruFrxs().remove(cruFrx);
		cruFrx.setCruReview(null);

		return cruFrx;
	}

	public List<CruLogitem> getCruLogitems() {
		return this.cruLogitems;
	}

	public void setCruLogitems(List<CruLogitem> cruLogitems) {
		this.cruLogitems = cruLogitems;
	}

	public CruLogitem addCruLogitem(CruLogitem cruLogitem) {
		getCruLogitems().add(cruLogitem);
		cruLogitem.setCruReview(this);

		return cruLogitem;
	}

	public CruLogitem removeCruLogitem(CruLogitem cruLogitem) {
		getCruLogitems().remove(cruLogitem);
		cruLogitem.setCruReview(null);

		return cruLogitem;
	}

	public List<CruNotification> getCruNotifications() {
		return this.cruNotifications;
	}

	public void setCruNotifications(List<CruNotification> cruNotifications) {
		this.cruNotifications = cruNotifications;
	}

	public CruNotification addCruNotification(CruNotification cruNotification) {
		getCruNotifications().add(cruNotification);
		cruNotification.setCruReviewBean(this);

		return cruNotification;
	}

	public CruNotification removeCruNotification(CruNotification cruNotification) {
		getCruNotifications().remove(cruNotification);
		cruNotification.setCruReviewBean(null);

		return cruNotification;
	}

	public List<CruPatch> getCruPatches() {
		return this.cruPatches;
	}

	public void setCruPatches(List<CruPatch> cruPatches) {
		this.cruPatches = cruPatches;
	}

	public CruPatch addCruPatch(CruPatch cruPatch) {
		getCruPatches().add(cruPatch);
		cruPatch.setCruReviewBean(this);

		return cruPatch;
	}

	public CruPatch removeCruPatch(CruPatch cruPatch) {
		getCruPatches().remove(cruPatch);
		cruPatch.setCruReviewBean(null);

		return cruPatch;
	}

	public CruProject getCruProjectBean() {
		return this.cruProjectBean;
	}

	public void setCruProjectBean(CruProject cruProjectBean) {
		this.cruProjectBean = cruProjectBean;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

	public List<CruReview> getCruReviews() {
		return this.cruReviews;
	}

	public void setCruReviews(List<CruReview> cruReviews) {
		this.cruReviews = cruReviews;
	}

	public CruReview addCruReview(CruReview cruReview) {
		getCruReviews().add(cruReview);
		cruReview.setCruReview(this);

		return cruReview;
	}

	public CruReview removeCruReview(CruReview cruReview) {
		getCruReviews().remove(cruReview);
		cruReview.setCruReview(null);

		return cruReview;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

	public List<CruComment> getCruComments2() {
		return this.cruComments2;
	}

	public void setCruComments2(List<CruComment> cruComments2) {
		this.cruComments2 = cruComments2;
	}

	public List<CruReviewField> getCruReviewFields() {
		return this.cruReviewFields;
	}

	public void setCruReviewFields(List<CruReviewField> cruReviewFields) {
		this.cruReviewFields = cruReviewFields;
	}

	public CruReviewField addCruReviewField(CruReviewField cruReviewField) {
		getCruReviewFields().add(cruReviewField);
		cruReviewField.setCruReview(this);

		return cruReviewField;
	}

	public CruReviewField removeCruReviewField(CruReviewField cruReviewField) {
		getCruReviewFields().remove(cruReviewField);
		cruReviewField.setCruReview(null);

		return cruReviewField;
	}

	public List<CruReviewParticipant> getCruReviewParticipants() {
		return this.cruReviewParticipants;
	}

	public void setCruReviewParticipants(List<CruReviewParticipant> cruReviewParticipants) {
		this.cruReviewParticipants = cruReviewParticipants;
	}

	public CruReviewParticipant addCruReviewParticipant(CruReviewParticipant cruReviewParticipant) {
		getCruReviewParticipants().add(cruReviewParticipant);
		cruReviewParticipant.setCruReview(this);

		return cruReviewParticipant;
	}

	public CruReviewParticipant removeCruReviewParticipant(CruReviewParticipant cruReviewParticipant) {
		getCruReviewParticipants().remove(cruReviewParticipant);
		cruReviewParticipant.setCruReview(null);

		return cruReviewParticipant;
	}

	public List<CruReviewProperty> getCruReviewProperties() {
		return this.cruReviewProperties;
	}

	public void setCruReviewProperties(List<CruReviewProperty> cruReviewProperties) {
		this.cruReviewProperties = cruReviewProperties;
	}

	public CruReviewProperty addCruReviewProperty(CruReviewProperty cruReviewProperty) {
		getCruReviewProperties().add(cruReviewProperty);
		cruReviewProperty.setCruReview(this);

		return cruReviewProperty;
	}

	public CruReviewProperty removeCruReviewProperty(CruReviewProperty cruReviewProperty) {
		getCruReviewProperties().remove(cruReviewProperty);
		cruReviewProperty.setCruReview(null);

		return cruReviewProperty;
	}

	public List<CruRevpermaid> getCruRevpermaids() {
		return this.cruRevpermaids;
	}

	public void setCruRevpermaids(List<CruRevpermaid> cruRevpermaids) {
		this.cruRevpermaids = cruRevpermaids;
	}

	public CruRevpermaid addCruRevpermaid(CruRevpermaid cruRevpermaid) {
		getCruRevpermaids().add(cruRevpermaid);
		cruRevpermaid.setCruReview(this);

		return cruRevpermaid;
	}

	public CruRevpermaid removeCruRevpermaid(CruRevpermaid cruRevpermaid) {
		getCruRevpermaids().remove(cruRevpermaid);
		cruRevpermaid.setCruReview(null);

		return cruRevpermaid;
	}

}