package com.patika.OtelAgency.view;

import com.patika.OtelAgency.business.abstracts.OtelService;
import com.patika.OtelAgency.core.Helper.Config;
import com.patika.OtelAgency.core.Helper.Helper;
import com.patika.OtelAgency.entities.Otel;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private OtelService otelService;

    public OtelGUI(OtelService otelService){
        this.otelService = otelService;
        add(wrapper);
        setSize(600,400);
        int x = Helper.screenCenter("x",getSize());
        int y = Helper.screenCenter("y",getSize());
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_otel_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var name = fld_otel_name.getText();
                var address = fld_otel_address.getText();
                var phone = fld_otel_phone.getText();
                var mail = fld_otel_mail.getText();
                var star = cmb_otel_star.getSelectedItem().toString();
                int a = Integer.parseInt(star);
                Otel otel = new Otel();
                otel.setAddress(address);
                otel.setName(name);
                otel.setMail(mail);
                otel.setPhone(phone);
                otel.setStar(a);
                if (otelService.add(otel)){
                    Helper.showMsg("Otel sisteme eklendi");
                }else {
                    Helper.showMsg("Otel sistemde mevcut");
                }

            }
        });
    }
}
