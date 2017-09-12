package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_UPLOAD_ITEM database table.
 * 
 */
@Entity
@Table(name="CRU_UPLOAD_ITEM")
@NamedQuery(name="CruUploadItem.findAll", query="SELECT c FROM CruUploadItem c")
public class CruUploadItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_UPLOAD_ID")
	private long cruUploadId;

	@Column(name="CRU_CHARSET")
	private String cruCharset;

	@Column(name="CRU_CREATE_DATE")
	private BigDecimal cruCreateDate;

	@Lob
	@Column(name="CRU_DESCRIPTION")
	private String cruDescription;

	@Column(name="CRU_ORIGINAL_CONTENT_TYPE")
	private String cruOriginalContentType;

	@Column(name="CRU_ORIGINAL_NAME")
	private String cruOriginalName;

	//bi-directional many-to-one association to CruPatch
	@OneToMany(mappedBy="cruUploadItemBean")
	private List<CruPatch> cruPatches;

	//bi-directional many-to-one association to CruRevision
	@OneToMany(mappedBy="cruUploadItemBean")
	private List<CruRevision> cruRevisions;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER")
	private CruUser cruUserBean;

	public CruUploadItem() {
	}

	public long getCruUploadId() {
		return this.cruUploadId;
	}

	public void setCruUploadId(long cruUploadId) {
		this.cruUploadId = cruUploadId;
	}

	public String getCruCharset() {
		return this.cruCharset;
	}

	public void setCruCharset(String cruCharset) {
		this.cruCharset = cruCharset;
	}

	public BigDecimal getCruCreateDate() {
		return this.cruCreateDate;
	}

	public void setCruCreateDate(BigDecimal cruCreateDate) {
		this.cruCreateDate = cruCreateDate;
	}

	public String getCruDescription() {
		return this.cruDescription;
	}

	public void setCruDescription(String cruDescription) {
		this.cruDescription = cruDescription;
	}

	public String getCruOriginalContentType() {
		return this.cruOriginalContentType;
	}

	public void setCruOriginalContentType(String cruOriginalContentType) {
		this.cruOriginalContentType = cruOriginalContentType;
	}

	public String getCruOriginalName() {
		return this.cruOriginalName;
	}

	public void setCruOriginalName(String cruOriginalName) {
		this.cruOriginalName = cruOriginalName;
	}

	public List<CruPatch> getCruPatches() {
		return this.cruPatches;
	}

	public void setCruPatches(List<CruPatch> cruPatches) {
		this.cruPatches = cruPatches;
	}

	public CruPatch addCruPatch(CruPatch cruPatch) {
		getCruPatches().add(cruPatch);
		cruPatch.setCruUploadItemBean(this);

		return cruPatch;
	}

	public CruPatch removeCruPatch(CruPatch cruPatch) {
		getCruPatches().remove(cruPatch);
		cruPatch.setCruUploadItemBean(null);

		return cruPatch;
	}

	public List<CruRevision> getCruRevisions() {
		return this.cruRevisions;
	}

	public void setCruRevisions(List<CruRevision> cruRevisions) {
		this.cruRevisions = cruRevisions;
	}

	public CruRevision addCruRevision(CruRevision cruRevision) {
		getCruRevisions().add(cruRevision);
		cruRevision.setCruUploadItemBean(this);

		return cruRevision;
	}

	public CruRevision removeCruRevision(CruRevision cruRevision) {
		getCruRevisions().remove(cruRevision);
		cruRevision.setCruUploadItemBean(null);

		return cruRevision;
	}

	public CruUser getCruUserBean() {
		return this.cruUserBean;
	}

	public void setCruUserBean(CruUser cruUserBean) {
		this.cruUserBean = cruUserBean;
	}

}