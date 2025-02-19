/*
 * Java
 *
 * Copyright 2025  MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.exercise.ui.parameters;

import com.microej.exercise.ui.parameters.widget.RadioButton;
import com.microej.exercise.ui.parameters.widget.RadioButtonGroup;
import com.microej.exercise.ui.style.ClassIdentifiers;
import com.microej.exercise.ui.style.Fonts;
import com.microej.exercise.ui.util.Page;
import ej.microui.display.Colors;
import ej.mwt.Widget;
import ej.mwt.style.EditableStyle;
import ej.mwt.style.background.RectangularBackground;
import ej.mwt.style.outline.FlexibleOutline;
import ej.mwt.style.outline.UniformOutline;
import ej.mwt.stylesheet.cascading.CascadingStylesheet;
import ej.mwt.stylesheet.selector.ClassSelector;
import ej.mwt.stylesheet.selector.TypeSelector;
import ej.mwt.util.Alignment;
import ej.widget.basic.ImageWidget;
import ej.widget.basic.Label;
import ej.widget.container.LayoutOrientation;
import ej.widget.container.SimpleDock;
import ej.widget.container.List;

public class ParametersPage extends Page {

    private SimpleDock dock;
    private Label title;
    private Label subtitle;

    @Override
    public Widget getWidget() {
        this.dock = new SimpleDock(LayoutOrientation.VERTICAL);
        this.dock.addClassSelector(ClassIdentifiers.PARAMETERS);

        /**
         * STEP 12: Internationalization
         *
         * Objective: Learn how to implement internationalization using the NLS library.
         *
         * Step 12.2: Update the parameters page
         *
         * 1. Set the current locale by calling the Model method you just updated. <br>
         * 2. Replace the RadioButton creations to create one RadioButton per available locale.
         * Use the code snippet provided in the training documentation to replace the existing code. <br>
         * 3. Update the title and subtitle Labels instantiation to use NLS and allow translation.
         *
         */

        // WRITE CODE HERE

        // adds a label that represents the title of the page at the top
        this.title = new Label("Parameters");
        this.title.addClassSelector(ClassIdentifiers.APPLICATION_TITLE);
        this.dock.setCenterChild(title);

        // creates a list of RadioButton and subtitle
        List list = new List(LayoutOrientation.VERTICAL);

        // creates a SimpleDock with an Image and a Label
        SimpleDock languagesDock = new SimpleDock(LayoutOrientation.HORIZONTAL);
        ImageWidget image = new ImageWidget("/step11/langIcon.png");
        this.subtitle = new Label("Languages");
        languagesDock.setFirstChild(image);
        languagesDock.setCenterChild(this.subtitle);
        languagesDock.addClassSelector(ClassIdentifiers.LANGUAGE_LABEL);

        // adds the subtitle simpledock to the list
        list.addChild(languagesDock);

        RadioButtonGroup group = new RadioButtonGroup();

        RadioButton radioButton1 = new RadioButton("en_US" , "English", group);
        radioButton1.addClassSelector(ClassIdentifiers.RADIO_BUTTON);
        RadioButton radioButton2 = new RadioButton("pt_US" , "Portuguese", group);
        radioButton2.addClassSelector(ClassIdentifiers.RADIO_BUTTON);
        RadioButton radioButton3 = new RadioButton("fr_FR" , "French", group);
        radioButton3.addClassSelector(ClassIdentifiers.RADIO_BUTTON);

        // adds all the radioButton to the list
        list.addChild(radioButton1);
        list.addChild(radioButton2);
        list.addChild(radioButton3);

        // checks the first button
        group.setChecked(radioButton1);

        this.dock.setLastChild(list);

        return this.dock;
    }

    @Override
    public void populateStylesheet(CascadingStylesheet stylesheet) {
        // defines the style of the top container of the parameters application
        EditableStyle style = stylesheet.getSelectorStyle(new ClassSelector(ClassIdentifiers.PARAMETERS));
        style.setBackground(new RectangularBackground(Colors.BLACK));

        // defines the style of the parameters application title
        style = stylesheet.getSelectorStyle(new ClassSelector(ClassIdentifiers.APPLICATION_TITLE));
        style.setMargin(new FlexibleOutline(20, 0, 0, 0));
        style.setVerticalAlignment(Alignment.TOP);
        style.setFont(Fonts.getMediumFont());

        // defines the style of the parameters language simpledock
        style = stylesheet.getSelectorStyle(new ClassSelector(ClassIdentifiers.LANGUAGE_LABEL));
        style.setHorizontalAlignment(Alignment.LEFT);
        style.setPadding(new FlexibleOutline(0, 0, 20, 0));

        // defines the style of the image widget in the simpledock
        style = stylesheet.getSelectorStyle(new TypeSelector(ImageWidget.class));
        style.setMargin(new FlexibleOutline(0, 15, 0, 0));

        // defines the style of the radiobutton list
        style = stylesheet.getSelectorStyle(new TypeSelector(List.class));
        style.setMargin(new FlexibleOutline(0, 0, 70, 100));

        // defines the style of the radiobuttons
        style = stylesheet.getSelectorStyle(new ClassSelector(ClassIdentifiers.RADIO_BUTTON));
        style.setHorizontalAlignment(Alignment.LEFT);
        style.setExtraInt(RadioButton.CHECKED_COLOR_FIELD, Colors.RED);
        style.setMargin(new UniformOutline(2));
    }

    /**
     * STEP 12: Internationalization
     *
     * Objective: Learn how to implement internationalization using the NLS library.
     *
     * Step 12.3: Override the update method
     *
     * 1. Override the `public void update()` method. <br>
     * 2. Set the title and subtitle Labels text using their respective setText() methods.
     * Set their value using NLS and the corresponding msgid (see Labels*.po files). <br>
     * 3. Request a render of the SimpleDock at the root of the page to update it and its children.
     *
     */

    // WRITE CODE HERE
}
