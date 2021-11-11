package cl.padget.desafiouno.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Periodo
{
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaCreacion;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaFin;
	private List<LocalDate> fechas;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public LocalDate getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaFin()
	{
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin)
	{
		this.fechaFin = fechaFin;
	}

	public List<LocalDate> getFechas()
	{
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas)
	{
		this.fechas = fechas;
	}
}