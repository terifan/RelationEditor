package org.terifan.nodeeditor.examples;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JColorChooser;
import org.terifan.nodeeditor.Connector;
import org.terifan.nodeeditor.NodeEditorPane;
import org.terifan.nodeeditor.Styles;
import org.terifan.nodeeditor.NodeItem;
import org.terifan.ui.Anchor;
import org.terifan.ui.TextBox;


public class ColorChooserNodeItem extends NodeItem
{
	private static final int COLOR_BOX_WIDTH = 30;
	private Color mColor;
	
	
	public ColorChooserNodeItem(String aText, Color aColor, Connector... aConnectors)
	{
		super(aText, aConnectors);

		mColor = aColor;
		mSize.height = 20;
	}


	@Override
	protected void paintComponent(NodeEditorPane aEditorPane, Graphics2D aGraphics, boolean aHover)
	{
		aGraphics.setColor(new Color(48, 48, 48));
		aGraphics.fillRoundRect(mBounds.x, mBounds.y, COLOR_BOX_WIDTH, mBounds.height, 4, 4);

		aGraphics.setColor(mColor);
		aGraphics.fillRoundRect(mBounds.x + 1, mBounds.y + 1, COLOR_BOX_WIDTH - 2, mBounds.height - 2, 4, 4);

		new TextBox(mName)
			.setBounds(mBounds)
			.setAnchor(Anchor.WEST)
			.setMargins(0, COLOR_BOX_WIDTH + 10, 0, 0)
			.setForeground(Styles.BOX_FOREGROUND_COLOR)
			.render(aGraphics);
	}


	@Override
	protected void actionPerformed(NodeEditorPane aEditorPane, Point aClickPoint)
	{
		Color c = JColorChooser.showDialog(aEditorPane, mName, mColor);
		if (c != null)
		{
			mColor = c;
			aEditorPane.repaint();
		}
	}


	@Override
	protected boolean mousePressed(NodeEditorPane aEditorPane, Point aClickPoint)
	{
		if (new Rectangle(mNodeBox.getBounds().x + mBounds.x, mNodeBox.getBounds().y + mBounds.y, COLOR_BOX_WIDTH, mBounds.height).contains(aClickPoint))
		{
			return true;
		}

		return false;
	}
}
