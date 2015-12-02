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
package com.avanza.astrix.beans.service;

import com.avanza.astrix.beans.config.AstrixConfig;

public final class ServiceBeanContext {

	private final ServiceComponentRegistry serviceComponents;
	private final ServiceLeaseManager leaseManager;
	private final AstrixServiceBeanInstanceMbeanExporter serviceMbeanExporter;
	private final ServiceBeanProxyInvocationDispatcherFactory serviceBeanInvocationDispatcherFactory;
	private final AstrixConfig config;
	
	
	public ServiceBeanContext(ServiceComponentRegistry serviceComponents, 
							  ServiceLeaseManager leaseManager,
							  AstrixConfig astrixConfig,
							  AstrixServiceBeanInstanceMbeanExporter serviceMbeanExporter,
							  ServiceBeanProxyInvocationDispatcherFactory serviceBeanInvocationDispatcherFactory) {
		this.serviceComponents = serviceComponents;
		this.leaseManager = leaseManager;
		this.config = astrixConfig;
		this.serviceMbeanExporter = serviceMbeanExporter;
		this.serviceBeanInvocationDispatcherFactory = serviceBeanInvocationDispatcherFactory;
	}
	
	public AstrixConfig getConfig() {
		return config;
	}

	public ServiceLeaseManager getLeaseManager() {
		return leaseManager;
	}

	public ServiceComponentRegistry getServiceComponents() {
		return serviceComponents;
	}
	
	public AstrixServiceBeanInstanceMbeanExporter getServiceMbeanExporter() {
		return serviceMbeanExporter;
	}
	
	public ServiceBeanProxyInvocationDispatcherFactory getServiceBeanInvocationDispatcherFactory() {
		return serviceBeanInvocationDispatcherFactory;
	}
	
}
