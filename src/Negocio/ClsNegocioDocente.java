package Negocio;

import Entidad.ClsEntidadDocente;
import Interface.ClsInterfaceDocente;
import Conexion.ClsConexion;
import Entidad.ClsEntidadUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ClsNegocioDocente implements ClsInterfaceDocente {

    private Connection conexion = new ClsConexion().getConnection();
    
    @Override
    public void AgregarDocente(ClsEntidadDocente Docente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarDocente(String codigo, ClsEntidadDocente Docente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarDocente(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarDocente() {
        ArrayList<ClsEntidadDocente> Docente = new ArrayList<ClsEntidadDocente>();
        
        try {
            CallableStatement cst = conexion.prepareCall("{call USP_Docente_S()}");
            ResultSet rs = cst.executeQuery();
            
            while (rs.next()) {
                ClsEntidadDocente doc = new ClsEntidadDocente();
                
                doc.setCodDoc(rs.getString("cod_doc"));
                doc.setApelDoc(rs.getString("apel_doc"));
                doc.setNombDoc(rs.getString("nomb_doc"));
                doc.setDNIDoc(rs.getString("dni_doc"));
                doc.setEmailDoc(rs.getString("email_doc"));
                doc.setCelDoc(rs.getString("cel_doc"));
                doc.setFotoDoc(rs.getString("foto_doc"));
                doc.setEstadoDoc(rs.getString("estado_doc"));
                
                Docente.add(doc);
            }
            return Docente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
