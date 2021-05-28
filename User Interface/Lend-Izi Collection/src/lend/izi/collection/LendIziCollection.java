
package lend.izi.collection;

import App_Windows.Main_Menu;

// Creado por Ronaldo Vinas Barboza 1176101338

public class LendIziCollection {
    public static String email = null;
    public static int identification;  
    
    public static void main(String[] args) {
        Main_Menu result = new Main_Menu();
        result.setVisible(true);
    }

    public static String getEmail() {
        return email;
    }

    public static int getIdentification() {
        return identification;
    }

    public static void setEmail(String email) {
        LendIziCollection.email = email;
    }

    public static void setIdentification(int identification) {
        LendIziCollection.identification = identification;
    }
    
    
}
