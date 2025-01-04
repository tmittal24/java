package com.yogi.focusTraversal;
import javax.swing.*;
import java.awt.*;
 
public class FocusExample extends JFrame {
    protected JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    protected MyPanel panel;
    protected MyFocusTraversalPolicy focusTraversalPolicy;
    
    public FocusExample() {
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);
        tf4 = new JTextField(10);
        tf5 = new JTextField(10);
        tf6 = new JTextField(10);
        panel = new MyPanel();
        
        getContentPane().setLayout(new FlowLayout());
        
        this.getContentPane().add(tf1);
        this.getContentPane().add(tf2);
        this.getContentPane().add(tf3);
        this.getContentPane().add(panel);
        this.getContentPane().add(tf4);
        this.getContentPane().add(tf5);
        this.getContentPane().add(tf6);
        
        focusTraversalPolicy = new MyFocusTraversalPolicy();
        setFocusTraversalPolicy(focusTraversalPolicy);
        
        pack();
        setVisible(true);
    }
    
    public class MyFocusTraversalPolicy extends FocusTraversalPolicy {
        public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
            if(aComponent.equals(tf1)) return tf2;
            else if(aComponent.equals(tf2)) return tf3;
            else if(aComponent.equals(tf3)) return panel.getFocusTraversalPolicy().getDefaultComponent(panel);
            else if(panel.isAncestorOf(aComponent)){
                if(aComponent.equals(panel.getFocusTraversalPolicy().getLastComponent(panel))) return tf4;
                else return panel.getFocusTraversalPolicy().getComponentAfter(panel, aComponent);
            }
            else if(aComponent.equals(tf4)) return tf5;
            else if(aComponent.equals(tf5)) return tf6;
            else return tf1;
        }
        
        public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
            if(aComponent.equals(tf6)) return tf5;
            else if(aComponent.equals(tf5)) return tf4;
            else if(aComponent.equals(tf4)) return panel.getFocusTraversalPolicy().getLastComponent(panel);
            else if(panel.isAncestorOf(aComponent)){
                if(aComponent.equals(panel.getFocusTraversalPolicy().getFirstComponent(panel))) return tf3;
                else return panel.getFocusTraversalPolicy().getComponentBefore(panel, aComponent);
            }
            else if(aComponent.equals(tf3)) return tf2;
            else if(aComponent.equals(tf2)) return tf1;
            else return tf6;
        }
        
        public Component getDefaultComponent(Container focusCycleRoot) {
            return tf1;
        }
        
        public Component getFirstComponent(Container focusCycleRoot) {
            return tf1;
        }
        
        public Component getLastComponent(Container focusCycleRoot) {
            return tf6;
        }
    }
 
    public class MyPanel extends JPanel {
        protected JTextField tf1, tf2, tf3;
        protected FocusTraversalPolicy focusTraversalPolicy;
        
        public MyPanel() {
            tf1 = new JTextField(10);
            tf2 = new JTextField(10);
            tf3 = new JTextField(10);
            
            this.add(tf3);
            this.add(tf2);
            this.add(tf1);
            
            focusTraversalPolicy = new FocusTraversalPolicy() {
                public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
                    if(aComponent.equals(tf1)) return tf2;
                    else if(aComponent.equals(tf2)) return tf3;
                    else return tf1;
                }
                
                public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
                    if(aComponent.equals(tf3)) return tf2;
                    else if(aComponent.equals(tf2)) return tf1;
                    else return tf3;
                }
                
                public Component getDefaultComponent(Container focusCycleRoot) {
                    return tf1;
                }
                
                public Component getFirstComponent(Container focusCycleRoot) {
                    return tf2;
                }
                
                public Component getLastComponent(Container focusCycleRoot) {
                    return tf3;
                }
            };
        } 
        
        public FocusTraversalPolicy getFocusTraversalPolicy() {
            return focusTraversalPolicy;
        }
    }
    
    public static void main(String args[]) {
        new FocusExample();
    }
}

