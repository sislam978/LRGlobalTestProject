package lrglobal.project.test.Model;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@NamedNativeQueries({
	@NamedNativeQuery(
			name="change_in_macro_data",
			query ="CALL change_in_macro_data(:q_MacroName)",
			hints=	@javax.persistence.QueryHint(name = "org.hibernate.callable", value = "true"),
			resultClass=MacroData.class
			)	
})
@Entity
@Table(name="macro_data")
public class MacroData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="macro_id")
	private long macro_id;
	
	@Column(name="macro_name")
	private String macro_name;
	
	@Column(name="macro_value")
	private Double macro_value;
	
	@Column(name="date")
	private String date;
	
	@Column(name="created_by")
	private Integer created_by;
	
	@Column(name="created_on")
	private String created_on;
	
	@Column(name="deleted_by")
	private Integer deleted_by;
	
	@Column(name="deleted_on")
	private String deleted_on;

	public long getMacro_id() {
		return macro_id;
	}

	public void setMacro_id(long macro_id) {
		this.macro_id = macro_id;
	}

	public String getMacro_name() {
		return macro_name;
	}

	public void setMacro_name(String macro_name) {
		this.macro_name = macro_name;
	}

	public Double getMacro_value() {
		return macro_value;
	}

	public void setMacro_value(Double macro_value) {
		this.macro_value = macro_value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public Integer getDeleted_by() {
		return deleted_by;
	}

	public void setDeleted_by(Integer deleted_by) {
		this.deleted_by = deleted_by;
	}

	public String getDeleted_on() {
		return deleted_on;
	}

	public void setDeleted_on(String deleted_on) {
		this.deleted_on = deleted_on;
	}
	
	public static Comparator<MacroData> MacroComparator = new Comparator<MacroData>() {

	public int compare(MacroData s1, MacroData s2) {
	   String macro1 = s1.getMacro_name().toUpperCase();
	   String macro2 = s2.getMacro_name().toUpperCase();

	   //ascending order
	   return macro1.compareTo(macro2);

	   //descending order
	   //return StudentName2.compareTo(StudentName1);
    }};

	@Override
	public String toString() {
		return "MacroData [macro_name=" + macro_name + ", macro_value=" + macro_value + ", date=" + date + "]";
	}
	
	

}
