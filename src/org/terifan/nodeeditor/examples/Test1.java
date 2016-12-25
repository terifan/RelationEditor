package org.terifan.nodeeditor.examples;

import java.awt.Color;
import javax.swing.JFrame;
import org.terifan.nodeeditor.Connector;
import org.terifan.nodeeditor.Direction;
import org.terifan.nodeeditor.NodeEditorPane;
import org.terifan.nodeeditor.NodeBox;
import org.terifan.nodeeditor.NodeItem;


public class Test1
{
	public static void main(String ... args)
	{
		try
		{
			NodeEditorPane editor = new NodeEditorPane();

			NodeItem node0 = new NodeItem("node0", new Connector(Direction.OUT));
			NodeItem node1 = new NodeItem("node1", new Connector(Direction.OUT));
			NodeItem node2 = new NodeItem("node2", new Connector(Direction.IN));
			NodeItem node3 = new NodeItem("node3", new Connector(Direction.OUT));
			NodeItem node4 = new NodeItem("node4", new Connector(Direction.IN));
			NodeItem node5 = new NodeItem("node5", new Connector(Direction.IN));
			NodeItem node6 = new NodeItem("node6", new Connector(Direction.OUT));
			NodeItem node7 = new NodeItem("node7", new Connector(Direction.IN), new Connector(Direction.OUT));
			NodeItem node8 = new NodeItem("node8", new Connector(Direction.OUT));
			NodeItem node9 = new NodeItem("node9", new Connector(Direction.OUT, Connector.PURPLE));
			NodeItem node10 = new ImageNodeItem("node10", 200, 200, new Connector(Direction.OUT, Connector.PURPLE), new Connector(Direction.OUT, Connector.PURPLE), new Connector(Direction.OUT, Connector.PURPLE));
			NodeItem node11 = new ColorChooserNodeItem("node11", new Color(255,255,255), new Connector(Direction.IN, Connector.YELLOW));
			NodeItem node12 = new NodeItem("node12", new Connector(Direction.IN, Connector.PURPLE));
			NodeItem node13 = new NodeItem("node13", new Connector(Direction.IN, Connector.YELLOW));
			NodeItem node14 = new NodeItem("node14", new Connector(Direction.IN, Connector.GRAY));
			NodeItem node15 = new NodeItem("node15", new Connector(Direction.IN, Connector.GRAY));
			NodeItem node16 = new NodeItem("node16", new Connector(Direction.IN, Connector.GRAY));
			NodeItem node17 = new NodeItem("node17", new Connector(Direction.IN, Connector.GRAY));
			NodeItem node18 = new NodeItem("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
			NodeItem slider1 = new SliderNodeItem("Roughness", 0, 1, 0);
			NodeItem slider2 = new SliderNodeItem("Roughness", 0, 1, 0.5);
			NodeItem slider3 = new SliderNodeItem("Roughness", 0, 1, 0.75);
			NodeItem slider4 = new SliderNodeItem("Roughness", 0.0, 0.1);
			NodeItem checkbox1 = new CheckBoxNodeItem("Inverted", false);
			NodeItem checkbox2 = new CheckBoxNodeItem("Inverted", true);
			NodeItem comboBoxNodeItem1 = new ComboBoxNodeItem("GCX");
			NodeItem comboBoxNodeItem2 = new ComboBoxNodeItem("Beckmann");
			NodeBox nodeBox0 = new NodeBox("nodeBox0", node0, node1, comboBoxNodeItem1, comboBoxNodeItem2);
			NodeBox nodeBox1 = new NodeBox("nodeBox1", node2, slider1, slider2, slider3, slider4, checkbox1, checkbox2, node3);
			NodeBox nodeBox2 = new NodeBox("nodeBox2", node4, node5, node10, node6);
			NodeBox nodeBox3 = new NodeBox("nodeBox3", node7);
			NodeBox nodeBox4 = new NodeBox("nodeBox4", node13, node8, node9, node18, node15, node16, node17);
			NodeBox nodeBox5 = new NodeBox("nodeBox5", node11, node12, node14);
			editor.add(nodeBox0).addConnection(node0, node2).addConnection(node1, node7);
			editor.add(nodeBox1).addConnection(node3, node4).addConnection(node9, node12);
			editor.add(nodeBox2).addConnection(node6, node7);
			editor.add(nodeBox3).addConnection(node7, node11);
			editor.add(nodeBox4).addConnection(node8, node5);
			editor.add(nodeBox5);

			nodeBox0.setLocation(100, 50);
			nodeBox1.setLocation(300, 0);
			nodeBox2.setLocation(500, 150);
			nodeBox3.setLocation(800, 170);
			nodeBox4.setLocation(100, 250);
			nodeBox5.setLocation(1000, 200);
			editor.center();
			editor.setScale(2);

			JFrame frame = new JFrame();
			frame.add(editor);
			frame.setSize(2*1600, 2*1000);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		catch (Throwable e)
		{
			e.printStackTrace(System.out);
		}
	}
}
