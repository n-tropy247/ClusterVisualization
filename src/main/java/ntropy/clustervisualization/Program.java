/*
 * Copyright (C) 2022 Riley Castelli
 * Copyright (C) 2022 Timothy Dovci
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
package ntropy.clustervisualization;

import java.awt.EventQueue;
import java.util.Arrays;
import javax.swing.JFrame;

/**
 * Program container for visualizer.
 *
 * @author Riley Castelli
 * @author Timothy Dovci
 * @version 2.13.2022
 * @since 2.13.2022
 */
final class Program extends JFrame {

    /**
     * Default constructor, invokes local settings initialization.
     *
     * @param debug true if debug mode specified
     */
    Program(final boolean debug) {
        init(debug);
    }

    /**
     * Adds {@link ntropy.clustervisualization.Panel Panel} and initializes
     * application view.
     *
     * @param debug true if debug mode specified
     */
    private void init(final boolean debug) {
        /* gets the content pane of the primary window and sets it to
         * the custom panel.
        */
        getContentPane().add(new Panel(debug));
        
        /* do not allow user to resize window */
        setResizable(false);
        
        /* scale graphics */
        pack();
        
        /* set window title in top bar */
        setTitle("Cluster Visualization: RGB");
        
        /* should open in center of screen */
        setLocationByPlatform(true);
        
        /* the 'x' actually closes the app */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Adds program container to EventQueue.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        /* command line arguments to list, check for debug mode */
        boolean debug = Arrays.asList(args).contains("debug");
        /* fancy lambda stuff, basically allows us to add this program to the 
         * event queue without maintaining a real reference to it. Shorthand.
        */
        EventQueue.invokeLater(() -> {
            JFrame e = new Program(debug);
            e.setVisible(true);
            e.requestFocusInWindow();
        });
    }

}
