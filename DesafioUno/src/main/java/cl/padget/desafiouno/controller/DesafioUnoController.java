package cl.padget.desafiouno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.padget.desafiouno.model.PeriodoExtendido;
import cl.padget.desafiouno.service.DesafioUnoService;

@RestController
@RequestMapping("/desafiouno")
public class DesafioUnoController
{
	@Autowired
	private DesafioUnoService servicio;

	@GetMapping(value = "/obtener")
	public ResponseEntity<PeriodoExtendido> obtenerFaltantes()
	{
		try {
			return new ResponseEntity<>(servicio.obtenerPeriodoFaltante(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}