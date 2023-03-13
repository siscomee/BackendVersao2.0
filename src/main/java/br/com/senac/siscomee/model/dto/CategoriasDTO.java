package br.com.senac.siscomee.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CategoriasDTO implements Serializable {

    private static final long serialVersionUID = 1L;

	private Integer id;
    private String nmCategoria;
	private short inAtivo;
	private int usuarioIdAtualiza;
	private Date dtUltAtualiza;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNmCategoria() {
		return nmCategoria;
	}
	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}
	public short getInAtivo() {
		return inAtivo;
	}
	public void setInAtivo(short inAtivo) {
		this.inAtivo = inAtivo;
	}
	public int getUsuarioIdAtualiza() {
		return usuarioIdAtualiza;
	}
	public void setUsuarioIdAtualiza(int usuarioIdAtualiza) {
		this.usuarioIdAtualiza = usuarioIdAtualiza;
	}
	public Date getDtUltAtualiza() {
		return dtUltAtualiza;
	}
	public void setDtUltAtualiza(Date dtUltAtualiza) {
		this.dtUltAtualiza = dtUltAtualiza;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	  
}
