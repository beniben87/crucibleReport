package be.beniben.cruciblemodel;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CRU_RECENTLY_VISITED database table.
 * 
 */
@Entity
@Table(name="CRU_RECENTLY_VISITED")
@NamedQuery(name="CruRecentlyVisited.findAll", query="SELECT c FROM CruRecentlyVisited c")
public class CruRecentlyVisited implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CruRecentlyVisitedPK id;

	@Column(name="CRU_LAST_VIEWED")
	private BigDecimal cruLastViewed;

	public CruRecentlyVisited() {
	}

	public CruRecentlyVisitedPK getId() {
		return this.id;
	}

	public void setId(CruRecentlyVisitedPK id) {
		this.id = id;
	}

	public BigDecimal getCruLastViewed() {
		return this.cruLastViewed;
	}

	public void setCruLastViewed(BigDecimal cruLastViewed) {
		this.cruLastViewed = cruLastViewed;
	}

}