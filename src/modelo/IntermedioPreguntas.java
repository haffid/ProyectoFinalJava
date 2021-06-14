package modelo;

public class IntermedioPreguntas {

    private String pregunta;
    public String respuesta1 = "Ceiba";
    public String respuesta2 = "1821";
    public String respuesta3 = "Marimba";
    public String respuesta4 = "Monja Blanca";
    public String respuesta5 = "José Joaquín Palma";

    public int intentos = 0, aciertos = 0, fallas = 0;
    public int intentos1 = 0, aciertos1 = 0, fallas1 = 0;
    public int intentos2 = 0, aciertos2 = 0, fallas2 = 0;
    public int intentos3 = 0, aciertos3 = 0, fallas3 = 0;
    public int intentos4 = 0, aciertos4 = 0, fallas4 = 0;

    public IntermedioPreguntas() {
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

}
