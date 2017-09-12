package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_COMMENT_READ_STATUS database table.
 * 
 */
@Entity
@Table(name="CRU_COMMENT_READ_STATUS")
@NamedQuery(name="CruCommentReadStatus.findAll", query="SELECT c FROM CruCommentReadStatus c")
public class CruCommentReadStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_COMMENT_READ_STATUS_ID")
	private long cruCommentReadStatusId;

	@Column(name="CRU_READ")
	private BigDecimal cruRead;

	//bi-directional many-to-one association to CruComment
	@ManyToOne
	@JoinColumn(name="CRU_COMMENT")
	private CruComment cruCommentBean;

	//bi-directional many-to-one association to CruUser
	@ManyToOne
	@JoinColumn(name="CRU_USER")
	private CruUser cruUserBean;

	public CruCommentReadStatus() {
	}

	public long getCruCommentReadStatusId() {
		return this.cruCommentReadStatusId;
	}

	public void setCruCommentReadStatusId(long cruCommentReadStatusId) {
		this.cruCommentReadStatusId = cruCommentReadStatusId;
	}

	public BigDecimal getCruRead() {
		return this.cruRead;
	}

	public void setCruRead(BigDecimal cruRead) {
		this.cruRead = cruRead;
	}

	public CruComment getCruCommentBean() {
		return this.cruCommentBean;
	}

	public void setCruCommentBean(CruComment cruCommentBean) {
		this.cruCommentBean = cruCommentBean;
	}

	public CruUser getCruUserBean() {
		return this.cruUserBean;
	}

	public void setCruUserBean(CruUser cruUserBean) {
		this.cruUserBean = cruUserBean;
	}

}