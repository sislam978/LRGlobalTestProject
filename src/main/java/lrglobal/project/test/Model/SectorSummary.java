package lrglobal.project.test.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sector_summary")
public class SectorSummary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sector_id")
	private long sector_id;
	
	@Column(name="sector_name")
	private String sector_name;
	
	@Column(name="shares_held")
	private Double shares_held;
	
	@Column(name="market_value")
	private Double market_value;
	
	@Column(name="change_in_share")
	private Double change_in_Share;
	
	@Column(name="net_buy_sell")
	private  Double net_buy_sell;
	
	@Column(name="source_date")
	private String source_date;

	public long getSector_id() {
		return sector_id;
	}

	public void setSector_id(long sector_id) {
		this.sector_id = sector_id;
	}

	public String getSector_name() {
		return sector_name;
	}

	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}

	public Double getShares_held() {
		return shares_held;
	}

	public void setShares_held(Double shares_held) {
		this.shares_held = shares_held;
	}

	public Double getMarket_value() {
		return market_value;
	}

	public void setMarket_value(Double market_value) {
		this.market_value = market_value;
	}

	public Double getChange_in_Share() {
		return change_in_Share;
	}

	public void setChange_in_Share(Double change_in_Share) {
		this.change_in_Share = change_in_Share;
	}

	public Double getNet_buy_sell() {
		return net_buy_sell;
	}

	public void setNet_buy_sell(Double net_buy_sell) {
		this.net_buy_sell = net_buy_sell;
	}

	public String getSource_date() {
		return source_date;
	}

	public void setSource_date(String source_date) {
		this.source_date = source_date;
	}

	@Override
	public String toString() {
		return "SectorSummary [sector_id=" + sector_id + ", sector_name=" + sector_name + ", shares_held=" + shares_held
				+ ", market_value=" + market_value + ", change_in_Share=" + change_in_Share + ", net_buy_sell="
				+ net_buy_sell + ", source_date=" + source_date + ", getSector_id()=" + getSector_id()
				+ ", getSector_name()=" + getSector_name() + ", getShares_held()=" + getShares_held()
				+ ", getMarket_value()=" + getMarket_value() + ", getChange_in_Share()=" + getChange_in_Share()
				+ ", getNet_buy_sell()=" + getNet_buy_sell() + ", getSource_date()=" + getSource_date()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
