## Challenges
Fuse/Camel and A-MQ is an established toolkit for creating integration solutions. Fuse Integration Services and xPaaS A-MQ provide these core technologies as containerised building blocks on OpenShift. Whilst the basic technologies are familiar to anyone used to developing integrations based on Fuse / Fabric 6.2.1 and A-MQ 6.2.1, the documented differences between FIS and Fuse introduce challenges to glueing these two technologies together.
- https://docs.openshift.com/enterprise/3.1/using_images/xpaas_images/fuse.html#differences-between-fuse-integration-services-and-jboss-fuse
- https://docs.openshift.com/enterprise/3.1/using_images/xpaas_images/a_mq.html#differences-between-the-jboss-a-mq-xpaas-image-and-the-regular-release-of-jboss-a-mq
  
## Location
- https://github.com/benemon/camel-cxf-cdi-java-example

## Core Technologies
 - Red Hat JBoss xPaaS A-MQ
 - Red Hat JBoss xPaaS Fuse Integration Services
 - OpenShift

## Solution Components

The project is broken down into two components:

### Greeting
Produces a RESTful Camel CXFRS endpoint on /greeting, that will accept any input as an HTTP path parameter and create a message from it e.g:

http://cxf-cdi-java-example.uki-ose3.saleslab.fab.redhat.com/greeting/ben

Camel’s Kubernetes Service Discovery mechanism is then used to look up the namespace A-MQ instance, and the message is enqueued.  
  
Also exposes a Jolokia instance of simpler interrogation.

### Template
Produces the OpenShift namespace artifacts based on the fis-java-openshift image. Also creates the namespace message broker from the A-MQ xPaaS image.

## Usage

### OpenShift

The example can also be built and run using the included S2I template *cxf-cdi-java-example.yaml*

The template file can be used to create an OpenShift application template by executing the following command from the project root:

	oc create -f openshift/cxf-cdi-java-example.yaml
