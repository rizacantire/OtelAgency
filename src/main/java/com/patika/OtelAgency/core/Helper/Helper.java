package com.patika.OtelAgency.core.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setLayout(){
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    public static int screenCenter(String position, Dimension size){
        int point;
        switch (position){
            case "x":
                point =(Toolkit.getDefaultToolkit().getScreenSize().width - size.width) /2 ;
                break;
            case "y":
                point =(Toolkit.getDefaultToolkit().getScreenSize().height - size.height) /2 ;
                break;
            default:
                point = 0;

        }return point;

    }

    public static boolean fieldIsEmpty(JTextField textField){
        return textField.getText().trim().isEmpty();
    }
    public static boolean textAreaIsEmpty(JTextArea textArea){
        return textArea.getText().trim().isEmpty();

    }
    public static void blankField(JTextField... textFields){
        for (var textField : textFields){
            textField.setText(null);
        }
    }

    public static boolean confirm(String str){
        optionPageTr();
        String msg;
        switch (str){
            case "sure":
                msg = "Bu işlemi gerçekleştirmek istediğinize emin misiniz?";
                break;
            default:
                msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Son kararınız mı?",JOptionPane.YES_OPTION) == 0;
    }

    public static void showMsg(String str){
        optionPageTr();
        String msg;
        String title;
        switch (str){
            case "fill":
                msg = "Lütfen bütün alanları doldurunuz.";
                title = "Hata";
                break;
            case "done":
                msg = "İşlem başarılı";
                title = "Sonuç";
                break;
            case "error":
                msg = "Bir hata oluştu";
                title = "Hata";
            default:
                title = "Mesaj";
                msg =str;
        }

        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);

    }

    public static void optionPageTr(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
    }
}
