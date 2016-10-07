
package Interface;

import Entidad.ClsEntidadUsuario;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface ClsInterfaceUsuario {
    void AgregarUsuario(ClsEntidadUsuario Usuario);
    
    void ModificarUsuario(String codigo,ClsEntidadUsuario Usuario);
    
    void EliminarUsuario(String codigo);
    
    public ArrayList ListarUsuario();
    
    public ResultSet LoginUsuario(String usuario, String password) throws Exception;
}
