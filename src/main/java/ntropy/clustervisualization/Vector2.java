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
 * 2-Dimensional data.
 *
 * @author Riley Castelli
 * @author Timothy Dovci
 * @version 2.13.2022
 * @since 2.11.2022
 */
public class Vector2 {

    /* data */
    private double x = 0;
    private double y = 0;

    /**
     * Default constructor. Keeps defaults of 0.
     */
    public Vector2() {
    }

    /**
     * Parameterized constructor. Specified data values.
     *
     * @param a x-value
     * @param b y-value
     */
    public Vector2(final double a, final double b) {
        x = a;
        y = b;
    }

    /**
     * Getter for x-value.
     * @return x-value
     */
    public double getX() {
        return x;
    }

    /**
     * Setter for y-value.
     * @param x x-value to set
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(final double y) {
        this.y = y;
    }
}
