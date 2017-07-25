package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_INVITEES database table.
 * 
 */
@Entity
@Table(name="CRU_INVITEES")
@NamedQuery(name="CruInvitee.findAll", query="SELECT c FROM CruInvitee c")
public class CruInvitee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CRU_ADDRESS")
	private String cruAddress;

	//bi-directional many-to-one association to CruReview
	@ManyToOne
	@JoinColumn(name="CRU_REVIEW_ID")
	private CruReview cruReview;

	public CruInvitee() {
	}

	public String getCruAddress() {
		return this.cruAddress;
	}

	public void setCruAddress(String cruAddress) {
		this.cruAddress = cruAddress;
	}

	public CruReview getCruReview() {
		return this.cruReview;
	}

	public void setCruReview(CruReview cruReview) {
		this.cruReview = cruReview;
	}

}