package com.krakentouch.server.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TCP")
@XmlType(name = "ComputeScoreBean", propOrder = { "command", "result", "note", "computeScoreBeanValue"})
public class ComputeScoreBean {
	@XmlElement(name = "action", required = true)
	private String command; // <Command>login</Command>
	
	@XmlElement(name = "Result", required = true)
	private String result; // <Result>1</Result> ----1 成功 0 失败
	
	@XmlElement(name="Note", required = true)
	private String note; // <Note>....</Note> ----备注
	
	@XmlElement(name="value", required = true)
	private ComputeScoreBeanValue computeScoreBeanValue;
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ComputeScoreBeanValue getComputeScoreBeanValue() {
		return computeScoreBeanValue;
	}

	public void setComputeScoreBeanValue(ComputeScoreBeanValue computeScoreBeanValue) {
		this.computeScoreBeanValue = computeScoreBeanValue;
	}
}
