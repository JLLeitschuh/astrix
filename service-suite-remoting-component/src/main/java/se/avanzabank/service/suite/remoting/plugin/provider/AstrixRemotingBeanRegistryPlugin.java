/*
 * Copyright 2014-2015 Avanza Bank AB
 *
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
 */
package se.avanzabank.service.suite.remoting.plugin.provider;

import org.kohsuke.MetaInfServices;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import se.avanzabank.service.suite.context.AstrixBeanRegistryPlugin;
import se.avanzabank.service.suite.remoting.plugin.consumer.AstrixRemotingPluginDependencies;
import se.avanzabank.service.suite.remoting.server.AstrixRemotingFrameworkBean;

/**
 * @author Elias Lindholm (elilin)
 *
 */
@MetaInfServices(AstrixBeanRegistryPlugin.class)
public class AstrixRemotingBeanRegistryPlugin implements AstrixBeanRegistryPlugin {

	@Override
	public void registerBeanDefinitions(BeanDefinitionRegistry registry) throws BeansException {
		new AstrixRemotingFrameworkBean().postProcessBeanDefinitionRegistry(registry);
	}
	
	@Override
	public Class<?> getBeanDependencyClass() {
		// TODO: those are client side dependencies required to create a 
		// remote service proxy. Do we need to separate between client and
		// server side deps?
		return AstrixRemotingPluginDependencies.class;
	}

}