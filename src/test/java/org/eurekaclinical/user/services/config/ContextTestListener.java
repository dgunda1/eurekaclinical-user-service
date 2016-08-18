/*-
 * #%L
 * Eureka! Clinical User Services
 * %%
 * Copyright (C) 2016 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.eurekaclinical.user.services.config;


import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceServletContextListener;
import org.eurekaclinical.common.config.InjectorSupport;

/**
 * Create a Guice injector for testing.
 *
 * @author miaoai
 *
 */
public class ContextTestListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return new InjectorSupport(
				new Module[]{
					new ServletTestModule(),
					new AppTestModule()
				},
				Stage.DEVELOPMENT).getInjector();
	}

}
