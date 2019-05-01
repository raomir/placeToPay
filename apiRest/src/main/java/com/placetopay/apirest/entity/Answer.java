package com.placetopay.apirest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="answer", schema = "")
public class Answer implements Serializable {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Id
	@JoinColumn(name="request_id")
	private Long request_id;
	
	@JoinColumn(name="name")
	private String name;
	
	@JoinColumn(name="document")
	private String document;
	
	@JoinColumn(name="total")
	private String total;
	
	@JoinColumn(name="status")
	private String status;
	
	@JoinColumn(name="reason")
	private String reason;
	
	@JoinColumn(name="message")
	private String message;
	
	@JoinColumn(name="date")
	private String date;
	
	@JoinColumn(name="process_url")
	private String process_url;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRequestId() {
		return request_id;
	}
	
	public void setRequestId(Long requestId) {
		this.request_id = requestId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public String getTotal() {
		return total;
	}
	
	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getProcessUrl() {
		return process_url;
	}
	
	public void setProcessUrl(String processUrl) {
		this.process_url = processUrl;
	}
}
