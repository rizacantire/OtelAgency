package com.patika.OtelAgency.view;

import com.patika.OtelAgency.business.abstracts.OtelPropertyService;
import com.patika.OtelAgency.business.abstracts.OtelService;
import com.patika.OtelAgency.business.abstracts.OtelTypeService;
import com.patika.OtelAgency.core.Helper.Config;
import com.patika.OtelAgency.core.Helper.Helper;
import com.patika.OtelAgency.core.Helper.Item;
import com.patika.OtelAgency.entities.Otel;
import com.patika.OtelAgency.entities.OtelType;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
    private JList list_otel_properties;
    private DefaultListModel<String> listModel;
    private JTextArea ctrlTuşuIleÇokluTextArea;
    private JButton button1;
    private OtelService otelService;
    private OtelTypeService otelTypeService;
    private OtelPropertyService otelPropertyService;



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


        var otelTypeList = otelTypeService.getAll();
        for (var ot : otelTypeList){
            cmb_otel_type.addItem(new Item(ot.getId(),ot.getType()));
        }

        var otelProperties = otelPropertyService.getAll();
        listModel = new DefaultListModel<String>();
        for (var op : otelProperties){
            listModel.addElement(op.getId()+" "+op.getProperty());
        }
        list_otel_properties.setModel(listModel);


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

                if (otelService.add(otel)){
                    Helper.showMsg("Otel sisteme eklendi");
                }else {
                    Helper.showMsg("Otel sistemde mevcut");
                }

            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var si = list_otel_properties.getSelectedValues();
                for(var i : si){
                    System.out.println(i.toString());
                }

            }
        });
    }
}
