
package Negocio;

import Entidad.ClsEntidadUsuario;
import Interface.ClsInterfaceUsuario;
import Conexion.ClsConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ClsNegocioUsuario implements ClsInterfaceUsuario{

    private Connection conexion = new ClsConexion().getConnection();
    
    @Override
    public void AgregarUsuario(ClsEntidadUsuario Usuario) {
        try {
            CallableStatement cst = conexion.prepareCall("{call USP_Usuario_I(?,?,?,?,?)}");
            cst.setString("pcod_doc", Usuario.getCodDoc());
            cst.setString("pnomb_usu", Usuario.getNombUsu());
            cst.setString("ppass_usu", Usuario.getPassUsu());
            cst.setString("pnivel_usu", Usuario.getNivelUsu());
            cst.setString("pestado_usu", Usuario.getEstadoUsu());
            cst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void ModificarUsuario(String codigo, ClsEntidadUsuario Usuario) {
        try {
            CallableStatement cst = conexion.prepareCall("{call USP_Usuario_U(?,?,?,?,?,?)}");
            cst.setString("pid_usu",codigo);
            cst.setString("pcod_doc", Usuario.getCodDoc());
            cst.setString("pnomb_usu", Usuario.getNombUsu());
            cst.setString("ppass_usu", Usuario.getPassUsu());
            cst.setString("pnivel_usu", Usuario.getNivelUsu());
            cst.setString("pestado_usu", Usuario.getEstadoUsu());
            cst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void EliminarUsuario(String codigo) {
        try {
            CallableStatement cst = conexion.prepareCall("{call USP_Usuario_D(?)}");
            cst.setString("pid_usu",codigo);
            cst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList ListarUsuario() {
        ArrayList<ClsEntidadUsuario> Usuario = new ArrayList<ClsEntidadUsuario>();
        
        try {
            CallableStatement cst = conexion.prepareCall("{call USP_UsuarioDocente()}");
            ResultSet rs = cst.executeQuery();
            
            while (rs.next()) {
                ClsEntidadUsuario Usu = new ClsEntidadUsuario();
                
                Usu.setIdUs(rs.getString("id_usu"));
                Usu.setNombDoc(rs.getString("nomb_doc"));
                Usu.setApelDoc(rs.getString("apel_doc"));
                Usu.setNombUsu(rs.getString("nomb_usu"));
                Usu.setPassUsu(rs.getString("pass_usu"));
                Usu.setNivelUsu(rs.getString("nivel_usu"));
                Usu.setEstadoUsu(rs.getString("estado_usu"));
                Usuario.add(Usu);
            }
            return Usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultSet LoginUsuario(String usuario, String password) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement cst = conexion.prepareCall("{call USP_Usuario_Login(?,?)}");
            cst.setString("pnomb_usu", usuario);
            cst.setString("ppass_usu", password);
            
            rs = cst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    
}
