package modelo.pregunta;

import java.util.ArrayList;

import modelo.Semilla;
import texto.Texto;
import texto.Textos_Archivos;
import texto.Textos_Preguntas;

public class PreguntaTopologica extends Pregunta {

	private ArrayList<Integer> recorridoTopologico;
	
	/** Constructor de la clase */
	public PreguntaTopologica(Integer nNodos, Double porcentajeDeArcos) {
		super(nNodos, porcentajeDeArcos, true);
	}
	
	
	public PreguntaTopologica(Semilla semilla){
		super(semilla);
	}	
	
	
	@Override
	protected void aplicarAlgoritmo() {
		recorridoTopologico = getGrafo().recorridoTopologico();
	}
	
	
	@Override
	protected void construirTitulo() {
		titulo = Textos_Preguntas.tituloPregClasificacionTopologica();
	}
	

	@Override
	protected void construirEnunciado() {
		enunciado = Textos_Preguntas.enunciadoPregClasificacionTopologica();
	}
	
	
	@Override
	protected void construirParteAResponder() {
		resultadoDeOrdenarElGrafo(recorridoTopologico);
	}

	@Override
	protected void construirRespuestaCorrecta() {
		respuestaCorrecta(recorridoTopologico);
	}
	
	
	@Override
	protected void generarSemilla(boolean grafoDirigido) {
		super.generarConsignaEnFuncionDelTipoDePregunta(Semilla.clasificacionTopologica, grafoDirigido);
	}


	@Override
	public Texto getNombreDeArchivo() {
		return Textos_Archivos.nombreArchivoPregTopologica();
	}

}
