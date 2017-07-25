package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_INLINE_COMMENT_TO_FRX_REV database table.
 * 
 */
@Entity
@Table(name="CRU_INLINE_COMMENT_TO_FRX_REV")
@NamedQuery(name="CruInlineCommentToFrxRev.findAll", query="SELECT c FROM CruInlineCommentToFrxRev c")
public class CruInlineCommentToFrxRev implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_IC_TO_FRX_REV_ID")
	private long cruIcToFrxRevId;

	@Column(name="CRU_LINE_RANGE")
	private String cruLineRange;

	//bi-directional many-to-one association to CruFrxRevision
	@ManyToOne
	@JoinColumn(name="CRU_FRX_REV_ID")
	private CruFrxRevision cruFrxRevision;

	//bi-directional many-to-one association to CruInlineComment
	@ManyToOne
	@JoinColumn(name="CRU_INLINE_COMMENT_ID")
	private CruInlineComment cruInlineComment;

	public CruInlineCommentToFrxRev() {
	}

	public long getCruIcToFrxRevId() {
		return this.cruIcToFrxRevId;
	}

	public void setCruIcToFrxRevId(long cruIcToFrxRevId) {
		this.cruIcToFrxRevId = cruIcToFrxRevId;
	}

	public String getCruLineRange() {
		return this.cruLineRange;
	}

	public void setCruLineRange(String cruLineRange) {
		this.cruLineRange = cruLineRange;
	}

	public CruFrxRevision getCruFrxRevision() {
		return this.cruFrxRevision;
	}

	public void setCruFrxRevision(CruFrxRevision cruFrxRevision) {
		this.cruFrxRevision = cruFrxRevision;
	}

	public CruInlineComment getCruInlineComment() {
		return this.cruInlineComment;
	}

	public void setCruInlineComment(CruInlineComment cruInlineComment) {
		this.cruInlineComment = cruInlineComment;
	}

}