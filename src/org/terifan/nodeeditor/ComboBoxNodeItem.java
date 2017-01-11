package org.terifan.nodeeditor;

import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import org.terifan.ui.Anchor;


public class ComboBoxNodeItem extends AbstractNodeItem
{
	private final static float[] RANGES = new float[]{0f,1f};
	private boolean mArmed;


	public ComboBoxNodeItem(String aText)
	{
		super(aText);

		mPreferredSize.height = 21;
	}


	@Override
	protected void paintComponent(NodeEditorPane aEditorPane, Graphics2D aGraphics, boolean aHover)
	{
		Paint oldPaint = aGraphics.getPaint();

		aGraphics.setColor(Styles.SLIDER_BORDER_COLOR);
		aGraphics.fillRoundRect(mBounds.x, mBounds.y, mBounds.width, mBounds.height, 4, 4);

		aGraphics.setPaint(new LinearGradientPaint(0, mBounds.y + 1, 0, mBounds.y + mBounds.height - 2, RANGES, Styles.CHECKBOX_COLORS[mArmed ? 1 : 0]));
		aGraphics.fillRoundRect(mBounds.x + 1, mBounds.y + 1, mBounds.width - 2, mBounds.height - 2, 4, 4);

		int pw = 2;
		int ph = 4;
		int ax = mBounds.x + mBounds.width - 7;
		int ay = mBounds.y + mBounds.height / 2;
		int[] px = new int[]{ax - pw, ax, ax + pw};

		aGraphics.setColor(Styles.COMBOBOX_ARROW_COLOR);
		aGraphics.fillPolygon(px, new int[]{ay-1, ay-ph, ay-1}, 3);
		aGraphics.fillPolygon(px, new int[]{ay+1, ay+ph, ay+1}, 3);

		aGraphics.setPaint(oldPaint);

		mTextBox.setBounds(mBounds).setAnchor(Anchor.WEST).setMargins(0, 8, 0, 15).setForeground(Styles.BOX_FOREGROUND_SELECTED_COLOR).setMaxLineCount(1).setFont(Styles.SLIDER_FONT).render(aGraphics);
	}


	@Override
	protected boolean mousePressed(NodeEditorPane aEditorPane, Point aClickPoint)
	{
		mArmed = true;

		aEditorPane.setPopup(new Popup(this, new Rectangle(mBounds.x, mBounds.y, mBounds.width, 0)));
		aEditorPane.repaint();

		return true;
	}


	@Override
	protected void mouseReleased(NodeEditorPane aEditorPane, Point aClickPoint)
	{
		mArmed = false;

		aEditorPane.setPopup(null);
		aEditorPane.repaint();
	}
}
