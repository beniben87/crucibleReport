package be.beniben.cruciblereport.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CRU_METRIC_DEFINITION database table.
 * 
 */
@Entity
@Table(name="CRU_METRIC_DEFINITION")
@NamedQuery(name="CruMetricDefinition.findAll", query="SELECT c FROM CruMetricDefinition c")
public class CruMetricDefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRU_METRIC_ID")
	private long cruMetricId;

	@Lob
	@Column(name="CRU_XML")
	private String cruXml;

	public CruMetricDefinition() {
	}

	public long getCruMetricId() {
		return this.cruMetricId;
	}

	public void setCruMetricId(long cruMetricId) {
		this.cruMetricId = cruMetricId;
	}

	public String getCruXml() {
		return this.cruXml;
	}

	public void setCruXml(String cruXml) {
		this.cruXml = cruXml;
	}

}