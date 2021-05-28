
package App_Windows;

/*
By:
    Renzo Barra
    Álvaro Moreira
    Ronaldo Vindas
*/


import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CellColor extends JTable {
    

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex){
       
        Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);
        
        if(getValueAt(rowIndex,columnIndex).getClass().equals(String.class)){
            String value = this.getValueAt(rowIndex, columnIndex).toString();
            
            if(value.equals("In Stock") || value.equals("Blue")){
                component.setBackground(new java.awt.Color(153,153,255));
  
            }
            
            else if(value.equals("Loaned") || value.equals("Green")){
                component.setBackground(new java.awt.Color(153,255,153));    
            }
            
            else if(value.equals("In Tolerance") || value.equals("Yellow")){
                component.setBackground(new java.awt.Color(255,255,153));    
            }
            
            else if(value.equals("In Max Tolerance") || value.equals("Red")){
                component.setBackground(new java.awt.Color(255,153,153));    
            }
            
            else if(value.equals("Return Time Exceeded") || value.equals("Purple") ){
                component.setBackground(new java.awt.Color(204,153,255));    
            }

            else{
                component.setBackground(new java.awt.Color(255,255,255));    
            }
            
            
        }
        
        return component;
    }
    
}
