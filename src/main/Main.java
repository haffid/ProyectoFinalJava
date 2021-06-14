
package main;

import controlador.ControladorPrincipiante;
import controlador.ControladorAvanzado;
import controlador.ControladorEliminarUsuario;
import controlador.ControladorIngresarUsuario;
import controlador.ControladorIntermedio;
import controlador.ControladorLogin;
import controlador.ControladorModificarUsuario;
import controlador.ControladorMostrarUsuario;
import modelo.Avanzado;
import modelo.Conector;
import modelo.IntermedioPreguntas;
import modelo.PunteoDAO;
import modelo.PunteoVO;
import modelo.Suma;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmAvanzado;
import vista.FrmEliminarUsuario;
import vista.FrmIntermedio;
import vista.FrmLogin;
import vista.FrmMostrarUsuario;
import vista.FrmPrincipiante;

public class Main {

    public static void main(String[] args) {
        FrmAdministrador ad = new FrmAdministrador();
        FrmMostrarUsuario mu = new FrmMostrarUsuario();
        FrmEliminarUsuario eu = new FrmEliminarUsuario();
        FrmLogin lo = new FrmLogin();
        UsuarioVO uvo = new UsuarioVO();
        UsuarioDAO udao = new UsuarioDAO();
        FrmPrincipiante prin = new FrmPrincipiante();
        Suma sum = new Suma();
        FrmIntermedio inter = new FrmIntermedio();
        IntermedioPreguntas ip = new IntermedioPreguntas();
        FrmAvanzado avan = new FrmAvanzado();
        Avanzado ava = new Avanzado();
        PunteoVO pvo = new PunteoVO();
        PunteoDAO pdao = new PunteoDAO();
        ControladorIngresarUsuario ciu = new ControladorIngresarUsuario(ad, uvo, udao);
        ControladorEliminarUsuario ceu = new ControladorEliminarUsuario(ad, uvo, udao, eu);
        ControladorMostrarUsuario cmu = new ControladorMostrarUsuario(ad, uvo, udao, mu);
        ControladorModificarUsuario cmou = new ControladorModificarUsuario(ad, uvo, udao, mu);
        ControladorPrincipiante cale = new ControladorPrincipiante(prin, sum, inter, uvo, udao,pvo,pdao);
        ControladorIntermedio cinte = new ControladorIntermedio(inter, ip, avan, uvo, udao,pvo,pdao);
        ControladorAvanzado cava = new ControladorAvanzado(avan, ava, uvo, udao,pvo,pdao);
        ControladorLogin clog = new ControladorLogin(lo, uvo, udao, ad, prin, inter, avan,pvo,pdao);
        lo.setVisible(true);
        lo.setLocationRelativeTo(null);
        ciu.cargarEstado(0);
        ciu.cargarTipoUsuario(0);
    }

}
