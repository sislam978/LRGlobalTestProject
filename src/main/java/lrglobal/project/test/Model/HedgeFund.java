package lrglobal.project.test.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hedgefund2")
public class HedgeFund {
	
	@Id
	@Column(name="hedgeID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="StockName")
	private String stockName;
	
	@Column(name="Symbol")
	private String symbol;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="Share_Held")
	private Double shareHeld;
	
	@Column(name="Market_Value")
	private Double marketValue;
	
	@Column(name="PercentOfPortfolio")
	private Double per_Portfolio;
	
	@Column(name="PrevPerOfPortfolio")
	private Double prev_perPortfolio;
	
	
	@Column(name="Ranking")
	private Integer ranking;
	
	@Column(name="ChangeinShare")
	private Double changInshare;
	
	@Column(name="perChange")
	private Double perChange;
	
	@Column(name="ChangeType")
	private String changeType;
	
	@Column(name="OwnerShip")
	private Double ownerShip;
	
	@Column(name="QtrFirstOwned")
	private String qtrFirstOwned;
	
	@Column(name="sector")
	private String sector;
	
	@Column(name="source_type")
	private String source_type;
	
	@Column(name="source_date")
	private String source_date;
	
	@Column(name="Name_of_Fund")
	private String nameOfFund;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getShareHeld() {
		return shareHeld;
	}

	public void setShareHeld(Double shareHeld) {
		this.shareHeld = shareHeld;
	}

	public Double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}

	public Double getPer_Portfolio() {
		return per_Portfolio;
	}

	public void setPer_Portfolio(Double per_Portfolio) {
		this.per_Portfolio = per_Portfolio;
	}

	public Double getPrev_perPortfolio() {
		return prev_perPortfolio;
	}

	public void setPrev_perPortfolio(Double prev_perPortfolio) {
		this.prev_perPortfolio = prev_perPortfolio;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Double getChangInshare() {
		return changInshare;
	}

	public void setChangInshare(Double changInshare) {
		this.changInshare = changInshare;
	}

	public Double getPerChange() {
		return perChange;
	}

	public void setPerChange(Double perChange) {
		this.perChange = perChange;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public Double getOwnerShip() {
		return ownerShip;
	}

	public void setOwnerShip(Double ownerShip) {
		this.ownerShip = ownerShip;
	}

	public String getQtrFirstOwned() {
		return qtrFirstOwned;
	}

	public void setQtrFirstOwned(String qtrFirstOwned) {
		this.qtrFirstOwned = qtrFirstOwned;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSource_type() {
		return source_type;
	}

	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}

	public String getSource_date() {
		return source_date;
	}

	public void setSource_date(String source_date) {
		this.source_date = source_date;
	}

	public String getNameOfFund() {
		return nameOfFund;
	}

	public void setNameOfFund(String nameOfFund) {
		this.nameOfFund = nameOfFund;
	}

	@Override
	public String toString() {
		return "HedgeFund [id=" + id + ", stockName=" + stockName + ", symbol=" + symbol + ", type=" + type
				+ ", shareHeld=" + shareHeld + ", marketValue=" + marketValue + ", per_Portfolio=" + per_Portfolio
				+ ", prev_perPortfolio=" + prev_perPortfolio + ", ranking=" + ranking + ", changInshare=" + changInshare
				+ ", perChange=" + perChange + ", changeType=" + changeType + ", ownerShip=" + ownerShip
				+ ", qtrFirstOwned=" + qtrFirstOwned + ", sector=" + sector + ", source_type=" + source_type
				+ ", source_date=" + source_date + ", nameOfFund=" + nameOfFund + ", getId()=" + getId()
				+ ", getStockName()=" + getStockName() + ", getSymbol()=" + getSymbol() + ", getType()=" + getType()
				+ ", getShareHeld()=" + getShareHeld() + ", getMarketValue()=" + getMarketValue()
				+ ", getPer_Portfolio()=" + getPer_Portfolio() + ", getPrev_perPortfolio()=" + getPrev_perPortfolio()
				+ ", getRanking()=" + getRanking() + ", getChangInshare()=" + getChangInshare() + ", getPerChange()="
				+ getPerChange() + ", getChangeType()=" + getChangeType() + ", getOwnerShip()=" + getOwnerShip()
				+ ", getQtrFirstOwned()=" + getQtrFirstOwned() + ", getSector()=" + getSector() + ", getSource_type()="
				+ getSource_type() + ", getSource_date()=" + getSource_date() + ", getNameOfFund()=" + getNameOfFund()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
