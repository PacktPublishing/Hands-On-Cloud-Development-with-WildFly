<%
  String keycloakUrl = System.getProperty("keycloak.url");
%>
{
  "realm": "petstore",
  "auth-server-url": "<%= keycloakUrl %>/auth",
  "resource": "petstore-ui"
}
