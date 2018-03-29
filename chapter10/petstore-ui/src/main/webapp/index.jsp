<%
  String customerGatewayUrl = System.getProperty("customer.gateway.url");
  String keycloakUrl = System.getProperty("keycloak.url");
%>

<html>
   <head>
      <title>Cloud petstore</title>
      <link rel="stylesheet" href="/css/app.css"/>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.13.3/JSXTransformer.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.13.3/react-with-addons.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/react-router/0.13.3/ReactRouter.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <script src="<%= keycloakUrl %>/auth/js/keycloak.js"></script>
      <script language="javascript">
         customerGatewayUrl =  '<%= customerGatewayUrl %>'
         if (typeof Keycloak === 'function') {
           keycloak = new Keycloak('/keycloak.json');
         } else {
           alert('No keycloak is running. Cannot continue.');
         }
      </script>
      <script	type="text/babel" src="js/app.min.js"></script>
   </head>
   <body>
      <div id="container">
      </div>

   </body>
</html>