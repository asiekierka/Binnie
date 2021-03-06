package binnie.genetics.gui.bee.database;

import java.text.DecimalFormat;

import binnie.core.craftgui.controls.ControlText;
import binnie.core.craftgui.controls.ControlTextCentered;
import binnie.core.craftgui.controls.listbox.ControlList;
import binnie.core.craftgui.controls.listbox.ControlOption;
import binnie.core.craftgui.geometry.CraftGUIUtil;
import binnie.core.craftgui.geometry.Point;
import binnie.core.craftgui.minecraft.control.ControlItemDisplay;

public class ControlProductsItem extends ControlOption<ControlProductsBox.Product> {
	private ControlItemDisplay item;

	public ControlProductsItem(ControlList<ControlProductsBox.Product> controlList, ControlProductsBox.Product value, int y) {
		super(controlList, value, y);
		(item = new ControlItemDisplay(this, 4, 4)).setTooltip();
		ControlText textWidget = new ControlTextCentered(this, 2, "");
		CraftGUIUtil.moveWidget(textWidget, new Point(12, 0));
		item.setItemStack(value.item);
		int time = (int) (55000.0 / value.chance);
		int seconds = time / 20;
		int minutes = seconds / 60;
		int hours = minutes / 60;
		DecimalFormat df = new DecimalFormat("#.0");

		if (hours > 1) {
			textWidget.setValue("Every " + df.format(hours) + " hours");
		} else if (minutes > 1) {
			textWidget.setValue("Every " + df.format(minutes) + " min.");
		} else {
			textWidget.setValue("Every " + df.format(seconds) + " sec.");
		}
	}
}
