package com.example.RomansLodge.locale;


import java.util.Locale;
import java.util.ResourceBundle;

public class ReadWelcomeMessage {
    private ResourceBundle resourceBundle;
    private Locale locale;

    public ReadWelcomeMessage(String language, String country){
        locale= new Locale(language,country);
        resourceBundle=ResourceBundle.getBundle("welcome",locale);
    }

    public String getWelcomeMessage(){
        return resourceBundle.getString("welcome");

    }


}
