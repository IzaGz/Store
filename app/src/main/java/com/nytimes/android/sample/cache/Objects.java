/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nytimes.android.sample.cache;


import android.support.annotation.Nullable;

import java.util.Arrays;


/**
 * Helper functions that can operate on any {@code Object}.
 *
 * <p>See the Guava User Guide on <a
 * href="https://github.com/google/guava/wiki/CommonObjectUtilitiesExplained">writing
 * {@code Object} methods with {@code Objects}</a>.
 *
 * @author Laurence Gonsalves
 * @since 2.0
 */
public final class Objects {
  private Objects() {}

  /**
   * Determines whether two possibly-null objects are equal. Returns:
   *
   * <ul>
   * <li>{@code true} if {@code a} and {@code b} are both null.
   * <li>{@code true} if {@code a} and {@code b} are both non-null and they are
   *     equal according to {@link Object#equals(Object)}.
   * <li>{@code false} in all other situations.
   * </ul>
   *
   * <p>This assumes that any non-null objects passed to this function conform
   * to the {@code equals()} contract.
   *
   * <p><b>Note for Java 7 and later:</b> This method should be treated as
   * deprecated; use {@link java.util.Objects#equals} instead.
   */
  public static boolean equal(Object a, Object b) {
    return a == b || (a != null && a.equals(b));
  }

  /**
   * Generates a hash code for multiple values. The hash code is generated by
   * calling {@link Arrays#hashCode(Object[])}. Note that array arguments to
   * this method, with the exception of a single Object array, do not get any
   * special handling; their hash codes are based on identity and not contents.
   *
   * <p>This is useful for implementing {@link Object#hashCode()}. For example,
   * in an object that has three properties, {@code x}, {@code y}, and
   * {@code z}, one could write:
   * <pre>   {@code
   *   public int hashCode() {
   *     return Objects.hashCode(getX(), getY(), getZ());
   *   }}</pre>
   *
   * <p><b>Warning:</b> When a single object is supplied, the returned hash code
   * does not equal the hash code of that object.
   *
   * <p><b>Note for Java 7 and later:</b> This method should be treated as
   * deprecated; use {@link java.util.Objects#hash} instead.
   */
  public static int hashCode(@Nullable Object... objects) {
    return Arrays.hashCode(objects);
  }


// --Commented out by Inspection START (11/29/16, 5:04 PM):
//  @Deprecated
//  public static ToStringHelper toStringHelper(Object self) {
//    return new ToStringHelper(self.getClass().getSimpleName());
//  }
// --Commented out by Inspection STOP (11/29/16, 5:04 PM)

   
// --Commented out by Inspection START (11/29/16, 5:04 PM):
//  @Deprecated
//  public static ToStringHelper toStringHelper(Class<?> clazz) {
//    return new ToStringHelper(clazz.getSimpleName());
//  }
// --Commented out by Inspection STOP (11/29/16, 5:04 PM)

// --Commented out by Inspection START (11/29/16, 5:04 PM):
//  @Deprecated
//  public static ToStringHelper toStringHelper(String className) {
//    return new ToStringHelper(className);
//  }
// --Commented out by Inspection STOP (11/29/16, 5:04 PM)


   


  @Deprecated
  public static final class ToStringHelper {
    private final String className;
    private ValueHolder holderHead = new ValueHolder();
    private ValueHolder holderTail = holderHead;
    private boolean omitNullValues = false;

    /**
     * Use @link Objects#toStringHelper(Object)} to create an instance.
     */
    private ToStringHelper(String className) {
      this.className = className;
    }

    /**
     * Configures the {@link ToStringHelper} so {@link #toString()} will ignore
     * properties with null value. The order of calling this method, relative
     * to the {@code add()}/{@code addValue()} methods, is not significant.
     *
     * @since 12.0
     */
    public ToStringHelper omitNullValues() {
      omitNullValues = true;
      return this;
    }


    /**
     * Adds a name/value pair to the formatted output in {@code name=value}
     * format.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper add(String name, boolean value) {
      return addHolder(name, String.valueOf(value));
    }

    /**
     * Adds a name/value pair to the formatted output in {@code name=value}
     * format.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper add(String name, char value) {
      return addHolder(name, String.valueOf(value));
    }

    /**
     * Adds a name/value pair to the formatted output in {@code name=value}
     * format.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper add(String name, double value) {
      return addHolder(name, String.valueOf(value));
    }

    /**
     * Adds a name/value pair to the formatted output in {@code name=value}
     * format.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper add(String name, float value) {
      return addHolder(name, String.valueOf(value));
    }

    /**
     * Adds a name/value pair to the formatted output in {@code name=value}
     * format.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper add(String name, int value) {
      return addHolder(name, String.valueOf(value));
    }

    /**
     * Adds a name/value pair to the formatted output in {@code name=value}
     * format.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper add(String name, long value) {
      return addHolder(name, String.valueOf(value));
    }

    /**
     * Adds an unnamed value to the formatted output.
     *
     * <p>It is strongly encouraged to use {@link #add(String, boolean)} instead
     * and give value a readable name.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper addValue(boolean value) {
      return addHolder(String.valueOf(value));
    }

    /**
     * Adds an unnamed value to the formatted output.
     *
     * <p>It is strongly encouraged to use {@link #add(String, char)} instead
     * and give value a readable name.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper addValue(char value) {
      return addHolder(String.valueOf(value));
    }

    /**
     * Adds an unnamed value to the formatted output.
     *
     * <p>It is strongly encouraged to use {@link #add(String, double)} instead
     * and give value a readable name.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper addValue(double value) {
      return addHolder(String.valueOf(value));
    }

    /**
     * Adds an unnamed value to the formatted output.
     *
     * <p>It is strongly encouraged to use {@link #add(String, float)} instead
     * and give value a readable name.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper addValue(float value) {
      return addHolder(String.valueOf(value));
    }

    /**
     * Adds an unnamed value to the formatted output.
     *
     * <p>It is strongly encouraged to use {@link #add(String, int)} instead
     * and give value a readable name.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper addValue(int value) {
      return addHolder(String.valueOf(value));
    }

    /**
     * Adds an unnamed value to the formatted output.
     *
     * <p>It is strongly encouraged to use {@link #add(String, long)} instead
     * and give value a readable name.
     *
     * @since 11.0 (source-compatible since 2.0)
     */
    public ToStringHelper addValue(long value) {
      return addHolder(String.valueOf(value));
    }

    /**
     * Returns a string in the format specified by {@link
     *
     * <p>After calling this method, you can keep adding more properties to later
     * call toString() again and get a more complete representation of the
     * same object; but properties cannot be removed, so this only allows
     * limited reuse of the helper instance. The helper allows duplication of
     * properties (multiple name/value pairs with the same name can be added).
     */
    @Override
    public String toString() {
      // create a copy to keep it consistent in case value changes
      boolean omitNullValuesSnapshot = omitNullValues;
      String nextSeparator = "";
      StringBuilder builder = new StringBuilder(32).append(className).append('{');
      for (ValueHolder valueHolder = holderHead.next;
          valueHolder != null;
          valueHolder = valueHolder.next) {
        if (!omitNullValuesSnapshot || valueHolder.value != null) {
          builder.append(nextSeparator);
          nextSeparator = ", ";

          if (valueHolder.name != null) {
            builder.append(valueHolder.name).append('=');
          }
          builder.append(valueHolder.value);
        }
      }
      return builder.append('}').toString();
    }

    private ValueHolder addHolder() {
      ValueHolder valueHolder = new ValueHolder();
      holderTail = holderTail.next = valueHolder;
      return valueHolder;
    }

    private ToStringHelper addHolder( Object value) {
      ValueHolder valueHolder = addHolder();
      valueHolder.value = value;
      return this;
    }

    private ToStringHelper addHolder(String name,  Object value) {
      ValueHolder valueHolder = addHolder();
      valueHolder.value = value;
      valueHolder.name = name;
      return this;
    }

    private static final class ValueHolder {
      String name;
      Object value;
      ValueHolder next;
    }
  }
}