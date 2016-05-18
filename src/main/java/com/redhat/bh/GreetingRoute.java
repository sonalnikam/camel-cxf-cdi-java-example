/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.redhat.bh;

import javax.inject.Inject;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.Uri;

import io.fabric8.annotations.Alias;
import io.fabric8.annotations.ServiceName;

/**
 * Configures all our Camel routes, components, endpoints and beans
 */
@ContextName("camelContext")
public class GreetingRoute extends RouteBuilder {

	@Inject
	@Uri("cxfrs:http://0.0.0.0:8080?resourceClasses=com.redhat.bh.cxf.GreetingService&bindingStyle=SimpleConsumer")
	private Endpoint cxfEndpoint;

	@Inject
	@ServiceName("broker-amq-tcp")
	@Alias("amq")
	ActiveMQComponent activeMQComponent;

	@Inject
	@Uri("log:output")
	private Endpoint resultEndpoint;

	@Override
	public void configure() throws Exception {

		from(cxfEndpoint).beanRef("greetingProcessor").log("In: ${body}").inOnly("amq:queue:greetings")
				.setBody(simple("Hello, ${body}!"));
	}

}
