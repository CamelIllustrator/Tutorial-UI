/*
 * Java
 *
 * Copyright 2025  MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.exercise.ui.parameters;

import java.util.Set;

import com.microej.exercise.ui.generated.Labels;
import com.microej.exercise.ui.parameters.widget.RadioButton;
import com.microej.exercise.ui.parameters.widget.RadioButtonGroup;
import com.microej.exercise.ui.style.ClassIdentifiers;
import com.microej.exercise.ui.util.Model;
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
import ej.nls.NLS;
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

        // Set the current locale by calling the Model method you just updated.
        String currentLocale = Model.getInstance().getCurrentLocale();

        // Update the title Labels instantiation to use NLS and allow translation.
        this.title = new Label(Labels.NLS.getMessage(Labels.Parameters)); //$NON-NLS-1$

        // adds a label that represents the title of the page at the top
        this.title.addClassSelector(ClassIdentifiers.APPLICATION_TITLE);
        this.dock.setCenterChild(title);

        // creates a list of RadioButton
        List list = new List(LayoutOrientation.VERTICAL);

        // creates a SimpleDock with an Image and a Label
        SimpleDock languagesDock = new SimpleDock(LayoutOrientation.HORIZONTAL);
        ImageWidget image = new ImageWidget("/step11/langIcon.png");
        this.subtitle = new Label(Labels.NLS.getMessage(Labels.Languages));
        languagesDock.setFirstChild(image);
        languagesDock.setCenterChild(this.subtitle);
        languagesDock.addClassSelector(ClassIdentifiers.LANGUAGE_LABEL);

        // adds the subtitle simpledock to the list
        list.addChild(languagesDock);

        RadioButtonGroup group = new RadioButtonGroup();
        for (String locale: Labels.NLS.getAvailableLocales()) {

            RadioButton radio =
                new RadioButton(
                    locale,
                    Labels.NLS.getDisplayName(locale),
                    group
                );

            radio.addClassSelector(
                ClassIdentifiers.RADIO_BUTTON
            );

            if(locale.equals(
                Model.getInstance().getCurrentLocale())) {

                group.setChecked(radio);
            }

            list.addChild(radio);
        }

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

    @Override
    public void update() {
      this.title.setText(Labels.NLS.getMessage(Labels.Parameters));

      this.subtitle.setText(Labels.NLS.getMessage(Labels.Languages));

      this.dock.requestRender();
    }
}
