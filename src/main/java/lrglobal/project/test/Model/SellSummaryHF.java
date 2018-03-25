package lrglobal.project.test.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.NamedNativeQueries;

/*
 * Calling process of a procedure from sql database to java 
 * */
 
//@NamedNativeQueries({
//	@NamedNativeQuery(
//			name="insert_hedge_sell_record",
//			query ="CALL insert_hedge_sell_record()",
//			hints=	@javax.persistence.QueryHint(name = "org.hibernate.callable", value = "true"),
//			resultClass=SellSummaryHF.class
//			)	
//})
@Entity
@Table(name="sell_summeryhf")
public class SellSummaryHF {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="summaryId")
	private long id;
	
	@Column(name="row_labels")
	private String rowLabels;
	
	@Column(name="Market_Value")
	private Double Market_Value;
	
	@Column(name="Share_Held")
	private Double share_Held;
	
	@Column(name="Change_in_shares")
	private Double changeInShare;
	
	@Column(name="Net_Buy_Sell")
	private Double net_buy_sell;
	
	@Column(name="Source_date")
	private String source_date;
	
	@Column(name="Symbol")
	private String symbol;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRowLabels() {
		return rowLabels;
	}

	public void setRowLabels(String rowLabels) {
		this.rowLabels = rowLabels;
	}

	public Double getMarket_Value() {
		return Market_Value;
	}

	public void setMarket_Value(Double market_Value) {
		Market_Value = market_Value;
	}

	public Double getShare_Held() {
		return share_Held;
	}

	public void setShare_Held(Double share_Held) {
		this.share_Held = share_Held;
	}

	public Double getChangeInShare() {
		return changeInShare;
	}

	public void setChangeInShare(Double changeInShare) {
		this.changeInShare = changeInShare;
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

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "SellSummaryHF [id=" + id + ", rowLabels=" + rowLabels + ", Market_Value=" + Market_Value
				+ ", share_Held=" + share_Held + ", changeInShare=" + changeInShare + ", net_buy_sell=" + net_buy_sell
				+ ", source_date=" + source_date + ", symbol=" + symbol + ", getId()=" + getId() + ", getRowLabels()="
				+ getRowLabels() + ", getMarket_Value()=" + getMarket_Value() + ", getShare_Held()=" + getShare_Held()
				+ ", getChangeInShare()=" + getChangeInShare() + ", getNet_buy_sell()=" + getNet_buy_sell()
				+ ", getSource_date()=" + getSource_date() + ", getSymbol()=" + getSymbol() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
