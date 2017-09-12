package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CRU_PERM_SCHEME database table.
 * 
 */
@Entity
@Table(name="CRU_PERM_SCHEME")
@NamedQuery(name="CruPermScheme.findAll", query="SELECT c FROM CruPermScheme c")
public class CruPermScheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_PS_ID")
	private long cruPsId;

	@Column(name="CRU_NAME")
	private String cruName;

	//bi-directional many-to-one association to CruProject
	@OneToMany(mappedBy="cruPermScheme")
	private List<CruProject> cruProjects;

	//bi-directional many-to-one association to CruPsAllUser
	@OneToMany(mappedBy="cruPermScheme")
	private List<CruPsAllUser> cruPsAllUsers;

	//bi-directional many-to-one association to CruPsAnon
	@OneToMany(mappedBy="cruPermScheme")
	private List<CruPsAnon> cruPsAnons;

	//bi-directional many-to-one association to CruPsGroup
	@OneToMany(mappedBy="cruPermScheme")
	private List<CruPsGroup> cruPsGroups;

	//bi-directional many-to-one association to CruPsReviewRole
	@OneToMany(mappedBy="cruPermScheme")
	private List<CruPsReviewRole> cruPsReviewRoles;

	//bi-directional many-to-one association to CruPsUser
	@OneToMany(mappedBy="cruPermScheme")
	private List<CruPsUser> cruPsUsers;

	public CruPermScheme() {
	}

	public long getCruPsId() {
		return this.cruPsId;
	}

	public void setCruPsId(long cruPsId) {
		this.cruPsId = cruPsId;
	}

	public String getCruName() {
		return this.cruName;
	}

	public void setCruName(String cruName) {
		this.cruName = cruName;
	}

	public List<CruProject> getCruProjects() {
		return this.cruProjects;
	}

	public void setCruProjects(List<CruProject> cruProjects) {
		this.cruProjects = cruProjects;
	}

	public CruProject addCruProject(CruProject cruProject) {
		getCruProjects().add(cruProject);
		cruProject.setCruPermScheme(this);

		return cruProject;
	}

	public CruProject removeCruProject(CruProject cruProject) {
		getCruProjects().remove(cruProject);
		cruProject.setCruPermScheme(null);

		return cruProject;
	}

	public List<CruPsAllUser> getCruPsAllUsers() {
		return this.cruPsAllUsers;
	}

	public void setCruPsAllUsers(List<CruPsAllUser> cruPsAllUsers) {
		this.cruPsAllUsers = cruPsAllUsers;
	}

	public CruPsAllUser addCruPsAllUser(CruPsAllUser cruPsAllUser) {
		getCruPsAllUsers().add(cruPsAllUser);
		cruPsAllUser.setCruPermScheme(this);

		return cruPsAllUser;
	}

	public CruPsAllUser removeCruPsAllUser(CruPsAllUser cruPsAllUser) {
		getCruPsAllUsers().remove(cruPsAllUser);
		cruPsAllUser.setCruPermScheme(null);

		return cruPsAllUser;
	}

	public List<CruPsAnon> getCruPsAnons() {
		return this.cruPsAnons;
	}

	public void setCruPsAnons(List<CruPsAnon> cruPsAnons) {
		this.cruPsAnons = cruPsAnons;
	}

	public CruPsAnon addCruPsAnon(CruPsAnon cruPsAnon) {
		getCruPsAnons().add(cruPsAnon);
		cruPsAnon.setCruPermScheme(this);

		return cruPsAnon;
	}

	public CruPsAnon removeCruPsAnon(CruPsAnon cruPsAnon) {
		getCruPsAnons().remove(cruPsAnon);
		cruPsAnon.setCruPermScheme(null);

		return cruPsAnon;
	}

	public List<CruPsGroup> getCruPsGroups() {
		return this.cruPsGroups;
	}

	public void setCruPsGroups(List<CruPsGroup> cruPsGroups) {
		this.cruPsGroups = cruPsGroups;
	}

	public CruPsGroup addCruPsGroup(CruPsGroup cruPsGroup) {
		getCruPsGroups().add(cruPsGroup);
		cruPsGroup.setCruPermScheme(this);

		return cruPsGroup;
	}

	public CruPsGroup removeCruPsGroup(CruPsGroup cruPsGroup) {
		getCruPsGroups().remove(cruPsGroup);
		cruPsGroup.setCruPermScheme(null);

		return cruPsGroup;
	}

	public List<CruPsReviewRole> getCruPsReviewRoles() {
		return this.cruPsReviewRoles;
	}

	public void setCruPsReviewRoles(List<CruPsReviewRole> cruPsReviewRoles) {
		this.cruPsReviewRoles = cruPsReviewRoles;
	}

	public CruPsReviewRole addCruPsReviewRole(CruPsReviewRole cruPsReviewRole) {
		getCruPsReviewRoles().add(cruPsReviewRole);
		cruPsReviewRole.setCruPermScheme(this);

		return cruPsReviewRole;
	}

	public CruPsReviewRole removeCruPsReviewRole(CruPsReviewRole cruPsReviewRole) {
		getCruPsReviewRoles().remove(cruPsReviewRole);
		cruPsReviewRole.setCruPermScheme(null);

		return cruPsReviewRole;
	}

	public List<CruPsUser> getCruPsUsers() {
		return this.cruPsUsers;
	}

	public void setCruPsUsers(List<CruPsUser> cruPsUsers) {
		this.cruPsUsers = cruPsUsers;
	}

	public CruPsUser addCruPsUser(CruPsUser cruPsUser) {
		getCruPsUsers().add(cruPsUser);
		cruPsUser.setCruPermScheme(this);

		return cruPsUser;
	}

	public CruPsUser removeCruPsUser(CruPsUser cruPsUser) {
		getCruPsUsers().remove(cruPsUser);
		cruPsUser.setCruPermScheme(null);

		return cruPsUser;
	}

}