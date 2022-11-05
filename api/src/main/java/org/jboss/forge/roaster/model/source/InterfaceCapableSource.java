/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.roaster.model.source;

import org.jboss.forge.roaster.model.InterfaceCapable;
import org.jboss.forge.roaster.model.JavaInterface;
import org.jboss.forge.roaster.model.util.Methods;

/**
 * Represents a {@link JavaSource} that may implement one or more interfaces.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public interface InterfaceCapableSource<T extends JavaSource<T>> extends InterfaceCapable
{
   /**
    * Implements the specified interface name
    * 
    * @param type the interface FQN
    * @return this object
    */
   T addInterface(String type);

   /**
    * Implements the specified {@link Class} interface
    * 
    * @param type the interface {@link Class} reference
    * @return this object
    */
   default T addInterface(Class<?> type) {
      return addInterface(type.getCanonicalName());
   }

   /**
    * Implements the specified {@link JavaInterface}
    *
    * @param type the interface
    * @return this object
    */
   default T addInterface(JavaInterface<?> type) {
      return addInterface(type.getQualifiedName());
   }

   /**
    * Implements the specified {@link Class} interface and import their abstract methods, if any.
    * 
    * @param type the interface {@link Class} reference
    * @return this object
    * 
    * @see Methods#implementAbstractMethods(Class, MethodHolderSource)
    */
   T implementInterface(Class<?> type);

   /**
    * Implements the specified {@link JavaInterface} and import their abstract methods, if any.
    * 
    * @param type the interface {@link JavaInterface} reference
    * @return this object
    * 
    * @see Methods#implementAbstractMethods(JavaInterface, MethodHolderSource)
    */
   T implementInterface(JavaInterface<?> type);


   /**
    * Removes the specified interface FQN
    * 
    * @param type the interface FQN
    * @return this object
    */
   T removeInterface(String type);

   /**
    * Removes the specified interface
    * 
    * @param type the interface {@link Class}
    * @return this object
    */
   default T removeInterface(Class<?> type) {
      return removeInterface(type.getCanonicalName());
   }

   /**
    * Removes the specified interface
    * 
    * @param type the interface {@link JavaInterface}
    * @return this object
    */
   default T removeInterface(JavaInterface<?> type) {
      return removeInterface(type.getQualifiedName());
   }
}