package br.com.cpqd.conversation.entities.vo;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_messages")
public class MessageVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String channel;

	private String attendanceid;

	private String clientId;

	private String company;

	private String portfolio;

	private String dialog;

	private String message;

	private String requestId;

	private Instant moment;

	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAttendanceid() {
		return attendanceid;
	}

	public void setAttendanceid(String attendanceid) {
		this.attendanceid = attendanceid;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public String getDialog() {
		return dialog;
	}

	public void setDialog(String dialog) {
		this.dialog = dialog;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
