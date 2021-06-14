package modelo;

public class PunteoVO {

    private int id_score;
    private int punteo_score;
    private int id_usuario_fk;

    public PunteoVO() {
    }

    public int getId_score() {
        return id_score;
    }

    public void setId_score(int id_score) {
        this.id_score = id_score;
    }

    public int getPunteo_score() {
        return punteo_score;
    }

    public void setPunteo_score(int punteo_score) {
        this.punteo_score = punteo_score;
    }

    public int getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(int id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

}
