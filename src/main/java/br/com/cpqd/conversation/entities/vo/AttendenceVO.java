package br.com.cpqd.conversation.entities.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_attendance")
public class AttendenceVO {

	@Id
	private String attendanceid;

	private Integer amount;

	public String getAttendanceid() {
		return attendanceid;
	}

	public void setAttendanceid(String attendanceid) {
		this.attendanceid = attendanceid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
