package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRU_FRX_REVISION database table.
 * 
 */
@Entity
@Table(name="CRU_FRX_REVISION")
@NamedQuery(name="CruFrxRevision.findAll", query="SELECT c FROM CruFrxRevision c")
public class CruFrxRevision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_FRX_REV_ID")
	private long cruFrxRevId;

	@Column(name="CRU_DATE_ADDED")
	private BigDecimal cruDateAdded;

	@Column(name="CRU_REVISION_ORDER")
	private BigDecimal cruRevisionOrder;

	//bi-directional many-to-one association to CruFrx
	@ManyToOne
	@JoinColumn(name="CRU_FRX_ID")
	private CruFrx cruFrx;

	//bi-directional many-to-one association to CruRevision
	@ManyToOne
	@JoinColumn(name="CRU_REVISION")
	private CruRevision cruRevisionBean;

	//bi-directional many-to-one association to CruInlineCommentToFrxRev
	@OneToMany(mappedBy="cruFrxRevision")
	private List<CruInlineCommentToFrxRev> cruInlineCommentToFrxRevs;

	public CruFrxRevision() {
	}

	public long getCruFrxRevId() {
		return this.cruFrxRevId;
	}

	public void setCruFrxRevId(long cruFrxRevId) {
		this.cruFrxRevId = cruFrxRevId;
	}

	public BigDecimal getCruDateAdded() {
		return this.cruDateAdded;
	}

	public void setCruDateAdded(BigDecimal cruDateAdded) {
		this.cruDateAdded = cruDateAdded;
	}

	public BigDecimal getCruRevisionOrder() {
		return this.cruRevisionOrder;
	}

	public void setCruRevisionOrder(BigDecimal cruRevisionOrder) {
		this.cruRevisionOrder = cruRevisionOrder;
	}

	public CruFrx getCruFrx() {
		return this.cruFrx;
	}

	public void setCruFrx(CruFrx cruFrx) {
		this.cruFrx = cruFrx;
	}

	public CruRevision getCruRevisionBean() {
		return this.cruRevisionBean;
	}

	public void setCruRevisionBean(CruRevision cruRevisionBean) {
		this.cruRevisionBean = cruRevisionBean;
	}

	public List<CruInlineCommentToFrxRev> getCruInlineCommentToFrxRevs() {
		return this.cruInlineCommentToFrxRevs;
	}

	public void setCruInlineCommentToFrxRevs(List<CruInlineCommentToFrxRev> cruInlineCommentToFrxRevs) {
		this.cruInlineCommentToFrxRevs = cruInlineCommentToFrxRevs;
	}

	public CruInlineCommentToFrxRev addCruInlineCommentToFrxRev(CruInlineCommentToFrxRev cruInlineCommentToFrxRev) {
		getCruInlineCommentToFrxRevs().add(cruInlineCommentToFrxRev);
		cruInlineCommentToFrxRev.setCruFrxRevision(this);

		return cruInlineCommentToFrxRev;
	}

	public CruInlineCommentToFrxRev removeCruInlineCommentToFrxRev(CruInlineCommentToFrxRev cruInlineCommentToFrxRev) {
		getCruInlineCommentToFrxRevs().remove(cruInlineCommentToFrxRev);
		cruInlineCommentToFrxRev.setCruFrxRevision(null);

		return cruInlineCommentToFrxRev;
	}

}