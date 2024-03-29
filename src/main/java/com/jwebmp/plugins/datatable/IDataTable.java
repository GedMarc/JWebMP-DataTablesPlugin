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

package com.jwebmp.plugins.datatable;

import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.datatable.options.*;
import jakarta.validation.constraints.*;

public interface IDataTable<T extends TableRow<?>, J extends IDataTable<T, J>>
{
	/**
	 * Gets the header group for this Data Table
	 *
	 * @return
	 */
	@NotNull
	TableHeaderGroup<?> getHeaderGroup();

	/**
	 * Sets the header group for this table
	 * <p>
	 *
	 * @param headerGroup
	 */
	@NotNull
	J setHeaderGroup(TableHeaderGroup<?> headerGroup);
	
	TableRow<?> addDataRow();
	
	TableRow<?> addDataRow(String innerLoopVariableName);
	
	/**
	 * Returns all the options with this class
	 *
	 * @return
	 */
	@NotNull
	DataTableOptions<?> getOptions();
	
	/**
	 * Gets the footer group for this data table
	 *
	 * @return
	 */
	
	@NotNull
	TableFooterGroup<?> getFooterGroup();

	/**
	 * sets the footer group for this table
	 * <p>
	 *
	 * @param footerGroup
	 */
	
	@NotNull
	J setFooterGroup(TableFooterGroup<?> footerGroup);

	/**
	 * Gets the body group for this data table
	 *
	 * @return
	 */
	
	@NotNull
	TableBodyGroup<?> getBodyGroup();

	/**
	 * Returns the Table Caption associated with this object plus positioning utilities
	 *
	 * @return
	 */
	TableCaption<?> getCaptionOfTable();

	/**
	 * Sets the body group for the table
	 * <p>
	 *
	 * @param bodyGroup
	 */
	
	@NotNull
	J setBodyGroup(TableBodyGroup<?> bodyGroup);

	/**
	 * Sets the caption for the table
	 *
	 * @param captionOfTable
	 */
	
	@NotNull
	J setCaptionOfTable(TableCaption<?> captionOfTable);
}
