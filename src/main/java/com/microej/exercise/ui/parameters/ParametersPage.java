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
    @Override
    public Widget getWidget() {
        SimpleDock dock = new SimpleDock(LayoutOrientation.VERTICAL);
        dock.addClassSelector(ClassIdentifiers.PARAMETERS);

        // adds a label that represents the title of the page at the top
        Label title = new Label("Parameters"); //$NON-NLS-1$
        title.addClassSelector(ClassIdentifiers.APPLICATION_TITLE);
        dock.setCenterChild(title);

        // creates a list of RadioButton
        List list = new List(LayoutOrientation.VERTICAL);

        RadioButtonGroup group = new RadioButtonGroup();
        RadioButton radioButton1 = new RadioButton("en_US", "English", group);
        radioButton1.addClassSelector(ClassIdentifiers.RADIO_BUTTON);
        RadioButton radioButton2 = new RadioButton("pt_US", "Portuguese", group);
        radioButton2.addClassSelector(ClassIdentifiers.RADIO_BUTTON);
        RadioButton radioButton3 = new RadioButton("fr_FR", "French", group);
        radioButton3.addClassSelector(ClassIdentifiers.RADIO_BUTTON);

        // checks the first button
        group.setChecked(radioButton1);

        // creates a SimpleDock with an Image and a Label
        SimpleDock languagesDock = new SimpleDock(LayoutOrientation.HORIZONTAL);
        ImageWidget image = new ImageWidget("/step11/langIcon.png");
        Label label = new Label("Languages"); //$NON-NLS-1$
        languagesDock.setFirstChild(image);
        languagesDock.setCenterChild(label);
        languagesDock.addClassSelector(ClassIdentifiers.LANGUAGE_LABEL);

        // adds all elements to the list
        list.addChild(languagesDock);
        list.addChild(radioButton1);
        list.addChild(radioButton2);
        list.addChild(radioButton3);

        dock.setLastChild(list);

        return dock;
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
}
