/*
 * UniTime 3.4 (University Timetabling Application)
 * Copyright (C) 2013, UniTime LLC, and individual contributors
 * as indicated by the @authors tag.
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
*/
package org.unitime.timetable.gwt.client.aria;

import com.google.gwt.aria.client.LiveValue;
import com.google.gwt.aria.client.Roles;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class AriaStatus extends Widget implements HasText, HasHTML {
	private static AriaStatus sStatus = null;
	
	public AriaStatus(boolean assertive) {
		setElement(DOM.createSpan());
		setStyleName("unitime-AriaStatus");
		Roles.getStatusRole().set(getElement());
		Roles.getStatusRole().setAriaLiveProperty(getElement(), assertive ? LiveValue.ASSERTIVE : LiveValue.POLITE);		
	}
	
	public AriaStatus() {
		this(false);
	}
	
	public static AriaStatus getInstance() {
		if (sStatus == null) {
			sStatus = new AriaStatus(true);
			RootPanel.get().add(sStatus);
		}
		return sStatus;
	}
	
	@Override
	public String getText() {
		return getElement().getInnerText();
	}

	@Override
	public void setText(String text) {
		getElement().setInnerText(text);
	}

	@Override
	public String getHTML() {
		return getElement().getInnerHTML();
	}

	@Override
	public void setHTML(String html) {
		getElement().setInnerHTML(html);
	}
	
}