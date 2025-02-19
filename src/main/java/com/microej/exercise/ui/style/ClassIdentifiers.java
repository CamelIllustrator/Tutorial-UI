/*
 * Java
 *
 * Copyright 2019-2025  MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.exercise.ui.style;

import ej.mwt.stylesheet.selector.ClassSelector;

/**
 * Defines the identifiers of the style classes used in the application. Equivalent to <code>.class</code> names in CSS.
 *
 * <p>
 * Like in CSS, a class defines a group of elements that share the same style attributes.
 *
 * <p>
 * Use these identifiers to select widgets of a specific class with a {@link ClassSelector}.
 */
public class ClassIdentifiers {

	private ClassIdentifiers() {
		// prevents instantiation
	}

	/** The class identifier for the heart rate value. */
	public static final int HEART_RATE_VALUE = 0;

	/** The class identifier for the step count value. */
	public static final int STEP_VALUE = 1;

	/** The class identifier for the distance value. */
	public static final int DISTANCE_VALUE = 2;

	/** The class identifier for the digital watchface. */
	public static final int DIGITAL_WATCHFACE = 3;

	/** The class identifier for the analog watchface. */
	public static final int ANALOG_WATCHFACE = 4;

	/** The class identifier for the title of applications. */
	public static final int APPLICATION_TITLE = 5;

	/** The class identifier for the activity application. */
	public static final int ACTIVITY = 6;

	/** The class identifier for the parameters application. */
	public static final int PARAMETERS = 7;

	/** The class identifier for the radio buttons. */
	public static final int RADIO_BUTTON = 8;

	/** The class identifier for the language label on parameters page. */
	public static final int LANGUAGE_LABEL = 9;
}
