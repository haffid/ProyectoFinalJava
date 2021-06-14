package modelo;

public class UsuarioVO {

    private int id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private int edad_usuario;
    private String usuario;
    private String clave;
    private int id_estado_fk;
    private int id_tipo_usuario_fk;

    public UsuarioVO() {

    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public int getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(int edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_estado_fk() {
        return id_estado_fk;
    }

    public void setId_estado_fk(int id_estado_fk) {
        this.id_estado_fk = id_estado_fk;
    }

    public int getId_tipo_usuario_fk() {
        return id_tipo_usuario_fk;
    }

    public void setId_tipo_usuario_fk(int id_tipo_usuario_fk) {
        this.id_tipo_usuario_fk = id_tipo_usuario_fk;
    }

}
