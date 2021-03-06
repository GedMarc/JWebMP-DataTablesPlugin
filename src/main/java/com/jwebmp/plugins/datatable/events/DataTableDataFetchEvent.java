/*
 * Copyright (C) 2017 GedMarc
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

package com.jwebmp.plugins.datatable.events;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.plugins.datatable.DataTableData;
import com.jwebmp.plugins.datatable.search.DataTableSearchRequest;

/**
 * Data Tables Ajax fetch data.
 *
 * @param <J>
 */
public abstract class DataTableDataFetchEvent<J extends DataTableDataFetchEvent<J>>
		extends Event<GlobalFeatures, J>
{
	public DataTableDataFetchEvent()
	{
		this(null);
	}

	public DataTableDataFetchEvent(ComponentHierarchyBase component)
	{
		super(component);
	}

	/**
	 * Returns the data object to be rendered as json to the server
	 *
	 * @return
	 */
	public abstract DataTableData<?> returnData(DataTableSearchRequest<?> searchRequest);
}
