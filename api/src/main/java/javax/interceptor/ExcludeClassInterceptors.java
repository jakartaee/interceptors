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

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Used to exclude class-level interceptors for the lifecycle callback method, business method, timeout method, or
 * constructor to which it is applied.
 *
 * <p>
 * Excludes interceptors defined by means of the {@link javax.interceptor.Interceptors} annotation. Use of this
 * annotation to exclude interceptors defined by means of interceptor binding annotations is not portable.
 * </p>
 *
 * <pre>
 * &#064;ExcludeClassInterceptors
 * public void updateOrder(Order order) { ... }
 * </pre>
 *
 * @see javax.interceptor.ExcludeDefaultInterceptors
 *
 * @since Jakarta Interceptors 1.0
 */
@Target({ METHOD, CONSTRUCTOR })
@Retention(RUNTIME)
public @interface ExcludeClassInterceptors {
}
