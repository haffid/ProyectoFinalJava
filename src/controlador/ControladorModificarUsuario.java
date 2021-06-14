package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Hash;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmMostrarUsuario;

public class ControladorModificarUsuario implements ActionListener {

    FrmAdministrador ad = new FrmAdministrador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    FrmMostrarUsuario vista = new FrmMostrarUsuario();

    public ControladorModificarUsuario(FrmAdministrador ad, UsuarioVO uvo, UsuarioDAO udao, FrmMostrarUsuario vista) {
        this.ad = ad;
        this.uvo = uvo;
        this.udao = udao;
        this.vista = vista;

        ad.btnModificar.addActionListener(this);

    }

    private void modi() {
        try {
            String pass = new String(ad.txtClave.getPassword());
            String passC = new String(ad.txtClaveC.getPassword());
            if (pass.equals(passC)) {
                String nuevoPass = Hash.sha1(pass);
                uvo.getId_usuario();
                uvo.setNombre_usuario(ad.txtNombre.getText());
                uvo.setApellido_usuario(ad.txtApellido.getText());
                uvo.setEdad_usuario(Integer.parseInt(ad.txtEdad.getText()));
                uvo.setUsuario(ad.txtUsuario.getText());
                uvo.setClave(nuevoPass);
                uvo.setId_estado_fk(Integer.parseInt(ad.cbxEstado.getSelectedItem().toString()));
                uvo.setId_tipo_usuario_fk(Integer.parseInt(ad.cbxTipoUsuario.getSelectedItem().toString()));
                udao.actualizar(uvo);
                ad.txtNombre.setText("");
                ad.txtApellido.setText("");
                ad.txtEdad.setText("");
                ad.txtUsuario.setText("");
                ad.txtClave.setText("");
                ad.txtClaveC.setText("");
                ad.cbxEstado.setSelectedIndex(0);
                ad.cbxTipoUsuario.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Usuario Modificado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debes ingresar Datos para Modificar registro!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        if (e.getSource() == ad.btnModificar) {
            this.modi();
        }
    }

}
