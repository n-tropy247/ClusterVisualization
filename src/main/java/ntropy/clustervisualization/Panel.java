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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Graphics panel for visual representation of data.
 *
 * @author Riley Castelli
 * @author Timothy Dovci
 * @version 2.13.2022
 * @since 2.13.2022
 */
public class Panel extends JPanel {

    private final boolean DEBUG;

    /* points to plot */
    private final DataUtils data;

    /* window constraints */
    private final int winW = 1000, winH = 800;

    /* graphing constraints */
    private final double tan60 = Math.tan(Math.PI / 3.);
    private final int pointRad = 10;
    private final int xOff = 20, yOff = winH - 20;
    private final int scale = 50, axisLen = 10;

    /**
     * Default constructor. Invokes super then invokes local settings
     * initialization.
     * 
     * @param debug true if debug mode specified
     */
    Panel(final boolean debug) {
        super();
        data = new DataUtils(debug);
        DEBUG = debug;
        init();
    }

    /**
     * Configure JPanel.
     */
    private void init() {
        requestFocus();
        setPreferredSize(new Dimension(winW, winH));

        repaint();
    }

    /**
     * Paint needed graph constraints and data points. Currently configured for
     * a color triangle.
     *
     * @param g Graphics of panel
     */
    @Override
    public void paintComponent(final Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(4));

        /* base of triangle */
        g2.setColor(Color.red);
        g2.drawLine(xOff, yOff, xOff + (scale * axisLen), yOff);

        /* left side of triangle */
        g2.setColor(Color.green);
        g2.drawLine(xOff, yOff, (xOff + (scale * axisLen)) / 2,
                (int) (((xOff + (scale * axisLen)) / 2) * tan60));

        /* right side of triangle */
        g2.setColor(Color.blue);
        g2.drawLine((xOff + (scale * axisLen)) / 2,
                (int) (((xOff + (scale * axisLen)) / 2) * tan60),
                xOff + (scale * axisLen), yOff);

        /* draw points */
        g2.setColor(Color.black);
        data.getData().forEach(v -> {
            if (DEBUG) {
                System.out.printf("\nCoords: %d, %d",
                        xOff + ((int) (v.getX() * (scale * axisLen))),
                        yOff - ((int) (v.getY() * (scale * axisLen))));
            }
            //TODO data misaligned
            g2.drawOval(xOff + ((int) (v.getX() * (scale * axisLen))),
                    yOff - ((int) (v.getY() * (scale * axisLen))), pointRad,
                    pointRad);
        });
    }
}
