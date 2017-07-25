package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_USER_PROFILE database table.
 * 
 */
@Entity
@Table(name="CRU_USER_PROFILE")
@NamedQuery(name="CruUserProfile.findAll", query="SELECT c FROM CruUserProfile c")
public class CruUserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_USER_ID")
	private long cruUserId;

	@Column(name="CRU_AUTO_MARK_FILES")
	private BigDecimal cruAutoMarkFiles;

	@Column(name="CRU_CHANGESETSPERPAGE")
	private BigDecimal cruChangesetsperpage;

	@Column(name="CRU_COMMENT_EMAIL_NOTE")
	private BigDecimal cruCommentEmailNote;

	@Column(name="CRU_COMPLETE_EMAIL_NOTE")
	private BigDecimal cruCompleteEmailNote;

	@Column(name="CRU_CONTEXT")
	private BigDecimal cruContext;

	@Lob
	@Column(name="CRU_COOKIEPREFS")
	private String cruCookieprefs;

	@Column(name="CRU_DONT_SEND_ME_MY_NOTES")
	private BigDecimal cruDontSendMeMyNotes;

	@Column(name="CRU_EMAILFORMAT")
	private BigDecimal cruEmailformat;

	@Column(name="CRU_ENABLEIDE")
	private BigDecimal cruEnableide;

	@Column(name="CRU_GENERAL_EMAIL_NOTE")
	private BigDecimal cruGeneralEmailNote;

	@Column(name="CRU_IDECONNECTORPORT")
	private BigDecimal cruIdeconnectorport;

	@Column(name="CRU_MAXFILESPERCHANGESET")
	private BigDecimal cruMaxfilesperchangeset;

	@Column(name="CRU_REPLY_EMAIL_NOTE")
	private BigDecimal cruReplyEmailNote;

	@Column(name="CRU_STATE_CHANGE_EMAIL_NOTE")
	private BigDecimal cruStateChangeEmailNote;

	@Column(name="CRU_TABWIDTH")
	private BigDecimal cruTabwidth;

	@Column(name="CRU_TIMEZONE")
	private String cruTimezone;

	@Column(name="CRU_UNCOMPLETE_EMAIL_NOTE")
	private BigDecimal cruUncompleteEmailNote;

	@Column(name="CRU_UNCOMPLETE_ON_DEFECT")
	private BigDecimal cruUncompleteOnDefect;

	@Column(name="CRU_UNCOMPLETE_ON_REV_ADDED")
	private BigDecimal cruUncompleteOnRevAdded;

	@Column(name="CRU_UPLOAD_CHARSET")
	private String cruUploadCharset;

	@Column(name="CRU_UPLOAD_METHOD")
	private String cruUploadMethod;

	@Column(name="CRU_UPLOAD_TYPE")
	private String cruUploadType;

	@Column(name="CRU_WATCHMODE")
	private BigDecimal cruWatchmode;

	//bi-directional one-to-one association to CruUser
	@OneToOne
	@JoinColumn(name="CRU_USER_ID")
	private CruUser cruUser;

	public CruUserProfile() {
	}

	public long getCruUserId() {
		return this.cruUserId;
	}

	public void setCruUserId(long cruUserId) {
		this.cruUserId = cruUserId;
	}

	public BigDecimal getCruAutoMarkFiles() {
		return this.cruAutoMarkFiles;
	}

	public void setCruAutoMarkFiles(BigDecimal cruAutoMarkFiles) {
		this.cruAutoMarkFiles = cruAutoMarkFiles;
	}

	public BigDecimal getCruChangesetsperpage() {
		return this.cruChangesetsperpage;
	}

	public void setCruChangesetsperpage(BigDecimal cruChangesetsperpage) {
		this.cruChangesetsperpage = cruChangesetsperpage;
	}

	public BigDecimal getCruCommentEmailNote() {
		return this.cruCommentEmailNote;
	}

	public void setCruCommentEmailNote(BigDecimal cruCommentEmailNote) {
		this.cruCommentEmailNote = cruCommentEmailNote;
	}

	public BigDecimal getCruCompleteEmailNote() {
		return this.cruCompleteEmailNote;
	}

	public void setCruCompleteEmailNote(BigDecimal cruCompleteEmailNote) {
		this.cruCompleteEmailNote = cruCompleteEmailNote;
	}

	public BigDecimal getCruContext() {
		return this.cruContext;
	}

	public void setCruContext(BigDecimal cruContext) {
		this.cruContext = cruContext;
	}

	public String getCruCookieprefs() {
		return this.cruCookieprefs;
	}

	public void setCruCookieprefs(String cruCookieprefs) {
		this.cruCookieprefs = cruCookieprefs;
	}

	public BigDecimal getCruDontSendMeMyNotes() {
		return this.cruDontSendMeMyNotes;
	}

	public void setCruDontSendMeMyNotes(BigDecimal cruDontSendMeMyNotes) {
		this.cruDontSendMeMyNotes = cruDontSendMeMyNotes;
	}

	public BigDecimal getCruEmailformat() {
		return this.cruEmailformat;
	}

	public void setCruEmailformat(BigDecimal cruEmailformat) {
		this.cruEmailformat = cruEmailformat;
	}

	public BigDecimal getCruEnableide() {
		return this.cruEnableide;
	}

	public void setCruEnableide(BigDecimal cruEnableide) {
		this.cruEnableide = cruEnableide;
	}

	public BigDecimal getCruGeneralEmailNote() {
		return this.cruGeneralEmailNote;
	}

	public void setCruGeneralEmailNote(BigDecimal cruGeneralEmailNote) {
		this.cruGeneralEmailNote = cruGeneralEmailNote;
	}

	public BigDecimal getCruIdeconnectorport() {
		return this.cruIdeconnectorport;
	}

	public void setCruIdeconnectorport(BigDecimal cruIdeconnectorport) {
		this.cruIdeconnectorport = cruIdeconnectorport;
	}

	public BigDecimal getCruMaxfilesperchangeset() {
		return this.cruMaxfilesperchangeset;
	}

	public void setCruMaxfilesperchangeset(BigDecimal cruMaxfilesperchangeset) {
		this.cruMaxfilesperchangeset = cruMaxfilesperchangeset;
	}

	public BigDecimal getCruReplyEmailNote() {
		return this.cruReplyEmailNote;
	}

	public void setCruReplyEmailNote(BigDecimal cruReplyEmailNote) {
		this.cruReplyEmailNote = cruReplyEmailNote;
	}

	public BigDecimal getCruStateChangeEmailNote() {
		return this.cruStateChangeEmailNote;
	}

	public void setCruStateChangeEmailNote(BigDecimal cruStateChangeEmailNote) {
		this.cruStateChangeEmailNote = cruStateChangeEmailNote;
	}

	public BigDecimal getCruTabwidth() {
		return this.cruTabwidth;
	}

	public void setCruTabwidth(BigDecimal cruTabwidth) {
		this.cruTabwidth = cruTabwidth;
	}

	public String getCruTimezone() {
		return this.cruTimezone;
	}

	public void setCruTimezone(String cruTimezone) {
		this.cruTimezone = cruTimezone;
	}

	public BigDecimal getCruUncompleteEmailNote() {
		return this.cruUncompleteEmailNote;
	}

	public void setCruUncompleteEmailNote(BigDecimal cruUncompleteEmailNote) {
		this.cruUncompleteEmailNote = cruUncompleteEmailNote;
	}

	public BigDecimal getCruUncompleteOnDefect() {
		return this.cruUncompleteOnDefect;
	}

	public void setCruUncompleteOnDefect(BigDecimal cruUncompleteOnDefect) {
		this.cruUncompleteOnDefect = cruUncompleteOnDefect;
	}

	public BigDecimal getCruUncompleteOnRevAdded() {
		return this.cruUncompleteOnRevAdded;
	}

	public void setCruUncompleteOnRevAdded(BigDecimal cruUncompleteOnRevAdded) {
		this.cruUncompleteOnRevAdded = cruUncompleteOnRevAdded;
	}

	public String getCruUploadCharset() {
		return this.cruUploadCharset;
	}

	public void setCruUploadCharset(String cruUploadCharset) {
		this.cruUploadCharset = cruUploadCharset;
	}

	public String getCruUploadMethod() {
		return this.cruUploadMethod;
	}

	public void setCruUploadMethod(String cruUploadMethod) {
		this.cruUploadMethod = cruUploadMethod;
	}

	public String getCruUploadType() {
		return this.cruUploadType;
	}

	public void setCruUploadType(String cruUploadType) {
		this.cruUploadType = cruUploadType;
	}

	public BigDecimal getCruWatchmode() {
		return this.cruWatchmode;
	}

	public void setCruWatchmode(BigDecimal cruWatchmode) {
		this.cruWatchmode = cruWatchmode;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

}