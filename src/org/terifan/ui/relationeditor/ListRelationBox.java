package org.terifan.ui.relationeditor;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Rectangle;
import org.terifan.ui.ColumnLayout;
import org.terifan.util.log.Log;


public class ListRelationBox extends AbstractRelationBox
{
	public ListRelationBox(String aTitle)
	{
		super(new Rectangle());

		super.setTitle(aTitle);
		super.setBackground(BACKGROUND_COLOR);
		super.setForeground(Color.WHITE);
		super.setOpaque(true);

		mContainer.setLayout(new ColumnLayout(1, 0, 1));
	}


	public ListRelationBox addItem(RelationItem aRelationItem)
	{
		mRelationItems.add(aRelationItem);

		mContainer.add(aRelationItem.getComponent());

		return this;
	}


	@Override
	protected Anchor[] getConnectionAnchorsImpl(int aRelationItemIndex, RelationItem aRelationItem, Rectangle aBounds, Insets aBorderInsets)
	{
		Rectangle d = mContainer.getComponent(aRelationItemIndex).getBounds();

		int s = mContainerScrollPane.getVerticalScrollBar().getValue();
		int y = aBorderInsets.top + aBounds.y + d.y + d.height / 2 - s;

		y = Math.max(aBounds.y + aBorderInsets.top / 2, Math.min(y, aBounds.y + aBounds.height - aBorderInsets.bottom - 5));

		return new Anchor[]
		{
			new Anchor(new Rectangle(aBounds.x - 1 - 5, y - 5, 10, 10), Anchor.LEFT), 
			new Anchor(new Rectangle(aBounds.x + aBounds.width + 1 - 5, y - 5, 10, 10), Anchor.RIGHT)
		};
	}
}
