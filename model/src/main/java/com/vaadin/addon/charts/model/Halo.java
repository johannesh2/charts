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
/**
 * Options for the halo appearing around the hovered point in line-type series
 * as well as outside the hovered slice in pie charts. By default the halo is
 * filled by the current point or series color with an opacity of 0.25. The halo
 * can be disabled by setting the <code>halo</code> option to <code>false</code>
 * .
 */
public class Halo extends AbstractConfigurationObject {

	private static final long serialVersionUID = 1L;
	private Object attributes;
	private Number opacity;
	private Number size;

	public Halo() {
	}

	/**
	 * @see #setAttributes(Object)
	 */
	public Object getAttributes() {
		return attributes;
	}

	/**
	 * A collection of SVG attributes to override the appearance of the halo,
	 * for example <code>fill</code>, <code>stroke</code> and
	 * <code>stroke-width</code>.
	 * <p>
	 * Defaults to:
	 */
	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}

	/**
	 * @see #setOpacity(Number)
	 */
	public Number getOpacity() {
		return opacity;
	}

	/**
	 * Opacity for the halo unless a specific fill is overridden using the
	 * <code>attributes</code> setting. Note that Highcharts is only able to
	 * apply opacity to colors of hex or rgb(a) formats.
	 * <p>
	 * Defaults to: 0.25
	 */
	public void setOpacity(Number opacity) {
		this.opacity = opacity;
	}

	/**
	 * @see #setSize(Number)
	 */
	public Number getSize() {
		return size;
	}

	/**
	 * The pixel size of the halo. For point markers this is the radius of the
	 * halo. For pie slices it is the width of the halo outside the slice. For
	 * bubbles it defaults to 5 and is the width of the halo outside the bubble.
	 * <p>
	 * Defaults to: 10
	 */
	public void setSize(Number size) {
		this.size = size;
	}
}