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

/**
 * A single 3-tuple data point.
 *
 * @author Riley Castelli
 * @author Timothy Dovci
 * @version 2.13.2022
 * @since 2.11.2022
 */
public class DataPoint {

    /* 3-tuple of data */
    private final double x, y, z;

    /**
     * Default constructor. Initializes 3-tuple from given integers.
     *
     * @param a first element of tuple
     * @param b second element of tuple
     * @param c third element of tuple
     */
    public DataPoint(final int a, final int b, final int c) {
        x = a;
        y = b;
        z = c;
    }

    /**
     * Getter for first element of tuple.
     *
     * @return first element
     */
    public double getX() {
        return x;
    }

    /**
     * Getter for second element of tuple.
     *
     * @return second element
     */
    public double getY() {
        return y;
    }

    /**
     * Getter for third element of tuple.
     *
     * @return third element
     */
    public double getZ() {
        return z;
    }
}
