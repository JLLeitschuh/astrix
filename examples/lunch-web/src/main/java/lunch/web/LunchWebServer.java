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
package lunch.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.avanza.astrix.beans.core.AstrixSettings;

@EnableAutoConfiguration
@ComponentScan("lunch.web")
public class LunchWebServer {

	public static void main(String[] args) {
		System.setProperty("server.port", "9112");
//		System.setProperty(AstrixSettings.EXPORT_ASTRIX_MBEANS.name(), "false");
		SpringApplication.run(LunchWebServer.class, args);
	}

}
