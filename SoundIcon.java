/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class SoundIcon extends JButton implements ToolBarNode{
    public SoundIcon()
    {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(60,60));
        this.setToolTipText("Use this sound");
        this.addActionListener(e-> System.exit(0) );
    }
}
