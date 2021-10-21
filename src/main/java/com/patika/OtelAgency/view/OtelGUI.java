package com.patika.OtelAgency.view;

import com.patika.OtelAgency.business.abstracts.OtelPropertyService;
import com.patika.OtelAgency.business.abstracts.OtelService;
import com.patika.OtelAgency.business.abstracts.OtelTypeService;
import com.patika.OtelAgency.core.Helper.Config;
import com.patika.OtelAgency.core.Helper.Helper;
import com.patika.OtelAgency.core.Helper.Item;
import com.patika.OtelAgency.entities.Otel;
import com.patika.OtelAgency.entities.OtelType;
import com.patika.OtelAgency.entities.Property;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class OtelGUI extends JFrame {
    private JPanel wrapper;
    private JPanel otelAddPanel;
    private JPanel add_panel;
    private JTextField fld_otel_name;
    private JTextField fld_otel_address;
    private JTextField fld_otel_mail;
    private JTextField fld_otel_phone;
    private JComboBox cmb_otel_star;
    private JButton btn_otel_add;
    private JComboBox cmb_otel_type;
    private JPanel pnl_otel_properties;
    private JTextArea ekleyeceğinizÖzellikleriSağTarafaTextArea;
    private JButton btn_add_propetites;
    private JTable tbl_properties;
    private JTable tbl_otel_properties;
    private OtelService otelService;
    private OtelTypeService otelTypeService;
    private OtelPropertyService otelPropertyService;
    private Object[] col_properties;
    private Object[] row_properties;
    private DefaultTableModel mdl_properties;
    private DefaultTableModel mdl_otel_properties;
    private Object[] col_otel_properties;
    private Object[] row_otel_properties;
    private List<Property> properties;
    private Set<Property> otel_properties = new HashSet<>();



    public OtelGUI(OtelService otelService,OtelTypeService otelTypeService,OtelPropertyService otelPropertyService){
        this.otelService = otelService;
        this.otelTypeService = otelTypeService;
        this.otelPropertyService = otelPropertyService;
        add(wrapper);
        setSize(800,800);
        int x = Helper.screenCenter("x",getSize());
        int y = Helper.screenCenter("y",getSize());
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        getOtelType(otelTypeService);

        col_properties = new Object[] {"ID","Özellik"};
        mdl_properties = new DefaultTableModel();
        mdl_properties.setColumnIdentifiers(col_properties);
        tbl_properties.setModel(mdl_properties);
        tableEditHeader(tbl_properties);
        row_properties = new Object[col_properties.length];
        loadProperties();
        mdl_otel_properties = new DefaultTableModel();
        mdl_otel_properties.setColumnIdentifiers(col_properties);
        tbl_otel_properties.setModel(mdl_otel_properties);
        row_otel_properties = new Object[col_properties.length];
        tableEditHeader(tbl_otel_properties);


        btn_otel_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var name = fld_otel_name.getText();
                var address = fld_otel_address.getText();
                var phone = fld_otel_phone.getText();
                var mail = fld_otel_mail.getText();
                int star = Integer.parseInt(cmb_otel_star.getSelectedItem().toString());
                int type = ((Item)cmb_otel_type.getSelectedItem()).getKey();
                var ot = ((Item)cmb_otel_type.getSelectedItem()).getValue();
                var o = new OtelType();
                o.setId(type);
                o.setType(ot);
                Otel otel = new Otel();
                otel.setAddress(address);
                otel.setName(name);
                otel.setMail(mail);
                otel.setPhone(phone);
                otel.setStar(star);
                otel.setOtelType(o);
                otel.setOtelProperties(otel_properties);

                if (otelService.add(otel)){
                    Helper.showMsg("Otel sisteme eklendi");
                    otel_properties.clear();
                    loadOtelProperties(otel_properties);
                }else {
                    Helper.showMsg("Otel sistemde mevcut");
                }

            }
        });

        btn_add_propetites.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var id = tbl_properties.getValueAt(tbl_properties.getSelectedRow(),0).toString();
                var property = tbl_properties.getValueAt(tbl_properties.getSelectedRow(),1).toString();
                Property p = new Property(Integer.parseInt(id),property);
                otel_properties.add(p);
                loadOtelProperties(otel_properties);
            }
        });
    }

    private void loadProperties() {
        DefaultTableModel clear = (DefaultTableModel) tbl_properties.getModel();
        clear.setRowCount(0);
        properties = this.otelPropertyService.getAll();
        for (var item : properties){
            int i =0;
            row_properties[i++] = item.getId();
            row_properties[i++] = item.getProperty();
            mdl_properties.addRow(row_properties);

        }

    }

    private void loadOtelProperties(Set<Property> prop) {
        DefaultTableModel clear = (DefaultTableModel) tbl_otel_properties.getModel();
        clear.setRowCount(0);
        for (var item : prop){
            int i =0;
            row_otel_properties[i++] = item.getId();
            row_otel_properties[i++] = item.getProperty();
            mdl_otel_properties.addRow(row_otel_properties);
        }

    }

    private void tableEditHeader(JTable tbl){
        tbl.getColumnModel().getColumn(0).setMaxWidth(40);
        tbl.getTableHeader().setReorderingAllowed(false);
    }

    private void getOtelType(OtelTypeService otelTypeService) {
        var otelTypeList = otelTypeService.getAll();
        for (var ot : otelTypeList){
            cmb_otel_type.addItem(new Item(ot.getId(),ot.getType()));
        }
    }
}
