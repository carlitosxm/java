package com.krakedev.evaluacion;

public class Direccion {
	private String callePrincipal;
	private String CalleSecundaria;
	public Direccion(String callePrincipal, String calleSecundaria) {
		super();
		this.callePrincipal = callePrincipal;
		CalleSecundaria = calleSecundaria;
	}
	public String getCallePrincipal() {
		return callePrincipal;
	}
	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}
	public String getCalleSecundaria() {
		return CalleSecundaria;
	}
	public void setCalleSecundaria(String calleSecundaria) {
		CalleSecundaria = calleSecundaria;
	}
}
