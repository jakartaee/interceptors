/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javax.interceptor;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Specifies that a class is an interceptor.
 *
 * <pre>
 * &#064;Validated &#064;Interceptor
 * public class ValidationInterceptor { ... }
 * </pre>
 *
 * <p>
 * Use of this annotation is required when declaring an interceptor using interceptor binding annotations. It is ignored
 * during the processing of classes bound using the {@link javax.interceptor.Interceptors Interceptors} annotation (or
 * when the Jakarta Enterprise Beans deployment descriptor is used to associate the interceptor with the target class).
 * </p>
 *
 * @see javax.interceptor.Interceptors
 *
 * @since Jakarta Interceptors 1.1
 */
@Retention(RUNTIME)
@Target(TYPE)
@Documented
public @interface Interceptor {
    /**
     * <p>
     * Priorities that define the order in which interceptors are invoked. These values are intended to be used with the
     * {@link javax.annotation.Priority Priority} annotation for interceptors that are defined by means of interceptor
     * binding.
     *
     * <p>
     * Interceptors with smaller priority values are called first. If more than one interceptor has the same priority, the
     * relative order of those interceptors is undefined.
     * </p>
     *
     * <ul>
     * <li>Interceptors defined by platform specifications that are to be executed at the beginning of the interceptor chain
     * should have priority values in the range <a href="#PLATFORM_BEFORE">PLATFORM_BEFORE</a> up until
     * <a href="#LIBRARY_BEFORE">LIBRARY_BEFORE</a>.</li>
     *
     * <li>Interceptors defined by extension libraries that are intended to be executed earlier in the interceptor chain,
     * but after any interceptors in the range up until <a href="#LIBRARY_BEFORE">LIBRARY_BEFORE</a> should have priority
     * values in the range <a href="#LIBRARY_BEFORE">LIBRARY_BEFORE</a> up until
     * <a href="#APPLICATION">APPLICATION</a>.</li>
     *
     * <li>Interceptors defined by applications should have priority values in the range
     * <a href="#APPLICATION">APPLICATION</a> up until <a href="#LIBRARY_AFTER">LIBRARY_AFTER</a>.</li>
     *
     * <li>Interceptors defined by extension libraries that are intended to be executed later in the interceptor chain
     * should have priority values in the range <a href="#LIBRARY_AFTER">LIBRARY_AFTER</a> up until
     * <a href="#PLATFORM_AFTER">PLATFORM_AFTER</a>.</li>
     *
     * <li>Interceptors defined by platform specifications that are intended to be executed at the end of the interceptor
     * chain should have priority values at <a href="#PLATFORM_AFTER">PLATFORM_AFTER</a> or higher.</li>
     * </ul>
     *
     * <p>
     * An interceptor that must be invoked before or after another defined interceptor can choose any appropriate value.
     * </p>
     *
     *
     * <p>
     * For example, an extension library might define an interceptor like this:
     * </p>
     *
     * <pre>
     * &#064;Priority(Interceptor.Priority.LIBRARY_BEFORE+10)
     * &#064;Validated &#064;Interceptor
     * public class ValidationInterceptor { ... }
     * </pre>
     *
     * The {@link javax.annotation.Priority Priority} annotation is ignored when computing the invocation order of
     * interceptors bound to a target using the {@link javax.interceptor.Interceptors Interceptors} annotation.
     *
     * @see javax.annotation.Priority
     * 
     * @since Jakarta Interceptors 1.2
     */
    public static class Priority {
        private Priority() {
        } // don't allow instances

        /**
         * Start of range for early interceptors defined by platform specifications.
         */
        public static final int PLATFORM_BEFORE = 0;

        /**
         * Start of range for early interceptors defined by extension libraries.
         */
        public static final int LIBRARY_BEFORE = 1000;

        /**
         * Start of range for interceptors defined by applications.
         */
        public static final int APPLICATION = 2000;

        /**
         * Start of range for late interceptors defined by extension libraries.
         */
        public static final int LIBRARY_AFTER = 3000;

        /**
         * Start of range for late interceptors defined by platform specifications.
         */
        public static final int PLATFORM_AFTER = 4000;
    }
}
