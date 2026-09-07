package ventanas;

import apoyo.Mensajes;
import apoyo.PanelFondo;
import datos.AsistenciasDatos;
import datos.ReportesDatos;
import datos.UsuariosDatos;
import entidades.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaAdministrador extends JFrame {
    private final Usuario usuario;
    private final ReportesDatos reportesDatos = new ReportesDatos();
    private final UsuariosDatos usuariosDatos = new UsuariosDatos();
    private final AsistenciasDatos asistenciasDatos = new AsistenciasDatos();
    private final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final javax.swing.Timer reloj = new javax.swing.Timer(1000, event -> actualizarHora());

    public VentanaAdministrador() {
        this(new Usuario(0, "Administrador", "", "ADMIN"));
    }

    public VentanaAdministrador(Usuario usuario) {
        this.usuario = usuario;
        setContentPane(new PanelFondo("/imagenes/fondo_administrador.jpg"));
        initComponents();
        setSize(780, 470);
        setLocationRelativeTo(null);
        etiquetaUsuario.setText("Administrador: " + usuario.getNombre());
        tablaReporte.setAutoCreateRowSorter(true);
        actualizarHora();
        reloj.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaUsuario = new javax.swing.JLabel();
        etiquetaHora = new javax.swing.JLabel();
        etiquetaAcciones = new javax.swing.JLabel();
        tituloReporte = new javax.swing.JLabel();
        panelTabla = new javax.swing.JScrollPane();
        tablaReporte = new javax.swing.JTable();
        botonAsistencia = new javax.swing.JButton();
        botonSalida = new javax.swing.JButton();
        botonUsuarios = new javax.swing.JButton();
        etiquetaReportes = new javax.swing.JLabel();
        botonAtrasos = new javax.swing.JButton();
        botonSalidas = new javax.swing.JButton();
        botonInasistencias = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel administrador");

        etiquetaUsuario.setFont(etiquetaUsuario.getFont().deriveFont(16f));
        etiquetaUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaUsuario.setText("Administrador:");

        etiquetaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaHora.setText("Hora actual: 00:00:00");

        etiquetaAcciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaAcciones.setText("Acciones de administrador");

        tituloReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloReporte.setText("Seleccione un reporte");

        tablaReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        panelTabla.setViewportView(tablaReporte);

        botonAsistencia.setText("Registrar asistencia");
        botonAsistencia.addActionListener(this::botonAsistenciaActionPerformed);

        botonSalida.setText("Registrar salida");
        botonSalida.addActionListener(this::botonSalidaActionPerformed);

        botonUsuarios.setText("Gestion de usuarios");
        botonUsuarios.addActionListener(this::botonUsuariosActionPerformed);

        etiquetaReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaReportes.setText("Reportes");

        botonAtrasos.setText("Reporte de atrasos");
        botonAtrasos.addActionListener(this::botonAtrasosActionPerformed);

        botonSalidas.setText("Reporte de salidas anticipadas");
        botonSalidas.addActionListener(this::botonSalidasActionPerformed);

        botonInasistencias.setText("Reporte de inasistencias");
        botonInasistencias.addActionListener(this::botonInasistenciasActionPerformed);

        botonCerrar.setText("Cerrar sesion");
        botonCerrar.addActionListener(this::botonCerrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAsistencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonUsuarios)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(etiquetaReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tituloReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTabla)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAtrasos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonSalidas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonInasistencias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCerrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(etiquetaUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaAcciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAsistencia)
                    .addComponent(botonSalida)
                    .addComponent(botonUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtrasos)
                    .addComponent(botonSalidas)
                    .addComponent(botonInasistencias)
                    .addComponent(botonCerrar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasosActionPerformed
        cargarAtrasos();
    }//GEN-LAST:event_botonAtrasosActionPerformed

    private void botonSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalidasActionPerformed
        cargarSalidasAnticipadas();
    }//GEN-LAST:event_botonSalidasActionPerformed

    private void botonInasistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInasistenciasActionPerformed
        cargarInasistencias();
    }//GEN-LAST:event_botonInasistenciasActionPerformed

    private void botonAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsistenciaActionPerformed
        registrarMarca("Registrar asistencia", "ENTRADA", "Asistencia guardada.", "Esa asistencia ya esta guardada.");
    }//GEN-LAST:event_botonAsistenciaActionPerformed

    private void botonSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalidaActionPerformed
        registrarMarca("Registrar salida", "SALIDA", "Salida guardada.", "Esa salida ya esta guardada.");
    }//GEN-LAST:event_botonSalidaActionPerformed

    private void botonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUsuariosActionPerformed
        new VentanaUsuarios(usuario).setVisible(true);
    }//GEN-LAST:event_botonUsuariosActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void actualizarHora() {
        etiquetaHora.setText("Hora actual: " + LocalTime.now().format(formatoHora));
    }

    private void cargarAtrasos() {
        cargarReporte("Reporte de atrasos: entradas posteriores a 09:30", () -> reportesDatos.obtenerAtrasos());
    }

    private void cargarSalidasAnticipadas() {
        cargarReporte("Reporte de salidas anticipadas: salidas anteriores a 17:30", () -> reportesDatos.obtenerSalidasAnticipadas());
    }

    private void cargarInasistencias() {
        String textoFecha = JOptionPane.showInputDialog(
                this,
                "Ingrese fecha a consultar con formato AAAA-MM-DD:",
                LocalDate.now().toString()
        );
        if (textoFecha == null) {
            return;
        }

        try {
            LocalDate fecha = LocalDate.parse(textoFecha.trim());
            cargarReporte("Reporte de inasistencias: sin entrada ni salida el " + fecha, () -> reportesDatos.obtenerInasistencias(fecha));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha esta mal escrita. Use algo como 2026-09-07.");
        }
    }

    private void registrarMarca(String titulo, String tipo, String mensajeCorrecto, String mensajeRepetido) {
        try {
            List<Usuario> usuarios = usuariosDatos.obtenerUsuariosActivos();
            if (usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay usuarios para registrar.");
                return;
            }

            JComboBox<Usuario> listaUsuarios = new JComboBox<>(usuarios.toArray(new Usuario[0]));
            JTextField campoFecha = new JTextField(LocalDate.now().toString(), 12);

            JPanel panel = new JPanel(new java.awt.GridBagLayout());
            java.awt.GridBagConstraints posicion = new java.awt.GridBagConstraints();
            posicion.insets = new java.awt.Insets(5, 5, 5, 5);
            posicion.anchor = java.awt.GridBagConstraints.WEST;

            agregarFila(panel, posicion, 0, "Usuario:", listaUsuarios);
            agregarFila(panel, posicion, 1, "Fecha:", campoFecha);

            int opcion = JOptionPane.showConfirmDialog(this, panel, titulo, JOptionPane.OK_CANCEL_OPTION);
            if (opcion != JOptionPane.OK_OPTION) {
                return;
            }

            Usuario seleccionado = (Usuario) listaUsuarios.getSelectedItem();
            LocalDate fecha = LocalDate.parse(campoFecha.getText().trim());
            LocalTime hora = LocalTime.now();
            if ("SALIDA".equals(tipo)) {
                asistenciasDatos.registrarSalidaManual(seleccionado.getId(), fecha, hora);
            } else {
                asistenciasDatos.registrarIngresoManual(seleccionado.getId(), fecha, hora);
            }
            JOptionPane.showMessageDialog(this, mensajeCorrecto);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Fecha mal escrita.");
        } catch (SQLException e) {
            if ("MARCA_DUPLICADA".equals(e.getSQLState())) {
                JOptionPane.showMessageDialog(this, mensajeRepetido);
            } else {
                Mensajes.mostrarErrorConexion(this);
            }
        }
    }

    private void agregarFila(JPanel panel, java.awt.GridBagConstraints posicion, int fila, String texto, java.awt.Component campo) {
        posicion.gridx = 0;
        posicion.gridy = fila;
        panel.add(new JLabel(texto), posicion);

        posicion.gridx = 1;
        panel.add(campo, posicion);
    }

    private void cargarReporte(String titulo, CargaReporte cargaReporte) {
        try {
            DefaultTableModel modelo = cargaReporte.cargar();
            tablaReporte.setModel(modelo);
            tituloReporte.setText(titulo + " (" + modelo.getRowCount() + " registros)");
        } catch (SQLException e) {
            Mensajes.mostrarErrorConexion(this);
        }
    }

    private void cerrarSesion() {
        new VentanaLogin().setVisible(true);
        dispose();
    }

    @Override
    public void dispose() {
        reloj.stop();
        super.dispose();
    }

    private interface CargaReporte {
        DefaultTableModel cargar() throws SQLException;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtrasos;
    private javax.swing.JButton botonAsistencia;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonInasistencias;
    private javax.swing.JButton botonSalida;
    private javax.swing.JButton botonSalidas;
    private javax.swing.JButton botonUsuarios;
    private javax.swing.JLabel etiquetaAcciones;
    private javax.swing.JLabel etiquetaHora;
    private javax.swing.JLabel etiquetaReportes;
    private javax.swing.JLabel etiquetaUsuario;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tablaReporte;
    private javax.swing.JLabel tituloReporte;
    // End of variables declaration//GEN-END:variables
}
