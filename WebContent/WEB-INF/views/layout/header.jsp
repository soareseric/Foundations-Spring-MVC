<nav class="navbar navbar-expand-lg navbar-Dark bg-dark">
  <a class="navbar-brand" href="#">SpringMVC</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Álbuns
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/springmvc/albuns/listar">Listar</a>
          <a class="dropdown-item" href="/springmvc/albuns/adicionar">Cadastrar</a>
        </div>
      </li>
    </ul>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Musicas<span class="caret"></span>	
        </a>
        <ul class="dropdown-menu">
        	<li><a href="/springmvc/musicas/listar"></a></li>
        	<li><a href="/springmvc/musicas/adicionar"></a></li>
        </ul>
       <!-- <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/springmvc/musicas/listar">Listar</a>
          <a class="dropdown-item" href="/springmvc/musicas/adicionar">Cadastrar</a>
        </div> --> 
      </li>
    </ul>
  </div>
</nav>