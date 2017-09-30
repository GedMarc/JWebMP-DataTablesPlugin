/* 
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.plugins.jqdatatable;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;

/**
 * Implements the jQuery DataTable plugin
 * <p>
 *
 * @author MMagon
 * <p>
 * <p>
 * @version 1.0
 * @since 2014 09 30
 */
public class DataTableFeature extends Feature<DataTableOptions, DataTableFeature> implements GlobalFeatures
{
	
	private static final long serialVersionUID = 1L;
	private DataTableOptions options;
	
	/**
	 * Construct a new JW Data Table
	 * <p>
	 *
	 * @param component The Table to apply the Data Table features to.
	 */
	public DataTableFeature(Component component)
	{
		super("JWDataFeature");
		setComponent(component);
		component.addVariable(getDTID());
	}
	
	public String getDTID()
	{
		return "dt_" + getComponent().getID();
	}
	
	@Override
	public void assignFunctionsToComponent()
	{
		addQuery(getComponent().getJQueryID() + "DataTable(" + getOptions() + ");" + getNewLine());
		
		//Set a new ID for every call to render. Cannot re-initialize a data table
		//String s = "if((" + getDTID() + " === null))" + getNewLine();
		String s = "if (typeof " + getDTID() + " === \"undefined\")" + getNewLine();
		s += "{" + getNewLine();
		s += getDTID() + " = " + getComponent().getJQueryID() + "DataTable(" + getOptions() + ");" + getNewLine();
		s += "}" + getNewLine();
		s += "else" + getNewLine();
		s += "{" + getNewLine();
		//s += "alert('dt variable ' + " + getDTID() + ");" + getNewLine();
		// s += getDTID() + ".dataTable('refresh');" + getNewLine();
		s += getComponent().getJQueryID() + "DataTable(" + getOptions() + ");" + getNewLine();
		s += getDTID() + " = " + getComponent().getJQueryID() + "DataTable(" + getOptions() + ");" + getNewLine();
		s += "}" + getNewLine();
		
	//	addQuery(s);
	}
	
	@Override
	public DataTableOptions getOptions()
	{
		if (options == null)
		{
			options = new DataTableOptions();
		}
		return options;
	}
	
}