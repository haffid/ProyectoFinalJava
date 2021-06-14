package modelo;

import java.util.ArrayList;

public interface ConsultasPunteoDAO {

    public void insertar(PunteoVO p);

    public void actualizar(PunteoVO p);

    public void eliminar(PunteoVO p);

    public ArrayList<PunteoVO> consultarTabla(int dato);
}
