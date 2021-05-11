/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App_Windows;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CellColor extends JTable {
    

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex){
       
        Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);
        
        if(getValueAt(rowIndex,columnIndex).getClass().equals(String.class)){
            String value = this.getValueAt(rowIndex, columnIndex).toString();
            
            if(value.equals("In Stock")){
                component.setBackground(new java.awt.Color(153,153,255));
  
            }
            
            else if(value.equals("Loaned")){
                component.setBackground(new java.awt.Color(153,255,153));    
            }
            
            else if(value.equals("In Tolerance")){
                component.setBackground(new java.awt.Color(255,255,153));    
            }
            
            else if(value.equals("In Max Tolerance")){
                component.setBackground(new java.awt.Color(255,153,153));    
            }
            
            else if(value.equals("Return Time Exceeded")){
                component.setBackground(new java.awt.Color(204,153,255));    
            }
            else{
                component.setBackground(new java.awt.Color(255,255,255));    
            }
            
            
        }
        
        return component;
    }
    
}
