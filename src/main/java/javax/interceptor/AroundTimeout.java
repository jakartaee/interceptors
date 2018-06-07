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

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

/**
 * <p>Defines an interceptor method that interposes on timeout methods.
 * The method must take a single parameter of type 
 * {@link javax.interceptor.InvocationContext} and have a return type
 * {@link java.lang.Object}.  The method must not be declared as abstract,
 * final, or static.</p>
 * 
 * <pre>
 * &#064;AroundTimeout
 * public Object interceptTimeout(InvocationContext ctx) throws Exception { ... }
 * </pre>
 * 
 * <p><tt>AroundTimeout</tt> methods may be declared in interceptor
 * classes, in the superclasses of interceptor classes, in the target
 * class, and/or in superclasses of the target class.</p>
 *
 * <p>A given class must not declare more than one <tt>AroundTimeout</tt> 
 * method.</p>
 * 
 * <p>An <tt>AroundTimeout</tt> method can invoke any component or 
 * resource that its corresponding timeout method can invoke.</p>
 * 
 * <p>{@link javax.interceptor.InvocationContext#getTimer()} allows any 
 * <tt>AroundTimeout</tt> method to retrieve the timer object 
 * associated with the timeout.</p>
 * 
 * <p>In general, <tt>AroundTimeout</tt> method invocations occur within the 
 * same transaction and security context as the timeout method on which they 
 * are interposing.</p>
 * 
 * <p><tt>AroundTimeout</tt> methods may throw any exceptions that are 
 * allowed by the throws clause of the timeout method on which they are 
 * interposing. They may catch and suppress exceptions and recover 
 * by calling {@link javax.interceptor.InvocationContext#proceed()}.</p>
 *
 * @since Interceptors 1.1
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AroundTimeout {
}
