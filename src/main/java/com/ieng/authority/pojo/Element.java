package com.ieng.authority.pojo;

public class Element {
	private Integer id;
	private String eleno;

	public Element() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEleno() {
		return eleno;
	}

	public void setEleno(String eleno) {
		this.eleno = eleno;
	}

	@Override
	public String toString() {
		return "Element [id=" + id + ", eleno=" + eleno + "]";
	}

}
