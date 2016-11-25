<%-- 
    Document   : index
    Created on : 21/11/2016, 20:08:09
    Author     : Harlock
--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <link rel="stylesheet" href="template/css/estilo.css" media="screen" title="no title">
</head>
<body>
  <div class="container bg">
    <div  class="containerLogo">
      <div class="containerMD">
        <img  class="logo" src="template/imgs/logo.png" alt="" />
      </div>
      <div class="containerMD direita horizontal">
        <button class="botaoX preto" type="button" name="button">Entrar</button>
        <button class="botaoX vermelho" type="button" name="button">Cadastrar</button>
      </div>
    </div>
  </div>
  <!--- aqui vai corpo -->
  
    <div class="containerMD">

    </div>
  </div>
  <jsp:include page = "template/templates/login.html" />
  <!-- aqui vai css -->
  <script src="js/sessao.js" charset="utf-8"></script>
  <script src="js/formularios.js" charset="utf-8"></script>
</body>
</html>
