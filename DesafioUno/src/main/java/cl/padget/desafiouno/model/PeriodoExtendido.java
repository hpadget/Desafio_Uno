package cl.padget.desafiouno.model;

import java.time.LocalDate;
import java.util.List;

public class PeriodoExtendido extends Periodo
{
	private List<LocalDate> fechasFaltantes;

	public List<LocalDate> getFechasFaltantes()
	{
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<LocalDate> fechasFaltantes)
	{
		this.fechasFaltantes = fechasFaltantes;
	}
}
