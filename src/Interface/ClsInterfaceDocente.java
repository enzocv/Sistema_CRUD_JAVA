
package Interface;

import Entidad.ClsEntidadDocente;
import java.util.ArrayList;


public interface ClsInterfaceDocente {
    void AgregarDocente(ClsEntidadDocente Docente);
    
    void ModificarDocente(String codigo,ClsEntidadDocente Docente);
    
    void EliminarDocente(String codigo);
    
    public ArrayList ListarDocente();
    
    //public ResultSet LoginDocente(String usuario, String password) throws Exception;
}
