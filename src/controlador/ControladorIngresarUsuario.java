package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.EstadoDAO;
import modelo.EstadoVO;
import modelo.Hash;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;

public class ControladorIngresarUsuario implements ActionListener {
    FrmAdministrador ad = new FrmAdministrador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();

    public ControladorIngresarUsuario(FrmAdministrador ad, UsuarioVO uvo, UsuarioDAO udao) {
        this.ad = ad;
        this.uvo = uvo;
        this.udao = udao;
        ad.btnAgregar.addActionListener(this);
        ad.btnReporte.addActionListener(this);
    }

    private void insertarUsuario() {
        try {
            String pass = new String(ad.txtClave.getPassword());
            String passC = new String(ad.txtClaveC.getPassword());
            if (pass.equals(passC)) {
                String nuevoPass = Hash.sha1(pass);
                uvo.setNombre_usuario(ad.txtNombre.getText());
                uvo.setApellido_usuario(ad.txtApellido.getText());
                uvo.setEdad_usuario(Integer.parseInt(ad.txtEdad.getText()));
                uvo.setUsuario(ad.txtUsuario.getText());
                uvo.setClave(nuevoPass);
                uvo.setId_estado_fk(Integer.parseInt(ad.cbxEstado.getSelectedItem().toString()));
                uvo.setId_tipo_usuario_fk(Integer.parseInt(ad.cbxTipoUsuario.getSelectedItem().toString()));
                udao.insertar(uvo);
                ad.txtNombre.setText("");
                ad.txtApellido.setText("");
                ad.txtEdad.setText("");
                ad.txtUsuario.setText("");
                ad.txtClave.setText("");
                ad.txtClaveC.setText("");
                ad.cbxEstado.setSelectedIndex(0);
                ad.cbxTipoUsuario.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Usuario Creado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Datos para guardar registro!");
        }
    }

    public void cargarEstado(int buscar) {
        EstadoDAO edao = new EstadoDAO();
        int index = 1;
        ad.cbxEstado.removeAllItems();
        ad.cbxEstado.addItem("Seleccione Estado");
        for (EstadoVO evo : edao.consultarTabla()) {
            ad.cbxEstado.addItem(String.valueOf(evo.getId_estado()));
            if (evo.getId_estado() == buscar) {
                ad.cbxEstado.setSelectedIndex(index);
            }
            index++;
        }
    }

    public void cargarTipoUsuario(int buscar) {
        TipoUsuarioDAO tudao = new TipoUsuarioDAO();
        int index = 1;
        ad.cbxTipoUsuario.removeAllItems();
        ad.cbxTipoUsuario.addItem("Seleccione Estado");
        for (TipoUsuarioVO tuvo : tudao.consultarTabla()) {
            ad.cbxTipoUsuario.addItem(String.valueOf(tuvo.getId_tipo_usuario()));
            if (tuvo.getId_tipo_usuario() == buscar) {
                ad.cbxTipoUsuario.setSelectedIndex(index);
            }
            index++;
        }
    }

    private void reporte() {
        try {
            udao.reporte();
            udao.jv.setDefaultCloseOperation(ad.DISPOSE_ON_CLOSE);
            udao.jv.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reporte no generado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ad.btnAgregar) {
            this.insertarUsuario();
        }
        if (e.getSource() == ad.btnReporte) {
            this.reporte();
        }
    }

}
