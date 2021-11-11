package cl.padget.desafiouno.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

import cl.padget.desafiouno.model.Periodo;
import cl.padget.desafiouno.model.PeriodoExtendido;
import reactor.core.publisher.Mono;

@Service
public class DesafioUnoService
{

	public PeriodoExtendido obtenerPeriodoFaltante()
	{
		WebClient clienteApiGenerador = WebClient.builder()
				.baseUrl("http://127.0.0.1:8080/periodos/api")
				.defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
				.build();
		RequestHeadersUriSpec<?> reqSpect = clienteApiGenerador.get();
		Mono<Periodo> monoPeriodo = reqSpect.retrieve().bodyToMono(Periodo.class);
		Periodo periodoObtenido = monoPeriodo.block();
		
		PeriodoExtendido resultado = new PeriodoExtendido();
		resultado.setId(periodoObtenido.getId());
		resultado.setFechaCreacion(periodoObtenido.getFechaCreacion());
		resultado.setFechaFin(periodoObtenido.getFechaFin());
		resultado.setFechas(periodoObtenido.getFechas());

		Set<LocalDate> fechas = new HashSet<LocalDate>(resultado.getFechas());
		LocalDate inicio = resultado.getFechaCreacion();
		LocalDate fin = resultado.getFechaFin();
		List<LocalDate> faltantes = new ArrayList<>();
		while(inicio.compareTo(fin) <= 0) {
			boolean existe = fechas.contains(inicio);
			if(!existe) {
				faltantes.add(inicio);
			}
			inicio = inicio.plusMonths(1);
		}
		resultado.setFechasFaltantes(faltantes);
		return resultado;
	}
}
