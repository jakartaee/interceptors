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

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Specifies that an annotation type is an interceptor binding type.
 *
 * <pre>
 * &#064;Inherited
 * &#064;InterceptorBinding
 * &#064;Target({ TYPE, METHOD, CONSTRUCTOR })
 * &#064;Retention(RUNTIME)
 * public &#064;interface Valid {
 * }
 * </pre>
 *
 * <p>
 * Interceptor bindings are intermediate annotations that may be used to associate interceptors with target beans.
 * </p>
 *
 * <p>
 * The interceptor bindings of an interceptor are specified by annotating the interceptor class with the binding types
 * and the {@link javax.interceptor.Interceptor Interceptor} annotation.
 * </p>
 *
 * <pre>
 * &#064;Valid &#064;Interceptor
 * public class ValidationInterceptor { ... }
 * </pre>
 *
 * <p>
 * An interceptor may specify multiple interceptor bindings.
 * </p>
 *
 * <p>
 * An interceptor binding of a bean may be declared by annotating the bean class, a method of the bean class, or a
 * constructor of the bean class with the interceptor binding type.
 * </p>
 *
 * <pre>
 * &#064;Valid
 * public class Order { ... }
 * </pre>
 *
 * <pre>
 * &#064;Valid &#064;Secure
 * public void updateOrder(Order order) { ... }
 * </pre>
 *
 * <pre>
 * &#064;Valid
 * public Order(...) { ... }
 * </pre>
 *
 * <p>
 * A bean class or method of a bean class may declare multiple interceptor bindings.
 * </p>
 *
 * <p>
 * An interceptor binding type may declare other interceptor bindings.
 * </p>
 *
 * <pre>
 * &#064;Inherited
 * &#064;InterceptorBinding
 * &#064;Target({ TYPE, METHOD })
 * &#064;Retention(RUNTIME)
 * &#064;Valid
 * public &#064;interface Secure {
 * }
 * </pre>
 *
 * <p>
 * Interceptor bindings are transitive&mdash;an interceptor binding declared by an interceptor binding type is inherited
 * by all beans and other interceptor binding types that declare that interceptor binding type.
 * </p>
 *
 * @see javax.interceptor.Interceptor
 *
 * @since Jakarta Interceptors 1.1
 */
@Target(ANNOTATION_TYPE)
@Retention(RUNTIME)
@Documented
public @interface InterceptorBinding {
}
