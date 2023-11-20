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

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Handle 3-tuple conversion to graphable data.
 *
 * @author Riley Castelli
 * @author Timothy Dovci
 * @version 2.13.2022
 * @since 2.13.2022
 */
public class DataUtils {

    /* data */
    private final List<DataPoint> DATA_RAW;
    private final List<Vector2> DATA_GRAPH;

    /**
     * Default constructor, populate raw data and invoke conversion.
     *
     * @param debug true if debug mode specified
     */
    public DataUtils(final boolean debug) {
        DATA_RAW = new ArrayList<>();
        DATA_GRAPH = new ArrayList<>();

        if (debug) {
            createSampleData();
        }
        convertData();
    }

    /**
     * Create sample data of RGB values.
     */
    private void createSampleData() {
        Color[] testColors = {
            Color.red,
            Color.blue,
            Color.green,
            Color.cyan,
            Color.magenta,
            Color.yellow
        };

        for (Color c : testColors) {
            DATA_RAW.add(new DataPoint(c.getRed(), c.getGreen(), c.getBlue()));
        }
    }

    /**
     * Convert raw data to graphable data. Currently configured for RGB values.
     */
    private void convertData() {
        final double tan60 = Math.tan(Math.PI / 3.);

        DATA_RAW.forEach(d -> {
            int rgb = d.getX() + d.getY() + d.getZ();
            double x = (d.getZ() + (d.getX() * tan60)) / (rgb * tan60);
            double y = d.getZ() / (rgb * tan60);
            DATA_GRAPH.add(new Vector2(x, y));
        });
    }

    /**
     * Return graphable data.
     *
     * @return data in graphable format
     */
    public List<Vector2> getData() {
        return DATA_GRAPH;
    }
}
