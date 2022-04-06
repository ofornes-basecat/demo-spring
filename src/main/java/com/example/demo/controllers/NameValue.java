package com.example.demo.controllers;

public class NameValue implements Comparable<NameValue> {
	private String name;
	private String value;
	public NameValue() {
	}
	public NameValue(String name, String value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(NameValue o) {
		return name.compareTo(o.name);
	}
}
