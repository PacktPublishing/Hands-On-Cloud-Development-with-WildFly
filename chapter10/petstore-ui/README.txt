Running petstore-ui:
1. mvn clean install
2. java -Dcustomer.gateway.url=CUSTOMER_GATEWAY_ROUTE_URL -Dkeycloak.url=KEYCLOAK_ROUTE_URL -jar target/petstore-ui-1.0-swarm.jar
 (sample: java -Dcustomer.gateway.url=http://customer-gateway-petstore.192.168.42.98.nip.io -Dkeycloak.url=http://keycloak-openshift-petstore.192.168.42.98.nip.io -jar target/petstore-ui-1.0-swarm.jar)
