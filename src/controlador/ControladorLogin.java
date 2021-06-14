package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Hash;
import modelo.PunteoDAO;
import modelo.PunteoVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmAvanzado;
import vista.FrmIntermedio;
import vista.FrmLogin;
import vista.FrmPrincipiante;

public class ControladorLogin implements ActionListener {

    FrmLogin vista = new FrmLogin();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    FrmAdministrador ad = new FrmAdministrador();
    FrmPrincipiante pri = new FrmPrincipiante();
    FrmIntermedio inte = new FrmIntermedio();
    FrmAvanzado ava = new FrmAvanzado();
    PunteoVO pvo = new PunteoVO();
    PunteoDAO pdao = new PunteoDAO();

    public ControladorLogin(FrmLogin vista, UsuarioVO uvo, UsuarioDAO udao, FrmAdministrador ad, FrmPrincipiante pri, FrmIntermedio inte, FrmAvanzado ava, PunteoVO pvo, PunteoDAO pdao) {
        this.vista = vista;
        this.uvo = uvo;
        this.udao = udao;
        this.ad = ad;
        this.pri = pri;
        this.inte = inte;
        this.ava = ava;
        this.pvo = pvo;
        this.pdao = pdao;
        vista.btnIngresar.addActionListener(this);
    }

    public void verificar() {
        try {
            String pass = new String(vista.txtContraseña.getPassword());
            String contra = Hash.sha1(pass);
            uvo.setClave(contra);
            uvo.setUsuario(vista.txtUsuario.getText());
            udao.validacion(uvo);
            if (vista.txtUsuario.getText().isEmpty() || contra.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes de ingresar un usuario y una contraseña");
            } else {
                switch (udao.dato) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Bienvenid@ " + vista.txtUsuario.getText() + " Tu Nivel es Administrador");
                        vista.dispose();
                        ad.setVisible(true);
                        ad.setLocationRelativeTo(null);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Bienvenid@ " + vista.txtUsuario.getText() + " Tu Nivel es Principiante");
                        vista.dispose();
                        pri.setVisible(true);
                        pri.setLocationRelativeTo(null);
                        this.insertarPunteo();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Bienvenid@ " + vista.txtUsuario.getText() + " Tu Nivel es Intermedio");
                        vista.dispose();
                        inte.setVisible(true);
                        inte.setLocationRelativeTo(null);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Bienvenid@ " + vista.txtUsuario.getText() + " Tu Nivel es Avanzado");
                        vista.dispose();
                        ava.setVisible(true);
                        ava.setLocationRelativeTo(null);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    private void insertarPunteo() {
        try {
            pvo.setPunteo_score(100);
            pvo.setId_usuario_fk(udao.idnivel);
            pdao.insertar(pvo);
            JOptionPane.showMessageDialog(null, "Tu Punteo es de 100 puntos\nSe restaran puntos por cada respuesta equivocada");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Punteo no ingresado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar) {
            this.verificar();
        }
    }
}
