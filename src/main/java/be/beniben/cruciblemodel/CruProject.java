package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_PROJECT database table.
 * 
 */
@Entity
@Table(name="CRU_PROJECT")
@NamedQuery(name="CruProject.findAll", query="SELECT c FROM CruProject c")
public class CruProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_PROJECT_ID")
	private long cruProjectId;

	@Column(name="CRU_ALLOW_REVIEWERS_TO_JOIN")
	private BigDecimal cruAllowReviewersToJoin;

	@Column(name="CRU_DEFAULT_DURATION")
	private BigDecimal cruDefaultDuration;

	@Lob
	@Column(name="CRU_DEFAULT_OBJECTIVES")
	private String cruDefaultObjectives;

	@Column(name="CRU_DEFAULT_REPOSITORY_NAME")
	private String cruDefaultRepositoryName;

	@Column(name="CRU_DISABLE_MODERATOR")
	private BigDecimal cruDisableModerator;

	@Column(name="CRU_NAME")
	private String cruName;

	@Column(name="CRU_PROJ_KEY")
	private String cruProjKey;

	@Column(name="CRU_STORE_REVISIONS")
	private BigDecimal cruStoreRevisions;

	//bi-directional many-to-one association to CruContentRoot
	@OneToMany(mappedBy="cruProjectBean")
	private List<CruContentRoot> cruContentRoots;

	//bi-directional many-to-one association to CruPermScheme
	@ManyToOne
	@JoinColumn(name="CRU_PERMISSION_SCHEME")
	private CruPermScheme cruPermScheme;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_DEFAULT_MODERATOR")
	private CruUser cruUser;

	//bi-directional many-to-one association to CruProjAllowedGrp
	@OneToMany(mappedBy="cruProject")
	private List<CruProjAllowedGrp> cruProjAllowedGrps;

	//bi-directional many-to-many association to CruUser
	@ManyToMany(mappedBy="cruProjects2")
	private List<CruUser> cruUsers1;

	//bi-directional many-to-one association to CruProjDefaultGrp
	@OneToMany(mappedBy="cruProject")
	private List<CruProjDefaultGrp> cruProjDefaultGrps;

	//bi-directional many-to-many association to CruUser
	@ManyToMany(mappedBy="cruProjects3")
	private List<CruUser> cruUsers2;

	//bi-directional many-to-one association to CruReview
	@OneToMany(mappedBy="cruProjectBean")
	private List<CruReview> cruReviews;

	public CruProject() {
	}

	public long getCruProjectId() {
		return this.cruProjectId;
	}

	public void setCruProjectId(long cruProjectId) {
		this.cruProjectId = cruProjectId;
	}

	public BigDecimal getCruAllowReviewersToJoin() {
		return this.cruAllowReviewersToJoin;
	}

	public void setCruAllowReviewersToJoin(BigDecimal cruAllowReviewersToJoin) {
		this.cruAllowReviewersToJoin = cruAllowReviewersToJoin;
	}

	public BigDecimal getCruDefaultDuration() {
		return this.cruDefaultDuration;
	}

	public void setCruDefaultDuration(BigDecimal cruDefaultDuration) {
		this.cruDefaultDuration = cruDefaultDuration;
	}

	public String getCruDefaultObjectives() {
		return this.cruDefaultObjectives;
	}

	public void setCruDefaultObjectives(String cruDefaultObjectives) {
		this.cruDefaultObjectives = cruDefaultObjectives;
	}

	public String getCruDefaultRepositoryName() {
		return this.cruDefaultRepositoryName;
	}

	public void setCruDefaultRepositoryName(String cruDefaultRepositoryName) {
		this.cruDefaultRepositoryName = cruDefaultRepositoryName;
	}

	public BigDecimal getCruDisableModerator() {
		return this.cruDisableModerator;
	}

	public void setCruDisableModerator(BigDecimal cruDisableModerator) {
		this.cruDisableModerator = cruDisableModerator;
	}

	public String getCruName() {
		return this.cruName;
	}

	public void setCruName(String cruName) {
		this.cruName = cruName;
	}

	public String getCruProjKey() {
		return this.cruProjKey;
	}

	public void setCruProjKey(String cruProjKey) {
		this.cruProjKey = cruProjKey;
	}

	public BigDecimal getCruStoreRevisions() {
		return this.cruStoreRevisions;
	}

	public void setCruStoreRevisions(BigDecimal cruStoreRevisions) {
		this.cruStoreRevisions = cruStoreRevisions;
	}

	public List<CruContentRoot> getCruContentRoots() {
		return this.cruContentRoots;
	}

	public void setCruContentRoots(List<CruContentRoot> cruContentRoots) {
		this.cruContentRoots = cruContentRoots;
	}

	public CruContentRoot addCruContentRoot(CruContentRoot cruContentRoot) {
		getCruContentRoots().add(cruContentRoot);
		cruContentRoot.setCruProjectBean(this);

		return cruContentRoot;
	}

	public CruContentRoot removeCruContentRoot(CruContentRoot cruContentRoot) {
		getCruContentRoots().remove(cruContentRoot);
		cruContentRoot.setCruProjectBean(null);

		return cruContentRoot;
	}

	public CruPermScheme getCruPermScheme() {
		return this.cruPermScheme;
	}

	public void setCruPermScheme(CruPermScheme cruPermScheme) {
		this.cruPermScheme = cruPermScheme;
	}

	public CruUser getCruUser() {
		return this.cruUser;
	}

	public void setCruUser(CruUser cruUser) {
		this.cruUser = cruUser;
	}

	public List<CruProjAllowedGrp> getCruProjAllowedGrps() {
		return this.cruProjAllowedGrps;
	}

	public void setCruProjAllowedGrps(List<CruProjAllowedGrp> cruProjAllowedGrps) {
		this.cruProjAllowedGrps = cruProjAllowedGrps;
	}

	public CruProjAllowedGrp addCruProjAllowedGrp(CruProjAllowedGrp cruProjAllowedGrp) {
		getCruProjAllowedGrps().add(cruProjAllowedGrp);
		cruProjAllowedGrp.setCruProject(this);

		return cruProjAllowedGrp;
	}

	public CruProjAllowedGrp removeCruProjAllowedGrp(CruProjAllowedGrp cruProjAllowedGrp) {
		getCruProjAllowedGrps().remove(cruProjAllowedGrp);
		cruProjAllowedGrp.setCruProject(null);

		return cruProjAllowedGrp;
	}

	public List<CruUser> getCruUsers1() {
		return this.cruUsers1;
	}

	public void setCruUsers1(List<CruUser> cruUsers1) {
		this.cruUsers1 = cruUsers1;
	}

	public List<CruProjDefaultGrp> getCruProjDefaultGrps() {
		return this.cruProjDefaultGrps;
	}

	public void setCruProjDefaultGrps(List<CruProjDefaultGrp> cruProjDefaultGrps) {
		this.cruProjDefaultGrps = cruProjDefaultGrps;
	}

	public CruProjDefaultGrp addCruProjDefaultGrp(CruProjDefaultGrp cruProjDefaultGrp) {
		getCruProjDefaultGrps().add(cruProjDefaultGrp);
		cruProjDefaultGrp.setCruProject(this);

		return cruProjDefaultGrp;
	}

	public CruProjDefaultGrp removeCruProjDefaultGrp(CruProjDefaultGrp cruProjDefaultGrp) {
		getCruProjDefaultGrps().remove(cruProjDefaultGrp);
		cruProjDefaultGrp.setCruProject(null);

		return cruProjDefaultGrp;
	}

	public List<CruUser> getCruUsers2() {
		return this.cruUsers2;
	}

	public void setCruUsers2(List<CruUser> cruUsers2) {
		this.cruUsers2 = cruUsers2;
	}

	public List<CruReview> getCruReviews() {
		return this.cruReviews;
	}

	public void setCruReviews(List<CruReview> cruReviews) {
		this.cruReviews = cruReviews;
	}

	public CruReview addCruReview(CruReview cruReview) {
		getCruReviews().add(cruReview);
		cruReview.setCruProjectBean(this);

		return cruReview;
	}

	public CruReview removeCruReview(CruReview cruReview) {
		getCruReviews().remove(cruReview);
		cruReview.setCruProjectBean(null);

		return cruReview;
	}

}