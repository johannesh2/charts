package com.vaadin.addon.charts.model;

/*
 * #%L
 * Vaadin Charts
 * %%
 * Copyright (C) 2012 - 2016 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 * 
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 * 
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <https://vaadin.com/license/cval-3>.
 * #L%
 */

import java.util.ArrayList;
import java.util.Arrays;
public class DataGrouping extends AbstractConfigurationObject {

	private static final long serialVersionUID = 1L;
	private DateTimeLabelFormats dateTimeLabelFormats;
	private Boolean enabled;
	private Boolean forced;
	private Number groupPixelWidth;
	private Boolean smoothed;
	private ArrayList<TimeUnitMultiples> units;

	public DataGrouping() {
	}

	/**
	 * @see #setDateTimeLabelFormats(DateTimeLabelFormats)
	 */
	public DateTimeLabelFormats getDateTimeLabelFormats() {
		return dateTimeLabelFormats;
	}

	/**
	 * <p>
	 * Datetime formats for the header of the tooltip in a stock chart. The
	 * format can vary within a chart depending on the currently selected time
	 * range and the current data grouping.
	 * </p>
	 * 
	 * <p>
	 * The default formats are:
	 * </p>
	 * 
	 * <pre>
	 * {
	 * 	   millisecond: ['%A, %b %e, %H:%M:%S.%L', '%A, %b %e, %H:%M:%S.%L', '-%H:%M:%S.%L'],
	 * 	   second: ['%A, %b %e, %H:%M:%S', '%A, %b %e, %H:%M:%S', '-%H:%M:%S'],
	 * 	   minute: ['%A, %b %e, %H:%M', '%A, %b %e, %H:%M', '-%H:%M'],
	 * 	   hour: ['%A, %b %e, %H:%M', '%A, %b %e, %H:%M', '-%H:%M'],
	 * 	   day: ['%A, %b %e, %Y', '%A, %b %e', '-%A, %b %e, %Y'],
	 * 	   week: ['Week from %A, %b %e, %Y', '%A, %b %e', '-%A, %b %e, %Y'],
	 * 	   month: ['%B %Y', '%B', '-%B %Y'],
	 * 	   year: ['%Y', '%Y', '-%Y']
	 * 	}
	 * </pre>
	 * 
	 * <p>
	 * For each of these array definitions, the first item is the format used
	 * when the active time span is one unit. For instance, if the current data
	 * applies to one week, the first item of the week array is used. The second
	 * and third items are used when the active time span is more than two
	 * units. For instance, if the current data applies to two weeks, the second
	 * and third item of the week array are used, and applied to the start and
	 * end date of the time span.
	 * </p>
	 * <p>
	 * Defaults to:
	 */
	public void setDateTimeLabelFormats(
			DateTimeLabelFormats dateTimeLabelFormats) {
		this.dateTimeLabelFormats = dateTimeLabelFormats;
	}

	public DataGrouping(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @see #setEnabled(Boolean)
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Enable or disable data grouping. Defaults to <code>true</code>.
	 * <p>
	 * Defaults to: true
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @see #setForced(Boolean)
	 */
	public Boolean getForced() {
		return forced;
	}

	/**
	 * When data grouping is forced, it runs no matter how small the intervals
	 * are. This can be handy for example when the sum should be calculated for
	 * values appearing at random times within each hour. Defaults to
	 * <code>false</code>.
	 * <p>
	 * Defaults to: false
	 */
	public void setForced(Boolean forced) {
		this.forced = forced;
	}

	/**
	 * @see #setGroupPixelWidth(Number)
	 */
	public Number getGroupPixelWidth() {
		return groupPixelWidth;
	}

	/**
	 * The approximate pixel width of each group. If for example a series with
	 * 30 points is displayed over a 600 pixel wide plot area, no grouping is
	 * performed. If however the series contains so many points that the spacing
	 * is less than the groupPixelWidth, Highcharts will try to group it into
	 * appropriate groups so that each is more or less two pixels wide. If
	 * multiple series with different group pixel widths are drawn on the same x
	 * axis, all series will take the greatest width. For example, line series
	 * have 2px default group width, while column series have 10px. If combined,
	 * both the line and the column will have 10px by default. Defaults to
	 * <code>2</code>.
	 * <p>
	 * Defaults to: 2
	 */
	public void setGroupPixelWidth(Number groupPixelWidth) {
		this.groupPixelWidth = groupPixelWidth;
	}

	/**
	 * @see #setSmoothed(Boolean)
	 */
	public Boolean getSmoothed() {
		return smoothed;
	}

	/**
	 * Normally, a group is indexed by the start of that group, so for example
	 * when 30 daily values are grouped into one month, that month's x value
	 * will be the 1st of the month. This apparently shifts the data to the
	 * left. When the smoothed option is true, this is compensated for. The data
	 * is shifted to the middle of the group, and min and max values are
	 * preserved. Internally, this is used in the Navigator series.
	 * <p>
	 * Defaults to: false
	 */
	public void setSmoothed(Boolean smoothed) {
		this.smoothed = smoothed;
	}

	public TimeUnitMultiples[] getUnits() {
		TimeUnitMultiples[] arr = new TimeUnitMultiples[units.size()];
		units.toArray(arr);
		return arr;
	}

	public void setUnits(TimeUnitMultiples... units) {
		this.units = new ArrayList<TimeUnitMultiples>(Arrays.asList(units));
	}

	public void addUnit(TimeUnitMultiples unit) {
		if (this.units == null) {
			this.units = new ArrayList<TimeUnitMultiples>();
		}
		this.units.add(unit);
	}

	public void removeUnit(TimeUnitMultiples unit) {
		this.units.remove(unit);
	}
}