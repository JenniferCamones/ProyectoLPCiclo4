package interfaces;

import java.util.List;

import beans.LocalDTO;


public interface LocalDAO {

	public List<LocalDTO> listarLocales();
	public int agregarLocal(LocalDTO l);
	public int actualizarLocal(LocalDTO l);
	public int  eliminarLocal(String idLocal) ;
	public String generarCodigo();
	public LocalDTO buscarLocal(String cod);

	
	
	
}
