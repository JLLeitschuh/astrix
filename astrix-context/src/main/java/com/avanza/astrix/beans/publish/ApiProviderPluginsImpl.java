/*
 * Copyright 2014 Avanza Bank AB
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
package com.avanza.astrix.beans.publish;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 
 * @author Elias Lindholm (elilin)
 *
 */
final class ApiProviderPluginsImpl implements ApiProviderPlugins {
	
	private final ConcurrentMap<Class<? extends Annotation>, BeanPublisherPlugin> pluginByAnnotationType = new ConcurrentHashMap<>();
	
	ApiProviderPluginsImpl(Collection<BeanPublisherPlugin> apiProviderPlugins) {
		for (BeanPublisherPlugin plugin : apiProviderPlugins) {
			BeanPublisherPlugin previous = this.pluginByAnnotationType.putIfAbsent(plugin.getProviderAnnotationType(), plugin);
			if (previous != null) {
				throw new IllegalArgumentException(String.format("Multiple ApiProviderPlugin's found for providerAnnotationType=%s. p1=%s p2=%s", 
						plugin.getProviderAnnotationType().getName(), plugin.getClass().getName(), previous.getClass().getName()));
			}
		}
	}
	
	BeanPublisherPlugin getProviderPlugin(ApiProviderClass apiProvider) {
		for (BeanPublisherPlugin plugin : pluginByAnnotationType.values()) {
			if (apiProvider.isAnnotationPresent(plugin.getProviderAnnotationType())) {
				return plugin;
			}
		}
		throw new IllegalArgumentException("No plugin registered that can handle apiProvider: " + apiProvider);
	}

	public Collection<BeanPublisherPlugin> getAll() {
		return this.pluginByAnnotationType.values();
	}
	
	
	
}
