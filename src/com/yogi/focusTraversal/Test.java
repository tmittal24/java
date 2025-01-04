package com.yogi.focusTraversal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test {
	JButton hello, world, advanced;

	JFrame f;

	JPanel p;

	public Test() {
		f = new JFrame();
		Container contentPane = f.getContentPane();

		p = new JPanel();
		contentPane.add(p);
		hello = new JButton("Hello");
		p.add(hello);
		world = new JButton("World");
		p.add(world);
		advanced = new JButton("Advanced Button");
		hello.setNextFocusableComponent(world);
		world.setNextFocusableComponent(advanced);
		advanced.setNextFocusableComponent(hello);
		advanced.setEnabled(false);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == hello) {
					p.add(advanced);
					advanced.setEnabled(true);
					p.revalidate();
				} else if (e.getSource() == advanced) {
					p.remove(advanced);
					advanced.setEnabled(false);
					p.revalidate();
				}

				FocusManager.getCurrentManager().focusNextComponent((JComponent) e.getSource());
				System.out.println(((JButton) e.getSource()).getText());
			}
		};
		hello.addActionListener(al);
		world.addActionListener(al);
		advanced.addActionListener(al);

		f.setBounds(200, 200, 200, 200);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Test t;

		t = new Test();
	}
}
