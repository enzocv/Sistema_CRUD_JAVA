
package Entidad;

public class ClsEntidadUsuario {    
    
    //Atributos de Usuario
    private String idUs; //Id usuario
    private String CodDoc; //Código usuario
    private String NombDoc;
    private String ApelDoc; //Apellido usuario
    private String NombUsu; //Nombre usuario
    private String PassUsu; //Password usuario
    private String NivelUsu; //Nivel usuario
    private String EstadoUsu; //Estado usuario
    
    
    // GETTERS Y SETTERS DE ATRIBUTOS
    public String getIdUs() {
        return idUs;
    }

    public void setIdUs(String idUs) {
        this.idUs = idUs;
    }

    public String getCodDoc() {
        return CodDoc;
    }

    public void setCodDoc(String CodDoc) {
        this.CodDoc = CodDoc;
    }

    public String getApelDoc() {
        return ApelDoc;
    }

    public void setApelDoc(String ApelDoc) {
        this.ApelDoc = ApelDoc;
    }

    public String getNombUsu() {
        return NombUsu;
    }

    public void setNombUsu(String NombUsu) {
        this.NombUsu = NombUsu;
    }

    public String getPassUsu() {
        return PassUsu;
    }

    public void setPassUsu(String PassUsu) {
        this.PassUsu = PassUsu;
    }

    public String getNivelUsu() {
        return NivelUsu;
    }

    public void setNivelUsu(String NivelUsu) {
        this.NivelUsu = NivelUsu;
    }

    public String getEstadoUsu() {
        return EstadoUsu;
    }

    public void setEstadoUsu(String EstadoUsu) {
        this.EstadoUsu = EstadoUsu;
    }
    public String getNombDoc() {
        return NombDoc;
    }

    public void setNombDoc(String NombDoc) {
        this.NombDoc = NombDoc;
    }
}
