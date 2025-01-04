package com.yogi.tree;

import javax.swing.*;
import javax.swing.tree.*;

public class TestTree {
	public static void main(String[] args) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("top");
		JTree tree = new JTree(root);
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

		for (int x = 1; x <= 10; x++) {
			model.insertNodeInto(new DefaultMutableTreeNode("node " + x), root, root.getChildCount());
		}

		 model.reload();
		JFrame frame = new JFrame();
		frame.add(tree);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
