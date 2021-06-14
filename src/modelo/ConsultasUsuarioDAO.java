package modelo;

import java.util.ArrayList;

public interface ConsultasUsuarioDAO {

    public void insertar(UsuarioVO a);

    public void actualizar(UsuarioVO a);

    public void eliminar(UsuarioVO a);

    public ArrayList<UsuarioVO> consultarTabla();

    public ArrayList<UsuarioVO> validacion(UsuarioVO a);

    public void nivel(UsuarioVO a);
}
