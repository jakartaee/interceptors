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
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Used to exclude default interceptors for a target class or for a lifecycle callback method, business method, timeout
 * method, or constructor of a target class.
 *
 * <pre>
 * &#064;ExcludeDefaultInterceptors
 * &#064;Interceptors(ValidationInterceptor.class)
 * public class Order { ... }
 * </pre>
 *
 * <pre>
 * &#064;ExcludeDefaultInterceptors
 * public void updateOrder(Order order) { ... }
 * </pre>
 *
 * @since Jakarta Interceptors 1.0
 */
@Target({ TYPE, METHOD, CONSTRUCTOR })
@Retention(RUNTIME)
public @interface ExcludeDefaultInterceptors {
}
