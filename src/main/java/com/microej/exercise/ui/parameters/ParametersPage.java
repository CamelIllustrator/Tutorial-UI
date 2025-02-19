/*
 * Java
 *
 * Copyright 2025  MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.exercise.ui.parameters;

import com.microej.exercise.ui.style.ClassIdentifiers;
import com.microej.exercise.ui.util.Page;
import ej.microui.display.Colors;
import ej.mwt.Widget;
import ej.mwt.style.EditableStyle;
import ej.mwt.style.background.RectangularBackground;
import ej.mwt.stylesheet.cascading.CascadingStylesheet;
import ej.mwt.stylesheet.selector.ClassSelector;
import ej.widget.basic.Label;
import ej.widget.container.LayoutOrientation;
import ej.widget.container.SimpleDock;

public class ParametersPage extends Page {
    @Override
    public Widget getWidget() {
        SimpleDock dock = new SimpleDock(LayoutOrientation.VERTICAL);
        dock.addClassSelector(ClassIdentifiers.PARAMETERS);

        // adds a label that represents the title of the page at the top
        Label title = new Label("Parameters");
        title.addClassSelector(ClassIdentifiers.APPLICATION_TITLE);

        dock.setCenterChild(title);

        /**
         * STEP 11: Implement the Parameters page.
         *
         * Objective: Learn how to implement a new page and use custom widgets from the Example-Java-widget demo.
         *
         * Step 11.1: Create the layout of the new page.
         *
         * 1. Go to the Example-Java-widget demo and look at the
         * <a href="https://github.com/MicroEJ/Example-Java-Widget/tree/master/src/main/java/com/microej/demo/widget/radiobutton">RadioButton example</a>.
         * Add the classes RadioButton and RadioButtonGroup to your project.
         * (Open the files on GitHub and click on “Download raw file” in the top right corner of the file.
         * Then, move the files to the correct package in your project com.microej.exercise.ui.parameters.widget) <br>
         * 2. Create a RadioButtonGroup and three RadioButton.
         * You can add them to a List or another Container if needed.
         * Look at the RadioButtonPage example in the Example-Java-widget demo for the correct use of the widget. <br>
         * 3. Check the first RadioButton by default, using group.setChecked(radioButton); <br>
         * 4. Create a new SimpleDock for the “Languages” subtitle. Create an ImageWidget and a Label,
         * add them inside the new SimpleDock. The icon is declared in the step11.images.list resource file.
         * Add the SimpleDock at the top of your List. <br>
         * 5. Add the List (or other Container) to the SimpleDock as the lastChild and
         * the page title as the centerChild.
         *
         */

        // WRITE CODE HERE

        return dock;
    }

    @Override
    public void populateStylesheet(CascadingStylesheet stylesheet) {
        // defines the style of the top container of the parameters application
        EditableStyle style = stylesheet.getSelectorStyle(new ClassSelector(ClassIdentifiers.PARAMETERS));
        style.setBackground(new RectangularBackground(Colors.BLACK));
        /**
         * STEP 11: Implement the Parameters page.
         *
         * Objective: Learn how to implement a new page and use custom widgets from the Example-Java-Widget demo.
         *
         * Step 11.1: Add style to the page to match the mockup.
         *
         * 1. Apply style to the title Label. Refer to the ActivityPage if needed. Don’t forget to use ClassIdentifiers! <br>
         * 2. Add some margins to your List to center it: style.setMargin(new FlexibleOutline(0, 0, 70, 100)); <br>
         * 3. Align the three RadioButton horizontally. <br>
         * 4. Define the inner color of the RadioButton with the extra int field RadioButton.CHECKED_COLOR_FIELD. <br>
         * 5. Align the title Label vertically at the top. <br>
         * 6. Align the subtitle SimpleDock horizontally on the left and give it a 20px bottom padding. <br>
         * 7. Add a right margin of 15px to the ImageWidget.
         *
         */

        // WRITE CODE HERE
    }
}
