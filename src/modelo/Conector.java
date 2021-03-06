package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conector {

    private String driver = "com.mysql.jdbc.Driver";
    private String servidor = "127.0.0.1";
    private String usuario = "root";
    private String password = "";
    private String bd = "bd_usuarios";
    private String cadena;

    Connection con;
    Statement st;

    public void conectar() {
        this.cadena = "jdbc:mysql://" + this.servidor + "/" + this.bd;
        try {
            Class.forName(this.driver).newInstance();
            this.con = DriverManager.getConnection(this.cadena, this.usuario, this.password);
        } catch (Exception e) {
            System.out.println("Mensaje 1 " + e.getMessage());
        }

    }

    public void desconectar() {
        try {
            this.con.close();
        } catch (Exception e) {
            System.out.println("Mensaje 2 " + e.getMessage());
        }
    }

    public int consultas_multiples(String consulta) {
        int resultado;
        try {
            this.conectar();
            this.st = this.con.createStatement();
            resultado = this.st.executeUpdate(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje 3 " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Este registro, tiene una llave foranea, no se puede eliminar");
            return 0;
        } finally {
            this.desconectar();
        }
        return resultado;
    }

    public ResultSet consulta_datos(String consulta) {
        try {
            this.conectar();
            ResultSet resultado = null;
            this.st = this.con.createStatement();
            resultado = st.executeQuery(consulta);
            return resultado;
        } catch (Exception e) {
            System.out.println("Mensaje 4 " + e.getMessage());
        }
        return null;
    }

}
