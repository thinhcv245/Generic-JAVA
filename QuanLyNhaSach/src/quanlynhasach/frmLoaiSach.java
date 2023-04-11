/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package quanlynhasach;

import Models.*;
import Helper.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Chau Thinh
 */
public class frmLoaiSach extends javax.swing.JInternalFrame {

    Vector<String> header = new Vector<>();
    Vector data = new Vector();

    Component component = this;
    boolean endEdit = false;

    /**
     * Creates new form frmLoaiSach
     */
    public frmLoaiSach() throws Exception {
        initComponents();
        header.add("ID");
        header.add("Tên");
        header.add("Mô tả");
        loadData();
        
        tableLoaiSach.setDefaultEditor(Object.class, null);
        tableLoaiSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tableLoaiSach.getSelectedRow();
                int col = tableLoaiSach.getSelectedColumn();
                //System.out.println(String.valueOf(endEdit));
                if (row >= 0 && row < tableLoaiSach.getRowCount()) {
                    TableModel model = tableLoaiSach.getModel();
                    txtTenSach.setText(model.getValueAt(row, 1).toString());
                    txtMoTa.setText(model.getValueAt(row, 2).toString());
                }
                if (col == 0) {
                    tableLoaiSach.setColumnSelectionInterval(1, 1);
                    tableLoaiSach.getCellEditor(row, col + 1).stopCellEditing();
                    ControlHelper.getInstance().showMessageWarning(component, "Bạn không được chỉnh sửa cột này", "Cảnh báo");
                }
            }

        });
//        TableColumn col = tableLoaiSach.getColumnModel().getColumn(1);
//        DefaultCellEditor editor = new DefaultCellEditor(new JTextField());
//        col.setCellEditor(editor);
//        editor.addCellEditorListener(new CellEditorListener() {
//            @Override
//            public void editingStopped(ChangeEvent e) {
//                // Retrieve the new cell value
//                Object newValue = editor.getCellEditorValue();
//                System.out.println(newValue + ", ");
//                endEdit = true;
//                // Perform any necessary actions with the new value
//                // For example, updating a database or modifying other cells.
//            }
//
//            @Override
//            public void editingCanceled(ChangeEvent e) {
//                // This method is called when the user cancels the edit.
//                // You can handle this situation if necessary. 
//            }
//        });
    }

    private void loadData() throws Exception {
        if (data != null) {
            data.clear();
        }
        data = JDBCHelper.getInstance().ExecuteGetVector("select * from LoaiSach", null, LoaiSach.class);
        DefaultTableModel tmd = (DefaultTableModel) this.tableLoaiSach.getModel();
        tmd.setDataVector(data, header);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableLoaiSach = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(482, 402));
        jScrollPane1.setRequestFocusEnabled(false);

        tableLoaiSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tableLoaiSach.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableLoaiSach.setMinimumSize(new java.awt.Dimension(225, 80));
        tableLoaiSach.setShowGrid(true);
        jScrollPane1.setViewportView(tableLoaiSach);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 396, 108));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin loại sách"));

        jLabel1.setText("Tên sách:");

        jLabel2.setText("Mô tả:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(txtTenSach))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 120, 428, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa);

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });
        jPanel2.add(btnDong);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 440, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            String tenSach = txtTenSach.getText();
            String moTa = txtMoTa.getText();
            if (tenSach.isEmpty()) {
                ControlHelper.getInstance().showMessageError(this, "Không được bỏ trống tên sách", "Thông báo");
                return;
            }
            if (moTa.isEmpty()) {
                ControlHelper.getInstance().showMessageError(this, "Không được bỏ trống mô tả", "Thông báo");
                return;
            }
            if (JDBCHelper.getInstance().ExecuteScalar("select count(*) from LoaiSach where Ten = ?", new Object[]{tenSach}) > 0) {
                ControlHelper.getInstance().showMessageError(this, "Sách này đã tồn tại", "Thông báo");
                return;
            }
            int id = Utility.getInstance().createID("select Max(LS_ID) from LoaiSach", null);
            int rowInsert = JDBCHelper.getInstance().ExecuteNonQuery("insert into LoaiSach(LS_ID, Ten, MoTa) values(?, ?, ?)", new Object[]{id, tenSach, moTa});
            if (rowInsert > 0) {
                clearTextField();
                Vector<String> vt = new Vector<>();
                vt.add(id + "");
                vt.add(tenSach);
                vt.add(moTa);
                data.add(vt);
                tableLoaiSach.updateUI();
                ControlHelper.getInstance().showMessageInfomation(this, "Thêm thành công", "Thông báo");
            } else {
                ControlHelper.getInstance().showMessageError(this, "Thêm thất bại", "Thông báo");
            }
        } catch (Exception ex) {
            Logger.getLogger(frmLoaiSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int posRow = tableLoaiSach.getSelectedRow();
        if (posRow < 0 || posRow >= tableLoaiSach.getRowCount()) {
            ControlHelper.getInstance().showMessageError(this, "Vui lòng chọn hàng cần xoá", "Cảnh báo");
        } else {
            try {
                TableModel tableModel = tableLoaiSach.getModel();
                if (ControlHelper.getInstance().confirmYN(this, "Bạn có chắc chắn xoá loại sách " + tableModel.getValueAt(posRow, 1) + " không?", "Cảnh báo")) {
                    int rowDelete = JDBCHelper.getInstance().ExecuteNonQuery("exec dbo.sp_deteteLoaiSach @id=?", new Object[]{tableModel.getValueAt(posRow, 0)});
                    if (rowDelete > 0) {
                        data.remove(posRow);
                        tableLoaiSach.updateUI();
                        clearTextField();
                        ControlHelper.getInstance().showMessageInfomation(this, "Xoá thành công", "Thông báo");
                    } else {
                        ControlHelper.getInstance().showMessageError(this, "Xoá thất bại", "Thông báo");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(frmLoaiSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int posRow = tableLoaiSach.getSelectedRow();
        if (posRow < 0 || posRow >= tableLoaiSach.getRowCount()) {
            ControlHelper.getInstance().showMessageError(this, "Vui lòng chọn hàng cần sửa", "Cảnh báo");
        } else {
            try {
                String tenSach = txtTenSach.getText();
                String moTa = txtMoTa.getText();
                int id = 0;
                try {
                    id = Integer.parseInt(tableLoaiSach.getValueAt(posRow, 0).toString());
                }
                catch(Exception ex) {
                    ControlHelper.getInstance().showMessageError(this, "Lỗi lấy mã loại sách", "Thông báo");
                    return;
                }
                if (tenSach.isEmpty()) {
                    ControlHelper.getInstance().showMessageError(this, "Không được bỏ trống tên sách", "Thông báo");
                    return;
                }
                if (moTa.isEmpty()) {
                    ControlHelper.getInstance().showMessageError(this, "Không được bỏ trống mô tả", "Thông báo");
                    return;
                }
                if (JDBCHelper.getInstance().ExecuteScalar("select count(*) from LoaiSach where Ten = ?", new Object[]{tenSach}) > 0) {
                    ControlHelper.getInstance().showMessageError(this, "Sách này đã tồn tại", "Thông báo");
                    return;
                }
                int rowUpdate = JDBCHelper.getInstance().ExecuteNonQuery("update LoaiSach set Ten = ?, MoTa = ? where LS_ID = ?", new Object[]{tenSach, moTa, id});
                if (rowUpdate > 0) {
                    clearTextField();
                    loadData();
                    ControlHelper.getInstance().showMessageInfomation(this, "Cập nhật thành công", "Thông báo");
                } else {
                    ControlHelper.getInstance().showMessageError(this, "Cập nhật thất bại", "Thông báo");
                }
            } catch (Exception ex) {
                Logger.getLogger(frmLoaiSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void clearTextField() {
        tableLoaiSach.clearSelection();
        txtTenSach.setText("");
        txtMoTa.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLoaiSach;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
