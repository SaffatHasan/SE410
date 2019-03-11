/*
Storybook: Open Source software for novelists and authors.
Copyright (C) 2008 - 2012 Martin Mustun

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package storybook.ui.combobox;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import storybook.model.hbn.entity.Person;

/**
 * @author martin
 *
 */
@SuppressWarnings("serial")
public class PersonListCellRenderer extends DefaultListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		try {
			JLabel label = (JLabel) super.getListCellRendererComponent(list,
					value, index, isSelected, cellHasFocus);
			if (!(value instanceof Person)) {
				String str = value.toString();
				if (str.isEmpty()) {
					label.setText(" ");
					return label;
				}
				label.setText(value.toString());
				return label;
			}
			Person person = (Person) value;
			label.setIcon(person.getGender().getImageIcon()); 
			//not sure if I need to add a species icon
			//UI probably isn't designed for two icons here, so I'll skip it for now -Andrew
			return label;
		} catch (Exception e) {
			return new JLabel("");
		}
	}
}
