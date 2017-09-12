package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_USER database table.
 * 
 */
@Entity
@Table(name="CRU_USER")
@NamedQuery(name="CruUser.findAll", query="SELECT c FROM CruUser c")
public class CruUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_USER_ID")
	private long cruUserId;

	@Column(name="CRU_FAILEDLOGINCOUNT")
	private BigDecimal cruFailedlogincount;

	@Column(name="CRU_PASSWORDRESET_SRND")
	private String cruPasswordresetSrnd;

	@Column(name="CRU_PASSWORDRESETTIMESTAMP")
	private BigDecimal cruPasswordresettimestamp;

	@Column(name="CRU_USER_NAME")
	private String cruUserName;

	//bi-directional many-to-one association to CruChangesetComment
	@OneToMany(mappedBy="cruUser")
	private List<CruChangesetComment> cruChangesetComments;

	//bi-directional many-to-one association to CruComment
	@OneToMany(mappedBy="cruUser1")
	private List<CruComment> cruComments1;

	//bi-directional many-to-one association to CruComment
	@OneToMany(mappedBy="cruUser2")
	private List<CruComment> cruComments2;

	//bi-directional many-to-one association to CruCommentReadStatus
	@OneToMany(mappedBy="cruUserBean")
	private List<CruCommentReadStatus> cruCommentReadStatuses;

	//bi-directional many-to-one association to CruGlobalUserPermission
	@OneToMany(mappedBy="cruUser")
	private List<CruGlobalUserPermission> cruGlobalUserPermissions;

	//bi-directional many-to-one association to CruLoginCookie
	@OneToMany(mappedBy="cruUser")
	private List<CruLoginCookie> cruLoginCookies;

	//bi-directional many-to-one association to CruLogitem
	@OneToMany(mappedBy="cruUser")
	private List<CruLogitem> cruLogitems;

	//bi-directional many-to-one association to CruNotification
	@OneToMany(mappedBy="cruUser")
	private List<CruNotification> cruNotifications;

	//bi-directional many-to-one association to CruProject
	@OneToMany(mappedBy="cruUser")
	private List<CruProject> cruProjects1;

	//bi-directional many-to-many association to CruProject
	@ManyToMany
	@JoinTable(
		name="CRU_PROJ_ALLOWED_REVIEWER"
		, joinColumns={
			@JoinColumn(name="CRU_USER_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CRU_PROJECT_ID")
			}
		)
	private List<CruProject> cruProjects2;

	//bi-directional many-to-many association to CruProject
	@ManyToMany
	@JoinTable(
		name="CRU_PROJ_DEFAULT_REVIEWER"
		, joinColumns={
			@JoinColumn(name="CRU_USER_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CRU_PROJECT_ID")
			}
		)
	private List<CruProject> cruProjects3;

	//bi-directional many-to-one association to CruRecipient
	@OneToMany(mappedBy="cruUserBean")
	private List<CruRecipient> cruRecipients;

	//bi-directional many-to-one association to CruRepoUserPerm
	@OneToMany(mappedBy="cruUser")
	private List<CruRepoUserPerm> cruRepoUserPerms;

	//bi-directional many-to-one association to CruReview
	@OneToMany(mappedBy="cruUser")
	private List<CruReview> cruReviews;

	//bi-directional many-to-one association to CruReviewParticipant
	@OneToMany(mappedBy="cruUserBean")
	private List<CruReviewParticipant> cruReviewParticipants;

	//bi-directional many-to-one association to CruStateChange
	@OneToMany(mappedBy="cruUserBean")
	private List<CruStateChange> cruStateChanges;

	//bi-directional many-to-one association to CruUploadItem
	@OneToMany(mappedBy="cruUserBean")
	private List<CruUploadItem> cruUploadItems;

	//bi-directional many-to-one association to CruUserAppLink
	@OneToMany(mappedBy="cruUserBean")
	private List<CruUserAppLink> cruUserAppLinks;

	//bi-directional one-to-one association to CruUserProfile
	@OneToOne(mappedBy="cruUser")
	private CruUserProfile cruUserProfile;

	//bi-directional many-to-one association to CruUserRepoProperty
	@OneToMany(mappedBy="cruUser")
	private List<CruUserRepoProperty> cruUserRepoProperties;

	//bi-directional many-to-one association to CruUserSetting
	@OneToMany(mappedBy="cruUser")
	private List<CruUserSetting> cruUserSettings;

	//bi-directional many-to-one association to CruWatch
	@OneToMany(mappedBy="cruUser")
	private List<CruWatch> cruWatches;

	public CruUser() {
	}

	public long getCruUserId() {
		return this.cruUserId;
	}

	public void setCruUserId(long cruUserId) {
		this.cruUserId = cruUserId;
	}

	public BigDecimal getCruFailedlogincount() {
		return this.cruFailedlogincount;
	}

	public void setCruFailedlogincount(BigDecimal cruFailedlogincount) {
		this.cruFailedlogincount = cruFailedlogincount;
	}

	public String getCruPasswordresetSrnd() {
		return this.cruPasswordresetSrnd;
	}

	public void setCruPasswordresetSrnd(String cruPasswordresetSrnd) {
		this.cruPasswordresetSrnd = cruPasswordresetSrnd;
	}

	public BigDecimal getCruPasswordresettimestamp() {
		return this.cruPasswordresettimestamp;
	}

	public void setCruPasswordresettimestamp(BigDecimal cruPasswordresettimestamp) {
		this.cruPasswordresettimestamp = cruPasswordresettimestamp;
	}

	public String getCruUserName() {
		return this.cruUserName;
	}

	public void setCruUserName(String cruUserName) {
		this.cruUserName = cruUserName;
	}

	public List<CruChangesetComment> getCruChangesetComments() {
		return this.cruChangesetComments;
	}

	public void setCruChangesetComments(List<CruChangesetComment> cruChangesetComments) {
		this.cruChangesetComments = cruChangesetComments;
	}

	public CruChangesetComment addCruChangesetComment(CruChangesetComment cruChangesetComment) {
		getCruChangesetComments().add(cruChangesetComment);
		cruChangesetComment.setCruUser(this);

		return cruChangesetComment;
	}

	public CruChangesetComment removeCruChangesetComment(CruChangesetComment cruChangesetComment) {
		getCruChangesetComments().remove(cruChangesetComment);
		cruChangesetComment.setCruUser(null);

		return cruChangesetComment;
	}

	public List<CruComment> getCruComments1() {
		return this.cruComments1;
	}

	public void setCruComments1(List<CruComment> cruComments1) {
		this.cruComments1 = cruComments1;
	}

	public CruComment addCruComments1(CruComment cruComments1) {
		getCruComments1().add(cruComments1);
		cruComments1.setCruUser1(this);

		return cruComments1;
	}

	public CruComment removeCruComments1(CruComment cruComments1) {
		getCruComments1().remove(cruComments1);
		cruComments1.setCruUser1(null);

		return cruComments1;
	}

	public List<CruComment> getCruComments2() {
		return this.cruComments2;
	}

	public void setCruComments2(List<CruComment> cruComments2) {
		this.cruComments2 = cruComments2;
	}

	public CruComment addCruComments2(CruComment cruComments2) {
		getCruComments2().add(cruComments2);
		cruComments2.setCruUser2(this);

		return cruComments2;
	}

	public CruComment removeCruComments2(CruComment cruComments2) {
		getCruComments2().remove(cruComments2);
		cruComments2.setCruUser2(null);

		return cruComments2;
	}

	public List<CruCommentReadStatus> getCruCommentReadStatuses() {
		return this.cruCommentReadStatuses;
	}

	public void setCruCommentReadStatuses(List<CruCommentReadStatus> cruCommentReadStatuses) {
		this.cruCommentReadStatuses = cruCommentReadStatuses;
	}

	public CruCommentReadStatus addCruCommentReadStatus(CruCommentReadStatus cruCommentReadStatus) {
		getCruCommentReadStatuses().add(cruCommentReadStatus);
		cruCommentReadStatus.setCruUserBean(this);

		return cruCommentReadStatus;
	}

	public CruCommentReadStatus removeCruCommentReadStatus(CruCommentReadStatus cruCommentReadStatus) {
		getCruCommentReadStatuses().remove(cruCommentReadStatus);
		cruCommentReadStatus.setCruUserBean(null);

		return cruCommentReadStatus;
	}

	public List<CruGlobalUserPermission> getCruGlobalUserPermissions() {
		return this.cruGlobalUserPermissions;
	}

	public void setCruGlobalUserPermissions(List<CruGlobalUserPermission> cruGlobalUserPermissions) {
		this.cruGlobalUserPermissions = cruGlobalUserPermissions;
	}

	public CruGlobalUserPermission addCruGlobalUserPermission(CruGlobalUserPermission cruGlobalUserPermission) {
		getCruGlobalUserPermissions().add(cruGlobalUserPermission);
		cruGlobalUserPermission.setCruUser(this);

		return cruGlobalUserPermission;
	}

	public CruGlobalUserPermission removeCruGlobalUserPermission(CruGlobalUserPermission cruGlobalUserPermission) {
		getCruGlobalUserPermissions().remove(cruGlobalUserPermission);
		cruGlobalUserPermission.setCruUser(null);

		return cruGlobalUserPermission;
	}

	public List<CruLoginCookie> getCruLoginCookies() {
		return this.cruLoginCookies;
	}

	public void setCruLoginCookies(List<CruLoginCookie> cruLoginCookies) {
		this.cruLoginCookies = cruLoginCookies;
	}

	public CruLoginCookie addCruLoginCooky(CruLoginCookie cruLoginCooky) {
		getCruLoginCookies().add(cruLoginCooky);
		cruLoginCooky.setCruUser(this);

		return cruLoginCooky;
	}

	public CruLoginCookie removeCruLoginCooky(CruLoginCookie cruLoginCooky) {
		getCruLoginCookies().remove(cruLoginCooky);
		cruLoginCooky.setCruUser(null);

		return cruLoginCooky;
	}

	public List<CruLogitem> getCruLogitems() {
		return this.cruLogitems;
	}

	public void setCruLogitems(List<CruLogitem> cruLogitems) {
		this.cruLogitems = cruLogitems;
	}

	public CruLogitem addCruLogitem(CruLogitem cruLogitem) {
		getCruLogitems().add(cruLogitem);
		cruLogitem.setCruUser(this);

		return cruLogitem;
	}

	public CruLogitem removeCruLogitem(CruLogitem cruLogitem) {
		getCruLogitems().remove(cruLogitem);
		cruLogitem.setCruUser(null);

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
		cruNotification.setCruUser(this);

		return cruNotification;
	}

	public CruNotification removeCruNotification(CruNotification cruNotification) {
		getCruNotifications().remove(cruNotification);
		cruNotification.setCruUser(null);

		return cruNotification;
	}

	public List<CruProject> getCruProjects1() {
		return this.cruProjects1;
	}

	public void setCruProjects1(List<CruProject> cruProjects1) {
		this.cruProjects1 = cruProjects1;
	}

	public CruProject addCruProjects1(CruProject cruProjects1) {
		getCruProjects1().add(cruProjects1);
		cruProjects1.setCruUser(this);

		return cruProjects1;
	}

	public CruProject removeCruProjects1(CruProject cruProjects1) {
		getCruProjects1().remove(cruProjects1);
		cruProjects1.setCruUser(null);

		return cruProjects1;
	}

	public List<CruProject> getCruProjects2() {
		return this.cruProjects2;
	}

	public void setCruProjects2(List<CruProject> cruProjects2) {
		this.cruProjects2 = cruProjects2;
	}

	public List<CruProject> getCruProjects3() {
		return this.cruProjects3;
	}

	public void setCruProjects3(List<CruProject> cruProjects3) {
		this.cruProjects3 = cruProjects3;
	}

	public List<CruRecipient> getCruRecipients() {
		return this.cruRecipients;
	}

	public void setCruRecipients(List<CruRecipient> cruRecipients) {
		this.cruRecipients = cruRecipients;
	}

	public CruRecipient addCruRecipient(CruRecipient cruRecipient) {
		getCruRecipients().add(cruRecipient);
		cruRecipient.setCruUserBean(this);

		return cruRecipient;
	}

	public CruRecipient removeCruRecipient(CruRecipient cruRecipient) {
		getCruRecipients().remove(cruRecipient);
		cruRecipient.setCruUserBean(null);

		return cruRecipient;
	}

	public List<CruRepoUserPerm> getCruRepoUserPerms() {
		return this.cruRepoUserPerms;
	}

	public void setCruRepoUserPerms(List<CruRepoUserPerm> cruRepoUserPerms) {
		this.cruRepoUserPerms = cruRepoUserPerms;
	}

	public CruRepoUserPerm addCruRepoUserPerm(CruRepoUserPerm cruRepoUserPerm) {
		getCruRepoUserPerms().add(cruRepoUserPerm);
		cruRepoUserPerm.setCruUser(this);

		return cruRepoUserPerm;
	}

	public CruRepoUserPerm removeCruRepoUserPerm(CruRepoUserPerm cruRepoUserPerm) {
		getCruRepoUserPerms().remove(cruRepoUserPerm);
		cruRepoUserPerm.setCruUser(null);

		return cruRepoUserPerm;
	}

	public List<CruReview> getCruReviews() {
		return this.cruReviews;
	}

	public void setCruReviews(List<CruReview> cruReviews) {
		this.cruReviews = cruReviews;
	}

	public CruReview addCruReview(CruReview cruReview) {
		getCruReviews().add(cruReview);
		cruReview.setCruUser(this);

		return cruReview;
	}

	public CruReview removeCruReview(CruReview cruReview) {
		getCruReviews().remove(cruReview);
		cruReview.setCruUser(null);

		return cruReview;
	}

	public List<CruReviewParticipant> getCruReviewParticipants() {
		return this.cruReviewParticipants;
	}

	public void setCruReviewParticipants(List<CruReviewParticipant> cruReviewParticipants) {
		this.cruReviewParticipants = cruReviewParticipants;
	}

	public CruReviewParticipant addCruReviewParticipant(CruReviewParticipant cruReviewParticipant) {
		getCruReviewParticipants().add(cruReviewParticipant);
		cruReviewParticipant.setCruUserBean(this);

		return cruReviewParticipant;
	}

	public CruReviewParticipant removeCruReviewParticipant(CruReviewParticipant cruReviewParticipant) {
		getCruReviewParticipants().remove(cruReviewParticipant);
		cruReviewParticipant.setCruUserBean(null);

		return cruReviewParticipant;
	}

	public List<CruStateChange> getCruStateChanges() {
		return this.cruStateChanges;
	}

	public void setCruStateChanges(List<CruStateChange> cruStateChanges) {
		this.cruStateChanges = cruStateChanges;
	}

	public CruStateChange addCruStateChange(CruStateChange cruStateChange) {
		getCruStateChanges().add(cruStateChange);
		cruStateChange.setCruUserBean(this);

		return cruStateChange;
	}

	public CruStateChange removeCruStateChange(CruStateChange cruStateChange) {
		getCruStateChanges().remove(cruStateChange);
		cruStateChange.setCruUserBean(null);

		return cruStateChange;
	}

	public List<CruUploadItem> getCruUploadItems() {
		return this.cruUploadItems;
	}

	public void setCruUploadItems(List<CruUploadItem> cruUploadItems) {
		this.cruUploadItems = cruUploadItems;
	}

	public CruUploadItem addCruUploadItem(CruUploadItem cruUploadItem) {
		getCruUploadItems().add(cruUploadItem);
		cruUploadItem.setCruUserBean(this);

		return cruUploadItem;
	}

	public CruUploadItem removeCruUploadItem(CruUploadItem cruUploadItem) {
		getCruUploadItems().remove(cruUploadItem);
		cruUploadItem.setCruUserBean(null);

		return cruUploadItem;
	}

	public List<CruUserAppLink> getCruUserAppLinks() {
		return this.cruUserAppLinks;
	}

	public void setCruUserAppLinks(List<CruUserAppLink> cruUserAppLinks) {
		this.cruUserAppLinks = cruUserAppLinks;
	}

	public CruUserAppLink addCruUserAppLink(CruUserAppLink cruUserAppLink) {
		getCruUserAppLinks().add(cruUserAppLink);
		cruUserAppLink.setCruUserBean(this);

		return cruUserAppLink;
	}

	public CruUserAppLink removeCruUserAppLink(CruUserAppLink cruUserAppLink) {
		getCruUserAppLinks().remove(cruUserAppLink);
		cruUserAppLink.setCruUserBean(null);

		return cruUserAppLink;
	}

	public CruUserProfile getCruUserProfile() {
		return this.cruUserProfile;
	}

	public void setCruUserProfile(CruUserProfile cruUserProfile) {
		this.cruUserProfile = cruUserProfile;
	}

	public List<CruUserRepoProperty> getCruUserRepoProperties() {
		return this.cruUserRepoProperties;
	}

	public void setCruUserRepoProperties(List<CruUserRepoProperty> cruUserRepoProperties) {
		this.cruUserRepoProperties = cruUserRepoProperties;
	}

	public CruUserRepoProperty addCruUserRepoProperty(CruUserRepoProperty cruUserRepoProperty) {
		getCruUserRepoProperties().add(cruUserRepoProperty);
		cruUserRepoProperty.setCruUser(this);

		return cruUserRepoProperty;
	}

	public CruUserRepoProperty removeCruUserRepoProperty(CruUserRepoProperty cruUserRepoProperty) {
		getCruUserRepoProperties().remove(cruUserRepoProperty);
		cruUserRepoProperty.setCruUser(null);

		return cruUserRepoProperty;
	}

	public List<CruUserSetting> getCruUserSettings() {
		return this.cruUserSettings;
	}

	public void setCruUserSettings(List<CruUserSetting> cruUserSettings) {
		this.cruUserSettings = cruUserSettings;
	}

	public CruUserSetting addCruUserSetting(CruUserSetting cruUserSetting) {
		getCruUserSettings().add(cruUserSetting);
		cruUserSetting.setCruUser(this);

		return cruUserSetting;
	}

	public CruUserSetting removeCruUserSetting(CruUserSetting cruUserSetting) {
		getCruUserSettings().remove(cruUserSetting);
		cruUserSetting.setCruUser(null);

		return cruUserSetting;
	}

	public List<CruWatch> getCruWatches() {
		return this.cruWatches;
	}

	public void setCruWatches(List<CruWatch> cruWatches) {
		this.cruWatches = cruWatches;
	}

	public CruWatch addCruWatch(CruWatch cruWatch) {
		getCruWatches().add(cruWatch);
		cruWatch.setCruUser(this);

		return cruWatch;
	}

	public CruWatch removeCruWatch(CruWatch cruWatch) {
		getCruWatches().remove(cruWatch);
		cruWatch.setCruUser(null);

		return cruWatch;
	}

}