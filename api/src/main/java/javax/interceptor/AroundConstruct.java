/*
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
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

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Designates an interceptor method that receives a callback when the target class constructor is invoked.
 * 
 * <p>
 * The method to which the <code>AroundConstruct</code> annotation is applied must have one of the following signatures.
 * </p>
 *
 * <pre>
 * void &#060;METHOD&#062;(InvocationContext ctx)
 *
 * Object &#060;METHOD&#062;(InvocationContext ctx)
 * </pre>
 *
 * <p>
 * The method must not be declared as abstract, final, or static.
 * </p>
 *
 * <p>
 * An <code>AroundConstruct</code> interceptor method may be only declared in an interceptor class or superclass of an
 * interceptor class.
 * </p>
 *
 * <p>
 * An interceptor class must not declare more than one <code>AroundConstruct</code> method.
 * </p>
 *
 * <p>
 * The target instance is created and its constructor injection is performed, if applicable, when the last interceptor
 * method in the <code>AroundConstruct</code> interceptor chain invokes the
 * {@link javax.interceptor.InvocationContext#proceed()} method.
 *
 * <p>
 * An <code>AroundConstruct</code> interceptor method should exercise caution accessing the instance whose constructor it
 * interposes on.
 * </p>
 *
 * <p>
 * <code>AroundConstruct</code> methods may throw any exceptions that are allowed by the throws clause of the constructor on
 * which they are interposing.
 * </p>
 *
 * @since Jakarta Interceptors 1.2
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface AroundConstruct {
}
